<%@page import="model.DAO.Garson_dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="./pages/css/index.css">
        <link href="./pages/css/index2.css" rel="stylesheet" type="text/css"/>
        <script src="./pages/js/index.js" type="text/javascript"></script>
    </head>

    <body>
        <% 
            String nome=Garson_dao.getGarson().getNome();
            String apelido=Garson_dao.getGarson().getApelido();
            String garson=nome+" "+apelido;
        %>
        
        <header id="header">
             
        </header>
        <div id="sidebar">
            <div id="menu">
                <div class="input">
                    <label class="icon" id="garson"><img src="./pages/img/Muffin.png" alt="img"/></label>
                    <input type="button" name="garson" value="Garson" onclick="btnClick('garson')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                <div class="input">
                    <label class="icon" id="user"><img src="./pages/img/User_Circle.png" alt="imgg"/></label>
                    <input type="button" name="user" value="<%=garson%>"  onclick="btnClick('user')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                <div class="input" >
                    <label class="icon" id="rPed"><img src="./pages/img/Notebook.png" alt="img"/></label>
                    <input type="button" name="rPed" value="Registar Pedidos"  onclick="btnClick('rPed')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                
                <div class="input">
                    <label class="icon" id="vPed"><img src="./pages/img/eye-6x.png" alt="img"/></label>
                    <input type="button" name="vPed" value="Verificar Pedidos"  onclick="btnClick('vPed')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                
                <div class="input">
                    <label class="icon" id="vCont"><img src="./pages/img/eye-6x.png" alt="img"/></label>
                    <input type="button" name="vCont" value="Verificar Contas"  onclick="btnClick('vCont')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                
                <div class="input">
                    <label class="icon" id="vProd"><img src="./pages/img/eye-6x.png" alt="img"/></label>
                    <input type="button" name="vProd" value="Verificar Produtos"  onclick="btnClick('vProd')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                
                <div class="input">
                    <label class="icon" id="fLog"><img src="./pages/img/power-standby-4x.png" alt="img"/></label>
                    <input type="button" name="fLog" value="Fazer logout" onclick="btnClick('fLog')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
            </div>
        </div>
        <div id="mainbody">
            <div class="mainbody" id="main_rPed">
                <button  class="rpedido" id="bebidas">Bebidas</button>
                <button  class="rpedido" id="Sobremesas">Sobremesas</button>
                <button  class="rpedido" id="Pratos">Pratos Principais</button>
                <button id="rcliente" name="Registar Cliente">Registar Cliente</button>
            </div>
            <div class="mainbody" id="main_vPed">
                
            </div>
            <div class="mainbody" id="main_vCont">
                
            </div>
            <div class="mainbody" id="main_vProd">
                
            </div>
        </div>
        <div id="footer">
            <p>Direitos reservados a dahnani @ 2021</p>
        </div>
    </body>
</html>
