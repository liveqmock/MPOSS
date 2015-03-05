<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/stock/list">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/stock/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
				</td>
				<td>
					型号：
                    <input class="auto_productModel" type="text" name="product.productModel" value="${product.productModel}"/>
				</td>
				<td>
					产品名：
                    <input class="auto_productName" type="text" name="product.productName" value="${product.productName}"/>
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
	<table class="list" width="50%" layoutH=89">
		<thead>
			<tr>
			    <th>#</th>
			    <th>厂家</th>
			    <th>型号</th>
			    <th>产品名</th>
			    <th>英文名</th>
				<th>可用数</th>
				<th>锁定数</th>
				<th>待返厂数</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="stock" items="${stockList}" varStatus="i">
		    <tr>
			    <td>${i.index+1}</td>
			    <td>${stock.providerName}</td>
			    <td>${stock.productModel}</td>
			    <td>${stock.productName}</td>
			    <td>${stock.productEngName}</td>
				<td>
				    <c:choose>
				    <c:when test="${stock.totalQuantity - stock.lockQuantity > 0}">
				    <a class="custom" href="/stock/canUseInfo/${stock.providerProductId}" title="可用库存明细" target="dialog" width="900" height="500">${stock.totalQuantity - stock.providerQuantity - stock.lockQuantity}</a>
				    </c:when>
				    <c:otherwise>${stock.totalQuantity - stock.providerQuantity - stock.lockQuantity}</c:otherwise>
				    </c:choose>
				</td>
				<td>
				    <c:choose>
				    <c:when test="${stock.lockQuantity > 0}">
				    <a class="custom" href="/stock/lockInfo/${stock.providerProductId}" title="锁定库存明细" target="dialog" width="900" height="500">${stock.lockQuantity}</a>
				    </c:when>
				    <c:otherwise>${stock.lockQuantity}</c:otherwise>
				    </c:choose>
				</td>
				<td>
				    <c:choose>
				    <c:when test="${stock.providerQuantity > 0}">
				    <a class="custom" href="/stock/providerInfo/${stock.providerProductId}" title="待返厂库存明细" target="dialog" width="900" height="500">${stock.providerQuantity}</a>
				    </c:when>
				    <c:otherwise>${stock.providerQuantity}</c:otherwise>
				    </c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>