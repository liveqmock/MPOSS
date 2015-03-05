<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="dealForm" method="post" action="/sale/back/doDeal?navTabId=sale_back_listDeal&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,SaleBackDeal.dialogAjaxDone,'你确定提交处理结果吗？')">
        <input type="hidden" name="saleBackId" value="${saleBack.saleBackId}"/>
        <input id="status" type="hidden" name="status"/>
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
				<tbody id="saleBackDetailTbody">
				    <c:set var="totalBackQuantity" value="0"></c:set>
				    <c:set var="totalBackPrice" value="0"></c:set>
				    <c:forEach var="saleBackDetail" items="${saleBackDetailList}" varStatus="li">
				    <input type="hidden" name="saleBackDetailList[${li.index}].saleBackDetailId" value="${saleBackDetail.saleBackDetailId}"/>
				    <input type="hidden" name="saleBackDetailList[${li.index}].productModel" value="${saleBackDetail.productModel}"/>
				    <input type="hidden" name="saleBackDetailList[${li.index}].productName" value="${saleBackDetail.productName}"/>
				    <input type="hidden" name="saleBackDetailList[${li.index}].backQuantity" value="${saleBackDetail.backQuantity}"/>
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
					    <td><input type="text" size="5" name="saleBackDetailList[${li.index}].stockQuantity"/></td>
					    <td><input type="text" size="5" name="saleBackDetailList[${li.index}].providerQuantity"/></td>
					    <td><input type="text" size="5" name="saleBackDetailList[${li.index}].destroyQuantity"/></td>
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
					<dd><textarea id="confDesc" name="confDesc" cols="80" rows="2"></textarea></dd>
				</dl>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="SaleBackDeal.submit('yes');">提交处理</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="SaleBackDeal.submit('no');">审核不通过</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var SaleBackDeal = {
    dialogAjaxDone : function(json){
        SaleBackDeal.ajaxDone(json);
		if (json.statusCode == DWZ.statusCode.ok){
			if (json.navTabId){
				navTab.reload(json.forwardUrl, {navTabId: json.navTabId});
			} else if (json.rel) {
				var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
				var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
				navTabPageBreak(args, json.rel);
			}
			if ("closeCurrent" == json.callbackType) {
				$.pdialog.closeCurrent();
			}
		}
    },
    ajaxDone:function(json){
		if(json.statusCode == DWZ.statusCode.error) {
			if(json.message && alertMsg) {
			    var array = json.message.split("#");
			    alertMsg.error(array[0]);
			    if(array[1]){
			        var highLightRowArray = array[1].split(",");
				    for(index in highLightRowArray){
				        $("#saleBackDetailTbody tr").eq(highLightRowArray[index]).css("background-color","#EAD48B");
				    }
			    }
			}
		} else if (json.statusCode == DWZ.statusCode.timeout) {
			if(alertMsg) alertMsg.error(json.message || DWZ.msg("sessionTimout"), {okCall:DWZ.loadLogin});
			else DWZ.loadLogin();
		} else {
			if(json.message && alertMsg) alertMsg.correct(json.message);
		};
	},
    submit: function(flag){
        $("#saleBackDetailTbody tr").css("background-color","#FFFFFF");
	    if(flag == 'yes'){
	        $("#status", $.pdialog.getCurrent()).val("2"); //SALE_STATUS (2-已完成)
	    } else {
	        $("#status", $.pdialog.getCurrent()).val("3"); //SALE_STATUS (3-审核不通过)
	        if($("#confDesc", $.pdialog.getCurrent()).val()==""){
	            alertMsg.error("请输入不通过的原因！");
	            return;
	        }
	    }
	    
	    $("#dealForm", $.pdialog.getCurrent()).submit();
	}
};
</script>