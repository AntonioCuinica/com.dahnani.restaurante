<%-- 
    Document   : login
    Created on : Nov 26, 2021, 11:03:50 PM
    Author     : CUINIC4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../../resourcers/css/login.css">
        <style>
            body{
                background-color: red;
            }
        </style>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST">
            <label>
                Username:<input type="text" name="username">
            </label>
            <br/><br/>
            <label>
                Password:<input type="text" name="password">
            </label>
            <br/><br/>
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
