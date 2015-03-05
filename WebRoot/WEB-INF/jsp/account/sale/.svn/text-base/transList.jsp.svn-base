<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="100%" layoutH="37">
		<thead>
			<tr>
				<th>支付时间</th>
				<th>交易类型</th>
				<th>货款类型</th>
				<th>收支</th>
				<th>交易金额（元）</th>
				<th>交易后余额（元）</th>
				<th>相关方</th>
				<th>关联本方账户</th>
				<th>登记人</th>
				<th>登记时间</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalTransPrice" value="0"/>
		    <c:forEach var="trans" items="${transList}">
			<tr>
				<td><fmt:formatDate value="${trans.transTime}" pattern="yyyy-MM-dd"/></td>
				<td>${myfn:getConstantName('TRANS_ITEM', trans.transItem)}</td>
				<td>${myfn:getConstantName('BILL_TYPE', trans.billType)}</td>
			    <c:choose>
			    <c:when test="${trans.transPrice>=0}">
			    <td style="color:green;">收入</td>
			    <td>${myfn:fromF2YForShow(trans.transPrice)}</td>
			    </c:when>
			    <c:otherwise>
			    <td style="color:red;">支出</td>
			    <td>${myfn:fromF2YForShow(0-trans.transPrice)}</td>
			    </c:otherwise>
			    </c:choose>
				<td>${myfn:fromF2YForShow(trans.afterPrice)}</td>
				<td>${trans.targetName}</td>
				<td>
			        <c:choose>
			        <c:when test="${trans.accountType=='1'}">现金账户</c:when>
			        <c:otherwise>${trans.accountNo}</c:otherwise>
			        </c:choose>
			    </td>
				<td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', trans.regOperId)}</td>
			    <td><fmt:formatDate value="${trans.regTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${trans.transMemo}</td>
			</tr>
			<c:set var="totalTransPrice" value="${totalTransPrice + trans.transPrice}"/>
			</c:forEach>
			<tr>
			    <td></td>
			    <td></td>
			    <td>合计：</td>
			    <c:choose>
			    <c:when test="${totalTransPrice>=0}">
			    <td style="color:green;">收入</td>
			    <td>${myfn:fromF2YForShow(totalTransPrice)}</td>
			    </c:when>
			    <c:otherwise>
			    <td style="color:red;">支出</td>
			    <td>${myfn:fromF2YForShow(0-totalTransPrice)}</td>
			    </c:otherwise>
			    </c:choose>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
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