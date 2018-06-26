<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><style type="text/css">
   <!--
    .fs1 {font-size: 12px;}
    .fs2 {font-size: 2em;}
    .fs3 {font-size: 2ex;}
    .fs4 {font-size: 80%;}
    .fs5 {font-size: 100%;}
    .fs6 {font-size: 120%;}
    .fs7 {font-size: xx-small;}
    .fs8 {font-size: x-small;}
    .fs9 {font-size: small;}
    .fs10 {font-size: medium;}
    .fs11 {font-size: large;}
    .fs12 {font-size: x-large;}
    .fs13 {font-size: xx-large;}
   -->

   p.left { text-align: left; }
p.center { text-align: center; }
p.right { text-align: right; }

</style>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<meta charset="UTF-8">
<title>ユーザ新規登録</title>
</head>
<body>
<div class="container">
<span class="fs13"><p class="center">ユーザ新規登録</p></span>

	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

		<c:if test="${errMsg1 != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg1}
		</div>
	</c:if>

<form action="UserCreateServlet" method="post">
ログインID　　　　　　　　　<input type="text" name="loginId" value="${user.loginId }"><br>
<br>
パスワード　　　　　　　　　<input type="text" name="password"><br>
<br>
パスワード（確認）　　　　　<input type="text" name="passwordA"><br>
<br>
ユーザ名　　　　　　　　　　<input type="text" name="name" value="${user.name }"><br>
<br>
生年月日　　　　　　　　　　<input type="date" name="birthdate" value="${user.birthDateStr }"><br>
<br>
<br>
<p class="center"><input type="submit" value="登録"></p>
</form>

<p class="left"><a href="javascript:history.back()">[戻る]</a></p>

</div>
</body>
</html>