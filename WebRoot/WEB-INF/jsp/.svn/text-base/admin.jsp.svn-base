<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title><fmt:message key="ui.title" /></title>

<link href="/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="/styles/dwz/themes/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="/styles/theme/css/zTree/zTreeStyle.css" />

<!--[if IE]>
<link href="/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="/styles/dwz/js/speedup.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.autocomplete.js" type="text/javascript"></script>
<script src="/styles/js/zTree/jquery.ztree.core-3.5.js" type="text/javascript"></script>
<script src="/styles/js/zTree/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>

<script src="/styles/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.print.js" type="text/javascript"></script>
<!--<script src="/styles/dwz/js/dwz.min.js" type="text/javascript"></script>-->
<script src="/styles/dwz/js/dwz.custom.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){	
	DWZ.init("/styles/dwz/dwz.frag.xml", {
		loginUrl:"/login_dialog", loginTitle:"登录",	// 弹出登录对话框
		//loginUrl:"/login",	// 跳到登录页面
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"/styles/dwz/themes"});
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="/admin">flLogo</a>
				<ul class="nav">
					<li><a href="/admin">首页</a></li>
					<li><a href="/info" target="dialog" mask="true" height="400">个人资料</a></li>
					<li><a href="/passwd" target="dialog" mask="true">修改密码</a></li>
					<li><a href="/logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">blue</div></li>
					<li theme="green"><div>green</div></li>
					<li theme="purple"><div>purple</div></li>
					<li theme="silver"><div>silver</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
			
				<div class="accordion" fillSpace="sideBar">
					
					<c:forEach var="resource" items="${resourceList}">
					<div class="accordionHeader">
						<h2><span>Folder</span>${resource.resourceName}</h2>
					</div>
					<div class="accordionContent">
					    <c:if test="${fn:length(resource.resourceList)>0}">
					    <ul class="tree treeFolder expand">
					        <c:forEach var="resource" items="${resource.resourceList}">
					        <li>
					            <c:choose>
					            <c:when test="${resource.resourceUrl == null}"><a href="javascript:void(0);">${resource.resourceName}</a></c:when>
					            <c:otherwise>
					                <c:choose>
					                <c:when test="${resource.inuseFlag=='1'}">
					                <li><a href="${resource.resourceUrl}" target="navTab" rel="${resource.rel}">${resource.resourceName}</a></li>
					                </c:when>
					                <c:otherwise>
					                <li><a href="javascript:void(0);" onclick="alert('本功能将于近期内推出！');">${resource.resourceName}</a></li>
					                </c:otherwise>
					                </c:choose>
					            </c:otherwise>
					            </c:choose>
					            <c:if test="${fn:length(resource.resourceList)>0}">
					            <ul>
					                <c:forEach var="resource" items="${resource.resourceList}">
					                <c:choose>
					                <c:when test="${resource.inuseFlag=='1'}">
					                <li><a href="${resource.resourceUrl}" target="navTab" rel="${resource.rel}">${resource.resourceName}</a></li>
					                </c:when>
					                <c:otherwise>
					                <li><a href="javascript:void(0);" onclick="alert('本功能将于近期内推出！');">${resource.resourceName}</a></li>
					                </c:otherwise>
					                </c:choose>
					                </c:forEach>
						        </ul>
					            </c:if>
						    </li>
					        </c:forEach>
						</ul>
					    </c:if>
					</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">首页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">初始页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<div class="right">
								<p><fmt:formatDate value="${model.now}" pattern="dd MMMM yyyy, EEEE"/></p>
							</div>
							<p><span>欢迎使用FIDY摩配贸易管理系统！</span></p>
							<p></p>
						</div>
						
						<div class="pageFormContent" style="padding-left:20px;" layoutH="80">
						    <p style="width:100%;font-size:14px;">首次使用系统，数据初始化步骤（建议先完整看过系统视频教程）：</p>
						    <div class="divider"></div>
						    <p style="width:100%;color:green;">1.导入基础产品、厂家和客户等基础数据<span style="color:#C75050;">（请用标准的基础数据模版进行导入。基础数据也可以在业务过程中逐步添加，建议尽可能的先录好基础数据，后续只用关注业务操作即可）</span>；</p>
						    <p style="width:100%;color:green;">2.配置基础产品的规格数据<span style="color:#C75050;">（为少部分具备规格的基础产品配置规格数据，以便销售业务引用）</span>；</p>
						    <p style="width:100%;color:green;">3.配置厂家针对这些基础产品的价格数据<span style="color:#C75050;">（以便采购业务引用）</span>；</p>
						    <p style="width:100%;color:green;">4.添加银行卡账户<span style="color:#C75050;">（系统默认已经分配了一个现金账户，系统使用方还需要添加银行卡账户）</span>；</p>
						    <p style="width:100%;color:green;">5.添加角色，添加操作员帐号并分配角色；</p>
						    
						    <p style="font-size:14px;margin-top:20px;">系统能够做些什么？</p>
						    <div class="divider"></div>
						    <p style="width:100%;color:green;">1.支持对产品、客户和厂家资源的管理；</p>
						    <p style="width:100%;color:green;">2.支持对现金账户及银行卡账户的管理；</p>
						    <p style="width:100%;color:green;">3.支持对销售和采购业务的管理；</p>
						    <p style="width:100%;color:green;">4.支持对销售退货和采购退货的管理；</p>
						    <p style="width:100%;color:green;">5.支持对各类单据的导出（如销售单、装箱单、采购单及入仓单等）；</p>
						    <p style="width:100%;color:green;">6.支持对账务（基于销售和采购所产生）的管理，包括进行应收款应付款的清算平账；</p>
						    <p style="width:100%;color:green;">7.支持对其他日常开支的登记；</p>
						    <p style="width:100%;color:green;">8.支持对产品库存的管理，包括盘库等库存管理的常规业务；</p>
						    <p style="width:100%;color:green;">9.支持多仓库的管理，包括对不同仓库间产品库存的相互调拨；</p>
						    <p style="width:100%;color:green;">10.支持对历史交易订单、账户资金变动及库存变动情况等的追踪；</p>
						    <p style="width:100%;color:green;">11.支持对销售及采购业务量的汇总；</p>
						    <p style="width:100%;color:green;">12.支持对各类日常开销数据的汇总；</p>
						    <p style="width:100%;color:green;">13.支持对已入账部分的利润进行分析；</p>
						    <p style="width:100%;color:green;">14.支持不同人员的不同操作权限；</p>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
	
	<div id="footer"><fmt:message key="ui.copyrights" /></div>


</body>
</html>