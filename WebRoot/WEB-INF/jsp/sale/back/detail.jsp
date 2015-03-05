<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
       <div layoutH="37" class="nowrap">
		<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
			<thead>
				<tr>
					<th colspan="14" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
				</tr>
				<tr>
					<th colspan="14" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
				</tr>
				<tr>
					<th colspan="14" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
				</tr>
				<tr>
					<th colspan="14" style="height:30px;">Add: ${sessionOper.engAddress}</th>
				</tr>
				<tr>
					<th colspan="14" style="font-size:16px;height:30px;font-weight:bold;">销售退货单<br/>${saleBack.saleBackNo}</th>
				</tr>
				<tr>
					<th>NAME：</th>
					<th>${saleBack.consumerName}</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>DATE：</th>
					<th><fmt:formatDate value="${saleBack.createTime}" pattern="yyyy-MM-dd"/></th>
				</tr>
				<tr>
				    <th>编号<br/>No.</th>
				    <th>产品型号<br/>MODEL</th>
				    <th>产品名称<br/>ITEM</th>
				    <th>规格<br/>STANDARD</th>
				    <th>单位<br/>UNIT</th>
					<th>数量<br/>QUANTITY</th>
					<th>单价<br/>PRICE</th>
					<th>金额<br/>AMOUNT</th>
					<th>图片<br/>PIC</th>
					<th>备注</th>
					<th>供应商</th>
					<th>入库数</th>
					<th>返厂数</th>
					<th>销毁数</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="totalBackQuantity" value="0"></c:set>
			    <c:set var="totalBackPrice" value="0"></c:set>
			    <c:forEach var="saleBackDetail" items="${saleBackDetailList}" varStatus="li">
			    <input type="hidden" name="saleBackDetailList[${li.index}].saleBackDetailId" value="${saleBackDetail.saleBackDetailId}"/>
			    <tr>
				    <td>${saleBackDetail.saleBackDetailNo}</td>
				    <td>${saleBackDetail.productModel}</td>
				    <td>${saleBackDetail.productName}</td>
				    <td>${saleBackDetail.standard}</td>
				    <td>${saleBackDetail.unit}</td>
				    <td>${saleBackDetail.backQuantity}</td>
				    <td>${myfn:fromF2Y(saleBackDetail.backUnitPrice)}</td>
				    <td>${myfn:fromF2Y(saleBackDetail.backPrice)}</td>
				    <td><img src="${saleBackDetail.picImg}" width="90" height="65"/></td>
				    <td>${saleBackDetail.backDesc}</td>
				    <td>${saleBackDetail.providerName}</td>
				    <td>${saleBackDetail.stockQuantity}</td>
				    <td>${saleBackDetail.providerQuantity}</td>
				    <td>${saleBackDetail.destroyQuantity}</td>
				</tr>
				<c:set var="totalBackQuantity" value="${totalBackQuantity + saleBackDetail.backQuantity}"></c:set>
			    <c:set var="totalBackPrice" value="${totalBackPrice + saleBackDetail.backPrice}"></c:set>
			    </c:forEach>
			    <tr>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td>合计：</td>
			        <td>${totalBackQuantity}</td>
			        <td></td>
			        <td>${myfn:fromF2Y(totalBackPrice)}</td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
			</tbody>
		</table>
		<div class="pageFormContent nowrap">
			<dl>
				<dt>备注：</dt>
				<dd><textarea id="confDesc" name="confDesc" cols="80" rows="2" readonly="readonly">${saleBack.confDesc}</textarea></dd>
			</dl>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>