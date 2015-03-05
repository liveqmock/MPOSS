<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="/sale/back/insert?callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return RefSaleBack.validateCallback(this,navTabAjaxDone,'你确定创建销售退货单吗？')">
		<input id="totalQuantity" type="hidden" name="totalBackQuantity"/>
		<input id="totalPrice" type="hidden" name="inputTotalBackPrice"/>
		<input type="hidden" name="saleNo" value="${sale.saleNo}"/>
		<input type="hidden" name="deliverNo" value="${deliver.deliverNo}"/>
		<div layoutH="37" class="nowrap">
			<table class="list" width="100%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
				<thead>
					<tr>
						<th colspan="11" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
					</tr>
					<tr>
						<th colspan="11" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
					</tr>
					<tr>
						<th colspan="11" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
					</tr>
					<tr>
						<th colspan="11" style="height:30px;">Add: ${sessionOper.engAddress}</th>
					</tr>
					<tr>
						<th colspan="11" style="font-size:16px;height:30px;font-weight:bold;">销售退货单</th>
					</tr>
					<tr>
						<th>NAME：</th>
						<th>${consumer.consumerName}</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>DATE：</th>
						<th>${myfn:getTodayDate()}</th>
					</tr>
					<tr>
					    <th>编号<br/>No.</th>
					    <th>厂家</th>
					    <th>产品型号<br/>MODEL</th>
					    <th>产品名称<br/>ITEM</th>
					    <th>规格<br/>STANDER</th>
					    <th>单位<br/>UNIT</th>
						<th>数量<br/>QUANTITY</th>
						<th>退货单价<br/>PRICE</th>
						<th>金额<br/>AMOUNT</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="saleBackTbody">
				    <c:set var="index" value="0"></c:set>
				    <c:set var="no" value="1"></c:set>
				    <c:set var="saleBackDetailNo" value="1"></c:set>
				    <c:set var="totalBackQuantity" value="0"></c:set>
				    <c:set var="totalBackPrice" value="0"></c:set>
				    <c:forEach var="deliverDetail" items="${deliverDetailList}" varStatus="li">
				    <tr>
                         <td><input type="text" name="saleBackDetailList[${li.index}].saleBackDetailNo" value="${li.index+1}" size="4"/></td>
                         <td>${deliverDetail.providerName}</td>
                         <td>${deliverDetail.productModel}</td>
                         <td>${deliverDetail.productName}</td>
                         <td>${deliverDetail.standard}</td>
                         <td>${deliverDetail.unit}</td>
                         <td><input type="text" size="5" class="digits" name="saleBackDetailList[${li.index}].backQuantity" onblur="RefSaleBack.changeSaleQuantity(this);" value="${deliverDetail.bakQuantity}"/></td>
                         <td><input type="text" size="5" class="number" name="saleBackDetailList[${li.index}].inputBackUnitPrice" onblur="RefSaleBack.changeUnitPrice(this);" value="${myfn:fromF2Y(deliverDetail.saleUnitPrice)}"/></td>
                         <td custom="backPrice">${myfn:fromF2Y(deliverDetail.bakQuantity * deliverDetail.saleUnitPrice)}</td>
                         <td><input class="textInput" type="text" name="saleBackDetailList[${li.index}].backDesc"/></td>
                         <td>
                             <a href="javascript:void(0);" class="button" onclick="RefSaleBack.removeRow(this);"><span>移除</span></a>
                             <a href="javascript:void(0);" class="button" onclick="RefSaleBack.upRow(this);"><span>上移</span></a>
                             <a href="javascript:void(0);" class="button" onclick="RefSaleBack.downRow(this);"><span>下移</span></a>
                         </td>
                         <input type="hidden" name="saleBackDetailList[${li.index}].no" value="${li.index+1}"/>
                         <input type="hidden" name="saleBackDetailList[${li.index}].providerProductId" value="${deliverDetail.providerProductId}"/>
	                     <input type="hidden" name="saleBackDetailList[${li.index}].productModel" value="${deliverDetail.productModel}"/>
	                     <input type="hidden" name="saleBackDetailList[${li.index}].productName" value="${deliverDetail.productName}"/>
	                     <input type="hidden" name="saleBackDetailList[${li.index}].standard" value="${deliverDetail.standard}"/>
	                     <input type="hidden" name="saleBackDetailList[${li.index}].pic" value="${deliverDetail.pic}"/>
	                     <input type="hidden" name="saleBackDetailList[${li.index}].inputBackPrice" value="${myfn:fromF2Y(deliverDetail.bakQuantity * deliverDetail.saleUnitPrice)}"/>
                     </tr>
                     <c:set var="index" value="${index+1}"></c:set>
				     <c:set var="no" value="${no+1}"></c:set>
				     <c:set var="saleBackDetailNo" value="${saleBackDetailNo+1}"></c:set>
                     <c:set var="totalBackQuantity" value="${totalBackQuantity + deliverDetail.bakQuantity}"></c:set>
                     <c:set var="totalBackPrice" value="${totalBackPrice + deliverDetail.bakQuantity * deliverDetail.saleUnitPrice}"></c:set>
				    </c:forEach>
				    <tr id="saleBackCount">
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td id="totalQuantityShow">${totalBackQuantity}</td>
				        <td></td>
				        <td id="totalPriceShow">${myfn:fromF2Y(totalBackPrice)}</td>
				        <td></td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
			<br/>
			<div class="pageFormContent">
			    <dl>
			        <dt>客户名：</dt>
			        <dd>
						<input name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
						<input type="text" name="consumer.consumerName" value="${consumer.consumerName}" class="required" readonly="readonly"/>
			        </dd>
			    </dl>
				<dl>
				  <dt>退货备注：</dt>
				  <dd>
				      <textarea rows="2" cols="80" name="createDesc" class="textInput"></textarea>
				  </dd>
				</dl>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
