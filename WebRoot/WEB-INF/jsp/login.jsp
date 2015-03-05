<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="ui.title" /></title>
<link href="/styles/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
<script src="/styles/dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
function changeCode() {
	$("#kaptchaImg").attr('src', '/Kaptcha.jpg?' + Math.floor(Math.random()*100));
}
</script>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#" style="display:block;text-decoration:none;color:#444444;font-size:24px;font-weight:bold;letter-spacing:1px;font-family:'微软雅黑';">飞弟摩配贸易管理系统</a><br/>
				<a href="#" style="display:block;text-decoration:none;color:#835F29;font-size:14px;font-weight:bold;font-family:'微软雅黑';">FIDY - Motoparts Trading Management System</a><br/>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="#">关于飞弟</a></li>
						<li><a href="#">系统介绍</a></li>
					</ul>
				</div>
				<h2 class="login_title">
				    <p style="padding-left:17px;font-size:14px;letter-spacing:1px;">飞弟，专注传统行业信息化</p>
				</h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
			    <center style="color:red;">${message}</center>
				<form action="/doLogin" method="post">
					<p>
						<label>用户名：</label>
						<input type="text" name="userName" size="20" class="login_input" value="${oper.userName}"/>
<!--<input type="text" name="userName" size="20" class="login_input" value="admin"/>-->
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="passwd" size="20" class="login_input" value="${oper.passwd}"/>
<!--<input type="password" name="passwd" size="20" class="login_input" value="admin"/>-->
					</p>
					<p>
						<label>验证码：</label>
						<input class="code" type="text" name="kaptcha" size="5" value="${oper.kaptcha}"/>
<!--<input class="code" type="text" name="kaptcha" size="5" value="AAAA"/>-->
						<span><img src="/Kaptcha.jpg" style="cursor:pointer;" width="80" height="23" id="kaptchaImg" onclick="changeCode();"/></span>
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="/styles/dwz/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
					<li><a href="#">如何加入飞弟（FIDY）</a></li>
					<li><a href="#">首次使用，要注意什么？</a></li>
					<li><a href="#">忘记密码怎么办？</a></li>
				</ul>
				<div class="login_inner">
					<p>采购、销售、库存、账务、数据分析 一站式管理</p>
					<p>深度契合摩配贸易业务，提高企业经营工作效率。</p>
					<p>数据自动化运作，企业专注于提高销量，业绩翻番变得容易。</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2009 www.dwzjs.com Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>