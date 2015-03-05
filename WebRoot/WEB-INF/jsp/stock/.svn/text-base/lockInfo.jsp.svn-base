<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<table class="list" width="100%" layoutH=30">
		<thead>
			<tr>
			    <th>#</th>
			    <th>时间</th>
			    <th>厂家</th>
			    <th>型号</th>
			    <th>产品名</th>
			    <th>规格</th>
				<th>锁定数</th>
				<th>关联业务</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:set var="totalLockQuantity" value="0"></c:set>
		    <c:forEach var="stockLock" items="${stockLockList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td><fmt:formatDate value="${stockLock.lockTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${stockLock.providerName}</td>
			    <td>${stockLock.productModel}</td>
			    <td>${stockLock.productName}</td>
			    <td>${stockLock.standard}</td>
				<td>${stockLock.lockQuantity}</td>
				<td>${myfn:getConstantName('BUSI_TYPE', stockLock.busiType)}</td>
				<td><a class="button" href="/sale/search/detail/${stockLock.topId}/${stockLock.busiType}/${stockLock.targetLeafId}" title="详情" target="dialog" width="1000" height="660"><span>详情</span></a></td>
			</tr>
		    <c:set var="totalLockQuantity" value="${totalLockQuantity + stockLock.lockQuantity}"></c:set>
			</c:forEach>
			<tr>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td></td>
			  <td>合计：</td>
			  <td>${totalLockQuantity}</td>
			  <td></td>
			  <td></td>
			</tr>
		</tbody>
	</table>
</div>