<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<style>
<!--
#suggest ul {
    width: 220px;
}
-->
</style>
<form id="pagerForm" action="/purchase/saleGoods">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return dwzSearch(this, 'dialog');" action="/purchase/saleGoods" method="post">
	<input type="hidden" name="providerId" value="${providerId}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
				    <input type="hidden" name="sale.consumerName" value="${sale.consumerName}" />
					销售单：
					<input name="sale.saleNo" value="${sale.saleNo}" type="text" postField="" suggestFields="saleNo,consumerName" 
					suggestUrl="/suggest/suggestSaleForPur" lookupGroup="sale" autocomplete="on"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
    <div layoutH="101">
    <div style="text-align:center;color:red;font-size:14px;padding:10px;">温馨提示：当产品采购价临时变动时，或产品采购价受规格影响时，请自行修改价格列</div>
    <table class="list" width="100%">
		<thead>
		    <tr>
		        <th colspan="13" style="font-weight:bold;">销售产品列表</th>
		    </tr>
			<tr>
			    <th>编号<br/>No.</th>
			    <th>产品型号<br/>MODEL</th>
			    <th>产品名称<br/>ITEM</th>
			    <th>规格<br/>STANDARD</th>
			    <th>单位<br/>UNIT</th>
				<th>数量<br/>QUANTITY</th>
				<th>销售单价<br/>PRICE</th>
				<th>销售金额<br/>AMOUNT</th>
				<th>备注</th>
				<th>已采购数</th>
				<th>库存可用数</th>
				<th>采购价</th>
				<th>本次采购数</th>
			</tr>
		</thead>
		<tbody id="goodsTbody">
	    <c:forEach var="saleDetail" items="${saleDetailList}" varStatus="i">
	    <tr saleDetailId="${saleDetail.saleDetailId}" providerProductId="${saleDetail.providerProductId}" standard="${saleDetail.standard}" pic="${saleDetail.pic}">
		    <td>${saleDetail.saleDetailNo}</td>
		    <td>${saleDetail.productModel}</td>
		    <td>${saleDetail.productName}</td>
		    <td>${saleDetail.standard}</td>
		    <td>${saleDetail.unit}</td>
		    <td>${saleDetail.saleQuantity}</td>
		    <td>${myfn:fromF2Y(saleDetail.saleUnitPrice)}</td>
		    <td>${myfn:fromF2Y(saleDetail.salePrice)}</td>
		    <td>${saleDetail.saleDesc}</td>
		    <td>${saleDetail.purchaseQuantity}</td>
		    <td>${saleDetail.canUseQuantity}</td>
		    <td><input type="text" class="number" size="6" custom="unitPrice" value="${myfn:fromF2Y(saleDetail.purchaseUnitPrice)}"/></td>
		    <td>
		        <c:choose>
		            <c:when test="${saleDetail.purchaseFlag=='1'}"><input class="digits" custom="purchaseQuantity" type="text" size="8" value="${saleDetail.saleQuantity - saleDetail.purchaseQuantity}"/></c:when>
		            <c:otherwise>不生产</c:otherwise>
		        </c:choose>
		    </td>
		</tr>
	    </c:forEach>
		</tbody>
	</table>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="PurProduct.addData();">添加</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
