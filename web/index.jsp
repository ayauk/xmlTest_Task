<%-- 
    Document   : index
    Created on : 02.04.2018, 22:20:30
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Converting</title>
        <script src="scripts/jquery-3.1.1.min.js"></script>
        <script  src="scripts/script.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="styles/mainstyle.css">
    </head>
    <body>
        <div id="field">
            <form>
                <div id="inputData">
                  <h2>Enter Data:</h2>
                  
                    <div id="inValue">
                        <div class="in-block-l">
                            <label class="in-label" for="operation">Операция:</label>
                            <label class="in-label" for="uname">Имя:</label>
                            <label class="in-label" for="bill">Логин:</label>
                            <label class="in-label" for="text">E-mail:</label>
                            <label class="in-label" for="pnumber">Телефон:</label>
                            <label class="in-label" for="msg">Сообщение:</label>
                        </div>
                        <div class="in-block-v">
                            <select class="in-value" name="operation" id="operation" >
                                <option value="1">Объединение данных</option>
                                <option value="2">Найти уникальный символ</option>
                                <option value="3">Валидация имени и почты</option>
                            </select>
                            <input class="in-value" type="text" id="uname" name="user">
                            <input class="in-value" type="text" id="login" name="login">
                            <input class="in-value" type="text" id="email" name="email">
                            <input class="in-value" type="text" id="pnumber" name="pnumber">
                            <textarea rows="10" class="in-value" type="text" id="msg" name="msg"></textarea>
                        </div>
                </div>
         </form>         
                  <a class='button' href="" id="convertbtn" onclick="convert();">Convert</a>
                </div>
      
                <div id="outputData">
                  <h2>Result:</h2>
                  <div id="resultMessage"></div>
                </div>
             
            
        </div>
    </body>
</html>
