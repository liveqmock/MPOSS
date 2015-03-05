<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="/sale/make/insert?navTabId=sale_make_add" class="pageForm required-validate" onsubmit="return SaleAdd.validateCallback(this,navTabAjaxDone,'你确定创建销售单吗？')">
		<input id="totalQuantity" type="hidden" name="totalSaleQuantity"/>
		<input id="totalPrice" type="hidden" name="inputTotalSalePrice"/>
		<div layoutH="37" class="nowrap">
		    <br/>
			<a style="float:left;" class="button" href="/sale/make/product" target="dialog" mask="true" rel="sale_make_product" width="900" height="600"><span>添加销售产品</span></a>
			<div style="clear:both;"></div>
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
						<th colspan="10" style="font-size:16px;height:30px;font-weight:bold;">销售单 ORDER</th>
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
						<th>DATE：</th>
						<th>${myfn:getTodayDate()}</th>
					</tr>
					<tr>
					    <th>编号<br/>No.</th>
					    <th>产品型号<br/>MODEL</th>
					    <th>产品名称<br/>ITEM</th>
					    <th>规格<br/>STANDER</th>
					    <th>单位<br/>UNIT</th>
						<th>数量<br/>QUANTITY</th>
						<th>单价<br/>PRICE</th>
						<th>金额<br/>AMOUNT</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="saleTbody">
				    <tr id="saleCount">
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
						<input id="auto_consumerId" name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
						<input id="auto_consumerName" type="text" name="consumer.consumerName" value="${consumer.consumerName}" class="required"/>
			        </dd>
			    </dl>
			    <dl style="padding:0px;">
			        <dd style="padding-left:135px;">
			            <span>无此客户？<a href="/partner/consumer/add" target="navTab" rel="partner_consumer_add" style="color:red;">点这里添加</a></span>
			        </dd>
			    </dl>
			    <dl>
					<dt>收货人：</dt>
					<dd>
						<input type="text" id="linkMan" name="consumer.linkMan" class="required" />
					</dd>
				</dl>
			    <dl>
					<dt>收货地址：</dt>
					<dd>
						<input type="text" id="address" name="consumer.address" class="required" />
					</dd>
				</dl>
				<dl>
					<dt>联系电话：</dt>
					<dd>
						<input type="text" id="phone" name="consumer.phone" class="required" />
					</dd>
				</dl>
				<dl>
				    <dt>是否收取定金：</dt>
				    <dd>
				        <input type="radio" name="depositFlag" value="0" class="required"/>否
				        <input type="radio" name="depositFlag" value="1" class="required"/>是
				    </dd>
				</dl>
				<dl>
				<dt>交货日期：</dt>
				<dd>
				    <input type="text" name="arrivalDate" class="required date" readonly="readonly" />
				</dd>
			</dl>
				<dl>
				  <dt>订单备注：</dt>
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
$("#auto_consumerName", navTab.getCurrentPanel()).autocomplete("/autocomplete/loadConsumer",{dataType:'json',
    parse:function(consumers){
        var rows = new Array();
        $.each(consumers,function(i,consumer){
              rows[i] = {data:consumer,value:consumer.engLetter+consumer.consumerName,result:consumer.consumerName} 
        });
		return rows;
    },
    formatItem : function(consumer, i, total) { 
		return consumer.consumerName; 
	},
	formatMatch: function(consumer, i, max) {//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
		return consumer.engLetter + consumer.consumerName;
	},
	minChars:0,
	max:999,
	scrollHeight:300,
	mustMatch:true,
	matchContains:true
}).result(function(event,consumer,formatted) {
    if (consumer){
        $("#auto_consumerId", navTab.getCurrentPanel()).val(consumer.consumerId);
        $("#linkMan", navTab.getCurrentPanel()).val(consumer.linkMan);
        $("#address", navTab.getCurrentPanel()).val(consumer.address);
        $("#phone", navTab.getCurrentPanel()).val(consumer.phone);
    }else{
    	$("#auto_consumerId", navTab.getCurrentPanel()).val("");
        $("#linkMan", navTab.getCurrentPanel()).val("");
        $("#address", navTab.getCurrentPanel()).val("");
        $("#phone", navTab.getCurrentPanel()).val("");
    }
});

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
var SaleAdd = {
    index: 0,
    no: 1,
    saleDetailNo: 1,
    countTotalQuantity: function(){
	    var totalQuantity = 0;
	    
	    var $inputs_saleQuantity = $("#saleTbody tr", navTab.getCurrentPanel()).find("input[name$=saleQuantity]");
	    $.each($inputs_saleQuantity, function(i, input){
	        var $this = $(this);
	        if($this.val()){
	            totalQuantity += Number($this.val());
	        }
	    });
	    
	    $("#totalQuantityShow", navTab.getCurrentPanel()).html(totalQuantity);
	},
	countTotalPrice: function(){
	    var totalPrice = 0;
	    
	    var $trs = $("#saleTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        var salePrice = Number($(tr).find("td").eq(7).html());
	        totalPrice += salePrice;
	    });
	    
	    $("#totalPriceShow", navTab.getCurrentPanel()).html(totalPrice.toFixed(2));
	},
	resetNo: function(){
	    SaleAdd.no = 1;
	    var $trs = $("#saleTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        $(tr).find("input[name$=no]").val(SaleAdd.no);
	        SaleAdd.no++
	    });
	},
    removeRow: function(link){
        var $tr = $(link).closest("tr");
        
        $tr.remove();
        SaleAdd.countTotalQuantity();
	    SaleAdd.countTotalPrice();
	    SaleAdd.resetNo();
    },
    upRow: function(link){
        var $tr = $(link).closest("tr");
        $tr.after($tr.prev());
        SaleAdd.resetNo();
    },
    downRow: function(link){
        var $tr = $(link).closest("tr");
        if($tr.next().attr("id") == 'saleCount') return;
        $tr.before($tr.next());
        SaleAdd.resetNo();
    },
    changeSaleQuantity: function(input){
        SaleAdd.countTotalQuantity();
        SaleAdd.countSalePrice($(input).closest("tr"));
    },
    changeUnitPrice: function(input){
        SaleAdd.countSalePrice($(input).closest("tr"));
    },
    countSalePrice: function($tr){
        var saleQuantity = $tr.find("input[name$=saleQuantity]").val();
        var inputSaleUnitPrice = $tr.find("input[name$=inputSaleUnitPrice]").val();
        if(saleQuantity && inputSaleUnitPrice){
            saleQuantity = Number(saleQuantity);
            inputSaleUnitPrice = Number(inputSaleUnitPrice);
            var inputSalePrice = (saleQuantity * inputSaleUnitPrice).toFixed(2);
            $tr.find("td[custom=salePrice]").html(inputSalePrice);
            $tr.find("input[name$=inputSalePrice]").val(inputSalePrice);
        } else {
            $tr.find("td[custom=salePrice]").html("");
            $tr.find("input[name$=inputSalePrice]").val("");
        }
        SaleAdd.countTotalPrice();
    },
    validateCallback: function(form, callback, confirmMsg){
    
        if($("#saleTbody tr", navTab.getCurrentPanel()).not(":last").size() == 0){
		    alertMsg.error("没有可以提交的销售产品数据！");
		    return false;
		}
		
		//var emptySaleQuantity = false;
		//var $inputs_saleQuantity = $("#saleTbody", navTab.getCurrentPanel()).find("input[name$=saleQuantity]");
		//$.each($inputs_saleQuantity, function(i,input){
		//    var $this = $(this);
		//    if(!$this.val() || $this.val()=='0'){
		//        emptySaleQuantity = true;
		//        return false;
		//   }
		//});
		//if(emptySaleQuantity){
		//    alertMsg.error("部分产品未输入销售数量！");
		//    return false;
		//}
		
		//var emptyUnitPrice = false;
		//var $inputs_saleUnitPrice = $("#saleTbody", navTab.getCurrentPanel()).find("input[name$=inputSaleUnitPrice]");
		//$.each($inputs_saleUnitPrice, function(i,input){
		//    var $this = $(this);
		//    if(!$this.val() || $this.val()=='0'){
		//        emptyUnitPrice = true;
		//        return false;
		//    }
		//});
		//if(emptyUnitPrice){
		//    alertMsg.error("部分产品未输入销售单价！");
		//    return false;
		//}
		
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