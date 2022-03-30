<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="header">
        <div class="logo-container">
            <img src="./images/ugatu_logo.png" alt="" class="logougatu">
            <h1 class="zar">Зарплатный <span>калькулятор</span></h1>
        </div>


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


    
</body>
</html>