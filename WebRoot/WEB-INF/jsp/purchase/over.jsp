<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="bakForm" method="post" action="/purchase/doOver?navTabId=purchase_list_over&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone,'你确定提交到货确认吗?')">
        <input type="hidden" name="arrivalId" value="${arrival.arrivalId}"/>
        <input type="hidden" name="providerId" value="${purchase.providerId}"/>
        <input type="hidden" name="providerName" value="${purchase.providerName}"/>
	    <div layoutH="38">
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
						<th colspan="9" style="font-size:16px;height:30px;font-weight:bold;">入仓单<br/>${arrival.arrivalNo}</th>
					</tr>
					<tr>
						<th>NAME：</th>
						<th>${purchase.providerName}</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>DATE：</th>
						<th><fmt:formatDate value="${arrival.regTime}" pattern="yyyy-MM-dd"/></th>
					</tr>
					<tr>
					    <th>编号<br/>No.</th>
					    <th>产品型号<br/>MODEL</th>
					    <th>产品名称<br/>ITEM</th>
					    <th>规格<br/>STANDARD</th>
					    <th>单位<br/>UNIT</th>
						<th>数量<br/>QUANTITY</th>
						<th>价格<br/>PRICE</th>
						<th>金额<br/>AMOUNT</th>
						<th>图片<br/>PIC</th>
					</tr>
				</thead>
				<tbody>
				    <c:set var="totalArrivalQuantity" value="0"></c:set>
				    <c:set var="totalArrivalPrice" value="0"></c:set>
				    <c:forEach var="arrivalDetail" items="${arrivalDetailList}" varStatus="li">
				    <tr>
				        <td>${li.index + 1}</td>
				        <td>${arrivalDetail.productModel}</td>
				        <td>${arrivalDetail.productName}</td>
				        <td>${arrivalDetail.standard}</td>
				        <td>${arrivalDetail.unit}</td>
				        <td>${arrivalDetail.arrivalQuantity}</td>
				        <td>${myfn:fromF2Y(arrivalDetail.purchaseUnitPrice)}</td>
				        <td>${myfn:fromF2Y(arrivalDetail.arrivalPrice)}</td>
				        <td><img src="${arrivalDetail.picImg}" width="90" height="65"/></td>
				    </tr>
				    <c:set var="totalArrivalQuantity" value="${totalArrivalQuantity + arrivalDetail.arrivalQuantity}"></c:set>
				    <c:set var="totalArrivalPrice" value="${totalArrivalPrice + arrivalDetail.arrivalPrice}"></c:set>
				    </c:forEach>
				    <tr>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td>合计：</td>
				      <td>${totalArrivalQuantity}</td>
				      <td></td>
				      <td>${myfn:fromF2Y(totalArrivalPrice)}</td>
				      <td></td>
				    </tr>
				</tbody>
			</table>
		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">到货确认</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">

</script>