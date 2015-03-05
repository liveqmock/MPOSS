<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;" layoutH="37">
		<thead>
			<tr>
				<th colspan="10" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
			</tr>
			<tr>
				<th colspan="10" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
			</tr>
			<tr>
				<th colspan="10" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
			</tr>
			<tr>
				<th colspan="10" style="height:30px;">Add: ${sessionOper.address}</th>
			</tr>
			<tr>
				<th colspan="10" style="font-size:16px;height:30px;font-weight:bold;">采购账单 BILL</th>
			</tr>
			<tr>
				<th>NAME：</th>
				<th>${targetName}</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
			    <th>日期</th>
			    <th>产品型号</th>
			    <th>产品名称</th>
			    <th>规格<br/>STANDARD</th>
			    <th>单位<br/>UNIT</th>
				<th>数量<br/>QUANTITY</th>
				<th>单价<br/>PRICE</th>
				<th>应收/应付</th>
				<th>金额<br/>AMOUNT</th>
				<th>订单<br/>ORDER</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalBusiPrice" value="0"></c:set>
		    <c:forEach var="consume" items="${consumeList}" varStatus="i">
		    <tr>
			    <td><fmt:formatDate value="${consume.consumeTime}" pattern="yyyy-MM-dd"/></td>
			    <td>${consume.productModel}</td>
			    <td>${consume.productName}</td>
			    <td>${consume.standard}</td>
			    <td>${consume.unit}</td>
			    <td>${consume.quantity}</td>
			    <td>${myfn:fromF2Y(consume.unitPrice)}</td>
			    <c:choose>
			    <c:when test="${consume.price>0}">
			    <td style="color:green;">应收</td>
			    <td>${myfn:fromF2Y(consume.price)}</td>
			    </c:when>
			    <c:otherwise>
			    <td style="color:red;">应付</td>
			    <td>${myfn:fromF2Y(0-consume.price)}</td>
			    </c:otherwise>
			    </c:choose>
			    <td>${consume.paperNo}</td>
			</tr>
			<c:set var="totalBusiPrice" value="${totalBusiPrice + consume.price}"></c:set>
		    </c:forEach>
		    <tr>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td>合计：</td>
		        <c:choose>
		        <c:when test="${totalBusiPrice>0}">
			    <td style="color:green;">应收</td>
			    <td>${myfn:fromF2Y(totalBusiPrice)}</td>
			    </c:when>
			    <c:otherwise>
			    <td style="color:red;">应付</td>
			    <td>${myfn:fromF2Y(0-totalBusiPrice)}</td>
			    </c:otherwise>
		        </c:choose>
		        <td></td>
		    </tr>
		</tbody>
	</table>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>