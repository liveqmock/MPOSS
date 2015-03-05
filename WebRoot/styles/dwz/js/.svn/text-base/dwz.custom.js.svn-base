/**
 * @author Roger Wu
 * @扩展人 16530202@qq.com
 * 
 * 1.扩展了联动下拉框的查询返回的记忆功能
 * 使用：请在首页引入此js文件（作为最后一个js文件来引入，重写了部分dwz源码,而又不影响dwz的版本升级）
 *      只要给select下拉框一个remember属性就可以了：<select class="combox" remember="${yourDefaultValue}" ...
 * 2.扩展了下拉框的只读功能
 * 使用：class属性添加属性值readonly即可
 *      <select class="combox readonly" ...
 */
DWZ.ajaxError = function(xhr, ajaxOptions, thrownError){
	if (alertMsg) {
		alertMsg.error("<div>状态: " + xhr.status + " "+xhr.statusText + "</div>" 
			+ "<div style=\"margin-top:10px;\">未知系统错误，请反馈给技术人员。</div>");
	} else {
		alert("Http status: " + xhr.status + " " + xhr.statusText + "\najaxOptions: " + ajaxOptions + "\nthrownError:"+thrownError + "\n" +xhr.responseText);
	}
};
(function($){
	var allSelectBox = [];
	var killAllBox = function(bid){//将除bid这个仿制下拉框外的其他仿制下拉框的选项列表都隐藏掉
		$.each(allSelectBox, function(i){
			if (allSelectBox[i] != bid) {
				if (!$("#" + allSelectBox[i])[0]) {
					$("#op_" + allSelectBox[i]).remove();
					//allSelectBox.splice(i,1);
				} else {
					$("#op_" + allSelectBox[i]).css({ height: "", width: "" }).hide();
				}
				$(document).unbind("click", killAllBox);
			}
		});
	};
	
	$.extend($.fn, {
		/**
		 * 主要用以注册仿制下拉框内链接的点击事件，点击后只显示当前仿制下拉框对应的选项让用户选择。
		 * @param {Object} options
		 */
		comboxSelect: function(options){
			var op = $.extend({ selector: ">a" }, options);
			
			return this.each(function(){
				var box = $(this);//<div id="combox_firstLevelResource" class="select" ref="secondLevelResource"><a href="javascript:" class="" name="fristLevelResourceId" value="-1">一级资源</a></div>
				
				var $combox = box.parent();
				var readonly = false;
				if(($combox.attr("class")).indexOf("combox_readonly") != -1){
					readonly = true;
				}
				
				if(!readonly){
				    var selector = $(op.selector, box);//<a href="javascript:" class="" name="fristLevelResourceId" value="-1">一级资源</a>

				    allSelectBox.push(box.attr("id"));//<div id="combox_firstLevelResource" .../>
				    //注册链接的点击事件，弹出选项让用户选择
				    $(op.selector, box).click(function(){
					    var options = $("#op_"+box.attr("id"));
					    if (options.is(":hidden")) {
						    if(options.height() > 300) {
							    options.css({height:"300px",overchange:"scroll"});
						    }
						    var top = box.offset().top+box[0].offsetHeight-50;
						    if(top + options.height() > $(window).height() - 20) {
							    top =  $(window).height() - 20 - options.height();
						    }
						    options.css({top:top,left:box.offset().left}).show();
						    killAllBox(box.attr("id"));// 调用killAllBox(),将除本仿制下拉框之外的其他仿制下拉框的选项列表都隐藏掉
						    $(document).click(killAllBox);//点击文档其他地方时，移除所有选项
					    } else {
						    $(document).unbind("click", killAllBox);//移除事件监听
						    killAllBox();
					    }
					    return false;//阻止默认事件
				    });
				    $("#op_"+box.attr("id")).find(">li").comboxOption(selector, box);//主要对每一选项注册点击事件	
				}
				
			});
		},
		/**
		 * 选了某选项后的处理
		 * @param {Object} selector 仿制下拉框中链接的jQuery对象
		 * @param {Object} box 仿制下拉框的jQuery对象
		 */
		comboxOption: function(selector, box){//主要用以处理，选择了某选项后的处理
			return this.each(function(){
				$(">a", this).click(function(){
					var $this = $(this);//选项里的链接的jQuery对象
					$this.parent().parent().find(".selected").removeClass("selected");//移除选项中的selected样式
					$this.addClass("selected");//给当前点击的那个选项设置selected样式
					selector.text($this.text());//仿制下拉框中链接也显示为新的文本 breakpoint
					
					var $input = $("select", box);
					if ($input.val() != $this.attr("value")) {//如果选了非当前选项
						//那么将我们的<select>选中当前选的那个值后，触发refChange事件，获取下一个下拉框的数据
						$("select", box).val($this.attr("value")).trigger("change");
					}
				});
			});
		},
		/**
		 * 本函数初次调用发生在初始化页面UI的时候，针对class="combox"的下拉框jQuery对象集进行调用。
		 * 调用语句发生在dwz.ui.js的initUI()函数内的此语句：$("select.combox",$p).combox();
		 */
		combox:function(){
			/* 清理下拉层 */
			var _selectBox = [];
			$.each(allSelectBox, function(i){ 
				if ($("#" + allSelectBox[i])[0]) {
					_selectBox.push(allSelectBox[i]);
				} else {
					$("#op_" + allSelectBox[i]).remove();
				}
			});
			allSelectBox = _selectBox;
			
			return this.each(function(i){ // 循环class="combox"的下拉框jQuery对象集
				/** ------比如以下是我们的一个真实下拉框--------
			       <select class="combox" name="firstLevelResourceId" id="firstLevelResource" ref="secondLevelResource" refUrl="/system/perm/listResourceByParentForSelect.action?refResourceLevel=2&resourceId={value}" remember="${firstLevelResourceId}">
				     <option value="-1">一级资源</option>
				     <option value="1">系统管理</option>
				     <option value="42">易卡售前管理</option>
				     <option value="43">易卡售后管理</option>
				     <option value="44">网站内容管理</option>
				     <option value="45">统计报表</option>
				   </select>
			    */
			    // 移除这些下拉框的combox样式,同时将下拉框的各属性缓存到变量里备用
			    var readonly = false;
				if(($(this).attr("class")).indexOf("readonly") != -1){
					readonly = true;
				}
				var combox_readonly = "";
				var cursorStyle = "";
				if(readonly){
					combox_readonly = " combox_readonly";
					cursorStyle = "style=\"cursor:auto;\"";
				}
				var $this = $(this).removeClass("combox");
				var name = $this.attr("name");
				var value= $this.val();// 首项值
				var label = $("option[value=" + value + "]",$this).text();// 首项文本
				var ref = $this.attr("ref");// 关联下拉框
				var refUrl = $this.attr("refUrl") || "";// 关联下拉框的数据来源URL

				var cid = $this.attr("id") || Math.round(Math.random()*10000000);// id,如果没有则随机生成一个
				var remember = $this.attr("remember");//默认值
				
				// 创建一个定制UI的仿制下拉框，
				// 由于CSS对<select>、<option>的样式控制十分有限，无法满足DWZ对下拉框UI效果的需求，因此这里用其他元素创建一个定制UI的仿制下拉框
				// 后面将使用这个仿制下拉框来代替咱们的下拉框去展示给用户
				var select = '<div class="combox'+ combox_readonly +'"><div id="combox_'+ cid +'" class="select"' + (ref?' ref="' + ref + '"' : '') + '>';
				select += '<a '+ cursorStyle +' href="javascript:" class="'+$this.attr("class")+'" name="' + name +'" value="' + value + '" remember="'+ remember +'">' + label +'</a></div></div>';
				
				/** -----针对我们的这个下拉框，以上仿制的下拉框将是如下这个HTML结构-----
				 * <div class="combox">
					 <div id="combox_firstLevelResource" class="select" ref="secondLevelResource">
					   <a href="javascript:" class="" name="fristLevelResourceId" value="-1">一级资源</a>
					 </div>
				   </div>
				 */
				
				// 由于以上的仿制下拉框里只使用了一个链接来显示真实下拉框的当前项,
				// 因此为了点击这个链接时可选择其他项，我们必需将真实下拉框的选项都保留下来,
				// 创建列表元素用来承载真实下拉框的选项
				var options = '<ul class="comboxop" id="op_combox_'+ cid +'">';
				$("option", $this).each(function(){
					var option = $(this);
					options +="<li><a class=\""+ (value==option[0].value?"selected":"") +"\" href=\"#\" value=\"" + option[0].value + "\">" + option[0].text + "</a></li>";
				});
				options +="</ul>";
				
				/** -------创建的选项列表将是以下的HTML结构：
				 * <ul class="comboxop" id="op_combox_firstLevelResourceId">
				     <li><a class="selected" href="#" value="-1">一级菜单</a></li>
				     <li><a class="" href="#" value="1">系统管理</a></li>
				     <li><a class="" href="#" value="42">易卡售前管理</a></li>
				     <li><a class="" href="#" value="43">易卡售后管理</a></li>
				     <li><a class="" href="#" value="44">网站内容管理</a></li>
				     <li><a class="" href="#" value="45">统计报表</a></li>
				   </ul>
				 */
				// 将承载选项的列表隐藏在页面里（点击仿制下拉框的链接时，将显示此列表项让用户选择）
				$("body").append(options);
				
				//将仿制下拉框紧跟在真实下拉框后面去显示（这么一来，每个下拉框都会有2份显示在页面上了，先别急）
				$this.after(select);
				
				// 在仿制下拉框上调用comboxSelect()：主要是注册仿制下拉框里链接的点击事件，点击后显示选项列表让用户选择
				// 将真实下拉框移到仿制下拉框里面去
				$("div.select", $this.next()).comboxSelect().append($this);
				/**
				 * -----到此为止，HTML结构将是仿制下拉框内包含着真实下拉框（另外还有一份选项列表隐藏在页面里）：
				 * <div class="combox">
					 <div id="combox_firstLevelResource" class="select" ref="secondLevelResource">
					   <a href="javascript:" class="" name="fristLevelResourceId" value="-1">一级资源</a>
					   <select class="" name="firstLevelResourceId" id="firstLevelResource" ref="secondLevelResource" refUrl="/system/perm/listResourceByParentForSelect.action?refResourceLevel=2&resourceId={value}" remember="${firstLevelResourceId}">
					     <option value="-1">一级资源</option>
					     <option value="1">系统管理</option>
					     <option value="42">易卡售前管理</option>
					     <option value="43">易卡售后管理</option>
					     <option value="44">网站内容管理</option>
					     <option value="45">统计报表</option>
					   </select>
					 </div>
				   </div>
				 */
				
				if (ref && refUrl) {
					function _onchange(event){//添加关联下拉框的变化事件
						var $ref = $("#"+ref);// 关联的联动下拉框的jQuery对象
						if ($ref.size() == 0) return false;
						$.ajax({
							type:'POST', dataType:"json", url:refUrl.replace("{value}", encodeURIComponent($this.attr("value"))), cache: false, 
							data:{},
							success: function(json){
								if (!json) return;
								var html = '';
	
								$.each(json, function(i){
									if (json[i] && json[i].length > 1){
										html += '<option value="'+json[i][0]+'">' + json[i][1] + '</option>';
									}
								});
								
								var $refCombox = $ref.parents("div.combox:first");//获取关联的联动下拉框的仿制下拉框
								var remember = $refCombox.find("select").attr("remember");//...add
								if(remember){//...
									//将关联的真实下拉框的选项重置后，添加仿制下拉框后面
									$ref.html(html).val(remember).insertAfter($refCombox);//...
								}else{
									//将关联的真实下拉框的选项重置后，添加仿制下拉框后面
									$ref.html(html).insertAfter($refCombox);
								}
								//移除关联的仿制下拉框
								$refCombox.remove();
								//对关联的真实下拉框再调用combox进行初始
								$ref.trigger("change").combox();
							},
							error: DWZ.ajaxError
						});
					}
					
					$this.unbind("change", _onchange).bind("change", _onchange);
				}
				
			});
		},
		/**
		 * 本函数初次调用发生在初始化页面UI的时候，针对页面包含有remember属性的下拉框jQuery对象集进行调用。
		 * 调用语句发生在dwz.ui.js的initUI()函数内的此语句：$("select[remember]",$p).comboxDefault();
		 */
		comboxDefault: function(){
			
			// 每组联动下拉框，只要组内第一个下拉框的refChange事件被触发就可以挨个排的把默认值都记忆上了，
			// 因此定义ignores数组，就是为了避免后续重复触发组内下拉框的refChange事件。
			var ignores = new Array();
			
			this.each(function(i){
				var $this = $(this);
				if($this.attr("id") && ignores.indexOf($this.attr("id"))!=-1) return false;//如果下拉框已经存在于数组内，则不必处理。跳出循环
				
				//将此下拉框以及所关联的下拉框id放到数组里去。避免后续重复触发组内下拉框的refChange事件。
				ignores.push($this.attr("id"));
				if($this.attr("ref")){
					ignores.push($this.attr("ref"));
					if($("#"+$this.attr("ref")).attr("ref")){
						ignores.push($("#"+$this.attr("ref")).attr("ref"));
					}
				}
				
				var remember = $this.attr("remember");//获取要记忆的默认值
				if(remember){
					
					//将默认值所在的选项列表样式设置上
					var $optionUl = $("#op_"+$this.parent().attr("id"));
					$optionUl.find(".selected").removeClass("selected");
					$optionUl.find("a[value='"+remember+"']").addClass("selected");
					
					var $option = $("option[value='"+remember+"']",$this);//获取默认文本
					$this.val(remember).prev().attr("value",remember).text($option.text());//将此下拉框的默认选项选中，并且将显示链接的值也设置为默认值，将显示链接的文本设置为默认文本
					$this.trigger("change");//触发链接的refChange事件去获取关联下拉框的数据
				}
			});
		}
	});
})(jQuery);

