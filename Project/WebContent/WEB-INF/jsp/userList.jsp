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
<title>UserList</title>
</head>
<body>
<div class="container">
<p class="right">${userInfo.name}　さん　　<a href="Logout"> ログアウト </a></p><br />
<hr />
<span class="fs13"><p class="center">ユーザ一覧</p></span>

<p class="right"><a href="UserCreateServlet"> 新規登録 </a></p>

	<c:if test="${errMsg4 != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg4}
		</div>
	</c:if>

<form action="SearchServlet" method="post">
ログインID　　　　　　　　　<input type="text" name="login_id"><br>
<br>
ユーザ名　　　　　　　　　　<input type="text" name="password"><br>
<br>
生年月日　　　　　　　　　　<input type="date" name="birth_day">　～　<input type="date" name="birth_day1"><br>
<br>
<br>
<p class="right"><input type="submit" value="検索"></p>
</form>
       <div class="table-responsive">
             <table class="table table-striped">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>
                 <c:forEach var="user" items="${userList}" >
                   <tr>
                     <td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.birthDateFormat}</td>
                      <!-- ログインボタンの表示制御を行う -->
                     <td>
                       <c:if test="${userInfo.loginId == 'admin'}">
                       <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
                       <a class="btn btn-success" href="UpdateServlet?id=${user.id}">更新</a>
                       <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
                       </c:if>
                       <c:if test="${userInfo.loginId != 'admin'}">
	                       <c:if test="${userInfo.loginId == user.loginId}">
	                       <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
	                       <a class="btn btn-success" href="UpdateServlet?id=${user.id}">更新</a>
	                       </c:if>
	                       <c:if test="${userInfo.loginId != user.loginId}">
	                       <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
	                       </c:if>
                       </c:if>



                     </td>
                   </tr>
                 </c:forEach>
               </tbody>
             </table>
           </div>
</div>
</body>
</html>