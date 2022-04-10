<%@page import="org.junit.runner.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="database.User"
    %>
<%
//	if(session.getAttribute("role") != User.ROLE.USER){
//		response.sendRedirect("login.jsp");
//	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <title>Document</title> 
</head>
<body>
    <header>
        <a href="#" class="logo"><img src="./images/ugatu_logo.png" alt=""></a>
        <ul class="menu-bar">
            <li class="About"><a href="./main.html">О калькуляторе</a></li>
            <li class="Dev"><a href="./main.html">Разработчики</a></li>
        </ul>
        <div class="prava">
            <h3>Права досупа: Пользователь</h3>
        </div>
        <div class="btns">
            <button class="logout">
                <i class="fa-solid fa-gear"></i>
                Настройки
            </button>       
        </div>
    </header>
    <div class="nameProject">
        <h1>Зарплатный калькулятор</h1>
    </div>
    <div class="bubbles">
        <span class="one"></span>
        <span class="two"></span>
        <span class="three"></span>
        <span class="four"></span>
        <span class="five"></span>
        <span class="six"></span>
        <span class="seven"></span>
    </div>
    <div class="main-body">
    <div class="container">
        <form class="login-form" metod="post" action="Calculation">
            <div class="form-control">
                <input type="text" placeholder="Название организации" name="orgName">
                <i class="fa-solid fa-building"></i>
            </div>
            <div class="form-control">
                <input type="text" placeholder="Подразделение" name="subdivision">
                <i class="fas fa-people-roof"></i>
            </div>
            <div class="form-control">
                <input type="text" placeholder="Должность" name="position">
                <i class="fas fa-clipboard-user"></i>
            </div>
            <div class="form-control">
                <input  type="text" placeholder="Ф.И.О." name="FIO">
                <i class="fas fa-user"></i>
            </div>
            <div class="form-control">
                <input class="detailsCount" type="text" placeholder="Количество деталей" name="amountDetails">
                <i class="fa-solid fa-cubes-stacked"></i>
            </div>
            <div class="form-control">
                <input class="detailPrice" type="text" placeholder="Ставка детали">
                <i class="fa-solid fa-coins"></i>
            </div>
            <div class="form-control">
                <input class="penny" type="text" placeholder="Надбавка">
                <i class="fa-solid fa-money-bill-trend-up"></i>
            </div>
            <div class="form-control">
                    <input class="rezident" name="dzen" type="radio" value="da">Резидент РФ
                    <input class="nerezident" name="dzen" type="radio" value="net">Не резидент РФ
            </div>
            <p>
                <input class="date" type="date" id="localdate" name="date" placeholder="Время"/>
            </p>
            <div>
                <button class="calc">Расчет</button>
            </div>
        </form>
        <form class="output-form">
            <div class="output-control">
                <p class="sumSotr">Сумма сотруднику: 
                 <%
                 	
                	if(request.getParameter("amountDetails") != null){
                		out.print(request.getParameter("amountDetails"));
               		}
			      %>

                <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>НДФЛ 13%: <output name="result""></output></p>
            </div>
            <div class="output-control">
                <p>ПФ: <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ФОМС: <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ФСС: <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ФСС НС: <output name="result"></output></p>
            </div>
        </form>
        <form>
            <div>
                <button class="genPDF">
                    <i class="fa-solid fa-file-pdf"></i>
                    Сгенерировать PDF
                </button>
            </div>
        </form>
    </div>
</div>  
</body>
</html>