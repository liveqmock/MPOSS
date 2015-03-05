<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/stock/taking/listReg"></form>

<div class="pageContent">
    <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="/stock/taking/listStock" target="dialog" mask="true" rel="add_taking_data" title="添加盘库数据" width="900" height="500"><span>添加盘库数据</span></a></li>
		</ul>
	</div>
    <form id="takingForm" method="post" action="/stock/taking/insert?navTabId=stock_taking_listReg" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone,'你确定提交盘点单吗？')">
		<div layoutH="64" class="nowrap">
			<table class="list" width="70%" style="background:url(${sessionOper.logoImg}) left top no-repeat;">
				<thead>
				    <tr>
						<th colspan="9" style="font-size:24px;height:50px;">${sessionOper.orgName}</th>
					</tr>
					<tr>
						<th colspan="9" style="height:30px;font-weight:bold;">${sessionOper.engName}</th>
					</tr>
					<tr>
						<th colspan="9" style="height:30px;">Tel(电话): ${sessionOper.tel}  Fax（传真）: ${sessionOper.fax}</th>
					</tr>
					<tr>
						<th colspan="9" style="height:30px;">Add: ${sessionOper.address}</th>
					</tr>
					<tr>
						<th colspan="9" style="font-size:16px;height:30px;font-weight:bold;">盘库单<br/>${stockTaking.stockTakingNo}</th>
					</tr>
					<tr>
						<th>制单人：</th>
						<th>${myfn:getColumnValue('SYS_OPER.REAL_NAME', sessionOper.operId)}</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>制单日期：</th>
						<th>${myfn:getTodayDate()}</th>
					</tr>
					<tr>
					    <th>#</th>
					    <th>厂家</th>
					    <th>型号</th>
					    <th>产品名</th>
					    <th>规格</th>
						<th>锁定数</th>
						<th>可用数</th>
						<th>盘点可用数</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="takingTbody">
				    <c:forEach var="takingTemp" items="${stockTakingTempList}" varStatus="i">
					<tr>
					    <td>${i.index+1}</td>
					    <td>${takingTemp.providerName}</td>
					    <td>${takingTemp.productModel}</td>
					    <td>${takingTemp.productName}</td>
					    <td>${takingTemp.standard}</td>
						<td>${takingTemp.lockQuantity}</td>
						<td>${takingTemp.totalQuantity - takingTemp.lockQuantity}</td>
						<td style="color:red;">${takingTemp.takingQuantity}</td>
						<td><a target="ajaxTodo" href="/stock/taking/del/${takingTemp.stockTakingTempId}" class="button"><span>移除</span></a>
					</tr>
					<input type="hidden" name="stockTakingDetailList[${i.index}].providerProductId" value="${takingTemp.providerProductId}"/>
					<input type="hidden" name="stockTakingDetailList[${i.index}].standard" value="${takingTemp.standard}"/>
					<input type="hidden" name="stockTakingDetailList[${i.index}].totalQuantity" value="${takingTemp.totalQuantity}"/>
					<input type="hidden" name="stockTakingDetailList[${i.index}].lockQuantity" value="${takingTemp.lockQuantity}"/>
					<input type="hidden" name="stockTakingDetailList[${i.index}].takingQuantity" value="${takingTemp.takingQuantity}"/>
					</c:forEach>
				</tbody>
			</table>
			<br/>
			<div class="pageFormContent">
				<dl>
				    <dt>备注：</dt>
					<dd>
						<textarea name="regDesc" cols="80" rows="3"></textarea>
					</dd>
				</dl>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="Taking.commit();">提交</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
var Taking = {
    commit: function(){
        if($("#takingTbody tr", navTab.getCurrentPanel()).size() == 0){
            alertMsg.error("没有盘点数据可以提交！");
            return;
        }
        $("#takingForm", navTab.getCurrentPanel()).submit();
    }
};
</script>