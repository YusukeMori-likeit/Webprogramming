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
<title>ユーザ削除確認</title>
</head>
<body>
<div class="container">
<p class="right">${userInfo.name}　さん　　<a href="Logout"> ログアウト </a></p><br />
<hr />
<span class="fs13"><p class="center">ユーザ削除確認</p></span>
ログインID：${userInfo2.loginId}
<br>を本当に削除してよろしいでしょうか。
<br><br>
<a class="btn btn-danger" href ="UserListServlet?id=${userInfo2.id}">キャンセル</a>　　<a class="btn btn-danger" href ="DeleteServlet?id=${userInfo2.id}">OK</a>
</div>
</body>
</html>