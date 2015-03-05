<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <div layoutH="37" class="nowrap">
	    <table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
			<thead>
				<tr>
					<th colspan="19" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
				</tr>
				<tr>
					<th colspan="19" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
				</tr>
				<tr>
					<th colspan="19" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
				</tr>
				<tr>
					<th colspan="19" style="height:30px;">Add: ${sessionOper.engAddress}</th>
				</tr>
				<tr>
					<th colspan="19" style="font-size:16px;height:30px;font-weight:bold;">销售单 ORDER<br/>${sale.saleNo}</th>
				</tr>
				<tr>
					<th>NAME：</th>
					<th>${sale.consumerName}</th>
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
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>DATE：</th>
					<th><fmt:formatDate value="${sale.createTime}" pattern="yyyy-MM-dd"/></th>
				</tr>
				<tr>
				    <th>编号<br/>No.</th>
				    <th>产品型号<br/>MODEL</th>
				    <th>产品名称<br/>ITEM</th>
				    <th>规格<br/>STANDARD</th>
				    <th>单位<br/>UNIT</th>
					<th>数量<br/>QTY</th>
					<th>已采购数</th>
					<th>已到货数</th>
					<th>已发货数</th>
					<th>当前备货数</th>
					<th>价格<br/>PRICE</th>
					<th>金额<br/>AMOUNT</th>
					<th>件数</th>
					<th>备注</th>
					<th>图片<br/>PIC</th>
					<th>供应商</th>
					<th>进货价</th>
					<th>可用库存</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="totalSaleQuantity" value="0"></c:set>
			    <c:set var="totalSalePrice" value="0"></c:set>
			    <c:forEach var="saleDetail" items="${saleDetailList}" varStatus="i">
				<tr>
				    <td>${saleDetail.saleDetailNo}</td>
				    <td>${saleDetail.productModel}</td>
				    <td>${saleDetail.productName}</td>
				    <td>${saleDetail.standard}</td>
				    <td>${saleDetail.unit}</td>
				    <td>${saleDetail.saleQuantity}</td>
					<td>${saleDetail.purchaseQuantity}</td>
				    <td>${saleDetail.arrivalQuantity}</td>
				    <td>${saleDetail.deliverQuantity}</td>
				    <td>${saleDetail.bakQuantity - saleDetail.deliverQuantity}</td>
				    <td>${myfn:fromF2Y(saleDetail.saleUnitPrice)}</td>
				    <td>${myfn:fromF2Y(saleDetail.salePrice)}</td>
				    <td>${saleDetail.packAmount}</td>
				    <td>${saleDetail.saleDesc}</td>
				    <td><img src="${saleDetail.picImg}" width="90" height="65"/></td>
				    <td></td>
				    <td></td>
				    <td>${saleDetail.canUseQuantity}</td>
				    <td>
				        <a class="button" href="/purchase/goPurReg/${saleDetail.saleDetailId}" title="采购" target="dialog" width="400" height="250"><span>采购</span></a>
				    </td>
				</tr>
				<c:set var="totalSaleQuantity" value="${totalSaleQuantity + saleDetail.saleQuantity}"></c:set>
			    <c:set var="totalSalePrice" value="${totalSalePrice + saleDetail.salePrice}"></c:set>
			    </c:forEach>
			    <tr>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td>合计：</td>
			        <td>${totalSaleQuantity}</td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td>${myfn:fromF2Y(totalSalePrice)}</td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
			</tbody>
		</table>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>