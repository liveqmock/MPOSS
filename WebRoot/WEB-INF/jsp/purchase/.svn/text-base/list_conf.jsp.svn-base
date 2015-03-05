<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/purchase/listConf">
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
				<th>合同号</th>
			    <th>制单人</th>
				<th>制单时间</th>
				<th>采购备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="purchase" items="${purchaseList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${purchase.purchaseNo}</td>
			    <td>${myfn:getConstantName('PURCHASE_PROP', purchase.purchaseProp)}</td>
			    <td>${purchase.providerName}</td>
			    <td>${myfn:fromF2YForShow(purchase.totalPrice)}</td>
			    <td>${purchase.contractNo}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', purchase.createOperId)}</td>
			    <td><fmt:formatDate value="${purchase.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(purchase.createDesc)}</td>
			    <td>${myfn:getConstantName('PURCHASE_STATUS', purchase.status)}</td>
			    <td><a class="button" href="/purchase/conf/${purchase.purchaseId}" title="采购确认" target="dialog" mask="true" width="1000" height="600"><span>采购确认</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>