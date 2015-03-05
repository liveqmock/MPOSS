<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/stock/taking/listConf">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">
	<table class="list" width="100%" layoutH=110">
		<thead>
			<tr>
			    <th>#</th>
			    <th>盘点单号</th>
			    <th>盘点人</th>
				<th>盘点时间</th>
				<th>盘点备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="stockTaking" items="${stockTakingList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${stockTaking.stockTakingNo}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', stockTaking.regOperId)}</td>
			    <td><fmt:formatDate value="${stockTaking.regTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(stockTaking.regDesc)}</td>
			    <td>${myfn:getConstantName('STOCK_TAKING_STATUS', stockTaking.status)}</td>
			    <td><a class="button" href="/stock/taking/conf/${stockTaking.stockTakingId}" title="盘库确认" target="dialog" mask="true" width="900" height="600"><span>盘库确认</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>