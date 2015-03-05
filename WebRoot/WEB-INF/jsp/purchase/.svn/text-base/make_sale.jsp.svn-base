<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="/purchase/insert?navTabId=purchase_saleMake" class="pageForm required-validate" onsubmit="return SalePur.validateCallback(this,navTabAjaxDone,'你确定提交采购单吗？')">
		<input type="hidden" name="purchaseProp" value="1"/><!-- PURCHASE_PROP(1-销售单采购) -->
		<input id="totalPrice" type="hidden" name="inputTotalPrice"/>
		<input type="hidden" id="purProviderId" name="providerId"/>
		<input type="hidden" id="purProviderName" name="providerName"/>
		<div layoutH="37" class="nowrap">
		    <div style="padding:10px;height:30px;">
		        <span style="float:left;margin-top:6px;">厂家：</span>
		        <input style="float:left;" class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
                <input style="float:left;margin-top:3px;" class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
			    <a bind="custom" style="float:left;margin-left:3px;" class="button" href="#" target="dialog" mask="true" rel="purchase_product" width="1000" height="600"><span>添加采购产品</span></a>
		    </div>
			<div style="clear:both;"></div>
			<table class="list" width="90%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
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
						<th colspan="11" style="height:30px;">Add: ${sessionOper.address}</th>
					</tr>
					<tr>
						<th colspan="11" style="font-size:16px;height:30px;font-weight:bold;">采购订货单</th>
					</tr>
					<tr>
						<th>合同编号：</th>
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
					</tr>
					<tr>
						<th>TO（致）：</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>订货日期：</th>
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
						<th>销售单</th>
						<th>产品编号</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="purchaseTbody">
				    <tr id="purchaseCount">
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td id="totalPriceShow"></td>
				        <td></td>
				        <td></td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
			<br/>
			<div class="pageFormContent">
			    <dl>
					<dt>合同号：</dt>
					<dd>
						<input type="text" name="contractNo"/>
					</dd>
				</dl>
				<dl>
					<dd>
						<textarea name="createDesc" cols="177" rows="10">一、交货期限及地点：  年  月   日之前交至我司指定仓库，地址见页脚①
						
二、货款交付方法：

三、产品品质及包装方法：品质如样品，所有包装为我司客户指定的唛头出口包装。每个小包装及外纸箱上一定要有产品编号，打包装时要设法令体积减少到最小，外纸箱为出口五层瓦楞纸，外箱要打四道打包带，以免运输途中损坏产品。

四、运输方法及费用负担，货到港口前的一切费用由供方承担。

五、唛头:
						</textarea>
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
$(document).ready(function(){
    $("a[target='dialog']", navTab.getCurrentPanel()).click(function(event){
        
        event.preventDefault();
        var providerId = $(".auto_providerId", navTab.getCurrentPanel()).val();
	    if(!providerId){
	        alertMsg.error("请先选择厂家！");
	        return;
	    }
	    if(SalePur.purProviderId != null){
	        if(providerId != SalePur.purProviderId){
	            alertMsg.error("一张采购单只能对应一个厂家，无法选择其他厂家。");
	        	return;
	        }
	    }
	    
	    var $this = $(this);
	    
	    $this.attr("href","/purchase/saleGoods?providerId="+providerId);
	    
		var title = $this.attr("title") || $this.text();
		var rel = $this.attr("rel") || "_blank";
		var options = {};
		var w = $this.attr("width");
		var h = $this.attr("height");
		if (w) options.width = w;
		if (h) options.height = h;
		options.max = eval($this.attr("max") || "false");
		options.mask = eval($this.attr("mask") || "false");
		options.maxable = eval($this.attr("maxable") || "true");
		options.minable = eval($this.attr("minable") || "true");
		options.fresh = eval($this.attr("fresh") || "true");
		options.resizable = eval($this.attr("resizable") || "true");
		options.drawable = eval($this.attr("drawable") || "true");
		options.close = eval($this.attr("close") || "");
		options.param = $this.attr("param") || "";

		var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
		DWZ.debug(url);
		if (!url.isFinishedTm()) {
			alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
			return false;
		}
		$.pdialog.open(url, rel, title, options);
		
		return false;
    });
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
var SalePur = {
    no: 1,
    index: 0,
    purProviderId: null,
	countTotalPrice: function(){
	    var totalPrice = 0;
	    
	    var $trs = $("#purchaseTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        var salePrice = Number($(tr).find("td").eq(7).html());
	        totalPrice += salePrice;
	    });
	    
	    $("#totalPriceShow", navTab.getCurrentPanel()).html(totalPrice.toFixed(2));
	},
	resetNo: function(){
	    SalePur.no = 1;
	    var $trs = $("#purchaseTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        $(tr).find("td").eq(0).html(SalePur.no++);
	    });
	},
	resetPurProviderId: function(){
	    if($("#purchaseTbody tr", navTab.getCurrentPanel()).not(":last").size() == 0){
	        SalePur.purProviderId = null;
	        $("#purProviderId", navTab.getCurrentPanel()).val("");
	        $("#purProviderName", navTab.getCurrentPanel()).val("");
	    }
	},
    removeRow: function(link){
        var $tr = $(link).closest("tr");
        
        $tr.remove();
	    SalePur.countTotalPrice();
	    SalePur.resetNo();
	    SalePur.resetPurProviderId();
    },
    validateCallback: function(form, callback, confirmMsg) {
		var $form = $(form);
	
		if (!$form.valid()) {
			return false;
		}
		
		if($("#purchaseTbody tr", navTab.getCurrentPanel()).not(":last").size() == 0){
		    alertMsg.error("没有可以提交的采购产品数据！");
		    return false;
		}
		
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