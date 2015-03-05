/* 
 * Shortcut list: 
$X = IX.get;
$XA = IX.cvtToArray;
$XD = IX.Dom;
$XE = IX.err;
$XF = IX.getPropertyAsFunction;
$XH = IX.HtmlDocument;
$XP = IX.getProperty;
 *
*/

/**
 *  IX is a basic library which provider following functions: {
 *  	isEmpty(param) : return if param is undefined, null or empty string.
 *  	isObject(parma) : return if param is an instance of object.
 *  	isString(param) : return if param is an instance of string. Empty string will not be taken as String.
 *  	isFn(param): return if param is an instance of string.
 *  	isArray(param) : return if param is an instance of Array.
 *  
 *  	getProperty(object, propertyName, defaultValue): 
 *  			if object has a property named as propertyName, return its value no matter if it is null or empty;
 *  			otherwise return the defaultValue; 
 *		clone(object): create a duplicate object and return it. 
 *				The new object is totally different with object although the value is same.
 *
 *		ns(namespaceName): check if namespaceName is existed in current page window. 
 *				If not, create it to keep. 
 *		nsExisted(namespaceName) : return if namespaceName is existed in current page window.
 *		getNS(namespaceName): check if namespaceName is existed in current page window,
 *				If yes, return the object identified by namespaceName. Otherwise, return false.
 *
 *		iterate(arrayObject, fn): iterate to call fn for every elements in arrayObject by sequence.
 *				fn is a function to accept such object and index of object in arrayObject. 
 *				it can be defined as function(item, indexOfItemInArray)
 *		fnIterate(arrayObject, fnName): similar with iterate function, but no need to provide function.

 *				fnName should be a string to identified a function for each element in array.
 *		loop(arrayObject, accumulator, iterateFunction): iterate to do accumulation for every elements in arrayObject by sequence.
 *				iterateFunction can be defined as function(oldAccumulator, item, indexOfItemInArray), its task is
 *					deal with the item and the oldAccumulator and return the newAccumulator to help loop function to 
 *					get the result of accumulation.
 * 		partLoop(arrayObject, startIndex, endIndex, accumulator, iterateFunction):  basically, it is same as loop function.
 * 				But it will not deal with all elements by the elements from startIndex to endIndex(not include endIndex).
 * 					If the startIndex or endIndex is over-ranged, it just uses the proper index. 
 *      loopDsc(arrayObject, accumulator, iterateFunction): basically, it is same as loop function. 
 *      		But it will deal with element from the last one to the first one.
 *      each(object, accumulator, iterateFunction) : it will deal with all properties for object and return the accumulated result.
 *      		 iterateFunction can be defined as function(oldAccumulator, propertyValue, propertyName, indexOfPropertyInObject), 
 *      			its task is	deal with the property and the oldAccumulator and return the newAccumulator to help each function to 
 *					get the result of accumulation.
 *		
 *		extend(dst, src): copy all properties from src to dst no matter if the property has existed in dst. 
 *				After copying, return new dst. src will not be changed but dst should be changed.
 *		inherit(src, ...): create a new object, copy all properties from each src by sequence.
 *				After copying, return new object. Each src will not be changed.
 *
 *		isMSIE: the value to indicate if current browser is MicroSoft IE.
 *		isMSIE7: the value to indicate if current browser is MicroSoft IE 7.0.
 *		isSafari: the value to indicate if current browser is Safari.
 *		getUrlParam(key, defaultValue) : try to return the value of parameter identified by key in current URL. 
 *				If current URL has not included the key, return the default value.
 *		listen(type, target, eventName,  handerFunction): try to attach/detach an event handler on specified target.
 *				type: "attach" or "detach"
 *				target: should be a DOM object.
 *				eventName:  for example "click", "mousemove",...
 *				handlerFunction : an event handler.
 *
 *		toAnchor(anchorName): let current focus jump to specified anchor named as anchorName.
 *
 *		emptyFn: just a function shell but do nothing.
 *		execute(functionName, arguments): find the object which namespace is functionName. 
 *				If it is function, call it using the given arguments which is array.
 *		tryFn(functionObject): try to execute the given functionObject. If the given object is not function, do nothing.
 *
 *		get(domEl): try to get a DOM element by domEl which can be element or id of element.	
 *  }
 */
