<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/make/listDeposit">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">
	<table class="list" width="100%" layoutH=110">
		<thead>
			<tr>
			    <th>#</th>
			    <th>单号</th>
			    <th>订单类型</th>
			    <th>客户</th>
				<th>销售总额</th>
				<th>收货人</th>
				<th>联系电话</th>
				<th>收货地址</th>
			    <th>制单人</th>
				<th>制单时间</th>
				<th>制单备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="sale" items="${saleList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${sale.saleNo}</td>
			    <td>${myfn:getConstantName('SALE_TYPE', sale.saleType)}</td>
			    <td>${sale.consumerName}</td>
			    <td>${myfn:fromF2YForShow(sale.totalSalePrice)}</td>
			    <td>${sale.receMen}</td>
			    <td>${sale.linkPhone}</td>
			    <td>${sale.receAddress}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', sale.createOperId)}</td>
			    <td><fmt:formatDate value="${sale.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(sale.createDesc)}</td>
			    <td>${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    <td>
			        <a title="你确定已经收取定金了吗？" target="ajaxTodo" href="/sale/make/confDeposit/${sale.saleId}" class="button"><span>确认收取</span></a>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>