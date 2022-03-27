<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="NewFile.css">
<meta charset="UTF-8">
<title>Авторизация</title>
</head>
<body>
<form metod="doGet" action="/TEst/name">
	<h2>Введите логин и пароль</h2>
		<table>
			<tr>
				<td>Логин: </td>
				<td><input type="text" name="login"></td>
			</tr>
			<tr>
				<td>Пароль: </td>
				<td><input type="text" name="password"></td>
			</tr>	
			<tr>
				<td align="right" colspan="2"><input type="submit" value="Войти"></td>
		</table>
		<br>
    	<a href ='http://localhost:8080/TEst/jsp/NewUser.jsp'>Новый пользователь</a>
	</form>
</body>
</html>