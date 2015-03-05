<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/purchase/listOver">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">
	<table class="list" width="100%" layoutH=110">
		<thead>
			<tr>
			    <th>#</th>
			    <th>采购单号</th>
			    <th>采购性质</th>
			    <th>厂家</th>
				<th>采购总额</th>
			    <th>入仓单</th>
			    <th>到货数</th>
			    <th>到货人</th>
			    <th>到货时间</th>
			    <th>到货备注</th>
			    <th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="arrival" items="${arrivalList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${arrival.purchaseNo}</td>
			    <td>${myfn:getConstantName('PURCHASE_PROP', arrival.purchaseProp)}</td>
			    <td>${arrival.providerName}</td>
			    <td>${myfn:fromF2YForShow(arrival.totalPrice)}</td>
			    <td>${arrival.arrivalNo}</td>
			    <td>${arrival.arrivalQuantity}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', arrival.regOperId)}</td>
			    <td><fmt:formatDate value="${arrival.regTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(arrival.regDesc)}</td>
			    <td>${myfn:getConstantName('ARRIVAL_STATUS', arrival.status)}</td>
			    <td><a class="button" href="/purchase/over/${arrival.arrivalId}" title="到货确认" target="dialog" mask="true" width="1000" height="660"><span>到货确认</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>