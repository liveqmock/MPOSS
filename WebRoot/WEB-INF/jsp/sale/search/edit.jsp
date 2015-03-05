<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="/sale/search/update?navTabId=sale_search_list&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return SaleEdit.validateCallback(this,navTabAjaxDone,'你确定修改销售单吗？')">
		<input type="hidden" name="saleId" value="${sale.saleId}"/>
		<input id="totalQuantity" type="hidden" name="totalSaleQuantity"/>
		<input id="totalPrice" type="hidden" name="inputTotalSalePrice"/>
		<div layoutH="37" class="nowrap">
			<a style="float:left;" class="button" href="/sale/search/product" target="dialog" rel="sale_search_product" width="900" height="600"><span>追加新产品</span></a>
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
						<th colspan="11" style="height:30px;">Add: ${sessionOper.engAddress}</th>
					</tr>
					<tr>
						<th colspan="11" style="font-size:16px;height:30px;font-weight:bold;">销售单 ORDER<br/>${sale.saleNo}</th>
					</tr>
					<tr>
						<th>NAME：</th>
						<th id="consumerName">${sale.consumerName}</th>
						<th></th>
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
					    <th>规格<br/>STANDER</th>
					    <th>单位<br/>UNIT</th>
						<th>数量<br/>QUANTITY</th>
						<th>单价<br/>PRICE</th>
						<th>金额<br/>AMOUNT</th>
						<th>备注</th>
						<th>已完成数</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="saleTbody">
				    <c:set var="index" value="0"></c:set>
				    <c:set var="no" value="1"></c:set>
				    <c:set var="saleDetailNo" value="1"></c:set>
				    <c:set var="totalSaleQuantity" value="0"></c:set>
				    <c:set var="totalSalePrice" value="0"></c:set>
				    <c:forEach var="saleDetail" items="${saleDetailList}" varStatus="i">
				    <tr>
					    <td><input type="text" name="saleDetailList[${i.index}].saleDetailNo" value="${saleDetail.saleDetailNo}" size="4"/></td>
					    <td>${saleDetail.productModel}</td>
					    <td>${saleDetail.productName}</td>
					    <td>${saleDetail.standard}</td>
					    <td>${saleDetail.unit}</td>
					    <td><input class="required digits" custom="saleQuantity" name="saleDetailList[${i.index}].saleQuantity" type="text" value="${saleDetail.saleQuantity}" size="8" onblur="SaleEdit.changeSaleQuantity(this);"/></td>
					    <c:choose>
					    <c:when test="${saleDetail.saleUnitPrice != null}">
					    <td><input class="number" type="text" size="6" name="saleDetailList[${i.index}].inputSaleUnitPrice" value="${myfn:fromF2Y(saleDetail.saleUnitPrice)}" onblur="SaleEdit.changeUnitPrice(this);"/></td>
					    <td custom="salePrice">${myfn:fromF2Y(saleDetail.salePrice)}</td>
					    </c:when>
					    <c:otherwise>
					    <td><input class="number" type="text" size="6" name="saleDetailList[${i.index}].inputSaleUnitPrice" onblur="SaleEdit.changeUnitPrice(this);"/></td>
					    <td custom="salePrice"></td>
					    </c:otherwise>
					    </c:choose>
					    <td><input type="text" name="saleDetailList[${i.index}].saleDesc" value="${saleDetail.saleDesc}"/></td>
					    <td custom="hadBakQuantity">${saleDetail.saleQuantity - saleDetail.remainBakQuantity}</td>
					    <td>
					        <a href="javascript:void(0);" class="button" onclick="SaleEdit.upRow(this);"><span>上移</span></a>
					        <a href="javascript:void(0);" class="button" onclick="SaleEdit.downRow(this);"><span>下移</span></a>
					        <a href="javascript:void(0);" class="button" onclick="SaleEdit.removeRowWithData(this,${sale.saleId},${saleDetail.saleDetailId});"><span>移除</span></a>
					    </td>
					    <input type="hidden" name="saleDetailList[${i.index}].no" value="${saleDetail.no}"/>
					    <input type="hidden" name="saleDetailList[${i.index}].saleDetailId" value="${saleDetail.saleDetailId}"/>
					    <input type="hidden" name="saleDetailList[${i.index}].beforeSaleQuantity" value="${saleDetail.saleQuantity}"/>
					    <input type="hidden" name="saleDetailList[${i.index}].inputSalePrice" value="${myfn:fromF2Y(saleDetail.salePrice)}"/>
					</tr>
					<c:set var="totalSaleQuantity" value="${totalSaleQuantity + saleDetail.saleQuantity}"></c:set>
				    <c:set var="totalSalePrice" value="${totalSalePrice + saleDetail.salePrice}"></c:set>
				    <c:set var="index" value="${index+1}"></c:set>
				    <c:set var="no" value="${no+1}"></c:set>
				    <c:set var="saleDetailNo" value="${saleDetailNo+1}"></c:set>
				    </c:forEach>
				    <tr id="saleCount">
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td id="totalQuantityShow">${sale.totalSaleQuantity}</td>
				        <td></td>
				        <td id="totalPriceShow">${myfn:fromF2Y(totalSalePrice)}</td>
				        <td></td>
				        <td></td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
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
var SaleEdit = {
    no: ${no},
    index: ${index},
    saleDetailNo: ${saleDetailNo},
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
    changeSaleQuantity: function(input){
        SaleEdit.countTotalQuantity();
        SaleEdit.countSalePrice($(input).closest("tr"));
    },
    changeUnitPrice: function(input){
        SaleEdit.countSalePrice($(input).closest("tr"));
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
        SaleEdit.countTotalPrice();
    },
    resetNo: function(){
	    SaleEdit.no = 1;
	    var $trs = $("#saleTbody tr", navTab.getCurrentPanel()).not(":last");
	    $.each($trs, function(i, tr){
	        $(tr).find("input[name$=no]").val(SaleEdit.no);
	        SaleEdit.no++
	    });
	},
	removeRow: function(link){
	    var $tr = $(link).closest("tr");
	    
	    $tr.remove();
	    SaleEdit.countTotalQuantity();
	    SaleEdit.countTotalPrice();
	    SaleEdit.resetNo();
	},
    removeRowWithData: function(link, saleId, saleDetailId){
        var $tr = $(link).closest("tr");
        var hadBakQuantity = $tr.find("td[custom=hadBakQuantity]").html();
        if(Number(hadBakQuantity) > 0){
            alertMsg.error("此销售产品已存在备货数据，拒绝删除。");
            return;
        }
        alertMsg.confirm("确定删除此销售产品吗？", {okCall: function(){
            $.ajax({
	            async: false,
	            dataType: "json",
	            type : "GET",
	            url: "/sale/search/del/"+saleId+"/"+saleDetailId,
	            success: function(data){
                    $tr.remove();
                    SaleEdit.countTotalQuantity();
				    SaleEdit.countTotalPrice();
				    SaleEdit.resetNo();
	            }
	        });
        }});
        
    },
    upRow: function(link){
        var $tr = $(link).closest("tr");
        $tr.after($tr.prev());
        SaleEdit.resetNo();
    },
    downRow: function(link){
        var $tr = $(link).closest("tr");
        if($tr.next().attr("id") == 'saleCount') return;
        $tr.before($tr.next());
        SaleEdit.resetNo();
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
		//    }
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
		
		var changeOverLimit = false;
		var $inputs_saleQuantity = $("#saleTbody" ,navTab.getCurrentPanel()).find("input[name$='saleQuantity']");
		$.each($inputs_saleQuantity, function(i,input){
		    var $saleQuantity = $(input);
		    if(!$saleQuantity.val()) return true;//continue
		    var saleQuantity = Number($saleQuantity.val());
		    var hadBakQuantity = Number($saleQuantity.closest("tr").find("td[custom='hadBakQuantity']").html());
		    if(saleQuantity < hadBakQuantity){
		        changeOverLimit = true;
		        return false;//break
		    }
		});
		
		if(changeOverLimit){
		    alertMsg.error("销售数量不能少于已完成数！");
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