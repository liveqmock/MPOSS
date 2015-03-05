<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="confForm" method="post" action="/sale/make/doConf?navTabId=sale_make_listConf&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone,'你确定提交审核结果吗？')">
        <input type="hidden" name="saleId" value="${sale.saleId}"/>
        <input id="status" type="hidden" name="status"/>
        <div layoutH="37" class="nowrap">
			<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
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
						<th colspan="10" style="height:30px;">Add: ${sessionOper.engAddress}</th>
					</tr>
					<tr>
						<th colspan="10" style="font-size:16px;height:30px;font-weight:bold;">销售单 ORDER<br/>${sale.saleNo}</th>
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
						<th>DATE：</th>
						<th><fmt:formatDate value="${sale.createTime}" pattern="yyyy-MM-dd"/></th>
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
					</tr>
				</thead>
				<tbody>
				    <c:set var="totalSaleQuantity" value="0"></c:set>
				    <c:set var="totalSalePrice" value="0"></c:set>
				    <c:forEach var="saleDetail" items="${saleDetailList}" varStatus="i">
				    <tr>
					    <td>${saleDetail.saleDetailNo}</td>
					    <td>${saleDetail.productModel}</td>
					    <td>${saleDetail.productName}</td>
					    <td>${saleDetail.standard}</td>
					    <td>${saleDetail.unit}</td>
					    <td>${saleDetail.saleQuantity}</td>
					    <td>
					        <c:if test="${saleDetail.saleUnitPrice != null}">${myfn:fromF2Y(saleDetail.saleUnitPrice)}</c:if>
					    </td>
					    <td>
					        <c:if test="${saleDetail.salePrice != null}">${myfn:fromF2Y(saleDetail.salePrice)}</c:if>
					    </td>
					    <td><img src="${saleDetail.picImg}" width="90" height="65"/></td>
					    <td>${saleDetail.saleDesc}</td>
					</tr>
					<c:set var="totalSaleQuantity" value="${totalSaleQuantity + saleDetail.saleQuantity}"></c:set>
				    <c:set var="totalSalePrice" value="${totalSalePrice + saleDetail.salePrice}"></c:set>
				    </c:forEach>
				    <tr>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td>${totalSaleQuantity}</td>
				        <td></td>
				        <td>${myfn:fromF2Y(totalSalePrice)}</td>
				        <td></td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
			<div class="pageFormContent nowrap">
				<dl>
					<dt>审批备注：</dt>
					<dd><textarea id="confDesc" name="confDesc" cols="80" rows="2"></textarea></dd>
				</dl>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="SaleConf.submit('yes');">通过</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="SaleConf.submit('no');">不通过</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var SaleConf = {
    submit: function(flag){
	    if(flag == 'yes'){
	        $("#status", $.pdialog.getCurrent()).val("8"); //SALE_STATUS (8-新订单)
	    } else {
	        $("#status", $.pdialog.getCurrent()).val("3"); //SALE_STATUS (3-审核不通过)
	        if($("#confDesc", $.pdialog.getCurrent()).val()==""){
	            alertMsg.error("请输入不通过的原因！");
	            return;
	        }
	    }
	    
	    $("#confForm", $.pdialog.getCurrent()).submit();
	}
};
</script>