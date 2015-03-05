<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/back/listFinishDeliver">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/sale/back/listFinishDeliver" method="post">
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
					按装箱单查：<input class="textInput" type="text" name="deliverNo" value="${deliverNo}"/>
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
			    <th>销售单号</th>
			    <th>订单类型</th>
			    <th>客户</th>
				<th>销售总额</th>
				<th>收货人</th>
				<th>联系电话</th>
				<th>收货地址</th>
				<th>装箱单号</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="deliver" items="${deliverList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${deliver.saleNo}</td>
			    <td>${myfn:getConstantName('SALE_TYPE', deliver.saleType)}</td>
			    <td>${deliver.consumerName}</td>
			    <td>${myfn:fromF2YForShow(deliver.totalSalePrice)}</td>
			    <td>${deliver.receMen}</td>
			    <td>${deliver.linkPhone}</td>
			    <td>${deliver.receAddress}</td>
			    <td>${deliver.deliverNo}</td>
			    <td>${myfn:getConstantName('DELIVER_STATUS', deliver.status)}</td>
			    <td>
			        <a class="button" href="/sale/back/refAdd/${deliver.deliverId}" title="销售引用退货" target="navTab" rel="sale_back_refAdd"><span>引用退货</span></a>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>