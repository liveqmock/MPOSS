<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/account/sale/list"></form>

<div class="pageContent">
	<table class="list" width="70%" layoutH="0">
		<thead>
			<tr>
				<th>客户</th>
				<th>销售额（元）</th>
				<th>已收款（元）</th>
				<th>未收款（元）</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="countWaitPayPrice" value="0"></c:set>
		    <c:forEach var="billBusiBO" items="${billBusiBOList}" varStatus="s">
		    <tr>
		      <td>${billBusiBO.targetName}</td>
		      <td><a class="custom" href="/account/sale/consumeDetail/${billBusiBO.targetId}" title="销售明细" target="dialog" width="900" height="600">${myfn:fromF2Y(billBusiBO.totalBusiPrice)}</a></td>
		      <td><a class="custom" href="/account/sale/payDetail/${billBusiBO.targetId}" title="历史收款信息" target="dialog" width="1000" height="600">${myfn:fromF2Y(billBusiBO.totalPayPrice)}</a></td>
		      <td>${myfn:fromF2Y(billBusiBO.waitPayPrice)}</td>
		      <td>
<!--		          <a class="button" title="收款登记" target="dialog" href="/account/sale/reg/${billBusiBO.targetId}" width="800" height="450"><span>收款登记</span></a>-->
		          <a class="button" title="您确定此客户已结束收款吗？" target="ajaxTodo" href="/account/sale/over/${billBusiBO.targetId}"><span>收款结束</span></a>
		      </td>
		    </tr>
		    <c:set var="countWaitPayPrice" value="${countWaitPayPrice + billBusiBO.waitPayPrice}"></c:set>
			</c:forEach>
			<tr>
		      <td></td>
		      <td></td>
		      <td>合计：</td>
		      <td>${myfn:fromF2Y(countWaitPayPrice)}</td>
		      <td></td>
		    </tr>
		</tbody>
	</table>
</div>
