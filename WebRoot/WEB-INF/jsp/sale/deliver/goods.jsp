<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/sale/deliver/goods">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">
	<table class="list" width="100%" layoutH="37">
		<thead>
			<tr>
			    <th>产品型号</th>
			    <th>产品名称</th>
			    <th>进货商</th>
				<th>进货价</th>
				<th>装箱数量</th>
				<th>装箱重量</th>
				<th>装箱体积</th>
				<th>可用库存</th>
				<th>备货数量</th>
				<th>件数</th>
				<th>箱号</th>
			</tr>
		</thead>
		<tbody id="goodsTbody">
		    <c:forEach var="stock" items="${stockList}" varStatus="i">
			<tr providerProductId="${stock.providerProductId}" providerName="${stock.providerName}" productModel="${stock.productModel}" productName="${stock.productName}" unitPrice="${myfn:fromF2Y(stock.unitPrice)}" packQuantity="${stock.packQuantity}" packWeight="${stock.packWeight}" packVolume="${stock.packVolume}">
			    <td>${stock.productModel}</td>
				<td>${stock.productName}</td>
				<td>${stock.providerName}</td>
				<td>${myfn:fromF2Y(stock.unitPrice)}</td>
				<td custom="packQuantity">${stock.packQuantity}</td>
				<td>${stock.packWeight}</td>
				<td>${stock.packVolume}</td>
				<td custom="validQuantity" style="color:red;">${stock.totalQuantity - stock.lockQuantity}</td>
				<td><input custom="bakQuantity" type="text" size="7" onblur="SaleGoods.changePackAmount(this);"/></td>
				<td custom="packAmount"></td>
				<td><input custom="packNumber" type="text" size="7"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="SaleGoods.addData();">添加</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
var SaleGoods = {
    passCheckData: function($trs){
        var containData = false;
        var emptyPackNumber = false;
        var $inputs_bakQuantity = $trs.find("input[custom='bakQuantity']");
        $.each($inputs_bakQuantity, function(i,input) {
            var bakQuantity = $(input).val();
            if(bakQuantity && bakQuantity!="0"){
                containData = true;
                
                var packNumber = $(input).closest("tr").find("input[custom='packNumber']").val();
                if(!packNumber){
                    emptyPackNumber = true;
                }
            }
        });
        
        if(!containData){
            alertMsg.error("请输入备货数");
            return false;
        }
        if(emptyPackNumber){
            alertMsg.error("备货商品必须输入箱号");
            return false;
        }
        
        return true;
    },
    passCheckStockLimit: function($trs){
        var overStockList = false;
        var $inputs_bakQuantity = $trs.find("input[custom='bakQuantity']");
        $.each($inputs_bakQuantity, function(i,input) {
            var bakQuantity = $(input).val();
            if(bakQuantity && bakQuantity!="0"){
                var $tr = $(input).closest("tr");
                var validQuantity = $tr.find("td[custom='validQuantity']").html();
                if(Number(validQuantity) <Number(bakQuantity)){
                    overStockList = true;
                    return false;
                }
            }
        });
        
        if(overStockList){
            alertMsg.error("备货数不能大于库存可用数");
            return false;
        }
        return true;
    },
    changePackAmount: function(input){
        var bakQuantity = $(input).val();
        var $tr = $(input).closest("tr");
        if(bakQuantity && bakQuantity != "0"){
            var packQuantity = $tr.find("td[custom='packQuantity']").html();
            if(!packQuantity){
                $tr.find("td[custom='packAmount']").html("");
            }else{
                var packAmount = 0;
                bakQuantity = Number(bakQuantity);
                packQuantity = Number(packQuantity);
                if(bakQuantity % packQuantity == 0){
                    packAmount = bakQuantity / packQuantity;
                }else{
                    packAmount = bakQuantity / packQuantity + 1;
                }
                $tr.find("td[custom='packAmount']").html(packAmount.toFixed(0));
            }
        } else {
            $tr.find("td[custom='packAmount']").html("");
        }
    },
    addData: function(){
    
        var $trs = $("#goodsTbody", $.pdialog.getCurrent()).find("tr");
        if(!SaleGoods.passCheckData($trs)) return;
        if(!SaleGoods.passCheckStockLimit($trs)) return;
        
        var bakQuantityForRow = 0;
        $.each($trs, function(i,tr){
            var $tr = $(tr);
            var providerProductId = $tr.attr("providerProductId");
            var providerName = $tr.attr("providerName");
            var productModel = $tr.attr("productModel");
            var productName = $tr.attr("productName");
            var costUnitPrice = $tr.attr("unitPrice");
            
            var packWeight = $tr.attr("packWeight");
            var packVolume = $tr.attr("packVolume");
            
            var bakQuantity = $tr.find("input[custom='bakQuantity']").val();
            if(!bakQuantity || bakQuantity == "0") return true;//continue
            var packAmount = $tr.find("td[custom='packAmount']").html();
            var packNumber = $tr.find("input[custom='packNumber']").val();
            var costPrice = (Number(costUnitPrice) * Number(bakQuantity)).toFixed(2);
            
            var bakWeight = (Number(packAmount) * Number(packWeight)).toFixed(2);
            var bakVolume = (Number(packAmount) * Number(packVolume)).toFixed(6);
            
            var trHtml = "<tr>"+
                             "<td>"+productModel+"</td>"+
                             "<td>"+productName+"</td>"+
                             "<td>"+providerName+"</td>"+
                             "<td>"+costUnitPrice+"</td>"+
                             "<td custom=\"bakQuantity\">"+bakQuantity+"</td>"+
                             "<td custom=\"packAmount\">"+packAmount+"</td>"+
                             "<td>"+packNumber+"</td>"+
                             "<td custom=\"bakVolume\">"+bakVolume+"</td>"+
                             "<td custom=\"bakWeight\">"+bakWeight+"</td>"+
                             "<td custom=\"bakCostPrice\">"+costPrice+"</td>"+
                             "<td><a class=\"button\" href=\"javascript:void(0);\" onclick=\"SaleBak.removeRow(this,"+providerProductId+","+SaleBak.saleDetailId+");\"><span>移除</span></a></td>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].saleDetailId\" value=\""+SaleBak.saleDetailId+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].providerProductId\" value=\""+providerProductId+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].inputSaleUnitPrice\" value=\""+SaleBak.saleUnitPrice+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].bakQuantity\" value=\""+bakQuantity+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].packAmount\" value=\""+packAmount+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].packNumber\" value=\""+packNumber+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].inputCostUnitPrice\" value=\""+costUnitPrice+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].inputCostPrice\" value=\""+costPrice+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].bakWeight\" value=\""+bakWeight+"\"/>"+
                             "<input type=\"hidden\" name=\"deliverDetailList["+SaleBak.index+"].bakVolume\" value=\""+bakVolume+"\"/>"+
                         "</tr>";
                         
            $("#deliverCount").before(trHtml);
            
            bakQuantityForRow += Number(bakQuantity);
            
            SaleBak.index++;
        });
        
        SaleBak.incBakQuantity(bakQuantityForRow, SaleBak.saleDetailId);
        SaleBak.count();
        $.pdialog.closeCurrent();
    }
};
</script>