window.IX = (function(){
	var currentVersion="1.0";
	
	var isEmptyFn = function(str){
		return (str===undefined||str===null||str==="");		
	};
	
	var isTypeFn = function(type){
		var  types = {
			"object": Object,
			"function": Function,
			"string":String
		};
		return function(obj){
			return (!isEmptyFn(obj) && (typeof(obj)==type || obj instanceof types[type]));
		};
	};

	var typeUtils = {
		isEmpty : isEmptyFn,
		isObject : isTypeFn("object"),
		isString : isTypeFn("string"),
		isFn : isTypeFn("function"),
		isArray : function(ob) {return (!!ob && ob instanceof Array);}
	};
	
	var loopFn = function(varr,sIdx,eIdx, acc0, fun, isAscLoop) {
		if (varr==null ||varr.length==0){
			return acc0;
		}
		var len=varr.length;
		eIdx = (eIdx==-1)?len: eIdx;
		if (sIdx>=eIdx){
			return acc0;
		}
		var acc = acc0, min = Math.max(0, sIdx), max = Math.min(len, eIdx);
		var xlen = len -1;
		for (var i=0; i<=xlen; i+=1) {
			var idx = isAscLoop?i:(xlen-i);
			//try{
			if (idx>=min && idx <max && (idx in varr)){
				acc = fun(acc, varr[idx], idx);
			}
			//}catch(e){
				//alert(e);
			//}
		}
		return acc;
	};
	var loopUtils = {
		iterate: function(arr, fun){
			if (isEmptyFn(arr))
				return;
			var len = arr.length;
			for (var i=0; i<len; i+=1)			
				fun(arr[i], i);
		},
		fnIterate :function(arr, fname){
			loopUtils.iterate(arr, function(item){
				if ((fname in item) && typeUtils.isFn(item[fname]))
					item[fname]();
			});
		},
		loop:function(varr, acc0, fun) {
			return loopFn(varr, 0, -1, acc0, fun, true);
		},
		loopbreak: function(varr, fun) {
			try{
				loopFn(varr, 0, -1, 0, fun, true);
			}catch(e){
			}
		},
		partLoop:function(varr,sIdx,eIdx, acc0, fun) {
			return loopFn(varr,sIdx,eIdx, acc0, fun, true);
		},
		loopDsc:function(varr, acc0, fun) {
			return loopFn(varr,0, -1, acc0, fun, false);
		},
		map : function(arr, fun){
			return loopFn(arr, 0, -1, [], function(acc, item, idx){
				acc.push(fun(item,idx));
				return acc;
			}, true);
		},
		each:function(obj, acc0, fun){
			var acc = acc0,idx = 0;
			for (p in obj){
				acc = fun(acc, obj[p], p, idx);
				idx+=1;
			}
			return acc;
		}
	};

	var arrUtils = {
		cvtToArray : function (iterable) {
			if (!iterable)
				return [];
			if (iterable.toArray)
				return iterable.toArray();
	
			var results = [];
			var len = iterable.length;
			for (var i = 0; i < len; i++)
				results.push(iterable[i]);
		    return results;
		}
	};
	
	var propertyUtils = {
		getProperty : function(obj, pName, defV) {
			var v = (defV!=undefined) ? defV : null;
			if (obj==null)
				return v;
			var names = pName.split(".");
			var pObj = obj;
			var len = names.length;
			for (var i=0; i<len; i++) {
				try{
					if (pObj && (names[i] in pObj)) {
						pObj = pObj[names[i]];
					} else {
						return v;
					}
				}catch(e){
					return v;
				}
			}
			return pObj;
		},
		getPropertyAsFunction:function(obj, fName){
			var fn = IX.getProperty(obj, fName);
			return IX.isFn(fn)?fn : IX.emptyFn;
		},
		/**
		 * Creates a deep copy of an object.
		 * Attention: there is no support for recursive references.
		 * @param {Object} object The object to be cloned.
		 * @returns {Object} The object clone.
		 * @example
		 * var obj =
		 *     {
		 *         name : 'John',
		 *         cars :
		 *             {
		 *                 Mercedes : { color : 'blue' },
		 *                 Porsche : { color : 'red' }
		 *             }
		 *     };
		 * var clone = IX.clone( obj );
		 * clone.name = 'Paul';
		 * clone.cars.Porsche.color = 'silver';
		 * alert( obj.name );	// John
		 * alert( clone.name );	// Paul
		 * alert( obj.cars.Porsche.color );	// red
		 * alert( clone.cars.Porsche.color );	// silver
		 */
		clone : function(obj) {
			var clone;

			// Array.
			if (typeUtils.isArray(obj)) {
				clone = [];
				for (var i = 0; i < obj.length; i++)
					clone[i] = propertyUtils.clone(obj[i]);
				return clone;
			}

			// "Static" types.
			if (obj === null || (typeof(obj) != 'object') || (obj instanceof String) || (obj instanceof Number)
					|| (obj instanceof Boolean) || (obj instanceof Date) || (obj instanceof RegExp)) {
				return obj;
			}

			// Objects.
			clone = new obj.constructor();
			for (var propertyName in obj) {
				var property = obj[propertyName];
				clone[propertyName] = propertyUtils.clone(property);
			}
			return clone;
		}
	};

	var nsLoopFn = function(nsname, fn){
		var names = nsname.split(".");
		if (names[0]=="window"){
			names.shift();
		}
		var nsObj = window;
		var flag = true;
		var i=0, len = names.length; 
		while(i<len && flag){
			var curname = names[i];
			flag = fn(curname, nsObj);
			if(flag)
				nsObj = nsObj[curname];
			i++;
		}
		return flag;
	};
	var namespaceUtils = {
		ns : function(nsname){
			nsLoopFn(nsname, function(name, obj){
				if (!(name in obj))
					obj[name] = {};
				return true;
			});
		},
		nsExisted : function(nsname){
			return nsLoopFn(nsname, function(name, obj){
				return (name in obj);
			});
		},
		getNS :function(objName) {
			return nsLoopFn(objName, function(name, obj){
				return (name in obj)?obj[name]:false;
			});
		}
	};

	var extendFn = function(dst, src) {
		if (dst==null || dst==undefined)
			dst = {};
		for (var p in src)
			dst[p] = src[p];
		return dst;
	};
	var extendUtils = {
		// obj = IX.extend(dst, src);
		// obj will has all members in both dst and src, 
		// in same time, dst will has all members in src. 
		extend: extendFn,
		// obj = IX.inherit(src1, src2, src3,...);
		// obj will has all members in all src*, 
		// and all src* will not be changed. 
		inherit : function(){
			return loopUtils.loop(arrUtils.cvtToArray(arguments), {}, function(acc, item){
				return extendFn(acc, item);
			});
		}
	};

	var ua = navigator.userAgent.toLowerCase();
	var checkUA = function(keywords){
		return ua.indexOf(keywords)!=-1;
	};
	var hasEventListener = ("addEventListener" in window) ;
	var _handlerWrapper = function(handler) {
		return function(evt){
			var e = evt || window.event;
			if (!("target" in e))
				e.target = e.srcElement; // for IE hack
			return handler(e);
		};
	};	  
	var _bindHandlers = function(el, handlers, isBind){
		if(!el) return;
		IX.iterate(["click", "blur", "keydown", "mouseover", "mouseout"], function(eventName){
			if (eventName in handlers)
				IX[isBind?"attachEvent":"detachEvent"](el, eventName, _handlerWrapper(handlers[eventName]));
		});
	};
	var browserUtils = {
		isMSIE7:(document.all && checkUA("msie 7.0")),
		isSafari:(window.openDatabase && checkUA("safari")),
		
		isMSIE: checkUA("msie") && !checkUA("opera"),    //匹配IE浏览器

		isOpera : checkUA("opera"),   //匹配Opera浏览器
		isChrome: checkUA("chrome"),   //匹配Chrome浏览器
		isFirefox: checkUA("gecko") && !checkUA("webkit"),   //匹配Firefox浏览器
		
		getUrlParam :function (key, defV){
			var paramList = window.location.search.substring(1).split("&");
			var len = paramList.length;
			for(var i=0; i<len; i+=1){
				var p = paramList[i]; 
				if(p.indexOf(key+"=")==0)
					return p.substring(key.length+1);
			}
			return defV;
		},
		/** low performance. should not use it */
		listen : function(type, target, eName, fn){
			var p = hasEventListener ?  {
				fname : type=="detach"?"removeEventListener":"addEventListener",
				etype  :eName
			} :{
				fname : type+ "Event",
				etype : "on" + eName
			};
			target[p.fname](p.etype, fn, false);
		},
		attachEvent : hasEventListener?function(target, eName, fn){
				target.addEventListener(eName, fn, false);
			}:function(target, eName, fn){
				target.attachEvent("on" + eName, fn);
			},
		detachEvent : hasEventListener?function(target, eName, fn){
				target.removeEventListener(eName, fn, false);
			}:function(target, eName, fn){
				target.detachEvent("on" + eName, fn);
			},
		bind : function(el, handlers) {_bindHandlers(el, handlers, true);},
		unbind : function(el, handlers) {_bindHandlers(el, handlers, false);},
		on : function(target, eName, fn) {
			target["on" + eName] = fn;
		}
	};
	
	var locationUtils = {				
		toAnchor : function(name){
			window.location.hash = "#" + name;
		}		
	};
	
	var emptyFn=function(){};
	var executeUtils = {
		emptyFn : emptyFn,
		execute : function(fname, args) {
			var fn = namespaceUtils.getNS(fname);
			if (typeUtils.isFn(fn)){
				fn.apply(null, args);
			}
		},
		tryFn : function(fn){
			return (typeUtils.isFn(fn))? fn() : emptyFn();
		}
	};
	
	var domUtils = {
		encodeTXT : function(txt){
			return (txt+"").replaceAll('&', '&amp;').replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
		},
		get : function(domEl){
			return (!isEmptyFn(domEl) && typeUtils.isString(domEl))? document.getElementById(domEl) 
				: (domEl &&("ownerDocument" in domEl)?domEl:null);
		}
	};
	var errUtils = {
		err : function(errMsg) {
			alert(errMsg);
		}
	};
	var mathUtils = {
		inRange : function(x, x1, x2){return (x-x1)*(x-x2)<=0;}	
	};
	
	var _idx = 0;
	var idUtils = {
		id : function(){
			_idx ++;
			return "ix"+_idx;
		}	
	};
	
	return extendUtils.inherit(typeUtils, arrUtils, propertyUtils, namespaceUtils, loopUtils, 
			extendUtils, browserUtils, locationUtils, executeUtils,domUtils,errUtils, mathUtils, idUtils, {
		version: currentVersion
	});
})();
$X = IX.get;
/**
 * $XA is an shortcut to IX.cvtToArray.	
 * @param {} iterable : an object which can be iterated.
 * @return : Array object
 */
