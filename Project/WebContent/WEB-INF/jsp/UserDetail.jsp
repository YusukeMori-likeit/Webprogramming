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
<title>property</title>
</head>
<body>
<div class="container">
<p class="right">${userInfo.name}　さん　　<a href="Logout"> ログアウト </a></p><br />
<hr />
<span class="fs13"><p class="center">ユーザ情報詳細参照</p></span>
<br>
<br>
<span class="fs12">ログインID　　　　　　${userInfo1.loginId}</span>
<br>
<span class="fs12">ユーザ名　　　　　　　${userInfo1.name}</span>
<br>
<span class="fs12">生年月日　　　　　　　${userInfo1.birthDateFormat}</span>
<br>
<span class="fs12">登録日時　　　　　　　${userInfo1.createDate}</span>
<br>
<span class="fs12">更新日時　　　　　　　${userInfo1.updateDate}</span>
<br>
<p class="left"><a href="javascript:history.back()">[戻る]</a></p>
</div>
</body>
</html>