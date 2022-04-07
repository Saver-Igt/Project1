<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="database.User"
    %>
<%
	if(session.getAttribute("role") != User.ROLE.ADMIN){
		response.sendRedirect("login.jsp");
	
	//	request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <title>Document</title>
    
</head>
<body>
    <header>
        <a href="#" class="logo"><img src="./images/ugatu-logo.png" alt=""></a>
        <div class="nameProject">
            <h1>Зарплатный калькулятор</h1>
        </div>
        <ul class="menu-bar">
            <li class="About"><a href="./main.html">О калькуляторе</a></li>
            <li class="Dev"><a href="./main.html">Разработчики</a></li>
        </ul>
        
        <div class="prava">
            <h3>Права досупа: Администратор</h3>
        </div>
        <div class="btns">
            <button class="logout">
                <i class="fa-solid fa-gear"></i>
                Настройки
                
                
            </button>
            <button class="settings">
                <i class="fa-solid fa-arrow-right-from-bracket"> </i> 
                Выход
                
            </button>
            
            
        </div>
    </header>

   


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
        <form class="login-form">
            <div class="form-control">
                <input type="text" placeholder="Название организации">
                <i class="fa-solid fa-building"></i>
            </div>

            <div class="form-control">
                <input type="text" placeholder="Подразделение">
                <i class="fas fa-people-roof"></i>
            </div>
            

            <div class="form-control">
                <input type="text" placeholder="Должность">
                <i class="fas fa-clipboard-user"></i>
            </div>

            <div class="form-control">
                <input  type="text" placeholder="Ф.И.О.">
                <i class="fas fa-user"></i>
            </div>

            <div class="form-control">
                <input class="detailsCount" type="text" placeholder="Количество деталей">
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
        </form>

        <form class="output-form">

            <div class="output-control">
                <p class="sumSotr">Сумма сотруднику: <output name="result"></output></p>
            </div>

            <div class="output-control">
                <p>НДФЛ 13%: <output name="result"></output></p>
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
                <button class="calc">Расчет</button>
            </div>
        
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