<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="database.User"
    %>
<%
// Чтобы зайти на форму - закоментить эту часть
	if(session.getAttribute("role")!= User.ROLE.USER){
		response.sendRedirect("login.jsp");
	}
%>
<style> 
<%@include file="/css/main.css"%> 
<%@include file="/css/popup.css"%> 
</style>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="viewport" content="width=600">
	<meta name="viewport" content="height=device-height">
	<meta name="viewport" content="user-scalable=yes">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <title>Калькулятор</title>
</head>
<body>
    <header class="lock-padding">
        <a href="#" class="logo"><img src="./images/ugatu_logo.png" alt=""></a>
        <div class="nameProject">
            <h1>Зарплатный калькулятор</h1>
        </div>
        <ul class="menu-bar">
            <li class="About"><a href="http://88.99.186.187/mediawiki" target="_blank">О калькуляторе</a></li>
            <li class="Dev"><a href="#popup_2" class="popup-link">Разработчики</a></li>
        </ul>
        <div class="prava">
            <h3>Права доступа: Обычный пользователь</h3>
        </div>
        <div class="btns">
        <a href="popup_4" class=popup-link>
            <button class="logout">
                <i class="fa-solid fa-arrow-right-from-bracket"> </i> 
                Выход   
            </button>
        </a>
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
        <form class="login-form" method = "post" action = "Calc">
            <div class="form-control">
                <input type="text" name="nameOrg" placeholder="Название организации" value=${nameOrg}>
                <i class="fa-solid fa-building"></i>
            </div>
            <div class="form-control">
                <input type="text" name="podrazdelenie" placeholder="Подразделение" value=${podrazdelenie}>
                <i class="fas fa-people-roof"></i>
            </div>
            <div class="form-control">
                <input type="text" name="doljnost" placeholder="Должность" value=${doljnost}>
                <i class="fas fa-clipboard-user"></i>
            </div>
            <div class="form-control">
                <input  type="text" name="FIO" placeholder="Ф.И.О." value=${FIO}>
                <i class="fas fa-user"></i>
            </div>
            <div class="form-control">
                <input class="detailsCount" type="text" placeholder="Количество деталей" name="amountDetails" value=${amountDetails}>
                <i class="fa-solid fa-cubes-stacked"></i>
            </div>
            <div class="form-control">
                <input class="detailPrice" type="text" placeholder="Ставка детали" name="cost" value=${cost}>
                <i class="fa-solid fa-coins"></i>
            </div>
            <div class="form-control">
                <input class="penny" type="text" placeholder="Надбавка" name="allowance" value=${allowance}>
                <i class="fa-solid fa-money-bill-trend-up"></i>
            </div>
            <div class="form-control">
                    <input class="rezident" name="dzen" type="radio" value="yes" checked="checked" value=${dzen}>Резидент РФ
                    <input class="nerezident" name="dzen" type="radio" value="no" value=${dzen}>Не резидент РФ
            </div>
            <p>
                <input class="date" type="date" id="localdate" name="date" placeholder="Время" value=${date}/>
            </p>
            <div class = "calcANDgen">
                <button class="calc" onclick = "form.action = 'Calc'; form.method = 'post'">Расчет</button>
                <button class="genPDF" onclick = "form.action = 'CreatePDF'; form.method = 'post'"><i class="fa-solid fa-file-pdf"></i>Сгенерировать PDF</button>
            </div>
        </form>
         <form class="output-form">
            <div class="output-control">
                <p class="sumSotr">Сумма сотруднику:${salary}
                 <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>НДФЛ: ${NDFL}
                 <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ПФ: ${PF} 
                <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ФОМС: ${FOMS}
                <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ФСС: ${FSS}
                <output name="result"></output></p>
            </div>
            <div class="output-control">
                <p>ФСС НС: ${FSSNS} 
                <output name="result"></output></p>
            </div>
        </form>
    </div>
</div>

<div id="popup" class="popup">
    <div class="popup_body">
        <div class="popup_content">
            <a href="#header" class="popup_close close-popup">X</a>
            <div class="popup_title">Описание калькулятора</div>
            <div class="popup_text">
            Калькулятор рассчитывает заработную плату 
            <br>по введенным данным и генерирует PDF-файл.
            </div>
            </div>
        </div>
    </div>

<div id="popup_2" class="popup">
    <div class="popup_body">
        <div class="popup_content">
            <a href="#header" class="popup_close close-popup">X</a>
            <div class="popup_title">Команда разработчиков</div>
            <div class="popup_text">
              Модератор - Аюпов Т.Р. (<a href = "https://github.com/ayupovv" target="_blank">Github</a>)<br>
                Разработчик 1  - Сираев Р.В. (<a href = "https://github.com/Saver-Igt" target="_blank">Github</a>)<br>
                Разработчик 2 - Фахретдинов Р.Н. (<a href = "https://github.com/userRinat" target="_blank">Github</a>)<br>
                Разработчик 3 - Хасанов Р.А. (<a href = "https://github.com/UniqueSunrise" target="_blank">Github</a>)
        	</div>
   		</div>
	</div>
</div>

<div id="popup_4" class="popup">
    <div class="popup_body">
        <div class="popup_content">
            <a href="#header" class="popup_close close-popup">X</a>
            <div class="popup_title">Вы точно хотите выйти ?</div>
            <div class="logout_quest">
            <form>
                <button class="logout_yes" onclick = "form.action = 'logout'; form.method = 'post'">Да</button>
                <button class="logout_no close-popup" >Нет</button>
            </form> 
            </div>  
   		</div>
	</div>
</div>

</body>
<script src="js/popups.js" type="text/javascript"></script>
</html>