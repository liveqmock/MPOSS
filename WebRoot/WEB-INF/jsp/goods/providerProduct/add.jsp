<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <div style="padding:10px;height:30px;">
        <span style="float:left;margin-top:6px;">厂家：</span>
        <input style="float:left;" class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
	    <input style="float:left;margin-top:3px;" class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
	    <a style="float:left;margin-left:3px;" class="button" href="javascript:void(0);" onclick="ProvProdAdd.addRow();"><span>添加产品</span></a>
    </div>
	<div style="clear:both;"></div>
	<form id="provProdAddForm" method="post" action="/goods/providerProduct/insert?navTabId=goods_providerProduct_list&callback=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,ProvProdAdd.navTabAjaxDone)">
		<table class="list" width="50%" layoutH=87">
			<thead>
				<tr>
				    <th>厂家</th>
				    <th>产品</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="provProdAddTbody">
			</tbody>
		</table>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="ProvProdAdd.commit();">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var ProvProdAdd = {
    index: 0,
    addRow: function(){
        var $providerInput = $(".auto_providerId", navTab.getCurrentPanel());
        var providerId = $providerInput.val();
        if(!providerId){
            alertMsg.error("请先选择厂家！");
            return;
        }
        var providerName = $(".auto_providerName", navTab.getCurrentPanel()).val();
        var trHTML = 
            "<tr>"+
		        "<td>"+
		            "<input type=\"hidden\" name=\"providerProductVOList["+ProvProdAdd.index+"].providerId\" value=\""+providerId+"\"/>"+
		            "<input type=\"hidden\" name=\"providerProductVOList["+ProvProdAdd.index+"].providerName\" value=\""+providerName+"\" readonly=\"readonly\"/>"+providerName+
		        "</td>"+
		        "<td>"+
		             "<input type=\"hidden\" class=\"auto_productId\" name=\"providerProductVOList["+ProvProdAdd.index+"].productId\"/>"+
                     "<input type=\"text\" class=\"auto_productShow\"/>"+
		        "</td>"+
		        "<td><input type=\"text\" class=\"number\" name=\"providerProductVOList["+ProvProdAdd.index+"].inputUnitPrice\" size=\"6\"/></td>"+
		        "<td><a href=\"javascript:void(0);\" class=\"button\" onclick=\"ProvProdAdd.removeRow(this);\"><span>移除</span></a></td>"+
		    "</tr>";
        $("#provProdAddTbody", navTab.getCurrentPanel()).append(trHTML);
        var $thisTr = $("#provProdAddTbody", navTab.getCurrentPanel()).children().last();
        dynamicBindEnter($thisTr);
        var $target = $thisTr.find(".auto_productShow");
        dynamicBindAutocomplete($target);
        ProvProdAdd.index++;
    },
    removeRow: function(link){
        $(link).closest("tr").remove();
    },
    commit: function(){
        $("#provProdAddTbody tr", navTab.getCurrentPanel()).css("background-color","#FFFFFF")
        $("#provProdAddForm", navTab.getCurrentPanel()).submit();
    },
    navTabAjaxDone: function(json){
		ProvProdAdd.ajaxDone(json);
		if (json.statusCode == DWZ.statusCode.ok){
			if (json.navTabId){ //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
				navTab.reloadFlag(json.navTabId);
			} else { //重新载入当前navTab页面
				var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
				var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
				navTabPageBreak(args, json.rel);
			}
			
			if ("closeCurrent" == json.callbackType) {
				setTimeout(function(){navTab.closeCurrentTab(json.navTabId);}, 100);
			} else if ("forward" == json.callbackType) {
				navTab.reload(json.forwardUrl);
			} else if ("forwardConfirm" == json.callbackType) {
				alertMsg.confirm(json.confirmMsg || DWZ.msg("forwardConfirmMsg"), {
					okCall: function(){
						navTab.reload(json.forwardUrl);
					},
					cancelCall: function(){
						navTab.closeCurrentTab(json.navTabId);
					}
				});
			} else {
				navTab.getCurrentPanel().find(":input[initValue]").each(function(){
					var initVal = $(this).attr("initValue");
					$(this).val(initVal);
				});
			}
		}
	},
	ajaxDone:function(json){
		if(json.statusCode == DWZ.statusCode.error) {
			if(json.message && alertMsg) {
			    var array = json.message.split("#");
			    alertMsg.error(array[0]);
			    if(array[1]){
			        var highLightRowArray = array[1].split(",");
			        for(index in highLightRowArray){
				        $("#provProdAddTbody tr", navTab.getCurrentPanel()).eq(highLightRowArray[index]).css("background-color","#EAD48B");
				    }
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