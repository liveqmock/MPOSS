<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/deliver/listBak">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/sale/deliver/listBak" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					客户：
					<input class="auto_consumerId" name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
                    <input class="auto_consumerName" type="text" name="consumer.consumerName" value="${consumer.consumerName}"/>
				</td>
				<td>
					按销售单查：<input class="textInput" type="text" name="saleNo" value="${saleNo}"/>
				</td>
				<td>
					按采购单查：<input class="textInput" type="text" name="purchaseNo" value="${purchaseNo}"/>
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
	<table class="list" width="100%" layoutH="62">
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
				<th>制单备注</th>
				<th>交货日期</th>
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
			    <td>${myfn:substring(sale.createDesc)}</td>
			    <td>${sale.arrivalDate}</td>
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
			        <a class="button" href="/sale/deliver/bak/${sale.saleId}" title="备货登记" target="dialog" width="1200" height="550"><span>备货登记</span></a>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>