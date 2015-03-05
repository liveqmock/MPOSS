<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/deliver/edit/${deliver.deliverId}"></form>
<div class="pageContent">
    <form id="bakForm" method="post" action="/sale/deliver/doCancel?navTabId=sale_deliver_listBakEdit&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone,'你确定取消整个装箱单吗?')">
        <input type="hidden" name="deliverId" value="${deliver.deliverId}"/>
	    <div layoutH="38">
			<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
				<thead>
					<tr>
						<th colspan="16" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
					</tr>
					<tr>
						<th colspan="16" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
					</tr>
					<tr>
						<th colspan="16" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
					</tr>
					<tr>
						<th colspan="16" style="height:30px;">Add: ${sessionOper.engAddress}</th>
					</tr>
					<tr>
						<th colspan="16" style="font-size:16px;height:30px;font-weight:bold;">装箱单 PAKING LIST<br/>${deliver.deliverNo}</th>
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
						<th></th>
					</tr>
				</thead>
				<tbody id="deliverEdit">
				    <c:set var="totalPackAmount" value="0"></c:set>
				    <c:set var="totalBakVolume" value="0"></c:set>
				    <c:set var="totalBakWeight" value="0"></c:set>
				    <c:set var="totalBakPrice" value="0"></c:set>
				    <c:set var="totalProfitPrice" value="0"></c:set>
				    <c:forEach var="deliverDetail" items="${deliverDetailList}" varStatus="li">
				    <tr>
				        <td>${li.index + 1}</td>
				        <td>${deliverDetail.productModel}</td>
				        <td>${deliverDetail.productName}<br/>${deliverDetail.productEngName}</td>
				        <td>${deliverDetail.unit}</td>
				        <td>${deliverDetail.bakQuantity}</td>
				        <td custom="packAmount">${deliverDetail.packAmount}</td>
				        <td>${deliverDetail.packNumber}</td>
				        <td custom="bakVolume">${myfn:formatVolume(deliverDetail.bakVolume)}</td>
				        <td custom="bakWeight">${myfn:formatWeight(deliverDetail.bakWeight)}</td>
				        <td>${myfn:fromF2Y(deliverDetail.saleUnitPrice)}</td>
				        <td custom="bakPrice">${myfn:fromF2Y(deliverDetail.bakQuantity * deliverDetail.saleUnitPrice)}</td>
				        <td><img src="${deliverDetail.picImg}" width="90" height="65"/></td>
				        <td>${myfn:fromF2Y(deliverDetail.costUnitPrice)}</td>
				        <td custom="profitPrice">${myfn:fromF2Y(deliverDetail.bakQuantity * deliverDetail.saleUnitPrice - deliverDetail.bakQuantity * deliverDetail.costUnitPrice)}</td>
				        <td>${deliverDetail.providerName}</td>
				        <td>
<!--				            <a title="确定释放此装箱单产品吗？" target="ajaxTodo" href="/sale/deliver/del/${deliverDetail.deliverDetailId}" class="button"><span>删除</span></a>-->
				            <a href="javascript:void(0);" class="button" onclick="DeliverEdit.removeRowWithData(this,${deliverDetail.deliverDetailId});"><span>删除</span></a>
				        </td>
				    </tr>
				    <c:set var="totalPackAmount" value="${totalPackAmount + deliverDetail.packAmount}"></c:set>
				    <c:set var="totalBakVolume" value="${totalBakVolume + deliverDetail.bakVolume}"></c:set>
				    <c:set var="totalBakWeight" value="${totalBakWeight + deliverDetail.bakWeight}"></c:set>
				    <c:set var="totalBakPrice" value="${totalBakPrice + (deliverDetail.bakQuantity * deliverDetail.saleUnitPrice)}"></c:set>
				    <c:set var="totalProfitPrice" value="${totalProfitPrice + (deliverDetail.bakQuantity * deliverDetail.saleUnitPrice - deliverDetail.bakQuantity * deliverDetail.costUnitPrice)}"></c:set>
				    </c:forEach>
				    <tr>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td id="totalPackAmount">${totalPackAmount}</td>
				        <td></td>
				        <td id="totalBakVolume">${myfn:formatVolume(totalBakVolume)}</td>
				        <td id="totalBakWeight">${myfn:formatWeight(totalBakWeight)}</td>
				        <td></td>
				        <td id="totalBakPrice">${myfn:fromF2Y(totalBakPrice)}</td>
				        <td></td>
				        <td></td>
				        <td id="totalProfitPrice">${myfn:fromF2Y(totalProfitPrice)}</td>
				        <td></td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">整单取消</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var DeliverEdit = {
    removeRowWithData: function(link, deliverDetailId){
        var $tr = $(link).closest("tr");
        alertMsg.confirm("确定释放此装箱单产品吗？", {okCall: function(){
            $.ajax({
	            async: false,
	            dataType: "json",
	            type : "GET",
	            url: "/sale/deliver/del/"+deliverDetailId,
	            success: function(data){
                    $tr.remove();
                    DeliverEdit.count();
	            }
	        });
        }});
        
    },
    count: function(){
	    var totalPackAmount = 0;
	    var totalBakVolume = 0;
	    var totalBakWeight = 0;
	    var totalBakPrice = 0;
	    var totalProfitPrice = 0;
	    var $trs = $("#deliverEdit tr", $.pdialog.getCurrent()).not(":last");
	    $.each($trs, function(i, tr){
	        var $tr = $(this);
	        var packAmount = Number($tr.find("td[custom='packAmount']").html());
	        var bakVolume = Number($tr.find("td[custom='bakVolume']").html());
	        var bakWeight = Number($tr.find("td[custom='bakWeight']").html());
	        var bakPrice = Number($tr.find("td[custom='bakPrice']").html());
	        var profitPrice = Number($tr.find("td[custom='profitPrice']").html());
	        
	        totalPackAmount+=packAmount;
	        totalBakVolume+=bakVolume;
	        totalBakWeight+=bakWeight;
	        totalBakPrice+=bakPrice;
	        totalProfitPrice+=profitPrice;
	    });
	    $("#totalPackAmount", $.pdialog.getCurrent()).html(totalPackAmount);
	    $("#totalBakVolume", $.pdialog.getCurrent()).html(totalBakVolume.toFixed(6));
	    $("#totalBakWeight", $.pdialog.getCurrent()).html(totalBakWeight.toFixed(2));
	    $("#totalBakPrice", $.pdialog.getCurrent()).html(totalBakPrice.toFixed(2));
	    $("#totalProfitPrice", $.pdialog.getCurrent()).html(totalProfitPrice.toFixed(2));
	}
};
</script>