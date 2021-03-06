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
<title>show your room</title>
</head>
<body>
<div class="container">
<div class="col-md-4"></div>
<div class="col-md-4">
<br><br>
<c:if test="${error == null }">
<div class="panel panel-success">
	<div class="panel-heading lead">
		ようこそ、<c:out value="${participant.participantName }"/>さん<br>
		あなたの部屋は<c:out value="${participant.roomNumber }"/>です
	</div>
	<div class="panel-body">
		あなたと同じ部屋の参加者は下に示しています<br>
		下に書いてあるリンクがあなたの部屋へのリンクです<br>
		なんかおかしいことがあったら、大坪に連絡ください<br>
	</div>
</div>
	<c:if test="${participant.roomNumber =='A' }"><div class="alert alert-info" role="alert">開始時刻は18:50です！</div></c:if>
	<c:if test="${participant.roomNumber =='B' }"><div class="alert alert-info" role="alert">開始時刻は18:55です！</div></c:if>
	<c:if test="${participant.roomNumber =='C' }"><div class="alert alert-info" role="alert">開始時刻は19:00です！</div></c:if>
	<c:if test="${participant.roomNumber =='D' }"><div class="alert alert-info" role="alert">開始時刻は18:50です！</div></c:if>
	<c:if test="${participant.roomNumber =='E' }"><div class="alert alert-info" role="alert">開始時刻は18:55です！</div></c:if>
	<c:if test="${participant.roomNumber =='F' }"><div class="alert alert-info" role="alert">開始時刻は19:00です！</div></c:if>
	<c:if test="${host == 1 }">
	<div class="alert alert-success" role="alert"><font color =red>あなたはホストです。<br>会議が始まると主催者からホストに指定されます</font></div>
	</c:if>
</c:if>
<c:if test="${error != null }">
<div class="panel panel-danger">
	<div class="panel-heading lead">
		すみません、定員オーバーです
	</div>
	<div class="panel-body">
		参加してくれてうれしいです<br>
		大坪に連絡してください
	</div>
</div>
</c:if>

<c:if test = "${participant.roomNumber == 'A'}">
<div class="panel panel-warning">
	<div class="panel-heading">
		ルームA
	</div>
	<div class="panel-body">
		URL：<a href="https://zoom.us/j/92718259358">https://zoom.us/j/92718259358</a>
	</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
			<c:if test="${participa.roomNumber=='A' }">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td>ルーム<c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	 </tbody>
</table>
<div class="panel-footer">
		このアプリ、シンプルに見えるけど結構大変だったからね！！
	</div>
</div>
	 </c:if>
<c:if test = "${participant.roomNumber == 'B'}">
<div class="panel panel-warning">
	<div class="panel-heading">
		ルームＢ
	</div>
	<div class="panel-body">
		URL：<a href="https://us04web.zoom.us/j/76335126367">https://us04web.zoom.us/j/76335126367</a>
	</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
			<c:if test="${participa.roomNumber=='B' }">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td>ルーム<c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	 </tbody>
</table>
<div class="panel-footer">
		このアプリ、シンプルに見えるけど結構大変だったからね！！
	</div>
</div>
	 </c:if>
	 <c:if test = "${participant.roomNumber == 'C'}">
<div class="panel panel-warning">
	<div class="panel-heading">
		ルームC
	</div>
	<div class="panel-body">
		URL：<a href="https://zoom.us/j/99117825461">https://zoom.us/j/99117825461</a>
	</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
			<c:if test="${participa.roomNumber=='C' }">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td>ルーム<c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	 </tbody>
</table>
<div class="panel-footer">
		このアプリ、シンプルに見えるけど結構大変だったからね！！
	</div>
</div>
	 </c:if>
	 <c:if test = "${participant.roomNumber == 'D'}">
<div class="panel panel-warning">
	<div class="panel-heading">
		ルームD
	</div>
	<div class="panel-body">
		URL：<a href="https://us04web.zoom.us/j/77955193872">https://us04web.zoom.us/j/77955193872</a>
	</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
			<c:if test="${participa.roomNumber=='D' }">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td>ルーム<c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	 </tbody>
</table>
<div class="panel-footer">
		このアプリ、シンプルに見えるけど結構大変だったからね！！<br>
	</div>
</div>
	 </c:if>
	 	 <c:if test = "${participant.roomNumber == 'E'}">
<div class="panel panel-warning">
	<div class="panel-heading">
		ルームE
	</div>
	<div class="panel-body">
		URL：<a href="https://us04web.zoom.us/j/78473689919">https://us04web.zoom.us/j/78473689919</a>
	</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
			<c:if test="${participa.roomNumber=='E' }">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td>ルーム<c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	 </tbody>
</table>
<div class="panel-footer">
		このアプリ、シンプルに見えるけど結構大変だったからね！！<br>
	</div>
</div>
	 </c:if>
	 	 <c:if test = "${participant.roomNumber == 'F'}">
<div class="panel panel-warning">
	<div class="panel-heading">
		ルームF
	</div>
	<div class="panel-body">
		URL：<a href="https://us04web.zoom.us/j/72870663905">https://us04web.zoom.us/j/72870663905</a>
	</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
			<c:if test="${participa.roomNumber=='F' }">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td>ルーム<c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	 </tbody>
</table>
<div class="panel-footer">
		このアプリ、シンプルに見えるけど結構大変だったからね！！<br>
	</div>
</div>
	 </c:if>

	 <form action="./delete" method="post">
	 	<div class="btn-group" role="group">
			<button type="submit" class="btn btn-danger" name="id" value="${participant.id }">退室</button>
		</div>
	</form>
	 <p class="text-right">現在の参加人数：<c:out value="${participants.size()}"></c:out></p>

	 	 <table class="table table-striped">
	<thead>
		<tr>
			<th>学年</th>
			<th>名前</th>
			<th>部屋</th>
			<th>ホスト</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participa" items="${participants}">
				<tr>
				<c:if test="${participa.grade == 1}"><td><c:out value="１年"/></td></c:if>
				<c:if test="${participa.grade == 2}"><td><c:out value="２年"/></td></c:if>
				<c:if test="${participa.grade == 3}"><td><c:out value="３年"/></td></c:if>
				<c:if test="${participa.grade == 4}"><td><c:out value="４年"/></td></c:if>
				<c:if test="${participa.grade == 5}"><td><c:out value="M1"/></td></c:if>
				<c:if test="${participa.grade == 6}"><td><c:out value="OB１年"/></td></c:if>
				<c:if test="${participa.grade == 7}"><td><c:out value="OB２年"/></td></c:if>
				<c:if test="${participa.grade == 8}"><td><c:out value="OB３年"/></td></c:if>
				<c:if test="${participa.grade == 9}"><td><c:out value="その他"/></td></c:if>

				<td><c:out value="${participa.participantName}"/></td>
				<td><c:out value="${participa.roomNumber}"/></td>
				<td><c:if test="${participa.host == 1 }">〇</c:if></td>
				</tr>
		</c:forEach>
	 </tbody>
</table>
	 </div>
	 <div class="col-md-4"></div>
	 </div>
</body>
</html>