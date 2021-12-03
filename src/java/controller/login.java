/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ValidarLogin;

/**
 *
 * @author CUINIC4
 */

public class login extends HttpServlet {
    private boolean temAcesso=false;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ValidarLogin vld=new ValidarLogin();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Connection con=(Connection)request.getAttribute("conexao");
        temAcesso=vld.temAcesso(username,password,con);
        
        request.setAttribute("temAcesso", temAcesso);
        if(temAcesso){
            RequestDispatcher rs=request.getRequestDispatcher("./redirect.jsp"); 
            rs.forward(request, response);
        }else{
            RequestDispatcher rs=request.getRequestDispatcher("./WEB-INF/jsp/login.jsp");
            rs.forward(request, response);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
