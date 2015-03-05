<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form id="bakForm" method="post" action="/sale/deliver/doBak?navTabId=sale_deliver_listBak&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,SaleBak.dialogAjaxDone,'你确定提交备货数据吗?')">
        <input type="hidden" name="saleId" value="${sale.saleId}"/>
        <input type="hidden" name="consumerId" value="${sale.consumerId}"/>
        <input id="finishBakFlag" type="hidden" name="finishBakFlag" value="${sale.finishBakFlag}"/>
        <input id="status" type="hidden" name="status" value="${sale.status}"/>
	    <div layoutH="38">
			<table class="list" width="100%">
			    <thead>
					<tr>
					    <th colspan="13" style="font-weight:bold;font-size:14px;color:green;padding:5px;">销售产品明细</th>
					</tr>
				</thead>
				<thead>
					<tr>
					    <th>编号</th>
					    <th>产品型号</th>
					    <th>产品名称</th>
					    <th>规格</th>
						<th>单位</th>
						<th>数量</th>
						<th>备注</th>
						<th>已发货数</th>
						<th>未发货数</th>
						<th>已备货数</th>
						<th>未备货数</th>
						<th>本次备货数</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="saleDetailTbody">
				    <c:set var="totalSaleQuantity" value="0"></c:set>
				    <c:set var="totalDeliverQuantity" value="0"></c:set>
				    <c:set var="totalUnDeliverQuantity" value="0"></c:set>
				    <c:set var="totalHadBakQuantity" value="0"></c:set>
				    <c:set var="totalRemainBakQuantity" value="0"></c:set>
				    <c:forEach var="saleDetail" items="${saleDetailList}" varStatus="i">
				    <c:if test="${saleDetail.saleQuantity > 0}">
				    <tr saleNo="${sale.saleNo}" saleDetailId="${saleDetail.saleDetailId}" saleDetailNo="${saleDetail.saleDetailNo}" productId="${saleDetail.productId}" productModel="${saleDetail.productModel}" productName="${saleDetail.productName}" standard="${saleDetail.standard}" unit="${saleDetail.unit}" packQuantity="${saleDetail.packQuantity}" packWeight="${saleDetail.packWeight}" packVolume="${saleDetail.packVolume}" saleUnitPrice="${myfn:fromF2Y(saleDetail.saleUnitPrice)}">
					    <td>${saleDetail.saleDetailNo}</td>
					    <td>${saleDetail.productModel}</td>
					    <td>${saleDetail.productName}</td>
					    <td>${saleDetail.standard}</td>
					    <td>${saleDetail.unit}</td>
					    <td>${saleDetail.saleQuantity}</td>
					    <td>${saleDetail.saleDesc}</td>
					    <td>${saleDetail.deliverQuantity}</td>
					    <td>${saleDetail.saleQuantity - saleDetail.deliverQuantity}</td>
					    <td>${(saleDetail.saleQuantity - saleDetail.deliverQuantity) - saleDetail.remainBakQuantity}</td>
					    <td custom="remainBakQuantity">${saleDetail.remainBakQuantity}</td>
					    <td style="color:red;" custom="bakQuantity">0</td>
					    <td>
					        <a class="button" href="javascript:void(0);" onclick="SaleBak.addRow(this);"><span>备货</span></a>
					    </td>
					</tr>
					<c:set var="totalSaleQuantity" value="${totalSaleQuantity + saleDetail.saleQuantity}"></c:set>
					<c:set var="totalDeliverQuantity" value="${totalDeliverQuantity + saleDetail.deliverQuantity}"></c:set>
					<c:set var="totalUnDeliverQuantity" value="${totalUnDeliverQuantity + (saleDetail.saleQuantity - saleDetail.deliverQuantity)}"></c:set>
					<c:set var="totalHadBakQuantity" value="${totalHadBakQuantity + ((saleDetail.saleQuantity - saleDetail.deliverQuantity) - saleDetail.remainBakQuantity)}"></c:set>
					<c:set var="totalRemainBakQuantity" value="${totalRemainBakQuantity + saleDetail.remainBakQuantity}"></c:set>
				    </c:if>
					</c:forEach>
					<tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td>合计：</td>
					    <td id="totalSaleQuantity">${totalSaleQuantity}</td>
					    <td></td>
					    <td id="totalDeliverQuantity">${totalDeliverQuantity}</td>
					    <td>${totalUnDeliverQuantity}</td>
					    <td>${totalHadBakQuantity}</td>
					    <td id="totalRemainBakQuantity">${totalRemainBakQuantity}</td>
					    <td id="totalBakQuantity2"></td>
					    <td></td>
					</tr>
				</tbody>
			</table>
			<br/><br/>
			<table class="list" width="100%">
			    <thead>
					<tr>
					    <th colspan="13" style="font-weight:bold;font-size:14px;color:green;padding:5px;">本次备货详情</th>
					</tr>
				</thead>
				<thead>
					<tr>
					    <th>产品型号</th>
					    <th>产品名称</th>
					    <th>规格</th>
					    <th>单位</th>
					    <th>进货商</th>
						<th>进货价</th>
						<th>备货数</th>
						<th>件数</th>
						<th>箱号</th>
						<th>体积</th>
						<th>重量</th>
						<th>成本小计</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="deliverTbody">
				    <tr id="deliverCount">
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td></td>
				        <td>合计：</td>
				        <td id="totalBakQuantity">0</td>
				        <td id="totalPackAmount">0</td>
				        <td></td>
				        <td id="totalBakVolume">0.000000</td>
				        <td id="totalBakWeight">0.00</td>
				        <td id="totalBakCostPrice">0.00</td>
				        <td></td>
				    </tr>
				</tbody>
			</table>
			<div style="text-align:center;color:red;font-size:14px;padding:10px;">温馨提示：进货价系统默认显示为“厂家本产品的末次采购价”。若本销售单采购时并非此价，请调整进货价数据，便于系统更加精确地统计利润数据。</div>
		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="SaleBak.commitDeliver();">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var SaleBak = {
    index: 0,
    beforeBakQuantity: 0,
    addRow: function(link){
    
        var $tr = $(link).closest("tr");
        
        var saleNo = $tr.attr("saleNo");
        var saleDetailId = $tr.attr("saleDetailId");
        var saleDetailNo = $tr.attr("saleDetailNo");
        var productId = $tr.attr("productId");
        var productModel = $tr.attr("productModel");
        var productName = $tr.attr("productName");
        var standard = $tr.attr("standard");
        var unit = $tr.attr("unit");
        var packQuantity = $tr.attr("packQuantity");
        var packWeight = $tr.attr("packWeight");
        var packVolume = $tr.attr("packVolume");
        
        var saleUnitPrice = $tr.attr("saleUnitPrice");
        
        var provicerSelectHtml = null;
        $.ajax({
            async: false,
            dataType: "html",
            type : "POST",
            url: "/sale/deliver/loadProviderForBak",
            data: "productId="+productId+"&standard="+standard,
            success: function(html){
                provicerSelectHtml = html;
            }
        });
        
        var trHtml = "<tr saleDetailId=\""+saleDetailId+"\" packQuantity=\""+packQuantity+"\" packWeight=\""+packWeight+"\" packVolume=\""+packVolume+"\">"+
				      "<td>"+productModel+"</td>"+
				      "<td>"+productName+"</td>"+
				      "<td>"+standard+"</td>"+
				      "<td>"+unit+"</td>"+
				      "<td>"+provicerSelectHtml+"</td>"+
				      "<td><input type=\"text\" class=\"number\" name=\"deliverDetailList["+SaleBak.index+"].inputCostUnitPrice\" size=\"5\"/></td>"+
				      "<td><input type=\"text\" class=\"digits\" name=\"deliverDetailList["+SaleBak.index+"].bakQuantity\" custom=\"bakQuantity\" size=\"4\" onfocus=\"SaleBak.focusBakQuantity(this);\" onblur=\"SaleBak.changeBakQuantity(this, '"+saleDetailId+"');\"/></td>"+
				      "<td><input type=\"text\" class=\"digits\" name=\"deliverDetailList["+SaleBak.index+"].packAmount\" custom=\"packAmount\" size=\"4\" onfocus=\"SaleBak.checkBakQuantity(this);\" onblur=\"SaleBak.changePackAmount(this);\"/></td>"+
				      "<td><input type=\"text\" name=\"deliverDetailList["+SaleBak.index+"].packNumber\" custom=\"packNumber\" size=\"4\" onfocus=\"SaleBak.checkBakQuantity(this);\"/></td>"+
				      "<td><input type=\"text\" class=\"number\" name=\"deliverDetailList["+SaleBak.index+"].bakVolume\" custom=\"bakVolume\" size=\"8\" onfocus=\"SaleBak.checkBakQuantity(this);\" onblur=\"SaleBak.changeBakVolume(this);\"/></td>"+
				      "<td><input type=\"text\" class=\"number\" name=\"deliverDetailList["+SaleBak.index+"].bakWeight\" custom=\"bakWeight\" size=\"10\" onfocus=\"SaleBak.checkBakQuantity(this);\" onblur=\"SaleBak.changeBakWeight(this);\"/></td>"+
				      "<td custom=\"bakCostPrice\"></td>"+
				      "<td><a class=\"button\" href=\"javascript:void(0);\" onclick=\"SaleBak.removeRow(this,'"+saleDetailId+"');\"><span>移除</span></a></td>"+
				      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].saleNo\" value=\""+saleNo+"\"/>"+
				      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].saleDetailId\" value=\""+saleDetailId+"\"/>"+
				      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].saleDetailNo\" value=\""+saleDetailNo+"\"/>"+
				      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].inputSaleUnitPrice\" value=\""+saleUnitPrice+"\"/>"+
				      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].standard\" value=\""+standard+"\"/>"+
				      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].providerProductId\"/>"+
                      "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].inputCostPrice\"/>"+
				    "</tr>";
        $("#deliverCount").before(trHtml);
        
        dynamicBindEnter($("#deliverCount").prev());
        
        SaleBak.index++;
    },
    changeProvider: function(select){
        var $select = $(select);
        var $tr = $select.closest("tr");
        var decQuantity = Number($tr.find("input[custom='bakQuantity']").val());
        if(!$select.val()){
            $tr.find("input[name$='inputCostUnitPrice']").val("");
            $tr.find("input[name$='providerProductId']").val("");
        }else{
            var $option = $select.find("option:selected");
            var inputCostUnitPrice = $option.attr("unitPrice");
            var providerProductId = $option.attr("providerProductId");
            $tr.find("input[name$='inputCostUnitPrice']").val(inputCostUnitPrice);
            $tr.find("input[name$='providerProductId']").val(providerProductId);
        }
        $tr.find("input[custom='bakQuantity']").val("");
        $tr.find("input[custom='packAmount']").val("");
        $tr.find("input[custom='packNumber']").val("");
        $tr.find("input[custom='bakVolume']").val("");
        $tr.find("input[custom='bakWeight']").val("");
        $tr.find("td[custom='bakCostPrice']").html(""); 
        
        var saleDetailId = $tr.attr("saleDetailId");
        SaleBak.decBakQuantity(decQuantity, saleDetailId);
        
        SaleBak.count();
    },
    changeBakQuantity: function(input, saleDetailId){
        var bakQuantity = $(input).val();
        var $tr = $(input).closest("tr");
        
        $tr.find("input[custom='packAmount']").val("");
        $tr.find("input[custom='packNumber']").val("");
        $tr.find("input[custom='bakVolume']").val("");
        $tr.find("input[custom='bakWeight']").val("");
        $tr.find("td[custom='bakCostPrice']").html("");
        $tr.find("input[name$='inputCostPrice']").val("");
        
        if(bakQuantity && bakQuantity != "0"){
            var costUnitPrice = $tr.find("input[name$='inputCostUnitPrice']").val();
            
            var packQuantity = $tr.attr("packQuantity");
            var packVolume = $tr.attr("packVolume");
            var packWeight = $tr.attr("packWeight");
            
            var packAmount = 0;//件数
            bakQuantity = Number(bakQuantity);//备货数
            packQuantity = Number(packQuantity);//装箱数
            if(bakQuantity % packQuantity == 0){
                packAmount = bakQuantity / packQuantity;
            }else{
                packAmount = Math.ceil(bakQuantity / packQuantity);
            }
            $tr.find("input[custom='packAmount']").val(packAmount.toFixed(0));
            
            var bakVolume = (Number(packAmount) * Number(packVolume)).toFixed(6);
            var bakWeight = (Number(packAmount) * Number(packWeight)).toFixed(2);
            var costPrice = (Number(costUnitPrice) * Number(bakQuantity)).toFixed(2);
            
            $tr.find("input[custom='bakVolume']").val(bakVolume);
            $tr.find("input[custom='bakWeight']").val(bakWeight);
            $tr.find("td[custom='bakCostPrice']").html(costPrice);
            $tr.find("input[name$='inputCostPrice']").val(costPrice);
        } 
        SaleBak.incBakQuantity(bakQuantity, saleDetailId);
        SaleBak.count();
    },
    changePackAmount: function(){
        SaleBak.countPackAmount();
    },
    changeBakVolume: function(){
        SaleBak.countBakVolume();
    },
    changeBakWeight: function(){
        SaleBak.countBakWeight();
    },
    focusBakQuantity: function(input){
        SaleBak.beforeBakQuantity = 0;
        if($(input).val()){
            SaleBak.beforeBakQuantity = Number($(input).val());
        }
        var $tr = $(input).closest("tr");
        var $select = $tr.children().find("select[custom='providerSelect']");
        if(!$select.val()){
            alert("请先选择厂家！");
            return;
        }
    },
    checkBakQuantity: function(input){
        var $tr = $(input).closest("tr");
        var $input = $tr.children().find("input[custom='bakQuantity']");
        if(!$input.val()){
            alert("请先填写备货数！");
            return;
        }
    },
    removeRow: function(link, saleDetailId){
        var $tr = $(link).closest("tr");
        
        var decQuantity = Number($tr.find("input[custom='bakQuantity']").val());
        SaleBak.decBakQuantity(decQuantity, saleDetailId);
        
        $tr.remove();
        
        SaleBak.count();
    },
    incBakQuantity: function(quantity, saleDetailId){
        quantity = Number(quantity);
        quantity = quantity - SaleBak.beforeBakQuantity;
        var $tr = $("#saleDetailTbody").find("tr[saleDetailId='"+saleDetailId+"']");
        var $input_bakQuantity = $tr.find("td[custom='bakQuantity']");
        $input_bakQuantity.html(Number($input_bakQuantity.html()) + quantity);
    },
    decBakQuantity: function(quantity, saleDetailId){
        var $tr = $("#saleDetailTbody").find("tr[saleDetailId='"+saleDetailId+"']");
        var $input_bakQuantity = $tr.find("td[custom='bakQuantity']");
        $input_bakQuantity.html(Number($input_bakQuantity.html()) - Number(quantity));
    },
    countBakQuantity: function(){
        var $inputs_bakQuantity = $("#deliverTbody tr").find("input[custom='bakQuantity']");
        var totalBakQuantity = 0;
        $.each($inputs_bakQuantity, function(i,input){
            var bakQuantity = Number($(input).val());
            totalBakQuantity += bakQuantity;
        });
        $("#totalBakQuantity").html(totalBakQuantity);
        $("#totalBakQuantity2").html(totalBakQuantity);
    },
    countPackAmount: function(){
        var $inputs_packAmount = $("#deliverTbody tr").find("input[custom='packAmount']");
        var totalPackAmount = 0;
        $.each($inputs_packAmount, function(i,input){
            var packAmount = Number($(input).val());
            totalPackAmount += packAmount;
        });
        $("#totalPackAmount").html(totalPackAmount);
    },
    countBakVolume: function(){
        var $inputs_bakVolume = $("#deliverTbody tr").find("input[custom='bakVolume']");
        var totalBakVolume = 0;
        $.each($inputs_bakVolume, function(i,input){
            var bakVolume = Number($(input).val());
            totalBakVolume += bakVolume;
        });
        $("#totalBakVolume").html(totalBakVolume.toFixed(6));
    },
    countBakWeight: function(){
        var $inputs_bakWeight = $("#deliverTbody tr").find("input[custom='bakWeight']");
        var totalBakWeight = 0;
        $.each($inputs_bakWeight, function(i,input){
            var bakWeight = Number($(input).val());
            totalBakWeight += bakWeight;
        });
        $("#totalBakWeight").html(totalBakWeight.toFixed(2));
    },
    countBakCostPrice: function(){
        var $tds_bakCostPrice = $("#deliverTbody tr").find("td[custom='bakCostPrice']");
        var totalBakCostPrice = 0;
        $.each($tds_bakCostPrice, function(i,td){
            var bakCostPrice = Number($(td).html());
            totalBakCostPrice += bakCostPrice;
        });
        $("#totalBakCostPrice").html(totalBakCostPrice.toFixed(2));
    },
    count: function(){
        SaleBak.countBakQuantity();
        SaleBak.countPackAmount();
        SaleBak.countBakVolume();
        SaleBak.countBakWeight();
        SaleBak.countBakCostPrice();
    },
    commitDeliver: function(){
        
        var $trs = $("#deliverTbody tr").not(":last");
        if($trs.size()==0){
            alertMsg.error("没有可以提交的备货数据");
            return;
        }
        
        //数据校验
        
        var overBakLimit = false;
        $trs = $("#saleDetailTbody tr").not(":last");
        $.each($trs, function(i,tr){
            var $tr = $(tr);
            var remainBakQuantity = $tr.find("td[custom='remainBakQuantity']").html();
            var bakQuantity = $tr.find("td[custom='bakQuantity']").html();
            if(Number(remainBakQuantity) < Number(bakQuantity)){
                overBakLimit = true;
                return false;
            }
        });
        
        if(overBakLimit){
            alertMsg.error("“本次备货数”不能超过“待备货数”");
            return;
        }
        
        var noPackNumber = false;
        var $inputs_packNumber = $("#deliverTbody").find("input[custom='packNumber']");
        $.each($inputs_packNumber,function(i,input){
            if(!$(input).val()){
                 noPackNumber = true;
                 return false;
            }
        });
        
        if(noPackNumber){
            alertMsg.error("请输入箱号！");
            return;
        }
        
        var totalBakQuantity = $("#totalBakQuantity").html();
        
        var totalRemainBakQuantity = $("#totalRemainBakQuantity").html();
        if(Number(totalBakQuantity) == Number(totalRemainBakQuantity)){
            $("#finishBakFlag").val("1");//FINISH_BAK_FLAG(1-完成备货)
            $("#status", $.pdialog.getCurrent()).val("4");//STATUS(4-待发货)
        }else{
            $("#status", $.pdialog.getCurrent()).val("2");//STATUS(2-备货中)
        }
        
        $("#deliverTbody tr").css("background-color","#FFFFFF")
        
        
        $("#bakForm").submit();
    },
	dialogAjaxDone: function (json){
		SaleBak.ajaxDone(json);
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
			    var highLightRowArray = array[1].split(",");
			    for(index in highLightRowArray){
			        $("#deliverTbody tr").eq(highLightRowArray[index]).css("background-color","#EAD48B");
			    }
			}
		} else if (json.statusCode == DWZ.statusCode.timeout) {
			if(alertMsg) alertMsg.error(json.message || DWZ.msg("sessionTimout"), {okCall:DWZ.loadLogin});
			else DWZ.loadLogin();
		} else {
			if(json.message && alertMsg) alertMsg.correct(json.message);
		};
	}
};
</script>