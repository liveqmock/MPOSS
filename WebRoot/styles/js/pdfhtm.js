var PdfContext = (function() {
  function constructor(w, h, sobjs, url_prefix, page_no) {
    this.w = w;
    this.h = h;
    this.sobjs = sobjs;
    this.url_prefix = url_prefix;
    this.styles = [];
    this.styleHash = {};
    this.fontFaces = [];
    this.fontFaceHash = {};
    this.containerSelector="";
    this.page_no = page_no;
  }
  
  var BASE_FONT_SIZE = 16;
  var vendor = '';
  if($.browser.safari || $.browser.webkit)
    vendor = '-webkit-';
  else if($.browser.mozilla)
    vendor = '-moz-';
  else if($.browser.opera)
    vendor = '-o-';
  else if($.browser.msie)
    vendor = '-ms-';

  /**
   * Hold a map of decoded fonts and of the standard fourteen Type1
   * fonts and their acronyms.
   */
  var stdFontMap = {
    "Arial":                        "Helvetica",
    "Arial_Bold":                   "Helvetica-Bold",
    "Arial_BoldItalic":             "Helvetica-BoldOblique",
    "Arial_Italic":                 "Helvetica-Oblique",
    "Arial_BoldItalicMT":           "Helvetica-BoldOblique",
    "Arial_BoldMT":                 "Helvetica-Bold",
    "Arial_ItalicMT":               "Helvetica-Oblique",
    "ArialMT":                      "Helvetica",
    "Courier_Bold":                 "Courier-Bold",
    "Courier_BoldItalic":           "Courier-BoldOblique",
    "Courier_Italic":               "Courier-Oblique",
    "CourierNew":                   "Courier",
    "CourierNew_Bold":              "Courier-Bold",
    "CourierNew_BoldItalic":        "Courier-BoldOblique",
    "CourierNew_Italic":            "Courier-Oblique",
    "CourierNewPS_BoldItalicMT":    "Courier-BoldOblique",
    "CourierNewPS_BoldMT":          "Courier-Bold",
    "CourierNewPS_ItalicMT":        "Courier-Oblique",
    "CourierNewPSMT":               "Courier",
    "Helvetica_Bold":               "Helvetica-Bold",
    "Helvetica_BoldItalic":         "Helvetica-BoldOblique",
    "Helvetica_Italic":             "Helvetica-Oblique",
    "Symbol_Bold":                  "Symbol",
    "Symbol_BoldItalic":            "Symbol",
    "Symbol_Italic":                "Symbol",
    "TimesNewRoman":                "Times-Roman",
    "TimesNewRoman_Bold":           "Times-Bold",
    "TimesNewRoman_BoldItalic":     "Times-BoldItalic",
    "TimesNewRoman_Italic":         "Times-Italic",
    "TimesNewRomanPS":              "Times-Roman",
    "TimesNewRomanPS_Bold":         "Times-Bold",
    "TimesNewRomanPS_BoldItalic":   "Times-BoldItalic",
    "TimesNewRomanPS_BoldItalicMT": "Times-BoldItalic",
    "TimesNewRomanPS_BoldMT":       "Times-Bold",
    "TimesNewRomanPS_Italic":       "Times-Italic",
    "TimesNewRomanPS_ItalicMT":     "Times-Italic",
    "TimesNewRomanPSMT":            "Times-Roman",
    "TimesNewRomanPSMT_Bold":       "Times-Bold",
    "TimesNewRomanPSMT_BoldItalic": "Times-BoldItalic",
    "TimesNewRomanPSMT_Italic":     "Times-Italic"
  };

  function noop() {}
  
  function fillVmlText(arr, args) {
  }
  
  function fillText(arr, args) {
    var flags = args[6];
//    if(flags&24)
//      return fillVmlText(arr, args);

    var color = args[1];
    var s = args[2];
    var fontname = args[3];
    var fontsize = args[4];
    var ascent = args[5]/1000;
    var vertical = (flags&4);
    var nArg = 7;
    var hscale = 1;
    var rotate = 0;
    if(flags&8) rotate=args[nArg++];
    if(flags&16) hscale=args[nArg++];
    var key = [color, fontname, fontsize, flags, hscale, rotate].join("#");
    var cssName = this.styleHash[key];
    if(!cssName) {
      var opacity = (color >>> 24);
      color = (color & 0xffffff);
      var css = "position:absolute;margin:0;padding:0;white-space:pre;color:#";
      css += (color+0x1000000).toString(16).substr(1);
      if(opacity>0) {
        css += ";opacity:";
        css += (1 - opacity/255.0);
      }

      css += ";font:";
      if(typeof(fontname)=="number") {
        this.addFontFace(fontname);
        fontname = 'pdf'+fontname;
      }
      else {
        var stdName = stdFontMap[fontname];
        if(stdName)
          fontname = stdName;
        if(fontname.indexOf("Oblique") != -1) flags |= 1;
        if(fontname.indexOf("Italic") != -1) flags |= 1;
        if(fontname.indexOf("Bold") != -1) flags |= 2;
        fontname = fontname.split("-")[0];
      }
      if(flags&1) css += "italic ";
      if(flags&2) css += "bold ";
      css += fontsize/BASE_FONT_SIZE;
      css += "em ";
      css += fontname;
      if(vertical)
        css += ";writing-mode:tb-rl";
      cssName = this.addStyle(key, css);
    }

    var x0 = args[nArg++];
    var y0 = args[nArg++];
    var charspace = '';
    var segLen = args[nArg++];
    var sty;
    if(typeof(segLen)=="string") {
      charspace = parseFloat(segLen)/100;
      segLen = args[nArg++];
      charspace = 'letter-spacing:'+charspace+'em;';
      sty = ' style="'+charspace+';left:';
    }
    else
      sty = ' style="left:';
    var offset = 0;
    if(flags & 8) {
      var theta = rotate*Math.PI/180;
      x0 = x0/fontsize + ascent*Math.sin(theta);
      y0 = y0/fontsize - ascent*Math.cos(theta);
    }
    else {
      x0 = x0/fontsize;
      y0 = y0/fontsize - ascent;
    }
    if(flags & 24) {
      var q = '<div style="position:absolute;left:';
      q += x0*fontsize/BASE_FONT_SIZE;
      q += 'em;top:';
      q += y0*fontsize/BASE_FONT_SIZE;
      q += 'em';
      var tr = '';
      if(flags & 8 ) {
        tr += 'rotate(';
        tr += rotate;
        tr += 'deg)';
      }
      if(flags & 16) {
        tr += 'scalex(';
        tr += hscale;
        tr += ')';
      }
      q += ";";
      q += vendor;
      q += "transform-origin:top left;";
      q += vendor;
      q += "transform:";
      q += tr;
      q += '">';
      arr[arr.length] = q;
      x0 = 0;
      y0 = 0;
    }
    var x=x0, y=y0;
    var inSpan = false;
    arr.splice(arr.length, 0, '<p class=', cssName, sty, x, 'em;top:', y, 'em">');
    while(segLen>0) {
      arr[arr.length] = IX.encodeTXT(s.substr(offset, segLen));
      offset += segLen;
      var dx = args[nArg++];
      if(typeof(dx)=="string") {
        charspace = parseFloat(dx)/100;
        if(Math.abs(charspace)<0.0001) {
          charspace = '';
          sty = ' style="left:';
        }
        else {
          charspace = 'letter-spacing:'+charspace+'em;';
          sty = ' style="'+charspace+'left:';
        }
        dx = args[nArg++];
      }
      segLen = args[nArg++];
      if(typeof(segLen)=="string") {
        dy = parseFloat(segLen);
        segLen = args[nArg++];
        x = x0 + dx;
        y = y0 + dy;
        if(inSpan) {
          arr.splice(arr.length, 0, '</span></p><p class=', cssName, sty, x, 'em;top:', y, 'em">');
          inSpan = false;
        }
        else
          arr.splice(arr.length, 0, '</p><p class=', cssName, sty, x, 'em;top:', y, 'em">');
      }
      else {
        if(inSpan)
          arr.splice(arr.length, 0, '</span><span style="display:inline-block;', charspace, 'margin-left:', dx, 'em">');
        else {
          arr.splice(arr.length, 0, '<span style="display:inline-block;', charspace, 'margin-left:', dx, 'em">');
          inSpan = true;
        }
      }
    }
    if(inSpan)
      arr.splice(arr.length, 0, IX.encodeTXT(s.substr(offset)), '</span></p>');
    else
      arr.splice(arr.length, 0, IX.encodeTXT(s.substr(offset)), '</p>');
    if(flags & 24)
      arr[arr.length] = '</div>';
  }

  var handlers=[
    noop,
    noop,
    noop,
    noop,
    fillText,
    fillText,
    noop,
    noop,
    noop,
    noop,
    noop,
    noop
  ];

  constructor.prototype = {
    addFontFace: function(objnum) {
      if(!this.fontFaceHash[objnum])
        this.fontFaceHash[objnum] = true;
    },

    addStyle: function(key, css) {
      var i = this.styles.length;
      var cssName = i<26? String.fromCharCode(0x61+i): ('c'+i);
      this.styles[i] = [this.containerSelector, ' .', cssName, '{', css, '}'].join("");
      this.styleHash[key] = cssName;
      return cssName;
    },

    draw: function(containerSelector, ratio, fontCb) {
      this.containerSelector = containerSelector;
      var $container = $(containerSelector);
      var d0 = new Date();
      var arr=['<div class="c" style="overflow:hidden;', vendor, 'transform-origin:top left;', vendor,
         'transform:scale(', ratio, ');font-size:', BASE_FONT_SIZE, 'px;width:', (this.w/BASE_FONT_SIZE),
         'em;height:', (this.h/BASE_FONT_SIZE), 'em;position:relative;left:0;top:0;background:url(', this.url_prefix, '/p',
         this.page_no, '.png) no-repeat"><div style="position:absolute;left:0;top:0;font-size:10em;',
          vendor, 'transform-origin:top left;', vendor, 'transform:scale(0.1)">'];
      var i, n=this.sobjs.length;
      var nHandlers = handlers.length;
      for(i=0; i<n; ++i) {
        var cmd = this.sobjs[i];
        var args = null;
        if(typeof(cmd) != "number") {
          args = cmd;
          cmd = args[0];
        }
        if(cmd >= 0 && cmd <= nHandlers)
          handlers[cmd].call(this, arr, args);
      }
      arr[arr.length] = '</div></div>';
      var d1 = new Date();
      var cssFaces = '';
      if(fontCb)
          fontCb(this.fontFaceHash);
      else {
		for(var fobj in this.fontFaceHash) {
          cssFaces += "@font-face{font-family:pdf";
          cssFaces += fobj;
          cssFaces += ";src:url(";
          cssFaces += this.url_prefix;
          cssFaces += "/x"
          cssFaces += fobj;
          cssFaces += ".otf);}";
		}
      }
      $('<style>'+cssFaces+this.styles.join("")+"</style>").appendTo($("head"));
      var d2 = new Date();
      var s = arr.join("");
      var d3 = new Date();
      $container[0].innerHTML = s;
      var d4 = new Date();
//      alert("concat:"+(d1.getTime()-d0.getTime())+",style:"+(d2.getTime()-d1.getTime())+",join:"+(d3.getTime()-d2.getTime())+",render:"+(d4.getTime()-d3.getTime())+",total:"+(d4.getTime()-d0.getTime())+",len:"+s.length);
    }
  };

  constructor.setRatio = function(containerSelector, ratio) {
    $(containerSelector).find(">div.c").css((vendor=="-ms-")? "msTransform": vendor+"transform", "scale("+ratio+")");
  };

  return constructor;
}());
