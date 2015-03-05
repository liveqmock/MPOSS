<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/rpt/listSaleBackColl">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/rpt/listSaleBackColl" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="saleBackType" remember="${saleBackType}">
					    <option value="">退货类型</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('SALE_BACK_TYPE')}">
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
			    <th>退货日期</th>
			    <th>退货客户</th>
				<th>退货总额</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalSumAmount" value="0"></c:set>
		    <c:forEach var="saleBackColl" items="${saleBackCollList}">
			<tr>
			    <td>${saleBackColl.transDate}</td>
			    <td>${saleBackColl.consumerName}</td>
			    <td><a href="/rpt/findSaleBackCollDetail/${saleBackColl.transDate}/${saleBackColl.consumerId}" class="custom" target="dialog" title="交易详情" width="900" height="600">${myfn:fromF2Y(saleBackColl.sumAmount)}</a></td>
			</tr>
			<c:set var="totalSumAmount" value="${totalSumAmount+saleBackColl.sumAmount}"></c:set>
			</c:forEach>
			<tr>
			  <td></td>
			  <td>合计：</td>
			  <td>${myfn:fromF2Y(totalSumAmount)}</td>
			</tr>
		</tbody>
	</table>
</div>