<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="70%" layoutH="117">
		<thead>
			<tr>
				<th>#</th>
				<th>支付时间</th>
				<th>支付服务</th>
				<th align="right">支付金额</th>
				<th>支付方式</th>
				<th>付款银行</th>
				<th>付款卡号</th>
				<th>凭证号</th>
				<th>服务开始日期</th>
				<th>服务结束日期</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="pay" items="${payList}" varStatus="li">
			<tr>
				<td>${li.index + 1}</td>
				<td><fmt:formatDate value="${pay.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${myfn:getConstantName('PLAT_SERVICE_TYPE', pay.platServiceType)}</td>
				<td align="right">${myfn:fromF2YForShow(pay.payPrice)}</td>
				<td>${myfn:getConstantName('PAY_WAY', pay.payWay)}</td>
				<td>${myfn:getColumnValue('ACC_BANK.BANK_NAME', pay.bankId)}</td>
				<td>${pay.bankCardNo}</td>
				<td>${pay.paperNo}</td>
				<td>${pay.startDate}</td>
				<td>${pay.endDate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
