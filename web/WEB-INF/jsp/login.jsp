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
        <link rel="stylesheet" type="text/css" href="./pages/css/login.css">
        <title>Login</title>
    </head>
    <body>
        <form id="login" action="login" method="POST">
            <h1>Login</h1>
            <input type="text" name="username" placeholder="Usuario" required="required">
            <input type="password" name="password" placeholder="Senha" required="required">
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
