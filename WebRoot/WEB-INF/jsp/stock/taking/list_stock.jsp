<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/stock/taking/listStock">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return dwzSearch(this, 'dialog');" action="/stock/taking/listStock" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
				</td>
			    <td>
					型号：
                    <input class="auto_productModel" type="text" name="product.productModel" value="${product.productModel}"/>
				</td>
				<td>
					产品名：
                    <input class="auto_productName" type="text" name="product.productName" value="${product.productName}"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
    <form method="post" action="/stock/taking/insertTemp?navTabId=stock_taking_listReg" class="pageForm required-validate" onsubmit="return myValidateCallback(this,dialogAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="150">
			<table class="list" width="100%">
				<thead>
					<tr>
					    <th>#</th>
					    <th>厂家</th>
					    <th>型号</th>
					    <th>产品</th>
					    <th>规格</th>
						<th>当前总数</th>
						<th>当前锁定数</th>
						<th>当前可用数</th>
						<th>盘点可用数</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbody">
				    <c:forEach var="stock" items="${stockList}" varStatus="i">
					<tr>
					    <td>${i.index+1}</td>
					    <td>${stock.providerName}</td>
					    <td>${stock.productModel}</td>
					    <td>${stock.productName}</td>
					    <td>${stock.standard}</td>
						<td>${stock.totalQuantity}</td>
						<td>${stock.lockQuantity}</td>
						<td>${stock.totalQuantity - stock.lockQuantity}</td>
						<td><input type="text" size="10" name="stockTakingTempList[${i.index}].takingQuantity" class="required digits" value="${stock.totalQuantity - stock.lockQuantity}"/></td>
						<td><a href="javascript:void(0);" class="btnDel" onclick="removeRow(this);">移除</a></td>
					</tr>
					<input type="hidden" name="stockTakingTempList[${i.index}].providerProductId" value="${stock.providerProductId}" />
					<input type="hidden" name="stockTakingTempList[${i.index}].standard" value="${stock.standard}" />
					<input type="hidden" name="stockTakingTempList[${i.index}].totalQuantity" value="${stock.totalQuantity}"/>
					<input type="hidden" name="stockTakingTempList[${i.index}].lockQuantity" value="${stock.lockQuantity}"/>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:import url="/WEB-INF/jsp/_frag/pager/panelBarForDialog.jsp"></c:import>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">添加</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
function removeRow(link){
    $(link).closest("tr").remove();
}
var takingQuantityVolumnSize = 8;
function passCheck() {
    var $trs = $("#tbody tr", $.pdialog.getCurrent());
    if($trs.size() == 0){
        alertMsg.error("没有可以添加的数据！");
        return false;
    }
    var noPass = false;
    $.each($trs, function(i,tr) {
        var $tr = $(tr);
        var takingQuantity = $tr.children().eq(takingQuantityVolumnSize).find("input[name*='takingQuantity']").eq(0).val();
        if(!takingQuantity){
            noPass = true;
            alertMsg.error("“盘点可用数”的列数据不能为空：<br/><br/>&nbsp;&nbsp;不盘点的请移除，盘点为0的请填写为0。");
            return false;
        }
        if(isNaN(Number(takingQuantity))){
            noPass = true;
            alertMsg.error("“盘点可用数”只能输入数字！");
            return false;
        }
    });
    if(noPass){
        return false;
    }
    
    return true;
}
/**
 * 普通ajax表单提交
 * @param {Object} form
 * @param {Object} callback
 * @param {String} confirmMsg 提示确认信息
 */
function myValidateCallback(form, callback, confirmMsg) {
	var $form = $(form);

	//if (!$form.valid()) {
	//	return false;
	//}
	if(!passCheck()){
	    return false;
	}
	
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
}
</script>