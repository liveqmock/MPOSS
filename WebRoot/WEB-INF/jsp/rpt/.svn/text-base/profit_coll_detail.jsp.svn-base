<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="100%" layoutH="38">
		<thead>
		    <tr>
		        <th colspan="10">【${consumerName} ${transDate}】交易详情</th>
		    </tr>
			<tr>
			    <th>交易时间</th>
			    <th>型号</th>
			    <th>产品名</th>
			    <th>规格</th>
				<th>数量</th>
				<th>价格</th>
				<th>金额</th>
				<th>成本价</th>
				<th>参考利润</th>
				<th>实际利润</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="sumAmount" value="0"></c:set>
		    <c:set var="sumProfitAmount" value="0"></c:set>
		    <c:set var="sumRealProfitAmount" value="0"></c:set>
		    <c:forEach var="profitColl" items="${profitCollList}">
			<tr>
			    <td><fmt:formatDate value="${profitColl.transTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${profitColl.productModel}</td>
			    <td>${profitColl.productName}</td>
			    <td>${profitColl.standard}</td>
			    <td>${profitColl.quantity}</td>
			    <td>${myfn:fromF2Y(profitColl.price)}</td>
			    <td>${myfn:fromF2Y(profitColl.amount)}</td>
			    <td>${myfn:fromF2Y(profitColl.costPrice)}</td>
			    <td>${myfn:fromF2Y(profitColl.profitAmount)}</td>
			    <td>${myfn:fromF2Y(profitColl.realProfitAmount)}</td>
			</tr>
			<c:set var="sumAmount" value="${sumAmount + profitColl.amount}"></c:set>
		    <c:set var="sumProfitAmount" value="${sumProfitAmount + profitColl.profitAmount}"></c:set>
		    <c:set var="sumRealProfitAmount" value="${sumRealProfitAmount + profitColl.profitAmount}"></c:set>
			</c:forEach>
			<tr>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td>${myfn:fromF2Y(sumAmount)}</td>
			    <td></td>
			    <td>${myfn:fromF2Y(sumProfitAmount)}</td>
			    <td>${myfn:fromF2Y(sumRealProfitAmount)}</td>
			</tr>
		</tbody>
	</table>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>