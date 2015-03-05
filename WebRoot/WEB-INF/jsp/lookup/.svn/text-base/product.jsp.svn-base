<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" action="/lookup/lookUsableProduct">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">

	<table class="table" layoutH="30" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th>产品型号</th>
				<th>产品名称</th>
				<th>产品英文名</th>
				<th>计量单位</th>
				<th>查找带回</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="product" items="${productList}">
		    <tr>
				<td>${product.productModel}</td>
				<td>${product.productName}</td>
				<td>${product.productEngName}</td>
				<td>${product.unit}</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({productId:'${product.productId}', productName:'${product.productName}', productEngName:'${product.productEngName}', productSuggestShow:'${product.productSuggestShow}'})" title="查找带回">选择</a>
				</td>
			</tr>
		    </c:forEach>
		</tbody>
	</table>
</div>