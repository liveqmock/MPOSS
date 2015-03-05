<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/back/list">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/sale/back/list" method="post">
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
			    <th>退货单号</th>
			    <th>单据类型</th>
			    <th>客户</th>
				<th>退货总额</th>
			    <th>制单人</th>
				<th>制单时间</th>
				<th>制单备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="saleBack" items="${saleBackList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${saleBack.saleBackNo}</td>
			    <td>${myfn:getConstantName('SALE_BACK_TYPE', saleBack.saleBackType)}</td>
			    <td>${saleBack.consumerName}</td>
			    <td>${myfn:fromF2Y(saleBack.totalBackPrice)}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', saleBack.createOperId)}</td>
			    <td><fmt:formatDate value="${saleBack.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(saleBack.createDesc)}</td>
			    <td>${myfn:getConstantName('SALE_BACK_STATUS', saleBack.status)}</td>
			    <td><a class="button" href="/sale/back/detail/${saleBack.saleBackId}" title="销售退货详情" mask="true" target="dialog" width="1024" height="600"><span>详情</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>