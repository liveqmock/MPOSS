<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form method="post" action="/purchase/insertSalePur?navTabId=purchase_salePur&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone)">
		<table class="list" width="100%" layoutH="38">
			<thead>
				<tr>
				    <th>供应商</th>
					<th>采购价</th>
					<th>采购数</th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach var="providerProduct" items="${providerProductList}" varStatus="li">
			    <tr>
			        <td>${providerProduct.providerName}</td>
			        <td><input class="number" type="text" size="7" name="purchaseDetailList[${li.index}].inputPurchaseUnitPrice" value="${myfn:fromF2Y(providerProduct.unitPrice)}"/></td>
			        <td>
			            <input class="digits" type="text" size="7" name="purchaseDetailList[${li.index}].purchaseQuantity"/>
			        </td>
			    </tr>
			    <input type="hidden" name="purchaseDetailList[${li.index}].providerProductId" value="${providerProduct.providerProductId}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].standard" value="${saleDetail.standard}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].saleNo" value="${sale.saleNo}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].consumerName" value="${sale.consumerName}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].saleDetailId" value="${saleDetail.saleDetailId}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].saleDetailNo" value="${saleDetail.saleDetailNo}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].purchase.purchaseProp" value="1"/><!-- PURCHASE_PROP 1-销售采购 -->
			    <input type="hidden" name="purchaseDetailList[${li.index}].purchase.providerId" value="${providerProduct.providerId}"/>
			    <input type="hidden" name="purchaseDetailList[${li.index}].purchase.providerName" value="${providerProduct.providerName}"/>
			    </c:forEach>
			</tbody>
		</table>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>