function initUI(_box){
	var $p = $(_box || document);

	$("div.panel", $p).jPanel();

	//tables
	$("table.table", $p).jTable();
	
	// css tables
	$('table.list', $p).cssTable();

	//auto bind tabs
	$("div.tabs", $p).each(function(){
		var $this = $(this);
		var options = {};
		options.currentIndex = $this.attr("currentIndex") || 0;
		options.eventType = $this.attr("eventType") || "click";
		$this.tabs(options);
	});

	$("ul.tree", $p).jTree();
	$('div.accordion', $p).each(function(){
		var $this = $(this);
		$this.accordion({fillSpace:$this.attr("fillSpace"),alwaysOpen:true,active:0});
	});

	$(":button.checkboxCtrl, :checkbox.checkboxCtrl", $p).checkboxCtrl($p);
	
	if ($.fn.combox) $("select.combox",$p).combox();
	if ($.fn.combox) $("select[remember]",$p).comboxDefault();//initUI()里只改了这句
	
	if ($.fn.xheditor) {
		$("textarea.editor", $p).each(function(){
			var $this = $(this);
			var op = {html5Upload:false, skin: 'vista',tools: $this.attr("tools") || 'full'};
			var upAttrs = [
				["upLinkUrl","upLinkExt","zip,rar,txt"],
				["upImgUrl","upImgExt","jpg,jpeg,gif,png"],
				["upFlashUrl","upFlashExt","swf"],
				["upMediaUrl","upMediaExt","avi"]
			];
			
			$(upAttrs).each(function(i){
				var urlAttr = upAttrs[i][0];
				var extAttr = upAttrs[i][1];
				
				if ($this.attr(urlAttr)) {
					op[urlAttr] = $this.attr(urlAttr);
					op[extAttr] = $this.attr(extAttr) || upAttrs[i][2];
				}
			});
			
			$this.xheditor(op);
		});
	}
	
	if ($.fn.uploadify) {
		$(":file[uploaderOption]", $p).each(function(){
			var $this = $(this);
			var options = {
				fileObjName: $this.attr("name") || "file",
				auto: true,
				multi: true,
				onUploadError: uploadifyError
			};
			
			var uploaderOption = DWZ.jsonEval($this.attr("uploaderOption"));
			$.extend(options, uploaderOption);

			DWZ.debug("uploaderOption: "+DWZ.obj2str(uploaderOption));
			
			$this.uploadify(options);
		});
	}
	
	// init styles
	$("input[type=text], input[type=password], textarea", $p).addClass("textInput").focusClass("focus");

	$("input[readonly], textarea[readonly]", $p).addClass("readonly");
	$("input[disabled=true], textarea[disabled=true]", $p).addClass("disabled");

	$("input[type=text]", $p).not("div.tabs input[type=text]", $p).filter("[alt]").inputAlert();

	//Grid ToolBar
	$("div.panelBar li, div.panelBar", $p).hoverClass("hover");

	//Button
	$("div.button", $p).hoverClass("buttonHover");
	$("div.buttonActive", $p).hoverClass("buttonActiveHover");
	
	//tabsPageHeader
	$("div.tabsHeader li, div.tabsPageHeader li, div.accordionHeader, div.accordion", $p).hoverClass("hover");

	//validate form
	$("form.required-validate", $p).each(function(){
		var $form = $(this);
		$form.validate({
			onsubmit: false,
			focusInvalid: false,
			focusCleanup: true,
			errorElement: "span",
			ignore:".ignore",
			invalidHandler: function(form, validator) {
				var errors = validator.numberOfInvalids();
				if (errors) {
					var message = DWZ.msg("validateFormError",[errors]);
					alertMsg.error(message);
				} 
			}
		});
		
		$form.find('input[customvalid]').each(function(){
			var $input = $(this);
			$input.rules("add", {
				customvalid: $input.attr("customvalid")
			})
		});
	});

	if ($.fn.datepicker){
		$('input.date', $p).each(function(){
			var $this = $(this);
			var opts = {};
			if ($this.attr("dateFmt")) opts.pattern = $this.attr("dateFmt");
			if ($this.attr("minDate")) opts.minDate = $this.attr("minDate");
			if ($this.attr("maxDate")) opts.maxDate = $this.attr("maxDate");
			if ($this.attr("mmStep")) opts.mmStep = $this.attr("mmStep");
			if ($this.attr("ssStep")) opts.ssStep = $this.attr("ssStep");
			$this.datepicker(opts);
		});
	}

	// navTab
	$("a[target=navTab]", $p).each(function(){
		$(this).click(function(event){
			var $this = $(this);
			var title = $this.attr("title") || $this.text();
			var tabid = $this.attr("rel") || "_blank";
			var fresh = eval($this.attr("fresh") || "true");
			var external = eval($this.attr("external") || "false");
			var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
			DWZ.debug(url);
			if (!url.isFinishedTm()) {
				alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
				return false;
			}
			navTab.openTab(tabid, url,{title:title, fresh:fresh, external:external});

			event.preventDefault();
		});
	});
	
	//dialogs
	$("a[target=dialog]", $p).each(function(){
		if($(this).attr("bind")=="custom") return true;//continue
		$(this).click(function(event){
			var $this = $(this);
			var title = $this.attr("title") || $this.text();
			var rel = $this.attr("rel") || "_blank";
			var options = {};
			var w = $this.attr("width");
			var h = $this.attr("height");
			if (w) options.width = w;
			if (h) options.height = h;
			options.max = eval($this.attr("max") || "false");
			options.mask = eval($this.attr("mask") || "false");
			options.maxable = eval($this.attr("maxable") || "true");
			options.minable = eval($this.attr("minable") || "true");
			options.fresh = eval($this.attr("fresh") || "true");
			options.resizable = eval($this.attr("resizable") || "true");
			options.drawable = eval($this.attr("drawable") || "true");
			options.close = eval($this.attr("close") || "");
			options.param = $this.attr("param") || "";

			var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
			DWZ.debug(url);
			if (!url.isFinishedTm()) {
				alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
				return false;
			}
			$.pdialog.open(url, rel, title, options);
			
			return false;
		});
	});
	$("a[target=ajax]", $p).each(function(){
		$(this).click(function(event){
			var $this = $(this);
			var rel = $this.attr("rel");
			if (rel) {
				var $rel = $("#"+rel);
				$rel.loadUrl($this.attr("href"), {}, function(){
					$rel.find("[layoutH]").layoutH();
				});
			}

			event.preventDefault();
		});
	});
	
	$("div.pagination", $p).each(function(){
		var $this = $(this);
		$this.pagination({
			targetType:$this.attr("targetType"),
			rel:$this.attr("rel"),
			totalCount:$this.attr("totalCount"),
			numPerPage:$this.attr("numPerPage"),
			pageNumShown:$this.attr("pageNumShown"),
			currentPage:$this.attr("currentPage")
		});
	});
	
	$("input[class*='digits']", $p).each(function(){
	    var $this = $(this);
	    
	    $this.on("keypress",function(event){
	        if(event.ctrlKey){//组合键允许
	             return true;
	        }
	        if(event.which > 47 && event.which < 58){//数字键允许
	             return true;
	        }
	        switch(event.which){
	            case 0:return true;//切换键允许
	            break;
	            case 8:return true;//退格键允许
	            break;
	            default: return false;//其他都不允许
	        }
	    });
	});
	
	$("input[class*='number']", $p).each(function(){
	    var $this = $(this);
	    
	    $this.on("keypress",function(event){
	    	if(event.ctrlKey){//组合键允许
	             return true;
	        }
	        if((event.which > 47 && event.which < 58) || (event.which == 46)){//数字 点
	             return true;
	        }
	        switch(event.which){
	            case 0:return true;//切换键允许
	            break;
	            case 8:return true;//退格键允许
	            break;
	            default: return false;//其他都不允许
	        }
	    });
	});
	
	if ($.fn.sortDrag) $("div.sortDrag", $p).sortDrag();

	// dwz.ajax.js
	if ($.fn.ajaxTodo) $("a[target=ajaxTodo]", $p).ajaxTodo();
	if ($.fn.dwzExport) $("a[target=dwzExport]", $p).dwzExport();

	if ($.fn.lookup) $("a[lookupGroup]", $p).lookup();
	if ($.fn.multLookup) $("[multLookup]:button", $p).multLookup();
	if ($.fn.suggest) $("input[suggestFields]", $p).suggest();
	if ($.fn.itemDetail) $("table.itemDetail", $p).itemDetail();
	if ($.fn.selectedTodo) $("a[target=selectedTodo]", $p).selectedTodo();
	if ($.fn.pagerForm) $("form[rel=pagerForm]", $p).pagerForm({parentBox:$p});

	// 这里放其他第三方jQuery插件...
	$(".auto_productModel", $p).autocomplete("/autocomplete/loadProductModel",{dataType:'json',
	    parse:function(productModels){
	        var rows = new Array();
	        $.each(productModels,function(i,productModel){
	              rows[i] = {data:productModel,value:productModel,result:productModel} 
	        });
			return rows;
	    },
	    formatItem : function(productModel, i, total) { 
			return productModel; 
		},
		minChars:0,
		max:999,
		scrollHeight:300,
		mustMatch:true,
		matchContains:true
	});
	
	$(".auto_productName", $p).autocomplete("/autocomplete/loadProductName",{dataType:'json',
	    parse:function(products){
	        var rows = new Array();
	        $.each(products,function(i,product){
	              rows[i] = {data:product,value:product.engLetter + product.productName,result:product.productName} 
	        });
			return rows;
	    },
	    formatItem : function(product, i, total) { 
			return product.productName; 
		},
		formatMatch: function(product, i, max) {//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
			return product.engLetter + product.productName;
		},
		minChars:0,
		max:999,
		scrollHeight:300,
		mustMatch:true,
		matchContains:true
	});
	
	$(".auto_productShow", $p).autocomplete("/autocomplete/loadProduct",{dataType:'json',
	    parse:function(products){
	        var rows = new Array();
	        $.each(products,function(i,product){
	              rows[i] = {data:product,value:product.engLetter + product.productModel + product.productName,result:product.productModel+"-"+product.productName} 
	        });
			return rows;
	    },
	    formatItem : function(product, i, total) { 
			return product.productModel +"-" + product.productName; 
		},
		formatMatch: function(product, i, max) {//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
			return product.engLetter + product.productModel + product.productName;
		},
		minChars:0,
		max:999,
		scrollHeight:300,
		mustMatch:true,
		matchContains:true,
		width:180,
	}).result(function(event,product,formatted) {
		if (product){
	    	$(event.target).parent().find(".auto_productId").val(product.productId);
	    }else{
	    	$(event.target).parent().find(".auto_productId").val("");
	    }
    });
	
	$(".auto_consumerName", $p).autocomplete("/autocomplete/loadConsumer",{dataType:'json',
	    parse:function(consumers){
	        var rows = new Array();
	        $.each(consumers,function(i,consumer){
	              rows[i] = {data:consumer,value:consumer.engLetter+consumer.consumerName,result:consumer.consumerName} 
	        });
			return rows;
	    },
	    formatItem : function(consumer, i, total) { 
			return consumer.consumerName; 
		},
		formatMatch: function(consumer, i, max) {//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
			return consumer.engLetter + consumer.consumerName;
		},
		minChars:0,
		max:999,
		scrollHeight:300,
		mustMatch:true,
		matchContains:true
	}).result(function(event,consumer,formatted) {
	    if (consumer){
	        $(event.target).parent().find(".auto_consumerId").val(consumer.consumerId);
	    }else{
	    	$(event.target).parent().find(".auto_consumerId").val("");
	    }
    });
	
	$(".auto_providerName", $p).autocomplete("/autocomplete/loadProvider",{dataType:'json',
	    parse:function(providers){
	        var rows = new Array();
	        $.each(providers,function(i,provider){
	              rows[i] = {data:provider,value:provider.engLetter+provider.providerName,result:provider.providerName} 
	        });
			return rows;
	    },
	    formatItem : function(provider, i, total) { 
			return provider.providerName; 
		},
		formatMatch: function(provider, i, max) {//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
			return provider.engLetter + provider.providerName;
		},
		minChars:0,
		max:999,
		scrollHeight:300,
		mustMatch:true,
		matchContains:true
	}).result(function(event,provider,formatted) {
	    if (provider){
	    	$(event.target).parent().find(".auto_providerId").val(provider.providerId);
	    }else{
	    	$(event.target).parent().find(".auto_providerId").val("");
	    }
    });
	
}

