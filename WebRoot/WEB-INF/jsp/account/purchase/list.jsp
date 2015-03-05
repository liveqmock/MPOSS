<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/account/purchase/list"></form>

<div class="pageContent">
	<table class="list" width="70%" layoutH="0">
		<thead>
			<tr>
				<th>厂家</th>
				<th>采购金额</th>
				<th>已付货款</th>
				<th>未付货款</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="countWaitPayPrice" value="0"></c:set>
		    <c:forEach var="billBusiBO" items="${billBusiBOList}" varStatus="s">
		    <tr>
		      <td>${billBusiBO.targetName}</td>
		      <td><a class="custom" href="/account/purchase/consumeDetail/${billBusiBO.targetId}" title="采购明细" target="dialog" width="900" height="600">${myfn:fromF2Y(billBusiBO.totalBusiPrice)}</a></td>
		      <td><a class="custom" href="/account/purchase/payDetail/${billBusiBO.targetId}" title="历史付款信息" target="dialog" width="1000" height="600">${myfn:fromF2Y(billBusiBO.totalPayPrice)}</a></td>
		      <td>${myfn:fromF2Y(billBusiBO.waitPayPrice)}</td>
		      <td>
<!--		          <a class="button" title="付款登记" target="dialog" href="/account/purchase/reg/${billBusiBO.targetId}" width="800" height="450"><span>付款登记</span></a>-->
		          <a class="button" title="您确定此客户已结束付款吗？" target="ajaxTodo" href="/account/purchase/over/${billBusiBO.targetId}"><span>付款结束</span></a>
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