$XA = IX.cvtToArray;
$XE = IX.err;
/**
 * $XP is an shortcut for IX.getProperty. For example:
 * 		var myId = $XP(config, "id", 123)
 * 		it means assign config.id to myId, if config has no property named as "id", assign 123 to myId. 
 *  
 */
$XP = IX.getProperty;
/**
 * $XF is an shortcut for IX.getPropertyAsFunction. For example:
 * 		var closeFn = $XF(config, "close")
 * 		it means assign config.close to closeFn, if config has no property named as "close", assign IX.emptyFn to closeFn. 
 *  
 */
$XF = IX.getPropertyAsFunction;

/**
 *  IX.Array is a supplement for Array.prototype. It includes: {
 *  	init(length, defaultValue): create a new Array that each element is set to defaultValue.
 *  	isFound(element, arraryObject, equalFn): return if element is in current arrayObject by equalFn.
 *  			For equalFn, should be defined as function(a,b) and return boolean value; 
 *  			if the caller don't provide the function and a has equal operator, use a.equal to compare.
 *  			otherwise, using default operator "==".
 *  	toSet(arrayObject, equalFn): return unduplicated array of arrayObject by equalFn.
 *  	isSame(arrayObject1, arrayObject2, equalFn): return if arrayObject1 is same set as arrayObject2 no matter thr order of array elements.
 *  	compact(arrayObject, validFn):return an array object which remove all not valid elements from arrayObject by validFn. 	 
 *  	remove(arrayObject, element, equalFn): return new array object which removed matched elements from arrayObject.
 *  	pushx(arrayObject, item): return arrayObject which add item as last element.
 *  	indexOf(arrayObject, matchFn): return the index of first matched element. If no matched, return -1;
 *  	splice(arrayObject, startIndex, deleteCount, insertArrayObject): 
 *  			delete "deleteCount" elements from startIndex in arrayObject and insert insertArrayObject into startIndex of arrayObject
 *  			after all, return the new array object.   
 *  }
 * 
 */