var PurProduct = {
    saleNo: '${sale.saleNo}',
    consumerName: '${sale.consumerName}',
    passCheckData: function (){
        
        var $trs = $("#goodsTbody tr", $.pdialog.getCurrent());
	    if($trs.size() == 0){
	        alertMsg.error("没有可以添加的数据！");
	        return false;
	    }
	    
	    $inputs_purchaseQuantity = $trs.find("input[custom='purchaseQuantity']");
	    var noContainData = true;
	    var noUnitPrice = false;
	    $.each($inputs_purchaseQuantity, function(i, input){
	        $input = $(input);
	        if($input.val() && ($input.val() != "0")){
	            noContainData = false;
		        
		        var $unitPrice = $input.closest("tr").find("input[custom='unitPrice']");
	            if(!$unitPrice.val()){
	                noUnitPrice = true;
	                return false;
	            }
	        }
	    });
	    if(noContainData){
	        alertMsg.error("请输入采购数量！");
	        return false;
	    }
	    if(noUnitPrice){
	        alertMsg.error("请输入采购价格");
	        return false;
	    }
	    
	    return true;
	},
	
    addData: function(){
        if(!PurProduct.passCheckData()) return;
    
	    var $trs = $("#goodsTbody tr", $.pdialog.getCurrent());
	    var htmlForTrs = "";
	    
	    $.each($trs, function(i, tr) {
	        var $tr = $(tr);
	        
	        var saleDetailId = $tr.attr("saleDetailId");
	        var providerProductId = $tr.attr("providerProductId");
	        var standard = $tr.attr("standard");
	        
	        var $tds = $tr.children();
	        var $purchaseQuantity = $tds.find("input[custom='purchaseQuantity']");
	        if($purchaseQuantity.size() == 0) return true;//continue
	        
	        var unitPrice = $tds.find("input[custom='unitPrice']").val();
	        
	        var purchaseQuantity = $purchaseQuantity.val();
	        
	        if(purchaseQuantity=="" || purchaseQuantity=="0") return true; //continue
	        
	        var saleDetailNo = $tds.eq(0).html();
	        var productModel = $tds.eq(1).html();
	        var productName = $tds.eq(2).html();
	        var unit = $tds.eq(4).html();
	        var pic = $tr.attr("pic");
	        
	        var purchasePrice = (Number(unitPrice)*Number(purchaseQuantity)).toFixed(2);
	        
	        //create tr'html for target table
	        var trHtml = "<tr>"+
	                         "<td>"+SalePur.no+"</td>"+
	                         "<td>"+productModel+"</td>"+
	                         "<td>"+productName+"</td>"+
	                         "<td>"+standard+"</td>"+
	                         "<td>"+unit+"</td>"+
	                         "<td>"+purchaseQuantity+"</td>"+
	                         "<td>"+unitPrice+"</td>"+
	                         "<td>"+purchasePrice+"</td>"+
	                         "<td>"+PurProduct.saleNo+"</td>"+
	                         "<td>"+saleDetailNo+"</td>"+
	                         "<td width=\"200\" align=\"center\"><a style=\"margin-left:78px;\" href=\"javascript:void(0);\" class=\"button\" onclick=\"SalePur.removeRow(this);\"><span>移除</span></a></div></td>"+
	                         "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].providerProductId\" value=\""+providerProductId+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].productModel\" value=\""+productModel+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].productName\" value=\""+productName+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].standard\" value=\""+standard+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].purchaseQuantity\" value=\""+purchaseQuantity+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].inputPurchaseUnitPrice\" value=\""+unitPrice+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].inputPurchasePrice\" value=\""+purchasePrice+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].pic\" value=\""+pic+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].saleNo\" value=\""+PurProduct.saleNo+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].consumerName\" value=\""+PurProduct.consumerName+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].saleDetailId\" value=\""+saleDetailId+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+SalePur.index+"].saleDetailNo\" value=\""+saleDetailNo+"\"/>"+
	                     "</tr>";
	        htmlForTrs += trHtml;
	        
	        SalePur.index++;
	        SalePur.no++;
	        
	    });
	    
	    $("#purchaseCount", navTab.getPanel('purchase_saleMake')).before(htmlForTrs);
	    
	    SalePur.countTotalPrice();
	    
	    if(SalePur.purProviderId == null){
	        var providerId = $(".auto_providerId", navTab.getPanel('purchase_saleMake')).val();
	        SalePur.purProviderId = providerId;
	        $("#purProviderId", navTab.getPanel('purchase_saleMake')).val(providerId);
	        $("#purProviderName", navTab.getPanel('purchase_saleMake')).val($(".auto_providerName", navTab.getPanel('purchase_saleMake')).val());
	    }
	    
	    alertMsg.info("已成功添加到采购产品列表");
    }
    
};
</script>