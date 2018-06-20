<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインフォーム</title>
</head>
<body>
<div class="container">
<span class="fs13"><p class="center">ログイン画面</p></span>
    <div class="container">

	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form action="LoginServlet" method="post">
ログインID　　　　　　　　　<input type="text" name="loginId"><br>
<br>
パスワード　　　　　　　　　<input type="text" name="password"><br>
<br>
<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">ログイン</button>
</form>
</div>
</body>
</html>