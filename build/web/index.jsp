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
        <script  src="scripts/mainjs.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
    </head>
    <body>
        <div id="field">
                <div id="inputData">
                    <form>
                  <h2>Введите телефонные данные:</h2>
                  
                    <div id="inValue">
                        <div class="in-block-l">
                            <label class="in-label" for="opeartion">Операция:</label>
                            <label class="in-label" for="val0">Имя:</label>
                            <label class="in-label" for="val1">Номер:</label>
                        </div>
                        
                        <div>
                        <div class="in-block-v" id="in-fields">
                            <select class="in-value" name="operation" id="operation" >
                                <option value="1">Объединение данных</option>
                                <option value="2">Найти уникальный символ</option>
                                <option value="3">Валидация имени и почты</option>
                            </select>
                             
                            <input class="in-value" type="text" id="val0" name="val0">
                            <input class="in-value" type="text" id="val1" name="val1">
                        </div>
                            <a class='button' href="" id="addbtn" onclick="add();">Добавить номер</a>
                        </div>
                       
                </div>
                    </form>
            
                </div>
      
                <div id="outputData">
                  <h2>Результат:</h2>
                  <div id="resultMessage"></div>
                   <a class='button' href="" id="convertbtn" onclick="">Получить результат</a>
                </div>
             
            
        </div>
        
    </body>
</html>
