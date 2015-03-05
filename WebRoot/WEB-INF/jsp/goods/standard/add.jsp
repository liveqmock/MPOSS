<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form id="standardAddForm" method="post" action="/goods/standard/insert?navTabId=goods_standard_list&callback=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,StandardAdd.dialogAjaxDone)">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="javascript:void(0);" title="追加表格行" onclick="StandardAdd.addRow();"><span>追加表格行</span></a></li>
			</ul>
		</div>
		<table class="list" layoutH="65" width="100%;">
		    <thead>
		        <tr>
		            <th>产品</th>
		            <th>规格</th>
		            <th>操作</th>
		        </tr>
		    </thead>
		    <tbody id="standardAddTbody">
		        <tr>
		            <td>
		                <input class="auto_productId" type="hidden" name="standardList[0].productId"/>
                    	<input class="auto_productShow" type="text"/>
		            </td>
		            <td><input type="text" name="standardList[0].standard"/></td>
		            <td><a href="javascript:void(0);" class="button" onclick="StandardAdd.removeRow(this);"><span>移除</span></a></td>
		        </tr>
		    </tbody>
		</table>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="StandardAdd.commit();">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var StandardAdd = {
    index: 1,
    removeRow: function(link){
        $(link).closest("tr").remove();
        StandardAdd.index--;
    },
    addRow: function(){
        var trHtml = "<tr>"+
			              "<td>"+
			                   "<input class=\"auto_productId\" type=\"hidden\" name=\"standardList["+StandardAdd.index+"].productId\"/>"+
	                    	   "<input class=\"auto_productShow textInput ac_input\" type=\"text\"/>"+
			              "</td>"+
			              "<td><input class=\"textInput\" type=\"text\" name=\"standardList["+StandardAdd.index+"].standard\"/></td>"+
			              "<td><a href=\"javascript:void(0);\" class=\"button\" onclick=\"StandardAdd.removeRow(this);\"><span>移除</span></a></td>"
			         "</tr>";
        $("#standardAddTbody", $.pdialog.getCurrent()).append(trHtml);
        var $target = $("#standardAddTbody", $.pdialog.getCurrent()).children().last().find(".auto_productShow");
        dynamicBindAutocomplete($target);
        StandardAdd.index++;
    },
    commit: function(){
        $("#standardAddTbody tr").css("background-color","#FFFFFF");
        $("#standardAddForm").submit();
    },
    dialogAjaxDone: function (json){
		StandardAdd.ajaxDone(json);
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
			    if(array[1]){
			        var highLightRowArray = array[1].split(",");
				    for(index in highLightRowArray){
				        $("#standardAddTbody tr").eq(highLightRowArray[index]).css("background-color","#EAD48B");
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