<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<button onclick="move()">버튼</button>

	<h2>로그인</h2>
	<!-- 에러 파라미터 확인 -->
	<c:if test="${param.error == 'true'}">
		<p style="color: red;">로그인 실패: 사용자 이름 또는 비밀번호가 잘못되었습니다.</p>
	</c:if>
	<form action="/login" method="post">
		<table>
			<tbody>
				<tr>
					<td><label for="username">아이디:</label></td>
					<td><input type="text" id="username" name="username" required></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호:</label></td>
					<td><input type="password" id="password" name="password"
						required></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">로그인</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
<script type="text/javascript">
	function move() {
		location.href = "/move";
	}
</script>
</html>