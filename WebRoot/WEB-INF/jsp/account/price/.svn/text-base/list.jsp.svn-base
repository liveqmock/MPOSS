<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/account/price/list"></form>

<div class="pageContent">
    <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="/account/price/add" target="navTab" rel="account_price_add" title="添加账户"><span>添加新账户</span></a></li>
		</ul>
	</div>
	<table class="list" width="70%" layoutH="138">
		<thead>
			<tr>
				<th>#</th>
				<th>账户类型</th>
				<th>开户行</th>
				<th>开户网点</th>
				<th>户名</th>
				<th>卡号</th>
				<th>金额（元）</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalPrice" value="0"></c:set>
		    <c:forEach var="account" items="${accountList}" varStatus="s">
			<tr target="accountId" rel="${account.accountId}">
				<td>${s.index + 1}</td>
				<td>${myfn:getConstantName('ACCOUNT_TYPE', account.accountType)}</td>
				<td>${myfn:getColumnValue('ACC_BANK.BANK_NAME', account.bankId)}</td>
				<td>${account.openNet}</td>
				<td>${account.accountName}</td>
				<td>${account.accountNo}</td>
				<td>${myfn:fromF2YForShow(account.price)}</td>
				<td>${myfn:getConstantName('ACCOUNT_STATUS', account.status)}</td>
				<td>
				    <c:choose>
				    <c:when test="${account.status=='1'}">
				    <c:if test="${s.index!=0}">
				    <a title="确定要停用吗？" target="ajaxTodo" href="/account/price/disable/${account.accountId}" class="button"><span>停用</span></a>
				    </c:if>
				    </c:when>
				    <c:otherwise>
				    <a title="确定要启用吗？" target="ajaxTodo" href="/account/price/enable/${account.accountId}" class="button"><span>启用</span></a>
				    </c:otherwise>
				    </c:choose>
				</td>
			</tr>
			<c:set var="totalPrice" value="${totalPrice+account.price}"></c:set>
			</c:forEach>
			<tr>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td>账户总额：</td>
			  <td>${myfn:fromF2YForShow(totalPrice)}</td>
			  <td></td>
			  <td></td>
			</tr>
		</tbody>
	</table>
</div>
