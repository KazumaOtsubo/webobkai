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
</head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>ERROR</title>
</head>
<body>
	<div class="col-md-4"></div>
	<div class="col-md-4">
	<br><br><br><br>
		<div class="panel panel-danger">
	<div class="panel-heading lead">
		ERROR
	</div>
	<div class="panel-body">
		パスワードが違います<br>
		OR<br>
		名前がすでに使われています<br>
		OR<br>
		初回ログイン後に更新されました<br>
		↑対応しきれませんでした
	</div>
</div>
<form action="index.jsp" method="post">
<button type="submit" class="btn btn-default">ログインページへ</button>
</form>
	</div>
	<div class="col-md-4"></div>
</body>
</body>
</html>