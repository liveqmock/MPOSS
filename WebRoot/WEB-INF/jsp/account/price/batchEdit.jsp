<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">

    <form method="post" action="/account/price/insertBatchTrans?navTabId=account_price_batchEdit" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone,'你确定提交吗？')">
        <table class="list" width="100%" layoutH="37">
			<thead>
				<tr>
					<th>什么账户</th>
					<th>什么时间</th>
					<th>收入或支出</th>
					<th>多少金额</th>
					<th>因什么原因</th>
					<th>关联方</th>
					<th>备注</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="priceBatchEditTbody">
			    <tr>
			        <td>
			            <select class="combox" name="accountType" ref="accountNo2" refUrl="/combox/loadAccountNo/{value}">
							<option value="">账户类型</option>
							<c:forEach var="entry" items="${myfn:getConstantMap('ACCOUNT_TYPE')}">
							<option value="${entry.key}">${entry.value}</option>
							</c:forEach>
						</select>
						<select class="combox" name="accountNo" id="accountNo2">
							<option value="">卡号</option>
						</select>
			        </td>
			        <td>
			            <input type="text" name="transDate" class="required date" readonly="readonly" size="12"/>
			        </td>
			        <td>
						<select class="combox" name="priceAction" ref="transItemSelect" refUrl="/combox/loadTransItem">
							<option value="">动作</option>
							<c:forEach var="entry" items="${myfn:getConstantMap('PRICE_ACTION')}">
							<option value="${entry.key}">${entry.value}</option>
							</c:forEach>
						</select>
			        </td>
			        <td><input type="text" name="inputTransPrice" class="required number" size="7"/></td>
			        <td>
			            <select class="combox" name="transItem" id="transItemSelect" ref="billTypeSelect" refUrl="/combox/loadBillType/{value}">
							<option value="">名目</option>
						</select>
						<select class="combox" name="billType" id="billTypeSelect" onchange="PriceBatchEdit.changeBillType(this);">
							<option value="">子名目</option>
						</select>
			        </td>
			        <td>
			            <input style="display:none;" class="auto_consumerId" name="consumer.consumerId" type="hidden"/>
					    <input style="display:none;" class="auto_consumerName" type="text" name="consumer.consumerName"/>
					    <input style="display:none;" class="auto_providerId" name="provider.providerId" type="hidden"/>
						<input style="display:none;" class="auto_providerName" type="text" name="provider.providerName"/>
			        </td>
			        <td><input type="text" size="35" name="transMemo"/></td>
			        <td><a class="button" href="javascript:void(0);" onclick="PriceBatchEdit.addRow(this);"><span>添加</span></a></td>
			    </tr>
			</tbody>
		</table>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var PriceBatchEdit = {
    index :0,
    hideTarget: function(){
        $("input[class^=auto_consumer]", navTab.getCurrentPanel()).val("").hide();
        $("input[class^=auto_provider]", navTab.getCurrentPanel()).val("").hide();
    },
    changeBillType: function(text){
        PriceBatchEdit.hideTarget();
        var val = $(text).val();
        if(!val) return;
        if(val=='1'||val=='3'||val=='4'){
            $("input[class^=auto_consumer]", navTab.getCurrentPanel()).show();
        }else{
            $("input[class^=auto_provider]", navTab.getCurrentPanel()).show();
        }
    },
    addRow: function(link){
        var $tr = $(link).closest("tr");
        var $accountType = $tr.find("select[name=accountType]");
        var $accountNo = $tr.find("select[name=accountNo]");
        var $transDate = $tr.find("input[name=transDate]");
        var $priceAction = $tr.find("select[name=priceAction]");
        var $inputTransPrice = $tr.find("input[name=inputTransPrice]");
        var $transItem = $tr.find("select[name=transItem]");
        var $billType = $tr.find("select[name=billType]");
        var $consumerId = $tr.find("input[name='consumer.consumerId']");
        var $consumerName = $tr.find("input[name='consumer.consumerName']");
        var $providerId = $tr.find("input[name='provider.providerId']");
        var $providerName = $tr.find("input[name='provider.providerName']");
        var $transMemo = $tr.find("input[name=transMemo]");
        
        var accountType = $accountType.val();
        var accountNo = $accountNo.val();
        var transDate = $transDate.val();
        var priceAction = $priceAction.val();
        var inputTransPrice = $inputTransPrice.val();
        var transItem = $transItem.val();
        var billType = $billType.val();
        var consumerId = $consumerId.val();
        var providerId = $providerId.val();
        var transMemo = $transMemo.val();
        var targetId = 0;
        var targetName = "";
        
        var accountTypeShow = $accountType.find("option:checked").html();
        var priceActionShow = $priceAction.find("option:checked").html();
        var transItemShow = $transItem.find("option:checked").html();
        var billTypeShow = $billType.find("option:checked").html();
        
        if(!accountType){
            alertMsg.error("请选择账户类型！");
            return;
        }
        if(accountType=='2' && !accountNo){
            alertMsg.error("请选择银行卡号！");
            return;
        }
        if(!transDate){
            alertMsg.error("请选择收支发生日期");
            return;
        }
        if(!priceAction){
            alertMsg.error("请选择收支动作！");
            return;
        }
        if(!inputTransPrice){
            alertMsg.error("请输入收支金额！");
            return;
        }
        if(!transItem){
            alertMsg.error("请选择名目！");
            return;
        }
        if(transItem=="09"){//货款
            if(!billType){
                alertMsg.error("货款类需选择子名目！");
            	return;
            }else{
                //检查子名目是否选择正确
                if(priceAction=="1"){//收入
                    if(billType=="2"){
                        alertMsg.error("不存在采购货款形式的收入，请修正！");
                    	return;
                    }
                    if(billType=="4"){
                        alertMsg.error("不存在销售退货退款形式的收入，请修正！");
                    	return;
                    }
                }else{//支出
                    if(billType=="1"){
                        alertMsg.error("不存在销售货款形式的支出，请修正！");
                    	return;
                    }
                    if(billType=="3"){
                        alertMsg.error("不存在销售定金形式的支出，请修正！");
                    	return;
                    }
                    if(billType=="5"){
                        alertMsg.error("不存在返厂回款形式的支出，请修正！");
                    	return;
                    }
                }
                if(billType=="1"||billType=="3"||billType=="4"){//BILL_TYPE(1-销售货款,3-销售定金,4-销售退货退款)
                    //检查客户是否有选择
                    if(!consumerId){
                        alertMsg.error("请选择关联客户！");
                        return;
                    }
                    targetId = $consumerId.val();
                    targetName = $consumerName.val();
                }else{//BILL_TYPE(2-采购货款,5-返厂回款)
                    //检查厂家是否有选择
                    if(!providerId){
                        alertMsg.error("请选择关联厂家！");
                        return;
                    }
                    targetId = $providerId.val();
                    targetName = $providerName.val();
                }
            }
        }
        
        var trHTML = "";
        if(transItem=="09"){//货款
            trHTML = "<tr>"+
                "<td>"+accountTypeShow+accountNo+"</td>"+
                "<td>"+transDate+"</td>"+
                "<td>"+priceActionShow+"</td>"+
                "<td>"+inputTransPrice+"</td>"+
                "<td>"+transItemShow+"【"+billTypeShow+"】</td>"+
                "<td>"+targetName+"</td>"+
                "<td>"+transMemo+"</td>"+
                "<td><a class=\"button\" href=\"javascript:void(0);\" onclick=\"PriceBatchEdit.removeRow(this);\"><span>移除</span></a></td>"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].accountType\" value=\""+accountType+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].accountNo\" value=\""+accountNo+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].transDate\" value=\""+transDate+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].priceAction\" value=\""+priceAction+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].inputTransPrice\" value=\""+inputTransPrice+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].transItem\" value=\""+transItem+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].billType\" value=\""+billType+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].targetId\" value=\""+targetId+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].targetName\" value=\""+targetName+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].transMemo\" value=\""+transMemo+"\" />"+
            "</tr>";
        }else{
            trHTML = "<tr>"+
                "<td>"+accountTypeShow+accountNo+"</td>"+
                "<td>"+transDate+"</td>"+
                "<td>"+priceActionShow+"</td>"+
                "<td>"+inputTransPrice+"</td>"+
                "<td>"+transItemShow+"</td>"+
                "<td>"+targetName+"</td>"+
                "<td>"+transMemo+"</td>"+
                "<td><a class=\"button\" href=\"javascript:void(0);\" onclick=\"PriceBatchEdit.removeRow(this);\"><span>移除</span></a></td>"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].accountType\" value=\""+accountType+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].accountNo\" value=\""+accountNo+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].transDate\" value=\""+transDate+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].priceAction\" value=\""+priceAction+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].inputTransPrice\" value=\""+inputTransPrice+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].transItem\" value=\""+transItem+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].billType\" value=\""+billType+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].targetId\" value=\""+targetId+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].targetName\" value=\""+targetName+"\" />"+
                "<input type=\"hidden\" name=\"transList["+PriceBatchEdit.index+"].transMemo\" value=\""+transMemo+"\" />"+
            "</tr>";
        }
        
        $("#priceBatchEditTbody", navTab.getCurrentPanel()).append(trHTML);
        PriceBatchEdit.index++;
        
    },
    removeRow: function(link){
        $(link).closest("tr").remove();
    }
};
</script>