IX.Array = (function(){
	var getEqualFn = function(equalFn){
		return IX.isFn(equalFn)?equalFn:function(a, b) {
			return (IX.isObject(a) &&("equal" in a) &&  IX.isFn(a.equal))?a.equal(b):(a==b);
		};
	};
	
	var isFoundFn = function(elem, arr, equalFn){
		if (arr==null ||arr.length==0)
			return false;
		for (var i=arr.length-1; i>=0; i--) {
			if (equalFn(elem, arr[i]))
				return true;
		}
		return false;
	};
	
	var self = {
		init : function(len, defV){
			var arr = [];
			for (var i=0; i<len; i++)
				arr[i] = IX.clone(defV);
			return arr;
		},
		isFound : function(elem, arr, equalFn){
			return isFoundFn(elem, arr, getEqualFn(equalFn));
		},
		toSet : function(arr, equalFn) {
			var fn = getEqualFn(equalFn);
			return IX.loop(arr, [], function(acc, item){
				if (!self.isFound(item, acc, fn))
					acc.push(item);
				return acc;
			});
		},
		isSameSet:function(_arr1, _arr2, equalFn){
			var arr1 = self.toSet(_arr1), arr2 = self.toSet(_arr2);
			if (arr1==null && arr2==null)
				return true;
			if (arr1==null || arr2==null || arr1.length!=arr2.length)
				return false;
			if (arr1.length==0 && arr2.length==0)
				return true;
			
			var fn = getEqualFn(equalFn);
			for (var i=arr1.length-1; i>=0; i--){
				if (!isFoundFn(arr1[i], arr2, fn))
					return false;
			}
			return true;
		},
		compact: function(arr, validFn) {
			var fn = IX.isFn(validFn)?validFn:function(item){return item;};
			return IX.loop(arr, [], function(acc, item) {
				if (fn(item))
					acc.push(item);
				return acc;
			});
		},
		remove:function(arr, elem, equalFn){
			var fn = getEqualFn(equalFn);
			return IX.loop(arr, [], function(acc, item){
				if (!fn(elem, item))
					acc.push(item);
				return acc;
			});
		},
		pushx:function(arr, item){
			arr.push(item);
			return arr;
		},
		
		flat : function(arr) {
			return IX.isArray(arr)?IX.loop(arr, [], function(acc, item){
				return acc.concat(self.flat(item));
			}) : [arr];
		},
		indexOf :function(arr, matchFn) {
			if(!arr || arr.length==0)
				return -1;
			var len = arr.length;
			for (var i=0; i<len; i++) {
				if (matchFn(arr[i]))
					return i;
			}
			return -1;
		},

		// exmaples:
		// arr= ["a", "b", "c", "d"]
		// (arr, 4) : return []
		// (arr, 3):  remove 1 elem: arr[3]; return ["a", "b", "c"];
		// (arr, 3, 4) : return []
		// (arr, 1, 2) : remove 2 elems: arr[1], arr[2]; return ["a", "d"];
		// (arr, 1, 2, ["g", "k", "l"]) : remove 2 elems: arr[1], arr[2] and add 3 elems; 
		//              return ["a", "g", "k", "l", "d"];
		// (arr, 1, 0, ["g", "k", "l"]) : remove 0 elems and add 3 elems; 
		//              return ["a", "g", "k", "l", "b", "c", "d"];
		splice:function(arr, start, deleteCount, insertArray) {
			var count = isNaN(deleteCount)?1:deleteCount;
			var len = arr.length;
			if (start<0 || start>len || count<0 || (start+count)>len){
				return [];
			}
			var iArr = insertArray?insertArray:[];
			return [].concat(arr.slice(0, start), iArr, arr.slice(start+count));
		}
	};
	return self;
})();

IX.IState = (function(){
	return {
		toggle :function(origStat, newStat){
			return (newStat==undefined)?!origStat : newStat;
		}
	};
})();

IX.IManager = function(){
	var _ht = {};
	return IX.inherit({
		isRegistered : function(name){
			return (name in _ht) && (_ht[name]);
		},
		register: function(name, obj) {
			_ht[name] = obj;
		},
		unregister : function(name){
			_ht[name] = null;
		},
		get: function(name){
			return (name in _ht)?_ht[name]: null;
		},
		clear : function() {
			_ht = {};
		},
		destory : function() {
			delete _ht;
		}
	});
};

IX.IList = function(){
	var _keyList = [];
	var IXArray =  IX.Array;
	var indexOfFn = function(key) {
		return key ? IXArray.indexOf(_keyList, function(item) {
			return item == key;
		}) : -1;
	};
	var removeFn = function(idx) {
		if (idx >= 0 && idx<_keyList.length)
			_keyList = _keyList.slice(0, idx).concat(_keyList.slice(idx+1));
	};
	var appendFn = function(key){
		if (!_keyList || _keyList.length == 0)
			_keyList = [key];
		else {
			var idx = indexOfFn(key);
			removeFn(idx);
			_keyList.push(key);
		}
	};
	return IX.inherit({
		isEmpty :function(){return _keyList.length==0;},
		getList : function(){
			return _keyList;
		},
		indexOf : indexOfFn,
		remove : removeFn,
		tryRemove : function(key){
			removeFn(indexOfFn(key));
		},
		append : appendFn,
		tryAdd :function(key){
			if (!_keyList || _keyList.length == 0)
				_keyList = [key];
			else if (indexOfFn(key) <0)
				_keyList.push(key);
		},
		insertBefore : function(key, dstKey) {
			// find the dstKey, if not exist, append current key to the end of list.
			var dstIdx = indexOfFn(dstKey);
			if (dstIdx == -1) {
				appendFn(key);
				return;
			}
			// find the key, if current key is before dstKey, do nothing.
			var idx = indexOfFn(key);
			if (idx != -1 && dstIdx - idx == 1)
				return;
			// else remove the existed record and insert it before dstKey.
			if (idx >= 0) {
				removeFn(idx);
				dstIdx = indexOfFn(dstKey);
			}
			_keyList = _keyList.slice(0, dstIdx).concat([key], _keyList.slice(idx));
		},
		clear : function(){
			_keyList = [];
		},
		destory : function(){
			delete _keyList;
		}
	});
};
IX.I1ToNManager = function() {
	var _mgr = new IX.IManager();
	
	var hasEntryFn = function(key) {
		var list = _mgr.get(key);
		return list && list.length>0;		
	};
	var indexOfFn = function(arr, value) {
		return IX.Array.indexOf(arr, function(item){
			return item==value;
		});
	};
	
	return IX.inherit(_mgr, {
		hasValue :hasEntryFn,
		put : function(k, v) {
			if (!hasEntryFn(k)) {
				_mgr.register(k, [v]);
			} else {
				var list = _mgr.get(k);
				if (indexOfFn(list, v)==-1)
					_mgr.register(k, list.concat(v));
			}	
		},
		remove : function(k, v){
			var list = _mgr.get(k);
			var idx = indexOfFn(list, v);
			if (idx >= 0)
				_mgr.register(IX.Array.splice(list, idx));	
		}	
	});
};
IX.IListManager = function() {
	var _super = new IX.IManager();
	var _list = new IX.IList();
	
	var registerFn = function(key, obj) {		
		_super.register(key, obj);
		var idx = _list.indexOf(key);
		if (obj) {
			if (idx == -1) {
				_list.append(key);
			}
		} else {
			_list.remove(idx);
		}
	};
	var listFn = function(keys) {
		return IX.map(keys, function(item) {return _super.get(item);});
	};
	return IX.inherit(_super, {
		// register should not change the sequence of key.
		register : registerFn,
		unregister : function(key){
			registerFn(key);
		},
		hasKey : _super.isRegistered,
		getKeys : function() {
			return _list.getList();
		},
		getByKeys : function(keys){
			return listFn(keys);
		},
		getAll : function() {
			return listFn(_list.getList());
		},
		getFirst : function() {
			var arr = _list.getList();
			if (!arr || arr.length == 0)
				return null;
			var len = arr.length;
			for (var i = 0; i < len; i++) {
				var inst = _super.get(arr[i]);
				if (inst) 
					return inst;
			}
			return null;
		},
		// only for key. append will remove existed record in keyList and append it to the end; 
		append : _list.append,
		insertBefore : _list.insertBefore,
		remove : function(key) {
			registerFn(key);
		},
		
		clear : function(){
			_super.clear();
			_list.clear();
		},
				
		destory : function() {
			_super.destory();
			delete _super;
			_list.destory();
			delete _list;
		}
	});
};

