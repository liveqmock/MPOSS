<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<link href="/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="/styles/dwz/themes/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="/styles/theme/css/zTree/zTreeStyle.css" />

<!--[if IE]>
<link href="/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->
<style type="text/css">
html,body{
    overflow:auto;
}
body{background: none repeat scroll 0 0 #FFFFFF;}
</style>
<script src="/styles/dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<div class="page unitBox" style="display: block;">
<div class="pageHeader">
	<form rel="pagerForm" action="/sale/make/import" method="post"  enctype="multipart/form-data">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					销售数据文件：
					<input type="file" name="file"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提取数据</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<form method="post" action="/sale/make/doImport" class="pageForm required-validate" onsubmit="return SaleImport.validateCallback(this, SaleImport.navTabAjaxDone, '你确定导入销售单吗？');">
	    <div id="mycontainer">
		    <table class="list" width="100%">
				<thead>
					<tr>
					    <th>#</th>
					    <th>编号<br/>NO.</th>
					    <th>产品型号<br/>MODEL</th>
						<th>产品名称<br/>ITEM</th>
						<th>规格<br/>STANDARD</th>
						<th>单位<br/>UNIT</th>
						<th>订购数量<br/>QTY</th>
						<th>价格<br/>PRICE</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody id="tbody">
				    <c:forEach var="saleImport" items="${saleImportList}" varStatus="li">
					<tr>
					    <td>${li.index+1}</td>
					    <td>${saleImport.saleDetailNo}</td>
					    <td>${saleImport.productModel}</td>
					    <td>${saleImport.productName}</td>
					    <td>${saleImport.standard}</td>
					    <td>${saleImport.unit}</td>
					    <td>${saleImport.saleQuantity}</td>
					    <td>
					    <c:if test="${saleImport.saleUnitPrice != null}">
					    ${myfn:fromF2Y(saleImport.saleUnitPrice)}
					    </c:if>
					    </td>
					    <td>${saleImport.saleDesc}</td>
					</tr>
					<input type="hidden" name="saleImportList[${li.index}].saleDetailNo" value="${saleImport.saleDetailNo}"/>
					<input type="hidden" name="saleImportList[${li.index}].productModel" value="${saleImport.productModel}"/>
					<input type="hidden" name="saleImportList[${li.index}].productName" value="${saleImport.productName}"/>
					<input type="hidden" name="saleImportList[${li.index}].standard" value="${saleImport.standard}"/>
					<input type="hidden" name="saleImportList[${li.index}].unit" value="${saleImport.unit}"/>
					<input type="hidden" name="saleImportList[${li.index}].saleQuantity" value="${saleImport.saleQuantity}"/>
					<c:if test="${saleImport.saleUnitPrice != null}">
					<input type="hidden" name="saleImportList[${li.index}].saleUnitPrice" value="${saleImport.saleUnitPrice}"/>
					</c:if>
					<input type="hidden" name="saleImportList[${li.index}].saleDesc" value="${saleImport.saleDesc}"/>
					</c:forEach>
				</tbody>
			</table>
			<div style="text-align:center;color:red;font-size:14px;padding:10px;">${message}</div>
	    </div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close" onclick="window.close();">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
$(function(){	
	DWZ.init("/styles/dwz/dwz.frag.xml", {
		loginUrl:"/login_dialog", loginTitle:"登录",	// 弹出登录对话框
		//loginUrl:"/login",	// 跳到登录页面
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"/styles/dwz/themes"});
		}
	});
	
	var docHeight = $(document).height();
    $("#mycontainer").height(docHeight-99);
});
var SaleImport = {
    removeRow: function(link){
        $(link).closest("tr").remove();
    },
    validateCallback: function (form, callback, confirmMsg) {
		var $form = $(form);
	
		var _submitFn = function(){
			$.ajax({
				type: form.method || 'POST',
				url:$form.attr("action"),
				data:$form.serializeArray(),
				dataType:"json",
				cache: false,
				success: callback || DWZ.ajaxDone,
				error: DWZ.ajaxError
			});
		}
		
		if (confirmMsg) {
			alertMsg.confirm(confirmMsg, {okCall: _submitFn});
		} else {
			_submitFn();
		}
		
		return false;
	},
	navTabAjaxDone: function(json){
	    SaleImport.ajaxDone(json);
	},
	ajaxDone:function(json){
		if(json.statusCode == DWZ.statusCode.error) {
			if(json.message && alertMsg) alertMsg.error(json.message);
		} else {
			if(json.message && alertMsg){
				alertMsg.correct(json.message,{okCall:function(){
				    window.close();
				}});
			} 
		};
	}
	
};
</script>
</div>
