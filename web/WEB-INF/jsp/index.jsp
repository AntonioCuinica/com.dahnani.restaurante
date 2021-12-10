<%@page import="model.DAO.Prato_dao"%>
<%@page import="model.entity.Prato"%>
<%@page import="model.DAO.Mesa_dao"%>
<%@page import="model.entity.Mesa"%>
<%@page import="model.DAO.Conexao"%>
<%@page import="model.DAO.Bebida_dao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.entity.Bebida"%>
<%@page import="model.entity.Garson"%>
<%@page import="model.DAO.Garson_dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="./pages/css/index.css">
        <link href="./pages/css/index2.css" rel="stylesheet" type="text/css"/>
        <link href="./pages/css/index3.css" rel="stylesheet" type="text/css"/>
        <script src="./pages/js/index.js" type="text/javascript"></script>
    </head>

    <body>
        <% 
            //Objecto garson
            Garson gUser=Garson_dao.getGarson();
            String nome=gUser.getNome();
            String apelido=gUser.getApelido();
            String nascimento=gUser.getNascimento();
            String nacionalidade=gUser.getNacionalidade();
            String telefone=gUser.getTelefone();
            String email=gUser.getEmail();
             
            //Objecto bebida
            ArrayList<Bebida> bebidas=new Bebida_dao().getBebidas();
            
            //Objecto mesa
            ArrayList<Mesa> mesas=new Mesa_dao().getMesas();
            
            //Objecto prato peincipal
            ArrayList<Prato> pratos=new Prato_dao().getPratos("PratoPrincipal");
            
            //Objecto sobremesa
            ArrayList<Prato> sobremesas=new Prato_dao().getPratos("Sobremesa");
        %>
        
        <header id="header">
             
        </header>
        <div id="sidebar">
            <div id="menu">
                <div class="input">
                    <label class="icon" id="garson"><img src="./pages/img/Muffin.png" alt="img"/></label>
                    <input type="button" id="btn_g" name="garson" value="Garson" onclick="btnClick('garson')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
                <div class="input">
                    <label class="icon" id="user"><img src="./pages/img/User_Circle.png" alt="imgg"/></label>
                    <input type="button" id="btn_u" name="user" value="<%=nome+" "+apelido%>"  onclick="btnClick('user')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
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
                    <input type="button" id="btn_log" name="fLog" value="Fazer logout" onclick="btnClick('fLog')" onmousemove="btnHoverIn(this)" onmouseout="btnHoverOut(this)">
                </div>
            </div>
        </div>
        <div id="mainbody">
            <div class="mainbody" id="main_rPed">
                <table>
                    <tr>
                        <td><button  class="rpedido" id="bebidas" onclick="rPedido('rpd_bebidas',this)"><pre>     Bebidas     </pre></button></td>
                        <td><button  class="rpedido" id="Sobremesas" onclick="rPedido('rpd_sobremesas',this)"><pre>   Sobremesas   </pre></button></td>
                        <td><button  class="rpedido" id="Pratos" onclick="rPedido('rpd_pratoP',this)"><pre>Pratos Principais</pre></button></td>
                    </tr>
                </table>
                <button id="rcliente" name="Registar Cliente" onclick="rPedido('rpd_cliente',this)">Registar Cliente</button>
            </div>
            <div class="mainbody" id="main_vPed">
                
            </div>
            <div class="mainbody" id="main_vCont">
                
            </div>
            <div class="mainbody" id="main_vProd">
                
            </div>
        </div>
                
        <!--Tags de caixa de dialog -->
        
        <!-- Dialog ver usuario -->
        <div id="vuser" class="myModel">
            <div class="garson_dados">
                <button class="x" onclick="userCancel()">X</button>
                <p class="gdados"><strong>Usuario</strong>:<%=gUser.getUsuario()%></p>
                <p class="gdados"><strong>Nome:</strong> <label><%=nome+" "+apelido%></label></p>
                <p class="gdados"><strong>Nascimento:</strong> <label><%=nascimento%></label></p>
                <p class="gdados"><strong>Nacionalidade:</strong> <label><%=nacionalidade%></label></p>
                <p class="gdados"><strong>Telefone:</strong> <label><%=telefone%></label></p>
                <p class="gdados"><strong>Email:</strong> <a href="mailto:<%=email%>" target="blank" ><%=email%></a></p>
            </div>
        </div>
        
        <!--dialog ver garson --> 
        <div id="vgarson" class="myModel">
            <div class="garson_dados">
                <button class="x" onclick="garsonCancel()">X</button>
                <h2>Garson</h2>
                <p class="gdados">
                    Responsavel por atender os clientes, registar 
                    todos  os seus pedidos, e também fazer as entregas
                    dos pedidos, quando já estiverem prontas.
                </p>
            </div>
        </div>
        
        <!--Dialog Registar pedidos: bebidas -->
        <div id="rpd_bebidas" class="myModel">
            <div class="garson_dados" > 
                <button class="x" onclick="rPedidoX('rpd_bebidas')">X</button>
                <h2>Bebidas</h2>
                <form action="bebida" method="POST">
                    <p class="camP">
                        <b>Escolha a mesa:</b>
                        <select name="mesa">
                            <% for(Mesa b:mesas){%>
                                <option value="<%=b.getIdmesa()%>"><%=b.getNome()%></option>
                            <%}%>
                        </select>
                    </p>
                    <p class="camP">
                        <b>Escolha uma bebida:</b>
                        <select name="bebida">
                            <% for(Bebida b:bebidas){%>
                               <%if(b.getIdbebida()!=1){%> <option value="<%=b.getIdbebida()%>"><%=b.getNome()%></option><%}%>
                            <%}%>
                        </select>
                    </p>
                    <p class="camP">
                        <b>Quantidade:</b>
                        <input type="number" name="quant" value="1" requered="requered"/>
                    </p>
                    <p class="camP">
                        <input type="submit" value="Submeter"/>
                    </p>
                </form>
            </div>
        </div>
        
         <!--Dialog Registar pedidos: sobremesas -->
        <div id="rpd_sobremesas" class="myModel">
            <div class="garson_dados" >
                <button class="x" onclick="rPedidoX('rpd_sobremesas')">X</button>
                <h2>Sobremesas</h2>
                <form action="sobremesa" method="POST">
                    <p class="camP">
                        <b>Escolha a mesa:</b>
                        <select name="mesa">
                            <% for(Mesa b:mesas){%>
                                <option value="<%=b.getIdmesa()%>"><%=b.getNome()%></option>
                            <%}%>
                        </select>
                    </p>
                    <p class="camP">
                        <b>Escolha uma sobremesa:</b>
                        <select name="sobremesa">
                            <% for(Prato b:sobremesas){%>
                                <%if(b.getIdprato()!=1){%><option value="<%=b.getIdprato()%>"><%=b.getNome()%></option><%}%>
                            <%}%>
                        </select>
                    </p>
                    <p class="camP">
                        <b>Quantidade:</b>
                        <input type="number" name="quant" value="1" requered="requered"/>
                    </p>
                    <p class="camP">
                        <input type="submit" value="Submeter"/>
                    </p>
                </form>
            </div>
        </div>
         
        <!--Dialog Registar pedidos: prato principal -->
        <div id="rpd_pratoP" class="myModel">
            <div class="garson_dados">
                <button class="x" onclick="rPedidoX('rpd_pratoP')">X</button>
                <h2>Prato principal</h2>
                <form action="prato" method="POST">
                    <p class="camP">
                        <b>Escolha a mesa:</b>
                        <select name="mesa">
                            <% for(Mesa b:mesas){%>
                                <option value="<%=b.getIdmesa()%>"><%=b.getNome()%></option>
                            <%}%>
                        </select>
                    </p>
                    <p class="camP">
                        <b>Escolha um prato:</b>
                        <select name="prato">
                            <% for(Prato b:pratos){%>
                                <%if(b.getIdprato()!=1){%><option value="<%=b.getIdprato()%>"><%=b.getNome()%></option><%}%>
                            <%}%>
                        </select>
                    </p>
                    <p class="camP">
                        <b>Quantidade:</b>
                        <input type="number" name="quant" value="1" requered="requered"/>
                    </p>
                    <p class="camP">
                        <input type="submit" value="Submeter"/>
                    </p>
                </form>
            </div>
        </div>
          
        <!--Dialog Registar pedidos: registar cliente -->
        <div id="rpd_cliente" class="myModel">
            <div class="garson_dados">
                <button class="x" onclick="rPedidoX('rpd_cliente')">X</button>
                <h2>Registar Cliente</h2>
                <form action="cliente" method="POST">
                    <p class="camP">
                        <b>Nome:</b>
                        <input type="text" name="nomeC" requered="requered">
                        <b>Apelido:</b>
                        <input type="text" name="apelidoC"  requered="requered">
                    </p>
                    <p class="camP">
                        <b>Email:</b> 
                        <input type="email" name="emailC"  requered="requered">
                    </p>
                    <p class="camP">
                        <b>Morada:</b>
                        <br>    
                        <textarea name="moradaC"  requered="requered"></textarea>
                    </p>
                    <p class="camP">
                        <input type="submit" value="Submeter"/>
                    </p>
                </form>
            </div>
        </div>  
          
          
        <!--Dialog fazer logout -->
        <div id="vlogout" class="myModel">
            <div class="garson_dados" id="logBox">
                <h2>Deseja Sair ?</h2>
                <a href="logout"><button id="sim" style="background-color:greenyellow;" >Sim</button></a>
                <button id="nao" style="background-color:red;" onclick="logoutCancel()">Nao</button>
            </div>
        </div>
        
        <!--Nostas de rodapé -->
        <div id="footer">
            Direitos reservados a dahnani @ 2021
        </div>
        
    </body>
</html>