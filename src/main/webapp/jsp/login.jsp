<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
<style type="text/css">
	body{background: url("/images/背景.jpg") no-repeat center;background-size: 100%}
	#header{width: 100%;height:150px;}
	#left{width: 60%;height: 100%;float: left}
	#right{width: 40%;height: 100%;float: left;font-size: 20px;margin: 20px 0px 0px 0px}
	#size{font-size:10px}
	#input{width: 250px;height:20px }
	#zi{font-size: 15px}
</style>
</head>

<body>
	<div id="header"></div>
	<div id="left">
		<img src="/images/约吧.png">
	</div>
	<div id="right">
		<form action="/user/login" method="post">
		<legend align="center">登 录 界 面</legend>
			<table align="center" border="5px" width="250px" height="200px">
			<tr>
				<td id="zi">用户名：<br><input name="uid" type="text" id="input"></td>
			</tr>
			<tr>
				<td id="zi">密  码： <br><input name="upwd" type="password" id="input"></td>
			</tr>
			<tr align="center" height="20px">
				<td >
				<input type="submit" name="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" name="reset" value="重置">
				<br>
				<a href="register.jsp" id="size">新用户点此注册</a>
				</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>