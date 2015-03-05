<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="/sale/back/insert?navTabId=sale_back_add" class="pageForm required-validate" onsubmit="return SaleBack.validateCallback(this,navTabAjaxDone,'你确定创建销售退货单吗？')">
		<input id="totalQuantity" type="hidden" name="totalBackQuantity"/>
		<input id="totalPrice" type="hidden" name="inputTotalBackPrice"/>
		<div layoutH="37" class="nowrap">
		    <br/>
			<a style="float:left;" class="button" href="/sale/back/product" target="dialog" mask="true" rel="sale_back_product" width="900" height="600"><span>添加退货产品</span></a>
			<div style="clear:both;"></div>
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
						<th></th>
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
				    <tr id="saleBackCount">
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td id="totalQuantityShow"></td>
				        <td></td>
				        <td id="totalPriceShow"></td>
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
						<input class="auto_consumerId" name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
						<input class="auto_consumerName" type="text" name="consumer.consumerName" value="${consumer.consumerName}" class="required"/>
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
function isRepeat(arr){
     var hash = {};
     for(var i in arr) {
         if(hash[arr[i]]) {
             return true;
         }
         hash[arr[i]] = true;
     }
     return false;
}
var SaleBack = {
    index: 0,
    no: 1,
    saleBackDetailNo: 1,
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
	    SaleBack.no = 1;
	    var $trs = $("#saleBackTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        $(tr).find("input[name$=no]").val(SaleBack.no);
	        SaleBack.no++
	    });
	},
    removeRow: function(link){
        var $tr = $(link).closest("tr");
        
        $tr.remove();
        SaleBack.countTotalQuantity();
	    SaleBack.countTotalPrice();
	    SaleBack.resetNo();
    },
    upRow: function(link){
        var $tr = $(link).closest("tr");
        $tr.after($tr.prev());
        SaleBack.resetNo();
    },
    downRow: function(link){
        var $tr = $(link).closest("tr");
        if($tr.next().attr("id") == 'saleBackCount') return;
        $tr.before($tr.next());
        SaleBack.resetNo();
    },
    changeSaleQuantity: function(input){
        SaleBack.countTotalQuantity();
        SaleBack.countSalePrice($(input).closest("tr"));
    },
    changeUnitPrice: function(input){
        SaleBack.countSalePrice($(input).closest("tr"));
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
        SaleBack.countTotalPrice();
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