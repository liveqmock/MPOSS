<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/purchase/listSale">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/purchase/listSale" method="post">
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
			    <td>${myfn:getConstantName('SALE_STATUS', sale.status)}</td>
			    <td><a class="button" href="/purchase/salePur/${sale.saleId}" title="销售采购" rel="purchase_salePur" target="navTab"><span>销售采购</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>