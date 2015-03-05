<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="100%" layoutH="38">
		<thead>
		    <tr>
		        <th colspan="9">【${consumerName} ${transDate}】退货详情</th>
		    </tr>
			<tr>
			    <th>退货时间</th>
			    <th>型号</th>
			    <th>产品名</th>
			    <th>规格</th>
				<th>数量</th>
				<th>价格</th>
				<th>金额</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="sumAmount" value="0"></c:set>
		    <c:forEach var="saleBackColl" items="${saleBackCollList}">
			<tr>
			    <td><fmt:formatDate value="${saleBackColl.transTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${saleBackColl.productModel}</td>
			    <td>${saleBackColl.productName}</td>
			    <td>${saleBackColl.standard}</td>
			    <td>${saleBackColl.quantity}</td>
			    <td>${myfn:fromF2Y(saleBackColl.price)}</td>
			    <td>${myfn:fromF2Y(saleBackColl.amount)}</td>
			</tr>
			<c:set var="sumAmount" value="${sumAmount + saleBackColl.amount}"></c:set>
			</c:forEach>
			<tr>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td>${myfn:fromF2Y(sumAmount)}</td>
			</tr>
		</tbody>
	</table>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>