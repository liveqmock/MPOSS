<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="confForm" method="post" action="/stock/taking/doConf?navTabId=stock_taking_listConf&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return myValidateCallback(this,dialogAjaxDone)">
        <input type="hidden" name="stockTakingId" value="${stockTaking.stockTakingId}"/>
        <input type="hidden" name="stockTakingNo" value="${stockTaking.stockTakingNo}"/>
        <input id="status" type="hidden" name="status"/>
		<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;" layoutH=93">
			<thead>
			    <tr>
					<th colspan="9" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
				</tr>
				<tr>
					<th colspan="9" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
				</tr>
				<tr>
					<th colspan="9" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
				</tr>
				<tr>
					<th colspan="9" style="height:30px;">Add: ${sessionOper.address}</th>
				</tr>
				<tr>
					<th colspan="9" style="font-size:16px;height:30px;font-weight:bold;">盘库单<br/>${stockTaking.stockTakingNo}</th>
				</tr>
				<tr>
					<th>制单人：</th>
					<th>${myfn:getColumnValue('SYS_OPER.REAL_NAME', stockTaking.regOperId)}</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>制单日期：</th>
					<th><fmt:formatDate value="${stockTaking.regTime}" pattern="yyyy-MM-dd"/></th>
				</tr>
				<tr>
				    <th>#</th>
				    <th>厂家</th>
				    <th>型号</th>
				    <th>产品名</th>
				    <th>规格</th>
				    <th>锁定数</th>
					<th>可用数</th>
					<th>盘点可用数</th>
					<th>可用数变化情况</th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach var="stockTakingDetail" items="${stockTakingDetailList}" varStatus="i">
				<tr>
				    <td>${i.index+1}</td>
				    <td>${stockTakingDetail.providerName}</td>
				    <td>${stockTakingDetail.productModel}</td>
				    <td>${stockTakingDetail.productName}</td>
				    <td>${stockTakingDetail.standard}</td>
				    <td>${stockTakingDetail.lockQuantity}</td>
				    <td>${stockTakingDetail.totalQuantity - stockTakingDetail.lockQuantity}</td>
				    <td>${stockTakingDetail.takingQuantity}</td>
				    <td style="color:red;">${stockTakingDetail.takingQuantity - (stockTakingDetail.totalQuantity - stockTakingDetail.lockQuantity)}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<center style="color:red;padding:10px;font-size:14px;">温馨提示：如果少量数据盘点有误，为避免整单重做，建议审批通过，之后再对盘错的部分再次盘点。</center>
		<br/>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="takingPass('yes');">审批通过</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="takingPass('no');">审批不通过</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
function takingPass(flag){
    if(flag == 'yes'){
        $("#status", $.pdialog.getCurrent()).val("2"); //STOCK_TAKING_STATUS (2-盘库成功)
        alertMsg.confirm("你确定提交进行盘库吗？", {okCall: function(){
            $("#confForm", $.pdialog.getCurrent()).submit();
        }});
    } else {
        $("#status", $.pdialog.getCurrent()).val("3"); //STOCK_TAKING_STATUS (3-盘库失败)
        alertMsg.confirm("审批不通过将直接结束盘点单。<br/>您确定终结盘点单吗？", {okCall: function(){
            $("#confForm", $.pdialog.getCurrent()).submit();
        }});
    }
}
function myValidateCallback(form, callback, confirmMsg) {
	var $form = $(form);

	if (!$form.valid()) {
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