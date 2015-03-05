<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/purchase/listSearch">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/purchase/listSearch" method="post">
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
					<input class="auto_productShow" type="text" name="product.productShow" value="${product.productShow}"/>
				</td>
				<td>
					<select class="combox" name="status" remember="${status}">
						<option value="">状态</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('PURCHASE_STATUS')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					日期：<input type="text" name="startDate" value="${startDate}" class="date" readonly="readonly" />至<input type="text" name="endDate" value="${endDate}" class="date" maxDate="%y-%M-%d" readonly="readonly" />
				</td>
				<td>
					按销售单查：<input class="textInput" type="text" name="saleNo" value="${saleNo}"/>
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
			    <th>#</th>
			    <th>采购单号</th>
			    <th>采购性质</th>
			    <th>关联销售单</th>
			    <th>厂家</th>
				<th>采购总额</th>
			    <th>制单人</th>
				<th>制单时间</th>
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
			    <td>
			        <c:set value="${fn:split(purchase.saleNos, ',')}" var="saleNos" />
			        <c:forEach var="saleNo" items="${saleNos}">${saleNo}<br/></c:forEach>
			    </td>
			    <td>${purchase.providerName}</td>
			    <td>${myfn:fromF2YForShow(purchase.totalPrice)}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', purchase.createOperId)}</td>
			    <td><fmt:formatDate value="${purchase.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:getConstantName('PURCHASE_STATUS', purchase.status)}</td>
			    <td>
			        <a class="button" href="/purchase/detail/${purchase.purchaseId}/0/0" title="采购详情" target="dialog" width="1000" height="600"><span>详情</span></a>
			        <c:if test="${purchase.status=='2' || purchase.status=='4'}">
			        <mytag:link className="button" href="/purchase/forceOver/${purchase.purchaseId}" title="确定要强制结束本采购单吗？" target="ajaxTodo" desc="强制结束" belong="admin"/>
			        </c:if>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>