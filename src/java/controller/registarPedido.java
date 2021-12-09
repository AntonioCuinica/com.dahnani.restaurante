/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CUINIC4
 */

@WebServlet(urlPatterns={"/bebida","/sobremesa","/prato","/cliente"})
public class registarPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(request.getRequestURI().contains("bebida")){
                
            }
            else if(request.getRequestURI().contains("sobremesa")){
                
            }
            else if(request.getRequestURI().contains("prato")){
                
            }
            else if(request.getRequestURI().contains("cliente")){
                
            }
    }
}


