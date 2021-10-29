<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <title>JSP - Hello World</title>
    </head>

    <body>
        <h1>
            <%= "Task1" %>
        </h1>
        <br />
        <a href="task1/login.jsp">Войти</a>
        <a href="task1/register.jsp">Зарегистрироваться</a>
        <br />
        <h1>
            <%= "Task2" %>
        </h1>
        <br />
        <form action="/task2/get_info" method="GET">
            <select name="action">
                <option selected value="id">id</option>
                <option value="date">date</option>
                <option value="server">server</option>
            </select>
            <button type="submit">узнать</button>
        </form>
        <br />
        <h1>
            <%= "Task4" %>
        </h1>
        <br />
        <form action="/valuta" method="GET">
            <select name="valuta">
                <option selected value="R01235">USA</option>
                <option value="R01035">Фунт стерлингов</option>
                <option value="R01090">Белорусских рублей</option>
                <option value="R01215">Датских крон</option>
                <option value="R01239">Евро</option>
                <option value="R01310">Исландских крон</option>
            </select>
            <input type="date" name="date1">
            <input type="date" name="date2">
            <button type="submit">узнать</button>
        </form>
    </body>

</html>