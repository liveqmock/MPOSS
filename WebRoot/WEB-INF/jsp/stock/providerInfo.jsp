<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="100%" layoutH=30">
		<thead>
			<tr>
			    <th>#</th>
			    <th>厂家</th>
			    <th>型号</th>
			    <th>产品名</th>
			    <th>规格</th>
				<th>待返厂数</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalProviderQuantity" value="0"></c:set>
		    <c:forEach var="stock" items="${stockList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${stock.providerName}</td>
			    <td>${stock.productModel}</td>
			    <td>${stock.productName}</td>
			    <td>${stock.standard}</td>
				<td>${stock.providerQuantity}</td>
			</tr>
		    <c:set var="totalProviderQuantity" value="${totalProviderQuantity + stock.providerQuantity}"></c:set>
			</c:forEach>
			<tr>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td>合计：</td>
			  <td>${totalProviderQuantity}</td>
			</tr>
		</tbody>
	</table>
</div>