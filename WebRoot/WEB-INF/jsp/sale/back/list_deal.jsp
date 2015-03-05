<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/back/listConf">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">
	<table class="list" width="100%" layoutH=110">
		<thead>
			<tr>
			    <th>#</th>
			    <th>退货单号</th>
			    <th>单据类型</th>
			    <th>客户</th>
				<th>退货总额</th>
			    <th>制单人</th>
				<th>制单时间</th>
				<th>制单备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="saleBack" items="${saleBackList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${saleBack.saleBackNo}</td>
			    <td>${myfn:getConstantName('SALE_BACK_TYPE', saleBack.saleBackType)}</td>
			    <td>${saleBack.consumerName}</td>
			    <td>${myfn:fromF2Y(saleBack.totalBackPrice)}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', saleBack.createOperId)}</td>
			    <td><fmt:formatDate value="${saleBack.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(saleBack.createDesc)}</td>
			    <td>${myfn:getConstantName('SALE_BACK_STATUS', saleBack.status)}</td>
			    <td><a class="button" href="/sale/back/deal/${saleBack.saleBackId}" title="销售退货处理" mask="true" target="dialog" width="1024" height="600"><span>退货处理</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>