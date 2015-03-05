<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return divSearch(this, 'sale_list');" action="/partner/provider/consumeDetail/${providerId}" method="post">
		<input type="hidden" name="pageNum" value="1" />
	</form>
</div>
<div class="pageContent">
	<table class="list" width="100%" layoutH="367">
		<thead>
		    <tr>
			    <th colspan="9" style="font-weight:bold;">厂家交易数据</th>
			</tr>
			<tr>
			    <th>日期</th>
			    <th>产品型号</th>
			    <th>产品名称</th>
			    <th>规格</th>
			    <th>单位</th>
				<th>数量</th>
				<th>单价</th>
				<th>金额</th>
				<th>订单</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="consume" items="${consumeList}" varStatus="i">
		    <tr>
			    <td><fmt:formatDate value="${consume.consumeTime}" pattern="yyyy-MM-dd"/></td>
			    <td>${consume.productModel}</td>
			    <td>${consume.productName}</td>
			    <td>${consume.standard}</td>
			    <td>${consume.unit}</td>
			    <td>${consume.quantity}</td>
			    <td>${myfn:fromF2Y(consume.unitPrice)}</td>
			    <td>${myfn:fromF2Y(consume.price)}</td>
			    <td>${consume.paperNo}</td>
			</tr>
		    </c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'purchase_list')">
				<c:forEach begin="10" end="40" step="10" varStatus="s">
					<option value="${s.index}" ${numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select>
			<span>条，共: ${totalCount}条</span>
		</div>
		
		<div class="pagination" rel="purchase_list" targetType="navTab" totalCount="${totalCount}" numPerPage="${numPerPage}" pageNumShown="10" currentPage="${param.pageNum}"></div>
	</div>
</div>