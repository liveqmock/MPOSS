<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="arrivalForm" method="post" action="/purchase/doArrival?navTabId=purchase_list_arrival&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return SalePurArrival.validateCallback(this,dialogAjaxDone,'你确定提交到货吗？')">
        <input type="hidden" name="purchaseId" value="${purchase.purchaseId}"/>
        <input type="hidden" name="providerId" value="${purchase.providerId}"/>
        <input type="hidden" name="providerName" value="${purchase.providerName}"/>
        <input type="hidden" id="arrivalQuantityHidden" name="arrivalQuantity"/>
        <input id="status" type="hidden" name="status" value="${purchase.status}"/>
	    <div layoutH="38">
			<table class="list" width="100%">
			    <thead>
					<tr>
					    <th colspan="11" style="text-align:left;font-weight:bold;">采购到货登记<a style="float:right;" class="button" href="javascript:SalePurArrival.allArrival();"><span>全部到货</span></a></th>
					</tr>
				</thead>
				<thead>
					<tr>
					    <th>产品型号</th>
					    <th>产品名称</th>
					    <th>规格</th>
					    <th>销售单</th>
					    <th>销售产品编号</th>
						<th>采购单价</th>
						<th>采购数</th>
						<th>已到货数</th>
						<th>本次到货数</th>
					</tr>
				</thead>
				<tbody id="purchaseDetailTbody">
				    <c:set var="totalQuantity" value="0"></c:set>
				    <c:set var="hisTotalArrivalQuantity" value="0"></c:set>
				    <c:forEach var="purchaseDetail" items="${purchaseDetailList}" varStatus="li">
					<tr>
					    <input type="hidden" name="arrivalDetailList[${li.index}].purchaseDetailId" value="${purchaseDetail.purchaseDetailId}"/>
	                    <input type="hidden" name="arrivalDetailList[${li.index}].providerProductId" value="${purchaseDetail.providerProductId}"/>
	                    <input type="hidden" name="arrivalDetailList[${li.index}].inputPurchaseUnitPrice" value="${myfn:fromF2Y(purchaseDetail.purchaseUnitPrice)}"/>
	                    <input type="hidden" name="arrivalDetailList[${li.index}].standard" value="${purchaseDetail.standard}"/>
	                    <input type="hidden" name="arrivalDetailList[${li.index}].saleNo" value="${purchaseDetail.saleNo}"/>
	                    <input type="hidden" name="arrivalDetailList[${li.index}].saleDetailId" value="${purchaseDetail.saleDetailId}"/>
	                    <input type="hidden" name="arrivalDetailList[${li.index}].saleDetailNo" value="${purchaseDetail.saleDetailNo}"/>
					    <td>${purchaseDetail.productModel}</td>
					    <td>${purchaseDetail.productName}</td>
					    <td>${purchaseDetail.standard}</td>
					    <td>${purchaseDetail.saleNo}</td>
					    <td>${purchaseDetail.saleDetailNo}</td>
					    <td>${myfn:fromF2Y(purchaseDetail.purchaseUnitPrice)}</td>
					    <td custom="purchaseQuantity">${purchaseDetail.purchaseQuantity}</td>
					    <td custom="hisArrivalQuantity">${purchaseDetail.arrivalQuantity}</td>
					    <td><input class="digits" type="text" name="arrivalDetailList[${li.index}].arrivalQuantity" size="5" onchange="SalePurArrival.changeArrivalQuantity();"/></td>
					</tr>
					<c:set var="totalQuantity" value="${totalQuantity + purchaseDetail.purchaseQuantity}"></c:set>
					<c:set var="hisTotalArrivalQuantity" value="${hisTotalArrivalQuantity + purchaseDetail.arrivalQuantity}"></c:set>
					</c:forEach>
					<tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td>合计：</td>
					    <td id="totalPurchaseQuantity">${totalQuantity}</td>
					    <td id="totalHisArrivalQuantity">${hisTotalArrivalQuantity}</td>
					    <td id="totalArrivalQuantity">0</td>
					</tr>
				</tbody>
			</table>
			<br/>
			<div class="pageFormContent nowrap">
				<dl>
					<dt>到货备注：</dt>
					<dd><textarea name="regDesc" cols="80" rows="2"></textarea></dd>
				</dl>
			</div>
		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var SalePurArrival = {
    count: function(){
        var totalArrivalQuantity = 0;
        var $arrivalQuantitys = $("#purchaseDetailTbody", $.pdialog.getCurrent()).find("input[name$=arrivalQuantity]");
        $.each($arrivalQuantitys, function(i, input){
            var arrivalQuantity = $(this).val();
            if(arrivalQuantity){
                totalArrivalQuantity+=Number(arrivalQuantity);
            }
        });
        
        $("#totalArrivalQuantity", $.pdialog.getCurrent()).html(totalArrivalQuantity);
    },
    changeArrivalQuantity: function(){
        SalePurArrival.count();
    },
    allArrival: function(){
        var $trs = $("#purchaseDetailTbody tr", $.pdialog.getCurrent()).not(":last");
	    $.each($trs, function(i, tr){
	        var $tr = $(tr);
	        var purchaseQuantity = Number($tr.find("td[custom='purchaseQuantity']").html());
	        var hisArrivalQuantity = Number($tr.find("td[custom='hisArrivalQuantity']").html());
	        var waitArrivalQuantity = purchaseQuantity - hisArrivalQuantity;
	        $tr.find("input[name$='arrivalQuantity']").val(waitArrivalQuantity);
	    });
	    SalePurArrival.count();
    },
    validateCallback: function(form, callback, confirmMsg){
    
        var $form = $(form);
    
        $("#purchaseDetailTbody tr", $.pdialog.getCurrent()).css("background-color","#FFFFFF");
		
		var $trs = $("#purchaseDetailTbody tr", $.pdialog.getCurrent()).not(":last");
	    var noContainData = true;
	    var quantityOverLimit = false;
	    $.each($trs, function(i, tr){
	        var $tr = $(tr);
	        var arrivalQuantity = Number($tr.find("input[name$='arrivalQuantity']").val());
	        if(noContainData == true && arrivalQuantity != 0){
	            noContainData = false;
	        }
	        var purchaseQuantity = Number($tr.find("td[custom='purchaseQuantity']").html());
	        var hisArrivalQuantity = Number($tr.find("td[custom='hisArrivalQuantity']").html());
	        var waitArrivalQuantity = purchaseQuantity - hisArrivalQuantity;
	        if(arrivalQuantity > waitArrivalQuantity){
	            $tr.css("background-color","#EAD48B");
	            quantityOverLimit = true;
	            return false;
	        }
	    });
    
        if(noContainData){
            alertMsg.error("没有到货数据！");
    	    return false;//没有到货数据，直接返回
        }
    	if(quantityOverLimit){
    	    alertMsg.error("到货数超限，请检查！");
    	    return false;//数量超限，直接返回
    	} 
    	
    	var totalArrivalQuantity = Number($("#totalArrivalQuantity", $.pdialog.getCurrent()).html());
    	$("#arrivalQuantityHidden", $.pdialog.getCurrent()).val(totalArrivalQuantity);
    	
    	var totalPurchaseQuantity = Number($("#totalPurchaseQuantity", $.pdialog.getCurrent()).html());
    	var totalHisArrivalQuantity = Number($("#totalHisArrivalQuantity", $.pdialog.getCurrent()).html());
    	if(totalArrivalQuantity + totalHisArrivalQuantity == totalPurchaseQuantity){
	        $("#status", $.pdialog.getCurrent()).val("5");
	    }else{
	        $("#status", $.pdialog.getCurrent()).val("4");
	    }
		
		var _submitFn = function(){
			$.ajax({
				type: form.method || 'POST',
				url:$form.attr("action"),
				data:$form.serializeArray(),
				dataType:"json",
				cache: false,
				success: callback || DWZ.ajaxDone,
				error: DWZ.ajaxError
			});
		}
		
		if (confirmMsg) {
			alertMsg.confirm(confirmMsg, {okCall: _submitFn});
		} else {
			_submitFn();
		}
		
		return false;
    }
    
};
</script>