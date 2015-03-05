<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/search/list">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/sale/search/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					客户：
					<input class="auto_consumerId" name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
                    <input class="auto_consumerName" type="text" name="consumer.consumerName" value="${consumer.consumerName}"/>
				</td>
				<td>
					产品：
                    <input class="auto_productId" type="hidden" name="product.productId" value="${product.productId}"/>
					<input class="auto_productShow" type="text" name="product.productShow" value="${product.productShow}"/>
				</td>
				<td>
					<select class="combox" name="status" remember="${status}">
						<option value="">状态</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('SALE_STATUS')}">
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
			    <th>单号</th>
			    <th>订单类型</th>
			    <th>客户</th>
				<th>销售总额</th>
				<th>收货人</th>
				<th>联系电话</th>
				<th>收货地址</th>
			    <th>制单人</th>
				<th>制单时间</th>
				<th>制单备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="sale" items="${saleList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${sale.saleNo}</td>
			    <td>${myfn:getConstantName('SALE_TYPE', sale.saleType)}</td>
			    <td>${sale.consumerName}</td>
			    <td>${myfn:fromF2YForShow(sale.totalSalePrice)}</td>
			    <td>${sale.receMen}</td>
			    <td>${sale.linkPhone}</td>
			    <td>${sale.receAddress}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', sale.createOperId)}</td>
			    <td><fmt:formatDate value="${sale.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(sale.createDesc)}</td>
			    <c:choose>
			    <c:when test="${sale.status=='8' && sale.purchaseQuantity == 0}">
			    <td style="color:red;">${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    </c:when>
			    <c:when test="${sale.status=='8' && sale.purchaseQuantity > 0 && sale.totalSaleQuantity > sale.purchaseQuantity}">
			    <td style="color:red;">${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    </c:when>
			    <c:when test="${sale.status=='2' && sale.purchaseQuantity == 0}">
			    <td style="color:red;">${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    </c:when>
			    <c:when test="${sale.status=='2' && sale.purchaseQuantity > 0 && sale.totalSaleQuantity > sale.purchaseQuantity}">
			    <td style="color:red;">${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    </c:when>
			    <c:otherwise>
			    <td>${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    </c:otherwise>
			    </c:choose>
			    <td>
			        <a class="button" href="/sale/search/detail/${sale.saleId}/0/0" title="详情" target="dialog" width="1100" height="660"><span>详情</span></a>
			        <c:if test="${sale.status=='1' || sale.status=='2' || sale.status=='4' || sale.status=='7' || sale.status=='8'}">
			            <mytag:link className="button" href="/sale/search/edit/${sale.saleId}" rel="sale_edit" title="修改订单" target="navTab" desc="修改订单" belong="admin"/>
			        </c:if>
			        <c:if test="${sale.status=='2' || sale.status=='4' || sale.status=='7' || sale.status=='8'}">
			            <mytag:link className="button" href="/sale/search/forceOver/${sale.saleId}" title="您确定要强制结束本销售单吗？" target="ajaxTodo" desc="强制结束" belong="admin"/>
			        </c:if>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>