function dynamicBindEnter($target) {
    $("input[class*='digits']", $target).each(function(){
	    var $this = $(this);
	    
	    $this.on("keypress",function(event){
	        if(event.ctrlKey){//组合键允许
	             return true;
	        }
	        if(event.which > 47 && event.which < 58){//数字键允许
	             return true;
	        }
	        switch(event.which){
	            case 0:return true;//切换键允许
	            break;
	            case 8:return true;//退格键允许
	            break;
	            default: return false;//其他都不允许
	        }
	    });
	});
	
	$("input[class*='number']", $target).each(function(){
	    var $this = $(this);
	    
	    $this.on("keypress",function(event){
	    	if(event.ctrlKey){//组合键允许
	             return true;
	        }
	        if((event.which > 47 && event.which < 58) || (event.which == 46)){//数字 点
	             return true;
	        }
	        switch(event.which){
	            case 0:return true;//切换键允许
	            break;
	            case 8:return true;//退格键允许
	            break;
	            default: return false;//其他都不允许
	        }
	    });
	});
}

function dynamicBindAutocomplete($target){
    $target.autocomplete("/autocomplete/loadProduct",{dataType:'json',
	    parse:function(products){
	        var rows = new Array();
	        $.each(products,function(i,product){
	              rows[i] = {data:product,value:product.productModel + product.productName,result:product.productModel+"-"+product.productName} 
	        });
			return rows;
	    },
	    formatItem : function(product, i, total) { 
			return product.productModel +"-" + product.productName; 
		},
		formatMatch: function(product, i, max) {//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
			return product.productModel + product.productName;
		},
		minChars:0,
		max:999,
		scrollHeight:300,
		mustMatch:true,
		matchContains:true,
		width:180,
	}).result(function(event,product,formatted) {
	    if (product){
	    	$(event.target).parent().find(".auto_productId").val(product.productId);
	    }else{
	    	$(event.target).parent().find(".auto_productId").val("");
	    }
	});
}
/**
 * url:url地址
 * config:可不写，默认宽度为850，高度为800，格式{width:850,height:800}
 */
function showModal(url,config) {
    var settings = $.extend({
        width:850,
        height:800
    },config||{});
    
    try {
		return window.showModalDialog(url,window,"dialogTop:0px;dialogLeft:"+(window.screen.availWidth-settings.width)/2+"px;dialogWidth:" + settings.width
				+ "px;dialogHeight=" + settings.height
				+ "px;scroll:yes;status:no;resizable=yes;help:no;");
	} catch (e) {
		
	}

}