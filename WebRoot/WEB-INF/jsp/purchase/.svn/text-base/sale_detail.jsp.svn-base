<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <div layoutH="37" class="nowrap">
        <a class="button" href="/purchase/exportPurchase/${purchase.purchaseId}" title="确实要导出采购单吗?" target="dwzExport" targetType="navTab"><span>导出采购单</span></a>
		<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
			<thead>
			    <tr>
					<th colspan="13" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
				</tr>
				<tr>
					<th colspan="13" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
				</tr>
				<tr>
					<th colspan="13" style="height:30px;">Tel（电话）: ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
				</tr>
				<tr>
					<th colspan="13" style="height:30px;">Add（地址）: ${sessionOper.address}</th>
				</tr>
				<tr>
					<th colspan="13" style="font-size:16px;height:30px;font-weight:bold;">采购订货单<br/>${purchase.purchaseNo}</th>
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
					<th>销售单</th>
					<th>销售产品编号</th>
					<th>已到货数</th>
					<th>已到货金额</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="totalQuantity" value="0"></c:set>
			    <c:set var="totalPrice" value="0"></c:set>
			    <c:set var="totalArrivalQuantity" value="0"></c:set>
			    <c:set var="totalArrivalPrice" value="0"></c:set>
			    <c:forEach var="purchaseDetail" items="${purchaseDetailList}" varStatus="i">
				<tr>
				    <td>${i.index+1}</td>
				    <td>${purchaseDetail.productModel}</td>
				    <td>${purchaseDetail.productName}</td>
				    <td>${purchaseDetail.standard}</td>
				    <td>${purchaseDetail.unit}</td>
				    <td>${purchaseDetail.purchaseQuantity}</td>
				    <td>${myfn:fromF2Y(purchaseDetail.purchaseUnitPrice)}</td>
				    <td>${myfn:fromF2Y(purchaseDetail.purchasePrice)}</td>
				    <td><img src="${purchaseDetail.picImg}" width="90" height="65"/></td>
				    <td>${purchaseDetail.saleNo}</td>
				    <td>${purchaseDetail.saleDetailNo}</td>
				    <td>${purchaseDetail.arrivalQuantity}</td>
				    <td>${myfn:fromF2Y(purchaseDetail.arrivalPrice)}</td>
				</tr>
				<c:set var="totalQuantity" value="${totalQuantity + purchaseDetail.purchaseQuantity}"></c:set>
				<c:set var="totalPrice" value="${totalPrice + purchaseDetail.purchasePrice}"></c:set>
				<c:set var="totalArrivalQuantity" value="${totalArrivalQuantity + purchaseDetail.arrivalQuantity}"></c:set>
				<c:set var="totalArrivalPrice" value="${totalArrivalPrice + purchaseDetail.arrivalPrice}"></c:set>
				</c:forEach>
				<tr>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td>合计：</td>
				    <td>${totalQuantity}</td>
				    <td></td>
				    <td>${myfn:fromF2Y(totalPrice)}</td>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td>${totalArrivalQuantity}</td>
				    <td>${myfn:fromF2Y(totalArrivalPrice)}</td>
				</tr>
			</tbody>
		</table>
		<c:forEach var="arrival" items="${arrivalList}">
		<br/>
		<br/>
		<a class="button" href="/purchase/exportArrival/${arrival.arrivalId}" title="确实要导出入仓单吗?" target="dwzExport" targetType="navTab"><span>导出入仓单</span></a>
		<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
			<thead>
				<tr>
					<th colspan="10" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
				</tr>
				<tr>
					<th colspan="10" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
				</tr>
				<tr>
					<th colspan="10" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
				</tr>
				<tr>
					<th colspan="10" style="height:30px;">Add: ${sessionOper.address}</th>
				</tr>
				<tr>
					<th colspan="10" style="font-size:16px;height:30px;font-weight:bold;">入仓单<br/>${arrival.arrivalNo}</th>
				</tr>
				<tr>
					<th>NAME：</th>
					<th>${purchase.providerName}</th>
					<th></th>
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
				    <th>单位<br/>UNIT</th>
					<th>数量<br/>QUANTITY</th>
					<th>价格<br/>PRICE</th>
					<th>金额<br/>AMOUNT</th>
					<th>图片<br/></th>
					<th>销售单</th>
					<th>销售产品编号</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="totalArrivalQuantity" value="0"></c:set>
			    <c:set var="totalArrivalPrice" value="0"></c:set>
			    <c:forEach var="arrivalDetail" items="${arrival.arrivalDetailList}" varStatus="li">
			    <tr>
			        <td>${li.index + 1}</td>
			        <td>${arrivalDetail.productModel}</td>
			        <td>${arrivalDetail.productName}</td>
			        <td>${arrivalDetail.unit}</td>
			        <td>${arrivalDetail.arrivalQuantity}</td>
			        <td>${myfn:fromF2Y(arrivalDetail.purchaseUnitPrice)}</td>
			        <td>${myfn:fromF2Y(arrivalDetail.arrivalPrice)}</td>
			        <td><img src="${arrivalDetail.picImg}" width="90" height="65"/></td>
			        <td>${arrivalDetail.saleNo}</td>
			        <td>${arrivalDetail.saleDetailNo}</td>
			    </tr>
			    <c:set var="totalArrivalQuantity" value="${totalArrivalQuantity + arrivalDetail.arrivalQuantity}"></c:set>
			    <c:set var="totalArrivalPrice" value="${totalArrivalPrice + arrivalDetail.arrivalPrice}"></c:set>
			    </c:forEach>
			    <tr>
			      <td></td>
			      <td></td>
			      <td></td>
			      <td></td>
			      <td>${totalArrivalQuantity}</td>
			      <td></td>
			      <td>${myfn:fromF2Y(totalArrivalPrice)}</td>
			      <td></td>
			      <td></td>
			      <td></td>
			    </tr>
			</tbody>
		</table>
		</c:forEach>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>