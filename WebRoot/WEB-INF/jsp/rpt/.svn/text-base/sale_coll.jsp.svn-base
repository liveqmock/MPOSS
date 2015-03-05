<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/rpt/listSaleColl">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/rpt/listSaleColl" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="saleType" remember="${saleType}">
					    <option value="">订单类型</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('SALE_TYPE')}">
					    <option value="${entry.key}">${entry.value}</option>
					    </c:forEach>
					</select>
				</td>
			    <td>
					客户：
					<input class="auto_consumerId" name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
                    <input class="auto_consumerName" type="text" name="consumer.consumerName" value="${consumer.consumerName}"/>
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
			    <th>交易客户</th>
				<th>交易总额</th>
				<th>参考利润</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalSumAmount" value="0"></c:set>
		    <c:set var="totalSumProfitAmount" value="0"></c:set>
		    <c:forEach var="saleColl" items="${saleCollList}">
			<tr>
			    <td>${saleColl.transDate}</td>
			    <td>${saleColl.consumerName}</td>
			    <td><a href="/rpt/findSaleCollDetail/${saleColl.transDate}/${saleColl.consumerId}" class="custom" target="dialog" title="交易详情" width="900" height="600">${myfn:fromF2Y(saleColl.sumAmount)}</a></td>
			    <td><a href="/rpt/findSaleCollDetail/${saleColl.transDate}/${saleColl.consumerId}" class="custom" target="dialog" title="交易详情" width="900" height="600">${myfn:fromF2Y(saleColl.sumProfitAmount)}</a></td>
			</tr>
			<c:set var="totalSumAmount" value="${totalSumAmount+saleColl.sumAmount}"></c:set>
		    <c:set var="totalSumProfitAmount" value="${totalSumProfitAmount+saleColl.sumProfitAmount}"></c:set>
			</c:forEach>
			<tr>
			  <td></td>
			  <td>合计：</td>
			  <td>${myfn:fromF2Y(totalSumAmount)}</td>
			  <td>${myfn:fromF2Y(totalSumProfitAmount)}</td>
			</tr>
		</tbody>
	</table>
</div>