<script type="text/javascript">
var RefSaleBack = {
    index: ${index},
    no: ${no},
    saleBackDetailNo: ${saleBackDetailNo},
    countTotalQuantity: function(){
	    var totalQuantity = 0;
	    
	    var $inputs_backQuantity = $("#saleBackTbody tr", navTab.getCurrentPanel()).find("input[name$=backQuantity]");
	    $.each($inputs_backQuantity, function(i, input){
	        var $this = $(this);
	        if($this.val()){
	            totalQuantity += Number($this.val());
	        }
	    });
	    
	    $("#totalQuantityShow", navTab.getCurrentPanel()).html(totalQuantity);
	},
	countTotalPrice: function(){
	    var totalPrice = 0;
	    
	    var $trs = $("#saleBackTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        var backPrice = Number($(tr).find("td").eq(8).html());
	        totalPrice += backPrice;
	    });
	    
	    $("#totalPriceShow", navTab.getCurrentPanel()).html(totalPrice.toFixed(2));
	},
	resetNo: function(){
	    RefSaleBack.no = 1;
	    var $trs = $("#saleBackTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        $(tr).find("input[name$=no]").val(RefSaleBack.no);
	        RefSaleBack.no++
	    });
	},
    removeRow: function(link){
        var $tr = $(link).closest("tr");
        
        $tr.remove();
        RefSaleBack.countTotalQuantity();
	    RefSaleBack.countTotalPrice();
	    RefSaleBack.resetNo();
    },
    upRow: function(link){
        var $tr = $(link).closest("tr");
        $tr.after($tr.prev());
        RefSaleBack.resetNo();
    },
    downRow: function(link){
        var $tr = $(link).closest("tr");
        if($tr.next().attr("id") == 'saleBackCount') return;
        $tr.before($tr.next());
        RefSaleBack.resetNo();
    },
    changeSaleQuantity: function(input){
        RefSaleBack.countTotalQuantity();
        RefSaleBack.countSalePrice($(input).closest("tr"));
    },
    changeUnitPrice: function(input){
        RefSaleBack.countSalePrice($(input).closest("tr"));
    },
    countSalePrice: function($tr){
        var backQuantity = $tr.find("input[name$=backQuantity]").val();
        var inputBackUnitPrice = $tr.find("input[name$=inputBackUnitPrice]").val();
        if(backQuantity && inputBackUnitPrice){
            backQuantity = Number(backQuantity);
            inputBackUnitPrice = Number(inputBackUnitPrice);
            var inputBackPrice = (backQuantity * inputBackUnitPrice).toFixed(2);
            $tr.find("td[custom=backPrice]").html(inputBackPrice);
            $tr.find("input[name$=inputBackPrice]").val(inputBackPrice);
        } else {
            $tr.find("td[custom=backPrice]").html("0.00");
            $tr.find("input[name$=inputBackPrice]").val(0);
        }
        RefSaleBack.countTotalPrice();
    },
    validateCallback: function(form, callback, confirmMsg){
    
        if($("#saleBackTbody tr", navTab.getCurrentPanel()).not(":last").size() == 0){
		    alertMsg.error("没有可以提交的退货产品数据！");
		    return false;
		}
		
		var emptySaleQuantity = false;
		var $inputs_backQuantity = $("#saleBackTbody", navTab.getCurrentPanel()).find("input[name$=backQuantity]");
		$.each($inputs_backQuantity, function(i,input){
		    var $this = $(this);
		    if(!$this.val() || $this.val()=='0'){
		        emptySaleQuantity = true;
		        return false;
		    }
		});
		if(emptySaleQuantity){
		    alertMsg.error("部分产品未输入退货数量！");
		    return false;
		}
		
		var emptyUnitPrice = false;
		var $inputs_saleUnitPrice = $("#saleBackTbody", navTab.getCurrentPanel()).find("input[name$=inputBackUnitPrice]");
		$.each($inputs_saleUnitPrice, function(i,input){
		    var $this = $(this);
		    if(!$this.val() || $this.val()=='0'){
		        emptyUnitPrice = true;
		        return false;
		    }
		});
		if(emptyUnitPrice){
		    alertMsg.error("部分产品未输入退货单价！");
		    return false;
		}
		
		var $form = $(form);
	
		if (!$form.valid()) {
			return false;
		}
		
		$("#totalQuantity", navTab.getCurrentPanel()).val($("#totalQuantityShow", navTab.getCurrentPanel()).html());
		$("#totalPrice", navTab.getCurrentPanel()).val($("#totalPriceShow", navTab.getCurrentPanel()).html());
	    
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