<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/stock/listChange">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/stock/listChange" method="post">
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
					<select class="combox" name="changeAction" remember="${changeAction}">
					    <option value="">库存动作</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('STOCK_CHANGE_ACTION')}">
					    <option value="${entry.key}">${entry.value}</option>
					    </c:forEach>
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
	<table class="list" width="70%" layoutH=89">
		<thead>
			<tr>
			    <th>时间</th>
			    <th>厂家</th>
			    <th>型号</th>
			    <th>产品名</th>
			    <th>规格</th>
				<th>动作</th>
				<th>数量</th>
				<th>触发业务</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="stockChange" items="${stockChangeList}">
			<tr>
			    <td><fmt:formatDate value="${stockChange.changeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${stockChange.providerName}</td>
			    <td>${stockChange.productModel}</td>
			    <td>${stockChange.productName}</td>
			    <td>${stockChange.standard}</td>
				<td>${myfn:getConstantName('STOCK_CHANGE_ACTION', stockChange.changeAction)}</td>
				<td>${stockChange.changeQuantity}</td>
				<td>${myfn:getConstantName('BUSI_TYPE', stockChange.busiType)}</td>
				<td>
				    <c:choose>
				    <c:when test="${stockChange.busiType=='02'}"><!-- 库存盘点 -->
				    <a class="button" href="/stock/taking/takingDetail/${stockChange.topId}/${stockChange.busiType}/${stockChange.targetLeafId}" title="详情" target="dialog" width="900" height="600"><span>详情</span></a>
				    </c:when>
				    <c:when test="${stockChange.busiType=='03'}"><!-- 采购到货 -->
				    <a class="button" href="/purchase/detail/${stockChange.topId}/${stockChange.busiType}/${stockChange.targetLeafId}" title="详情" target="dialog" width="1000" height="600"><span>详情</span></a>
				    </c:when>
				    <c:when test="${stockChange.busiType=='04'}"><!-- 装箱单备货 -->
				    <a class="button" href="/sale/search/detail/${stockChange.topId}/${stockChange.busiType}/${stockChange.targetLeafId}" title="详情" target="dialog" width="1000" height="660"><span>详情</span></a>
				    </c:when>
				    <c:when test="${stockChange.busiType=='05'}"><!-- 装箱单发货 -->
				    <a class="button" href="/sale/search/detail/${stockChange.topId}/${stockChange.busiType}/${stockChange.targetLeafId}" title="详情" target="dialog" width="1000" height="660"><span>详情</span></a>
				    </c:when>
				    <c:when test="${stockChange.busiType=='09'}"><!-- 销售单强制结束 -->
				    <a class="button" href="/sale/search/detail/${stockChange.topId}/${stockChange.busiType}/${stockChange.targetLeafId}" title="详情" target="dialog" width="1000" height="660"><span>详情</span></a>
				    </c:when>
				    <c:otherwise></c:otherwise>
				    </c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>