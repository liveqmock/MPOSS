<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" action="/purchase/goods">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return dwzSearch(this, 'dialog');" action="/purchase/goods" method="post">
	<input type="hidden" name="provider.providerId" value="${provider.providerId}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					产品型号：
                    <input class="auto_productModel" type="text" name="product.productModel" value="${product.productModel}"/>
				</td>
				<td>
					产品名称：
                    <input class="auto_productName" type="text" name="product.productName" value="${product.productName}"/>
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
    <div style="text-align:center;color:red;font-size:14px;padding:10px;">温馨提示：当产品采购价临时变动时，或产品采购价受规格影响时，请自行修改价格列</div>
	<table class="list" layoutH="161" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th>产品型号<br/>MODEL</th>
				<th>产品名称<br/>ITEM</th>
				<th>规格<br/>STANDER</th>
				<th>单位<br/>UNIT</th>
				<th>数量<br/>QUANTITY</th>
				<th>采购价<br/>PRICE</th>
			</tr>
		</thead>
		<tbody id="goodsTbody">
		    <c:forEach var="providerProduct" items="${providerProductList}">
		    <tr providerProductId="${providerProduct.providerProductId}" pic="${providerProduct.pic}">
		        <td>${providerProduct.productModel}</td>
				<td>${providerProduct.productName}<br/>${product.productEngName}</td>
				<td>${providerProduct.standard}</td>
				<td>${providerProduct.unit}</td>
				<td><input class="digits" type="text" size="6" custom="purchaseQuantity"/></td>
				<td><input type="text" class="number" size="6" custom="unitPrice" value="${myfn:fromF2Y(providerProduct.unitPrice)}"/></td>
		    </tr>
		    </c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBarForDialog.jsp"></c:import>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="PurProduct.addData();">添加</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
var PurProduct = {
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
	        
	        var providerProductId = $tr.attr("providerProductId");
	        
	        var $tds = $tr.children();
	        var purchaseQuantity = $tds.find("input[custom='purchaseQuantity']").val();
	        var unitPrice = $tds.find("input[custom='unitPrice']").val();
	        
	        if(purchaseQuantity=="" || purchaseQuantity=="0") return true; //continue
	        
	        var productModel = $tds.eq(0).html();
	        var productName = $tds.eq(1).html();
	        var standard = $tds.eq(2).html();
	        var unit = $tds.eq(3).html();
	        
	        var pic = $tr.attr("pic");
	        
	        var purchasePrice = (Number(unitPrice)*Number(purchaseQuantity)).toFixed(2);
	        
	        //create tr'html for target table
	        var trHtml = "<tr>"+
	                         "<td>"+Pur.no+"</td>"+
	                         "<td>"+productModel+"</td>"+
	                         "<td>"+productName+"</td>"+
	                         "<td>"+standard+"</td>"+
	                         "<td>"+unit+"</td>"+
	                         "<td>"+purchaseQuantity+"</td>"+
	                         "<td>"+unitPrice+"</td>"+
	                         "<td>"+purchasePrice+"</td>"+
	                         "<td width=\"200\" align=\"center\"><a style=\"margin-left:78px;\" href=\"javascript:void(0);\" class=\"button\" onclick=\"Pur.removeRow(this);\"><span>移除</span></a></div></td>"+
	                         "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].providerProductId\" value=\""+providerProductId+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].productModel\" value=\""+productModel+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].productName\" value=\""+productName+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].standard\" value=\""+standard+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].purchaseQuantity\" value=\""+purchaseQuantity+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].inputPurchaseUnitPrice\" value=\""+unitPrice+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].inputPurchasePrice\" value=\""+purchasePrice+"\"/>"+
		                     "<input type=\"hidden\" name=\"purchaseDetailList["+Pur.index+"].pic\" value=\""+pic+"\"/>"+
	                     "</tr>";
	        htmlForTrs += trHtml;
	        
	        Pur.index++;
	        Pur.no++;
	        
	    });
	    
	    $("#purchaseCount", navTab.getPanel('purchase_make')).before(htmlForTrs);
	    
	    Pur.countTotalPrice();
	    
	    if(Pur.purProviderId == null){
	        var providerId = $(".auto_providerId", navTab.getPanel('purchase_make')).val();
	        Pur.purProviderId = providerId;
	        $("#purProviderId", navTab.getPanel('purchase_make')).val(providerId);
	        $("#purProviderName", navTab.getPanel('purchase_make')).val($(".auto_providerName", navTab.getPanel('purchase_make')).val());
	    }
	    
	    alertMsg.info("已成功添加到采购产品列表");
    }
    
};
</script>