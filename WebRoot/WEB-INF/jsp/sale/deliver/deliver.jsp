<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="bakForm" method="post" action="/sale/deliver/doDeliver?navTabId=sale_deliver_listDeliver&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone,'你确定提交发货吗?')">
        <input type="hidden" name="deliverId" value="${deliver.deliverId}"/>
        <input type="hidden" name="consumerId" value="${sale.consumerId}"/>
        <input type="hidden" name="consumerName" value="${sale.consumerName}"/>
	    <div layoutH="38">
			<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
				<thead>
					<tr>
						<th colspan="15" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
					</tr>
					<tr>
						<th colspan="15" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
					</tr>
					<tr>
						<th colspan="15" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
					</tr>
					<tr>
						<th colspan="15" style="height:30px;">Add: ${sessionOper.engAddress}</th>
					</tr>
					<tr>
						<th colspan="15" style="font-size:16px;height:30px;font-weight:bold;">装箱单 PAKING LIST<br/>${deliver.deliverNo}</th>
					</tr>
					<tr>
						<th>NAME：</th>
						<th>${sale.consumerName}</th>
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
						<th></th>
						<th>DATE：</th>
						<th><fmt:formatDate value="${deliver.createTime}" pattern="yyyy-MM-dd"/></th>
					</tr>
					<tr>
					    <th>编号<br/>No.</th>
					    <th>产品型号<br/>MODEL</th>
					    <th>产品名称<br/>ITEM</th>
					    <th>单位<br/>UNIT</th>
						<th>数量<br/>QUANTITY</th>
						<th>件数<br/>CTN</th>
						<th>箱号<br/>NO</th>
						<th>体积<br/>V/m³</th>
						<th>重量<br/>W/KG</th>
						<th>价格<br/>PRICE</th>
						<th>金额<br/>AMOUNT</th>
						<th>图片<br/>PIC</th>
						<th>进货价</th>
						<th>利润</th>
						<th>进货商</th>
					</tr>
				</thead>
				<tbody>
				    <c:set var="totalPackAmount" value="0"></c:set>
				    <c:set var="totalBakVolume" value="0"></c:set>
				    <c:set var="totalBakWeight" value="0"></c:set>
				    <c:set var="totalDeliverPrice" value="0"></c:set>
				    <c:set var="totalProfitPrice" value="0"></c:set>
				    <c:forEach var="deliverDetail" items="${deliverDetailList}" varStatus="li">
				    <tr>
				        <td>${li.index + 1}</td>
				        <td>${deliverDetail.productModel}</td>
				        <td>${deliverDetail.productName}<br/>${deliverDetail.productEngName}</td>
				        <td>${deliverDetail.unit}</td>
				        <td>${deliverDetail.bakQuantity}</td>
				        <td>${deliverDetail.packAmount}</td>
				        <td>${deliverDetail.packNumber}</td>
				        <td>${myfn:formatVolume(deliverDetail.bakVolume)}</td>
				        <td>${myfn:formatWeight(deliverDetail.bakWeight)}</td>
				        <td>${myfn:fromF2Y(deliverDetail.saleUnitPrice)}</td>
				        <td>${myfn:fromF2Y(deliverDetail.bakQuantity * deliverDetail.saleUnitPrice)}</td>
				        <td><img src="${deliverDetail.picImg}" width="90" height="65"/></td>
				        <td>${myfn:fromF2Y(deliverDetail.costUnitPrice)}</td>
				        <td>${myfn:fromF2Y(deliverDetail.bakQuantity * deliverDetail.saleUnitPrice - deliverDetail.bakQuantity * deliverDetail.costUnitPrice)}</td>
				        <td>${deliverDetail.providerName}</td>
				    </tr>
				    <c:set var="totalPackAmount" value="${totalPackAmount + deliverDetail.packAmount}"></c:set>
				    <c:set var="totalBakVolume" value="${totalBakVolume + deliverDetail.bakVolume}"></c:set>
				    <c:set var="totalBakWeight" value="${totalBakWeight + deliverDetail.bakWeight}"></c:set>
				    <c:set var="totalDeliverPrice" value="${totalDeliverPrice + (deliverDetail.bakQuantity * deliverDetail.saleUnitPrice)}"></c:set>
				    <c:set var="totalProfitPrice" value="${totalProfitPrice + (deliverDetail.bakQuantity * deliverDetail.saleUnitPrice - deliverDetail.bakQuantity * deliverDetail.costUnitPrice)}"></c:set>
				    </c:forEach>
				    <tr>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td>${totalPackAmount}</td>
				        <td></td>
				        <td>${myfn:formatVolume(totalBakVolume)}</td>
				        <td>${myfn:formatWeight(totalBakWeight)}</td>
				        <td></td>
				        <td>${myfn:fromF2Y(totalDeliverPrice)}</td>
				        <td></td>
				        <td></td>
				        <td>${myfn:fromF2Y(totalProfitPrice)}</td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>