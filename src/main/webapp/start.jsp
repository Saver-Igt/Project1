<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <section class="side">
        <img src="./images/ugatu_logo.png" alt="">
    </section>

    <section class="main">
        <div class="logo-container">
            <p class="title">Авторизация</p>
            <div class="sep"></div>
            <p class="hello-message">Пожалуйста, авторизируйтесь для получения доступа</p>

            <form class="login-form" metod="get" action="welcome">
                <div class="form-control">
                    <input type="text" placeholder="Login" name="login">
                    <i class="fas fa-user"></i>
                </div>

                <div class="form-control">
                    <input type="password" placeholder="Password" name="password">
                    <i class="fas fa-lock"></i>
                </div>
                
                <div class="pas-for">
                    <a class="pas-for-link" href="Register.jsp">Зарегистрироваться</a>
                </div>

                <button class="submit">Войти</button>
            </form>
        </div>
    </section>
</body>
</html>