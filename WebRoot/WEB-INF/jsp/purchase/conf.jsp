<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="confForm" method="post" action="/purchase/doConf?navTabId=purchase_list_conf&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone,'您确定提交采购单审批结果吗？')">
        <input type="hidden" name="purchaseId" value="${purchase.purchaseId}"/>
        <input type="hidden" name="purchaseProp" value="${purchase.purchaseProp}"/>
        <input id="status" type="hidden" name="status"/>
        <div layoutH="37" class="nowrap">
			<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
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
						<th colspan="9" style="font-size:16px;height:30px;font-weight:bold;">采购订货单<br/>${purchase.purchaseNo}</th>
					</tr>
					<tr>
						<th>合同编号：</th>
						<th>${purchase.contractNo}</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<th>TO（致）：</th>
						<th>${purchase.providerName}</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>订货日期：</th>
						<th><fmt:formatDate value="${purchase.createTime}" pattern="yyyy-MM-dd"/></th>
					</tr>
					<tr>
					    <th>编号<br/>NO.</th>
					    <th>产品型号<br/>MODEL</th>
					    <th>产品名称<br/>ITEM</th>
					    <th>规格<br/>STANDARD</th>
					    <th>单位<br/>UNIT</th>
						<th>数量<br/>QUANTITY</th>
						<th>单价<br/>PRICE</th>
						<th>金额<br/>AMOUNT</th>
						<th>图片<br/>PIC</th>
					</tr>
				</thead>
				<tbody>
				    <c:set var="totalPrice" value="0"></c:set>
				    <c:forEach var="purchaseDetail" items="${purchaseDetailList}" varStatus="i">
					<tr>
					    <td>${i.index+1}</td>
					    <td>${purchaseDetail.productModel}</td>
					    <td>${purchaseDetail.productName}</td>
					    <td>${purchaseDetail.standard}</td>
					    <td>${purchaseDetail.unit}</td>
					    <td>${purchaseDetail.purchaseQuantity}</td>
					    <td>${myfn:fromF2YForShow(purchaseDetail.purchaseUnitPrice)}</td>
					    <td>${myfn:fromF2YForShow(purchaseDetail.purchasePrice)}</td>
					    <td><img src="${purchaseDetail.picImg}" width="90" height="65"/></td>
					    <input type="hidden" name="purchaseDetailList[${i.index}].saleDetailId" value="${purchaseDetail.saleDetailId}"/>
					    <input type="hidden" name="purchaseDetailList[${i.index}].saleNo" value="${purchaseDetail.saleNo}"/>
					    <input type="hidden" name="purchaseDetailList[${i.index}].purchaseQuantity" value="${purchaseDetail.purchaseQuantity}"/>
					</tr>
					<c:set var="totalPrice" value="${totalPrice + purchaseDetail.purchasePrice}"></c:set>
					</c:forEach>
					<tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td>合计：</td>
					    <td>${myfn:fromF2YForShow(totalPrice)}</td>
					    <td></td>
					</tr>
				</tbody>
			</table>
			<br/><br/><br/>
			<div class="pageFormContent nowrap">
				<dl>
					<dt>审批备注：</dt>
					<dd><textarea id="confDesc" name="confDesc" cols="80" rows="2"></textarea></dd>
				</dl>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="PurchaseConf.submit('yes');">审批通过</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="PurchaseConf.submit('no');">审批不通过</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var PurchaseConf = {
    submit: function(flag){
	    if(flag == 'yes'){
	        $("#status", $.pdialog.getCurrent()).val("2"); //PURCHASE_STATUS (2-待到货)
	    } else {
	        //...不通过备注
	        $("#status", $.pdialog.getCurrent()).val("3"); //PURCHASE_STATUS (3-审核退回)
	        if($("#confDesc", $.pdialog.getCurrent()).val()==""){
	            alertMsg.error("请输入不通过的原因！");
	            return;
	        }
	    }
        $("#confForm", $.pdialog.getCurrent()).submit();
	}
};
</script>