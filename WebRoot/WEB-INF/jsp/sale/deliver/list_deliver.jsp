<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/deliver/listDeliver">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">
	<table class="list" width="100%" layoutH=110">
		<thead>
			<tr>
			    <th>#</th>
			    <th>销售单号</th>
			    <th>订单类型</th>
			    <th>客户</th>
				<th>销售总额</th>
				<th>收货人</th>
				<th>联系电话</th>
				<th>收货地址</th>
				<th>装箱单号</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="deliver" items="${deliverList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${deliver.saleNo}</td>
			    <td>${myfn:getConstantName('SALE_TYPE', deliver.saleType)}</td>
			    <td>${deliver.consumerName}</td>
			    <td>${myfn:fromF2YForShow(deliver.totalSalePrice)}</td>
			    <td>${deliver.receMen}</td>
			    <td>${deliver.linkPhone}</td>
			    <td>${deliver.receAddress}</td>
			    <td>${deliver.deliverNo}</td>
			    <td>${myfn:getConstantName('DELIVER_STATUS', deliver.status)}</td>
			    <td>
			        <a class="button" href="/sale/deliver/deliver/${deliver.deliverId}" title="发货确认" target="dialog" mask="true" width="1000" height="660"><span>发货确认</span></a>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>