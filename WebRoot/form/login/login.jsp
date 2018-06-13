<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>宾馆管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${root}/form/login/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="${root}/form/login/js/jquery.js"></script>
<script src="${root}/form/login/js/jquery-1.8.3.js"></script>
<script src="${root}/form/login/js/verificationNumbers.js"></script>
<script src="${root}/form/login/js/Particleground.js"></script>
<script src="${root}/form_util/util/util_js/validateUtil.js"></script>
<script src="${root}/form_util/util/util_js/bodyUtil.js"></script>
<script src="${root}/form_util/util/util_js/jsonUtil.js"></script>
<script src="${root}/form_util/util/util_js/ajaxUtil.js"></script>
<script src="${root}/form/login/js/login.js"></script>
<script>
$(document).ready(function() {
	  //粒子背景特效
	  $('body').particleground({
	    dotColor: '#5cbdaa',
	    lineColor: '#5cbdaa'
	  });
	  createCode();
  })
</script>
</head>
<body style="background-color: #000;">
<form isValidate="y" onsubmit="return false;">
	<dl class="admin_login">
	 <dt>
	  <strong>宾馆管理系统</strong>
	  <em>binguan management system </em>
	 </dt>
	 <dd class="user_icon">
	  <input id="zh_zhm" value="" name="username" type="name" placeholder="账号" class="login_txtbx"/>
	 </dd>
	 <dd class="pwd_icon">
	  <input id="zh_zhmm" value="" name="userpwd" type="password" placeholder="密码" class="login_txtbx"/>
	 </dd>
	<dd style="">
		<input id="J_codetext" onblur="validate()" type="password" placeholder="验证码" class="login_txtbx" style="width: 50%"/>
		 <Canvas id="myCanvas" style="height: 30px;width:50%;height:100%;background-color:#ccc;"></Canvas>
	 </dd>
	 <dd>
 		<input onclick="login('')" type="submit" class="submit_btn" style="width: 49.5%;float: left;" value="立即登录" name="button"/>
 		<input onclick="addData()" type="button" class="submit_btn" style="width: 49.5%;float: left;background-color: blue;" value="立即注册"  name="button"/>
	 </dd>
	 <dd style="color: red" id="infoDiv">${infoError}</dd>
	</dl>
</form>
<!-- 提交数据 -->		
<form action="login_valiDate.do" id="myLoginForm" method="post">
	<!-- 参数隐藏 用于页面传值-->
	<input style="display: none;" id="mapStr" name="mapStr">
</form>
<form action="register_valiDate.do" id="myRegisterForm" method="post">
	<!-- 参数隐藏 用于页面传值-->
	<input style="display: none;" id="mapStr2" name="mapStr">
</form>
</body>
</html>
