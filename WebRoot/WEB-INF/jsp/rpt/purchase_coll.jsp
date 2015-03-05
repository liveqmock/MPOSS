<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/rpt/listPurchaseColl">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/rpt/listPurchaseColl" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="purchaseProp" remember="${purchaseProp}">
					    <option value="">采购性质</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('PURCHASE_PROP')}">
					    <option value="${entry.key}">${entry.value}</option>
					    </c:forEach>
					</select>
				</td>
			    <td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
                    <input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
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
	<table class="list" width="60%" layoutH="68">
		<thead>
			<tr>
			    <th>交易日期</th>
			    <th>交易厂家</th>
				<th>交易总额</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalSumAmount" value="0"></c:set>
		    <c:forEach var="purchaseColl" items="${purchaseCollList}">
			<tr>
			    <td>${purchaseColl.transDate}</td>
			    <td>${purchaseColl.providerName}</td>
			    <td><a href="/rpt/findPurchaseCollDetail/${purchaseColl.transDate}/${purchaseColl.providerId}" class="custom" target="dialog" title="交易详情" width="900" height="600">${myfn:fromF2Y(purchaseColl.sumAmount)}</a></td>
			</tr>
			<c:set var="totalSumAmount" value="${totalSumAmount+purchaseColl.sumAmount}"></c:set>
			</c:forEach>
			<tr>
			    <td></td>
			    <td>合计：</td>
			    <td>${myfn:fromF2Y(totalSumAmount)}</td>
			</tr>
		</tbody>
	</table>
</div>