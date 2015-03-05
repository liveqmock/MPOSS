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

<!--[if IE]>
<link href="/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="/styles/dwz/js/speedup.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="/styles/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){	
	DWZ.init("/styles/dwz/dwz.frag.xml", {
		loginUrl:"/management/index/login", loginTitle:"Login",	// 弹出登录对话框
		loginUrl:"/management/index/login",	// 跳到登录页面
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
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="/">Home</a></li>
					<li><a href="/management/user!editContext.do" target="dialog" mask="true">My Details</a></li>
					<li><a href="/management/index!editPwd.do" target="dialog" mask="true">Change Password</a></li>
					<li><a href="/passport!logout.do">Log out</a></li>
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
					<div class="accordionHeader">
						<h2><span>Folder</span>书目管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="/management/book" target="navTab" rel="bookLiNav">书目</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>账户管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder">
							<li><a href="tabsPage.html" target="navTab">新增银行卡账户</a></li>
							<li><a href="tabsPage.html" target="navTab">账户余额信息</a></li>
							<li><a href="tabsPage.html" target="navTab">账户收支明细</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>合作方管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
							<li><a href="tabsPage.html" target="navTab">客户管理</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">添加客户</a></li>
									<li><a href="http://www.baidu.com" target="navTab" rel="page1">查询客户</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">厂家管理</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">添加厂家</a></li>
									<li><a href="http://www.baidu.com" target="navTab" rel="page1">查询厂家</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>商品管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
							<li><a href="tabsPage.html" target="navTab">基础商品管理</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">新增基础商品</a></li>
									<li><a href="main.html" target="navTab" rel="main">查询基础商品</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">装箱规格管理</a>
								<ul>
								    <li><a href="main.html" target="navTab" rel="main">新增装箱规格</a></li>
								    <li><a href="main.html" target="navTab" rel="main">查询装箱规格</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">厂家商品管理</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">新增厂家商品</a></li>
									<li><a href="http://www.baidu.com" target="navTab" rel="page1">查询厂家商品</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>库存管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
							<li><a href="tabsPage.html" target="navTab">库存盘点</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">盘库登记</a></li>
									<li><a href="main.html" target="navTab" rel="main">盘库确认</a></li>
									<li><a href="main.html" target="navTab" rel="main">盘库查询</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">库存查询</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>采购管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
							<li><a href="tabsPage.html" target="navTab">直接采购</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">制作采购单</a></li>
									<li><a href="main.html" target="navTab" rel="main">采购单确认</a></li>
									<li><a href="main.html" target="navTab" rel="main">收货确认</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">销售单采购</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">采购单生成</a></li>
									<li><a href="main.html" target="navTab" rel="main">收货确认</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">采购查询</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>销售管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
							<li><a href="tabsPage.html" target="navTab">制单</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">制作销售单</a></li>
									<li><a href="main.html" target="navTab" rel="main">销售单确认</a></li>
									<li><a href="main.html" target="navTab" rel="main">制作装箱单</a></li>
									<li><a href="main.html" target="navTab" rel="main">装箱单确认</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">出货</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">销售单出货登记</a></li>
									<li><a href="main.html" target="navTab" rel="main">销售单出货确认</a></li>
									<li><a href="main.html" target="navTab" rel="main">装箱单出货登记</a></li>
									<li><a href="main.html" target="navTab" rel="main">装箱单出货确认</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">销售跟踪查询</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>对账管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
							<li><a href="tabsPage.html" target="navTab">客户对账</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">发起对账</a></li>
									<li><a href="main.html" target="navTab" rel="main">对账确认</a></li>
									<li><a href="main.html" target="navTab" rel="main">收款登记</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">厂家对账</a>
								<ul>
									<li><a href="main.html" target="navTab" rel="main">发起对账</a></li>
									<li><a href="main.html" target="navTab" rel="main">对账确认</a></li>
									<li><a href="main.html" target="navTab" rel="main">付款登记</a></li>
								</ul>
							</li>
							<li><a href="tabsPage.html" target="navTab">对账查询</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>统计报表</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
						    <li><a href="tabsPage.html" target="navTab">实时库存报表</a></li>
						    <li><a href="tabsPage.html" target="navTab">每日库存报表</a></li>
							<li><a href="tabsPage.html" target="navTab">日销售汇总表</a></li>
							<li><a href="tabsPage.html" target="navTab">月销售汇总表</a></li>
							<li><a href="tabsPage.html" target="navTab">销售利润报表</a></li>
							<li><a href="tabsPage.html" target="navTab">客户对账统计表</a></li>
							<li><a href="tabsPage.html" target="navTab">厂家对账统计表</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						 <ul class="tree treeFolder expand">
						    <li><a href="tabsPage.html" target="navTab">操作员管理</a></li>
							<li><a href="tabsPage.html" target="navTab">角色管理</a></li>
							<li><a href="tabsPage.html" target="navTab">菜单管理</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">My Home</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<div class="right">
								<p><fmt:formatDate value="${model.now}" pattern="dd MMMM yyyy, EEEE"/></p>
							</div>
							<p><span>Welcome, ${contextUser.title} ${contextUser.firstName} ${contextUser.lastName}</span></p>
							<p>${contextUser.email}</p>
						</div>
						
						<div class="pageFormContent" layoutH="80">
							<p>
								<label>Username:</label><span class="unit">${contextUser.userName}</span>
							</p>
							<p>
								<label>First Name:</label><span class="unit">${contextUser.firstName}</span>
							</p>
							<p>
								<label>Last Name:</label><span class="unit">${contextUser.lastName}</span>
							</p>
							<p>
								<label>Phone:</label><span class="unit">${contextUser.phone}</span>
							</p>
							<p>
								<label>Post Code:</label><span class="unit">${contextUser.postcode}</span>
							</p>
							<p>
								<label>Email:</label><span class="unit">${contextUser.email}</span>
							</p>
							
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
	
	<div id="footer"><fmt:message key="ui.copyrights" /></div>


</body>
</html>