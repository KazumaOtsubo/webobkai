<%@ page import="model.Participant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Welcome!!
</title>
</head>
<body>
<div class="container">
	<div class="col-md-4"></div>
	<div class="col-md-4">
	<h1><br><br><br><br>
	</h1>
	<div	 class="center-block" style=" text-align: center; background-color: #ffe661; border: 1px solid gray;">
	<div class="container-fluid  bg-info">
		<h3>Web OB会へようこそ</h3>
		<br>

		<form action="./check" method="post">
				<div class="input-group center block">
			<span class="input-group-addon">パスワード</span>
			<input type="text" name="password" class="form-control" placeholder="お伝えしたパスワードを入力してください" required>
		</div>
		<p></p>
		<div class="input-group center block">
			<span class="input-group-addon">ユーザー名</span>
			<input type="text" name="name" class="form-control" placeholder="名前かニックネームを入力してください">
		</div>
		<h6 ><font color="red">※退室しない限り,2回目以降は名前の入力不要です</font></h6>
		<br><br>
		<div class="btn-group" role="group">
	<button type="submit" class="btn btn-default">送信</button>
</div>
<p></p>
</form>
	</div>
	</div>
	</div>
	<div class="col-md-4"></div>
</div>
</body>
</html>