/**
 * data : {
 * 		type : "array"/"json", [option; default :"json"]
 * 		// for array:
 * 		fields :["name1", "name2", ...],
 * 		items:[ [value1, value2, ...], ...]
 * 		// for json:
 * 		items : [{name1: value1, name2: value2},...]
 *  }
 *  return: [{name1: value1, name2: value2},...]
 */
IX.DataStore = function(data){
	var _items = $XP(data, "items", []);
	if (_items.length>0 && $XP(data, "type", "json")!="json"){
		var _fields = $XP(data, "fields", []);
		_items =  IX.map(_items, function(row){
			return IX.loop(_fields, {}, function(acc, col, idx){
				acc[col] = IX.isArray(row)?row[idx]:row[col];
				return acc;
			});
		});
	}
	
	return IX.map(_items, function(item){
		var id = $XP(item, "id");
		if (IX.isEmpty(id))
			item.id = IX.id();
		return item;
	});
};

IX.Date = (function(){
	var _isUTC = false;
	var fields = [["FullYear", "Month", "Date"], ["Hours", "Minutes", "Seconds"]];
	var ds = "-", ts = ":";
	
	var _formatStr = function(str, sp) {
		if (IX.isEmpty(str))
			return "";
		str = str.split(sp, 3);
		return IX.map(sp==ds?[4,2,2]:[2,2,2], function(item, idx){
			return ("0".multi(item) + (str.length>idx?str[idx]:"")).substr(0-item, item);
		}).join(sp);
	}; 
	
	var _format = function(date, idx, sp){
		var getPrefix = "get" + (_isUTC?"UTC":"");
		var str = IX.map(fields[idx], function(item){
			return date[getPrefix + item]()*1 + (item=="Month"?1:0);
		}).join(sp);
		return _formatStr(str, sp);
	};
	
	var format = function(date, type) {
		if (type=="Date")
			return _format(date, 0, ds);
		if (type=="Time")
			return _format(date, 1, ts);
		return _format(date, 0, ds) + " " + _format(date,1, ts);
	};
	

	
	var checkData =function(acc, item, idx){
		return acc || isNaN(item) || item.indexOf(".")>=0 || (idx==0 && item.length!=4) || (idx>0 && item.length>2);
	};
	var checkTime =function(acc, item, idx){
		return acc || isNaN(item) || item.indexOf(".")>=0 || item.length>2;
	};
	var isValid = function(str, type){
		var isDate = type == "Date";
		var sps  = str.split(isDate?ds :ts, 3);
		if (sps.length!=3 || IX.loop(sps, false, isDate?checkData:checkTime))
			return false;
		if (isDate){
			var m = sps[1]*1;
			var d = sps[2]*1;
			return !(m<=0 || m>12 || d<=0 || d>31);
		}
		var h = sps[0]*1;
		var m = sps[1]*1;
		var s = sps[2]*1;
		return  !(h<0||h>23 || m<0||m>59 || s<0|| s>59);
	};
	
	return {
		setDS : function(v){ds = v;},
		setTS : function(v){ts = v;},
		setUTC : function(isUTC){
			_isUTC= isUTC;
		}, 
		isUTC :function(){
			return _isUTC;
		},
		// return YYYY/MM/DD hh:mm:ss 
		format:format,
		// return YYYY/MM/DD
		formatDate:function(date) {
			return format(date, "Date");
		},
		// return hh:mm:ss
		formatTime:function(date) {
			return format(date, "Time");
		},
		
		// return YYYY/MM/DD hh:mm:ss 
		formatStr:function(str) {
			str = (str + " ").split(" ");
			return _formatStr(str[0], ds) + " " + _formatStr(str[1], ts);
		},
		// return YYYY/MM/DD
		formatDateStr:function(str){
			return _formatStr(str, ds);
		},
		// return hh:mm:ss
		formatTimeStr:function(str){
			return _formatStr(str, ts);
		},
		
		// accept YYYY/MM/DD hh:mm:ss return true/false;
		isValid : function(dateStr, type) {
			var dt = dateStr.split(" ");
			if (type=="Date" ||type=="Time")
				return dt.length==1 && isValid(dt[0], type);
			
			return dt.length==2 && isValid(dt[0], "Date") && isValid(dt[1], "Time");
		}
	};
})();
/**
 *	IX.Net is a library for networking. It includes: {
 *		loadFile(url, responseHandler): active AJAX requirement and let responseHandler deal with response(Text).
 *		loadCss(cssUrl): load CSS and  apply to current document.
 *		loadJsFiles(jsFileUrlArray, postHandler): load all js files in array, and execute postHandler after all jsFiles are loaded.
 *		tryFn(fnName, argsArray,  dependency): try to execute function fnName with parameters argsArray.
 *				If the function is not existed, resolve the dependency and try it again.
 *				dependency:{
 *					beforeFn: function before applying dependency.
 *					cssFiles: all required CSS files for current function call.
 *					jsFiles: all required JS files for current function call.
 *					afterFn: function after executing current function call.
 *					delay: the milliseconds for waiting after js files are loaded.
 *				}
 *	}
 */
