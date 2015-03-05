<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <div layoutH="37" class="nowrap">
	    <a class="button" href="/stock/taking/exportTaking/${stockTaking.stockTakingId}" title="确实要导出盘库单吗?" target="dwzExport" targetType="navTab"><span>导出盘库单</span></a>
		<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
			<thead>
			    <tr>
					<th colspan="9" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
				</tr>
				<tr>
					<th colspan="9" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
				</tr>
				<tr>
					<th colspan="9" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
				</tr>
				<tr>
					<th colspan="9" style="height:30px;">Add: ${sessionOper.address}</th>
				</tr>
				<tr>
					<th colspan="9" style="font-size:16px;height:30px;font-weight:bold;">盘库单<br/>${stockTaking.stockTakingNo}</th>
				</tr>
				<tr>
					<th>制单人：</th>
					<th>${myfn:getColumnValue('SYS_OPER.REAL_NAME', stockTaking.regOperId)}</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>制单日期：</th>
					<th><fmt:formatDate value="${stockTaking.regTime}" pattern="yyyy-MM-dd"/></th>
				</tr>
				<tr>
				    <th>#</th>
				    <th>厂家</th>
				    <th>型号</th>
				    <th>产品名</th>
				    <th>规格</th>
					<th>锁定数</th>
					<th>可用数</th>
					<th>盘点可用数</th>
					<th>可用数变化</th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach var="stockTakingDetail" items="${stockTakingDetailList}" varStatus="i">
				<c:choose>
			    <c:when test="${busiType=='02' && stockTakingDetail.stockTakingDetailId == targetLeafId}">
			    <tr style="background-color:#B9ED93;">
			    </c:when>
			    <c:otherwise>
			    <tr>
			    </c:otherwise>
			    </c:choose>
				    <td>${i.index+1}</td>
				    <td>${stockTakingDetail.providerName}</td>
				    <td>${stockTakingDetail.productModel}</td>
				    <td>${stockTakingDetail.productName}</td>
				    <td>${stockTakingDetail.standard}</td>
				    <td>${stockTakingDetail.lockQuantity}</td>
				    <td>${stockTakingDetail.totalQuantity - stockTakingDetail.lockQuantity}</td>
				    <td>${stockTakingDetail.takingQuantity}</td>
				    <td style="color:red;">${stockTakingDetail.takingQuantity - (stockTakingDetail.totalQuantity - stockTakingDetail.lockQuantity)}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>