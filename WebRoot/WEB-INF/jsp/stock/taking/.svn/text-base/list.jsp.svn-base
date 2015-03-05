<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/stock/taking/list">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/stock/taking/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
				</td>
				<td>
					产品：
				    <input class="auto_productId" type="hidden" name="product.productId" value="${product.productId}"/>
				    <input class="auto_productShow" type="text" name="product.productName" value="${product.productName}"/>
				</td>
				<td>
					<select class="combox" name="status" remember="${status}">
						<option value="">状态</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('STOCK_TAKING_STATUS')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					日期：<input type="text" name="startDate" value="${startDate}" class="date" readonly="readonly" />至<input type="text" name="endDate" value="${endDate}" class="date" maxDate="%y-%M-%d" readonly="readonly" />
				</td>
				<td>
					输盘点单查：<input class="textInput" type="text" name="stockTakingNo" value="${stockTakingNo}"/>
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
	<table class="list" width="100%" layoutH=89">
		<thead>
			<tr>
			    <th>#</th>
			    <th>盘点单号</th>
			    <th>盘点人</th>
				<th>盘点时间</th>
				<th>盘点备注</th>
				<th>确认人</th>
				<th>确认时间</th>
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
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', stockTaking.confOperId)}</td>
			    <td><fmt:formatDate value="${stockTaking.confTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:getConstantName('STOCK_TAKING_STATUS', stockTaking.status)}</td>
			    <td>
			        <a class="button" href="/stock/taking/takingDetail/${stockTaking.stockTakingId}/0/0" title="盘点单详情" target="dialog" width="900" height="600"><span>详情</span></a>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>