IX.Net = (function(){
	var head= document.getElementsByTagName('head')[0];
	var getRequestFn = function(){
		if ("XMLHttpRequest" in window) {
			return new XMLHttpRequest();
		}
		if ("ActiveXObject" in window){
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		return null;
	};
	var loadFn = function(durl, cbFun){
		var request = getRequestFn();
		if(!request){
			$XE("unsupport AJAX. Failed");return;
		}
		request.onreadystatechange  = function(){
			if (request.readyState == 4){
				if (request.status == 200){
					if (IX.isFn(cbFun)){cbFun(request.responseText);}
				} else { 
					$XE("There was an error: (" + request.status + ") " + request.statusText);
				}
			}
		};
		request.open("GET", durl, true);
		request.send("");
	};
	var loadJsFn = function(durl, nextFn){
		var script= document.createElement('script');
		script.type= 'text/javascript';
		script.src= durl;
		if (IX.isFn(nextFn)){
			if (script.readyState){ // IE
				script.onreadystatechange= function () {
					log("STATE: [" +durl +"]:" +  this.readyState);
					if (script.readyState == 'complete' || script.readyState=='loaded') {
						script.onreadystatechange = null;
						nextFn();
					}
				};
			} else {
				script.onload= nextFn;
			}
		}
		head.appendChild(script);
	};
	var loadJsFilesInSeqFn = function(jsFiles, nextFn){
		if (!jsFiles || jsFiles.length==0)
			nextFn();
		var n = jsFiles.length;
		var idx =0;
		var fn = function(){
			loadJsFn(jsFiles[idx], function(){
				idx +=1;
				return (idx<n)?fn():nextFn();
			});
		};
		fn();
	};
	var loadCssFn = function(cssFile){
		var cssNode = document.createElement('link');
		cssNode.type = 'text/css';
		cssNode.rel = 'stylesheet';
		cssNode.href = cssFile;
		cssNode.media = 'screen';
		head.appendChild(cssNode);
	};
	return {
		loadFile:loadFn,
		loadCss:loadCssFn,
		loadJsFiles:function(jsFiles, nextFun, mode){
			//if (!mode || mode=="seq" ){
				loadJsFilesInSeqFn(jsFiles, nextFun);
			//}
		},
		tryFn:function(fnName, argList,dependencyConfig){
			var fn = function(){				
				IX.execute(fnName, argList);
				IX.tryFn(dependencyConfig.afterFn);
			};
			if (!IX.nsExisted(fnName)){
				if (!dependencyConfig){
					return;
				}
				var config = dependencyConfig;
				IX.tryFn(config.beforeFn);
				IX.iterate(config.cssFiles, loadCssFn);
				var delay = config.delay || 100;
				loadJsFilesInSeqFn(config.jsFiles, function(){
					setTimeout(fn,delay);
				});
			} else
				fn();
		}
	};
})();

/**
 * 	IX.Xml is a library to deal with XML string or document. It includes: {
 * 		parser(xmlString): it convert xmlString to XML document object and return.
 * 		getXmlString(xmlDocument) : it convert XML document to string and return.
 *  	duplicate(xmlDocument) : it duplicate xml document object and return.
 * 	}
 */
IX.Xml = (function(){return {
	parser:function(str){
		str = IX.isString(str)?str:"";
		var doc = null;
		if ("DOMParser" in window) {
			doc = (new DOMParser()).parseFromString(str, "text/xml");
		}else if ("ActiveXObject" in window){
			doc=new ActiveXObject("Microsoft.XMLDOM");
			doc.async="false";
			doc.loadXML(str);
		} else {
			$XE("this browser can't support XML parser.");
		}
		return doc;
	},
	getXmlString:function(xmlDoc){
		if(!xmlDoc==null){
			return "";
		}
		if(IX.nsExisted("document.implementation.createDocument")) {
			return (new XMLSerializer()).serializeToString(xmlDoc);
		}else if ("ActiveXObject" in window){
			return xmlDoc.xml;
		} else {
			$XE("this browser can't support XML parser.");
		}
		return "";
	},
	duplicate:function(xmlDoc){
		return this.parser(this.getXmlString(xmlDoc));
	}
};})();

/**
 * 	IX.Dom is a library to deal with DOM. It includes :{
 * 		first(node, tagN): try to get the first child of DOM element node which tag name is tagN.
 * 		next(node, tagN): try to get the first next sibling of DOM element node which tag name is tagN.
 * 		cdata(node, tagN): try to get the text of DOM element node which is involved by CDATA tag.
 * 		text (node, tagN): try to get the text of DOM element node.
 * 		attr (node, attN): try to get the value of attribute of DOM element node which name is attrN.
 * 		
 * 		inTag(tagN, content, attrs): 
 * 		inPureTag(tagN, content, attrs): 
 * }
 */
IX.Dom = (function(){
	var loopFn = function(node, type, checkFn, valueFn) {
		if (!node) return valueFn(null);
		var cnode = ("firstChild" in node)?node[type=="first"?"firstChild":"nextSibling"]:null;
		while(cnode!=null && !checkFn(cnode))
			cnode = cnode.nextSibling;
		return valueFn(cnode);
	};
	
	var getFn = function(node, tagN, type){
		return IX.isString(tagN)?loopFn(node, type, function(cnode){
					return cnode.nodeName.toLowerCase()==tagN;
				},function(cnode){
					return cnode;
				}
			):null;
	};
	var textFn = IX.isMSIE?function(node){return node? node.innerText:"";}:function(node){return node?node.textContent:"";};
	
	var cdataFn = function(node){
		if (!node)
			return "";
		return loopFn(node,"first",function(cnode){
				return cnode.nodeType==4;
			},function(cnode){
				return cnode?cnode.nodeValue:"";
			}
		);
	};
	var firstFn = function(node,tagN) {
		return getFn(node,tagN, "first");
	};
		
	var inTagFn = function(tag, content, attrs){//attrs should like [[pramName, paramValue],...
		var _attrs = IX.loop(attrs, [],  function(acc, item){
			return acc.concat(' ', item[0], '="', item[1], '"');
		});
		var arr = [].concat("<", tag, _attrs, ">", content, "</", tag, ">");
		return arr.join("");
	};
	var inPureTagFn = function(tag, content, attrs){
		return inTagFn(tag, ["<![CDATA[", content, "]]>"].join(""),  attrs);
	};

	return {
		first:firstFn,
		next:function(node, tagN){
			return getFn(node, tagN,"next");
		},
		cdata:function(node, tagN){
			return cdataFn(firstFn(node, tagN));
		},
		text:function(node, tagN){
			return textFn(firstFn(node, tagN));
		},
		attr:function(node, attN){
			if(!node)
				return "";
			var val = node.getAttribute(attN);
			return IX.isEmpty(val)?"":val;
		},
		
		inTag : inTagFn,
		inPureTag : inPureTagFn
	};
})();
$XD = IX.Dom;

IX.HtmlDocument = (function(){
	var hasFn = function(el, clzName){
		return el!=null && ("className" in el)&& IX.Array.isFound(clzName, el.className.split(" "));
	};
	var removeFn = function(el, clzName){
		if (!el) return;
		var clz = IX.Array.remove(el.className.split(" "), clzName);
		el.className = clz.join(" ");
	};
	var nextFn = function(node, clzName){
		if (!node)
			return null;
		var el = node.nextSibling;
		while(el){
			if (hasFn(el, clzName))
				return el;
			el = el.nextSibling;
		}
		return el;
	};
	return {
		hasClass : hasFn,
		removeClass : removeFn,
		addClass : function(el, clzName) {
			if (el)el.className += " " + clzName;
		},
		next :nextFn,
		first : function(parentEl, clzName){
			if (!parentEl)
				return null;
			var el = parentEl.firstChild;
			return hasFn(el, clzName)?el: nextFn(el, clzName);
		},
		isAncestor : function(node, pnode) {
			if (!node)
				return false;
			var el =  node;
			while(el!=null){
				if (el==pnode)
					return true;
				el = el.parentNode;
				if (el && el.nodeName.toLowerCase()=="body")
					break;
			}
			return false;
		},
		ancestor : function(node, clzName){
			if (!node)
				return null;
			var el =  node;
			while(el!=null && !hasFn(el, clzName)){
				el = el.parentNode;
				if (el && el.nodeName.toLowerCase()=="body")
					el = null;
			}
			return el;
		},
		
		getWindowScreen : function(){
			var body = document.body.parentNode;
			var win = window;
			return {
				scroll : [body.scrollLeft, body.scrollTop, body.scrollWidth, body.scrollHeight],
				size : [body.clientWidth, body.clientHeight]
			};
		},
		
		/* ri : [ left, top, width, height] */
		rect : function(el, ri){
			IX.iterate(["left", "top", "width", "height"], function(attr, idx){
				if (ri[idx]!=null)
					el.style[attr] = ri[idx] + "px";
			});
		},
		getPosition : function(el){
			var wh = [0,0, el.offsetWidth, el.offsetHeight];
			var offset = el.offsetParent;
			while(el && el.nodeName.toLowerCase()!="body"){
				if (el.offsetParent==offset){
					wh[0] += el.offsetLeft;
					wh[1] += el.offsetTop;
					offset = offset.offsetParent;
				}
				wh[0] -=el.scrollLeft;
				wh[1] -=el.scrollTop;
				el = el.parentNode;
			}
			return wh;	
		}
	};	
})();
$XH = IX.HtmlDocument;

/**
 * 
 * @param {} config 
 *  tpl :  the HTML template definition.
 *  tplDataFn : the function to provide data to tpl[tplId]
 *  
 * @return {}
 */
IX.ITemplate = function(config){
	var _tpl = $XP(config, "tpl", []);
	_tpl = [].concat(_tpl).join("");	
	if(IX.isEmpty(_tpl)) {
		return {
			render:function(){return "";},
			renderData:function(){return "";},
			destory : function() {}
		};
	}
	
	var _dataFn = $XP(config, "tplDataFn");
	if (!IX.isFn(_dataFn))
		_dataFn = function(){return null;};
	
	var tplMgr = new IX.IManager();

	var spFn = function(node, name) {
		var txtNode = node.ownerDocument.createTextNode(name);
		node.parentNode.appendChild(txtNode);
		return node.parentNode.removeChild(node);
	};
	var nextFn = function(node, root, notSkipChild) { // skip child
		if (notSkipChild && node.firstChild){
			return node.firstChild;
		}
		var ns = node.nextSibling;
		var np = node.parentNode;
		while(ns==null){
			if (np==root) break;				
			ns = np.nextSibling;
			np = np.parentNode;			
		}
		return ns;
	};
	var regex1 = new RegExp( '(?:<tpl.*?>)|(?:<\/tpl>)', 'img');
	var regex2 = /\{([\w-]+)\}/g;
	var parseFn = function(name, p){
		var subTpls= [];
		var node = p.firstChild;
		while(node) {
			if (node.nodeName=="tpl"){
				var ns = nextFn(node, p);
				var id = node.getAttribute("id");
				var tplName = "#" + id + "#";
				subTpls.push(tplName);
				parseFn(name + (IX.isEmpty(name)? "":".") + id, spFn(node, tplName));				
				node = ns;
			} else {
				node = nextFn(node, p, true);
			}
		}
		var tpl = IX.Xml.getXmlString(p).replace(regex1, '');
		tplMgr.register(name, {
			tpl: tpl,
			list : [].concat(subTpls, IX.Array.toSet(tpl.match(regex2)))
		});		
	};
	var getRootFn = function(xml){
		var  root = IX.Xml.parser('<tpl id="root">'+ xml + '</tpl>').firstChild;
		var node = root.firstChild;
		return (node.nodeName =="tpl" && node.getAttribute("id")=="root")?node :root;
	};
	parseFn("root", getRootFn(_tpl));
	
	var renderFn = function(tplId, data){
		var tpl = tplMgr.get(tplId);
		if (!tpl) {
			$XE("can't find templete by name: " + tplId);
			return "";
		}
		var html = tpl.tpl;
		var arr = IX.loop(tpl.list, [], function(acc, item){
			var t = item.charAt(0);
			var name = item.substring(1, item.length-1);
			if (t=='{') {
				var v = $XP(data, name);
				if (v!=null)
					acc.push([item, v]);			
			} else if (t=='#'){
				var arr0 = $XP(data, name, []);
				var h = IX.loop(arr0, [], function(acc1, item, idx) {
					var idata = IX.inherit(item, {idx: idx});
					acc1.push(renderFn(tplId+ "." + name, idata));
					return acc1;
				}).join("");
				acc.push([item, h]);
			}
			return acc;
		});
		
		return html.loopReplace(arr);
	};
	
	var getValidTplId = function(tplId){
		if (IX.isEmpty(tplId))
			return "root";		
		return tplId.indexOf("root")==0?tplId : ("root." + tplId);
	};
	
	return IX.inherit({		
		render : function(tplId){
			var id = getValidTplId(tplId);
			return renderFn(id, _dataFn(id));
		},
		renderData : function(tplId, data){
			var id = getValidTplId(tplId);
			return renderFn(id, data);
		},
		destory : function() {
			tplMgr.destory();
			tplMgr = null;
		}
	});
};

/**
 * 	Extends String.prototype for some tool kits. 
 */
IX.extend(String.prototype, {
	replaceAll:function(os, ns){return this.replace(new RegExp(os,"gm"),ns);},
	loopReplace:function(varr){return IX.loop(varr, this, function(acc, item){
		return acc.replaceAll(item[0], item[1]);
	});},
		
	trim:function(){return this.replace(/(^\s*)|(\s*$)|\r|\n/g, "");},
	stripTags:function() {return this.replace(/<\/?[^>]+>/gi, '');},
	stripScripts: function() {return this.replace(new RegExp( '(?:<script.*?>)((\n|\r|.)*?)(?:<\/script>)', 'img'), '');},
	stripFormTag:function(){return this.replace(new RegExp( '(?:<form.*?>)|(?:<\/form>)', 'img'), '');},
	strip:function() {return this.replace(/^\s+/, '').replace(/\s+$/, '');},
	isSpaces:function() {return (this.replace(/(\n)|(\r)|(\t)/g, "").strip().length==0);},

	trunc:function(len){return (this.length>len)?(this.substring(0, len-3)+"..."):this;},
	tail:function(len){return (this.length>len)?(this.substring(this.length-len)):this;},

	dehtml:function(){return this.loopReplace([["&", "&amp;"], ["<", "&lt;"],['"', "&quot;"]]);},
	enhtml:function(){return this.loopReplace([["&lt;", "<"],["&quot;",'"'], ["&amp;", "&"]]);},

	multi:function(len){ return IX.Array.init(len, this).join("");},
	
	inPureTag :function(tagN, attrs){return IX.Dom.inPureTag(tagN, this, attrs);},
	inTag :function(tagN, attrs){return IX.Dom.inTag(tagN, this, attrs);}
});

/**
 * 		Extends Function.prototype which function bind.
 */
Function.prototype.bind = function() {
	var __method = this, args = $XA(arguments), object = args.shift();
	return function() {return __method.apply(object, args.concat($XA(arguments)));};
};

/**
 * 	IX.UUID is a generator to create UUID.
 */
IX.UUID = (function(){
	var itoh = '0123456789ABCDEF';
	return {
		generate:function() {
			var  s = [] ;
			var i=0;
			for (i = 0; i <36; i++)
				s[i] = Math.floor(Math.random()*0x10);
			s[14] = 4;
			s[19] = (s[19] & 0x3) | 0x8;
			
			for (i = 0; i <36; i++) s[i] = itoh[s[i]];
			s[8] = s[13] = s[18] = s[23] = ''; // seperator
			return s.join('');
		}
	};
})();

///////////////////////////////////////////////////// UTILS finished///////////
IX.Test =(function(){
	var detectAttrsFn = function(obj, checkFn, injectorFn) { // injectorFn: function(result, name, value)
		var count = 0;
		return  IX.each(obj, "", function(acc, item, nc){
			try{
				if (checkFn(item,nc)){
					count += 1;
					return injectorFn(acc,  nc, item) + (count%5==4?"\r\n":"");
				}
			}catch(e){alert(e);}
			return acc;
		});
	};
	var listFn = function(obj, matchorFn, type){
		if (type!="fun" && IX.isString(obj)){
			return "String:" + obj.toString();
		}
		var isListFn = type=="fun"; 
		return (isListFn?"Funcs:":"Props:") + detectAttrsFn(obj, function(o, p){
				return (((!isListFn && !IX.isFn(o)) || (isListFn && IX.isFn(o))));
			}, function(r, n, v) {
				return [r, n, isListFn?"": [':"', (""+v).trunc(60), '" '].join(""), ", "].join("");
			}
		);
	};
	return {
		listProp:function(obj, matchor) {
			return listFn(obj, matchor, "");
		},
		listFun:function(obj, matchor) {
			return listFn(obj, matchor, "fun");
		}
	};
})();
var IXLoggerId = null;
function initLog(logPanelId){ IXLoggerId = logPanelId;}
function log(s){
	var logDiv = IX.get(IXLoggerId);
	if(logDiv)
		logDiv.innerHTML+= ((new Date()).getTime() + ":"+s).replaceAll("<","&lt;").replaceAll("\n", "<br>")+"<br>";
}

//////////////////////////////////////////////////// TEST-Utils finished////////
/**
 * 
 * Basic class definition
 * @param {} config {
 * 		id: the identified object(String, number, ...). If not provider, use IX.UUID to create one.
 * 		type: the object type, can be anything which's meaning is assigned by inherit class.
 * }
 * @return {
 * 		getId(): return current object identification.
 * 		setId(id): replace identification's value	
 * 		getType() : return current object type. Maybe null.
 * 		equal(dst) : return if they have same identification.
 * 		destory(): it is better to have  for each new class.
 * }
 */
IX.IObject = function(config){
	var _id = $XP(config, "id", IX.UUID.generate());
	var _type = $XP(config, "type");
	
	return {
		getId:function(){
			return _id;
		},
		setId:function(id){
			_id = id;
		},
		getType:function(){
			return _type;
		},
		equal : function(dst) {
			return _id == dst.getId(); 
		},
		destory: function(){}
	};
};

