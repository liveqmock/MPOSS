<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="/account/detail/list" method="post">
		<input type="hidden" name="pageNum" value="1" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
				    <td>
						<select class="combox" name="transItem" remember="${transItem}">
							<option value="">交易类型</option>
							<c:forEach var="entry" items="${myfn:getConstantMap('TRANS_ITEM')}">
							<option value="${entry.key}">${entry.value}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select class="combox" name="accountType" ref="accountNo" refUrl="/combox/loadAccountNo/{value}" remember="${accountType}">
							<option value="">账户类型</option>
							<c:forEach var="entry" items="${myfn:getConstantMap('ACCOUNT_TYPE')}">
							<option value="${entry.key}">${entry.value}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select class="combox" name="accountNo" id="accountNo" remember="${accountNo}">
							<option value="">卡号</option>
						</select>
					</td>
					<td>
						日期：<input type="text" name="startDate" value="${startDate}" class="date" readonly="readonly" />至<input type="text" name="endDate" value="${endDate}" class="date" maxDate="%y-%M-%d" readonly="readonly" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<table class="list" width="100%" layoutH="89">
		<thead>
			<tr>
				<th>时间</th>
				<th>交易类型</th>
				<th>货款类型</th>
				<th>账户类型</th>
				<th>开户行</th>
				<th>户名</th>
				<th>卡号</th>
				<th>交易金额（元）</th>
				<th>交易后余额（元）</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="trans" items="${transList}">
			<tr>
				<td><fmt:formatDate value="${trans.transTime}" pattern="yyyy-MM-dd"/></td>
				<td>${myfn:getConstantName('TRANS_ITEM', trans.transItem)}</td>
				<td>${myfn:getConstantName('BILL_TYPE', trans.billType)}</td>
				<td>${myfn:getConstantName('ACCOUNT_TYPE', trans.accountType)}</td>
				<td>${myfn:getColumnValue('ACC_BANK.BANK_NAME', trans.bankId)}</td>
				<td>${trans.accountName}</td>
				<td>${trans.accountNo}</td>
				<td>
				    <c:choose>
				    <c:when test="${trans.transPrice>=0}">
				    <span style="color:green;">+${myfn:fromF2YForShow(trans.transPrice)}</span>
				    </c:when>
				    <c:otherwise>
				    <span style="color:red;">${myfn:fromF2YForShow(trans.transPrice)}</span>
				    </c:otherwise>
				    </c:choose>
				</td>
				<td>${myfn:fromF2YForShow(trans.afterPrice)}</td>
				<td>${trans.transMemo}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>