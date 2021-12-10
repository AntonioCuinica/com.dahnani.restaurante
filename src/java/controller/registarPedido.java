/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.Pedido_dao;
import model.entity.Bebida;
import model.entity.Cliente;

/**
 *
 * @author CUINIC4
 */

@WebServlet(urlPatterns={"/bebida","/sobremesa","/prato","/cliente"})
public class registarPedido extends HttpServlet {
     static Cliente cliente=new Cliente("comum");
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
                int n=Integer.parseInt(request.getParameter("quant"));
                for(int i=0;i<n;i++){
                    Pedido_dao.setPedidos("bebida",request.getParameter("bebida"),request.getParameter("mesa"),cliente);
                }
                response.sendRedirect("index.htm");
            }
            else if(request.getRequestURI().contains("sobremesa")){
                int n=Integer.parseInt(request.getParameter("quant"));
                for(int i=0;i<n;i++){
                    Pedido_dao.setPedidos("prato",request.getParameter("sobremesa"),request.getParameter("mesa"),cliente);
                }
                response.sendRedirect("index.htm");
            }
            else if(request.getRequestURI().contains("prato")){
                int n=Integer.parseInt(request.getParameter("quant"));
                for(int i=0;i<n;i++){
                    Pedido_dao.setPedidos("prato",request.getParameter("prato"),request.getParameter("mesa"),cliente);
                }
                response.sendRedirect("index.htm");
            }
            else if(request.getRequestURI().contains("cliente")){
                cliente.setNome(""+request.getParameter("nomeC"));
                cliente.setApelido(""+request.getParameter("apelidoC"));
                cliente.setEmail(""+request.getParameter("emailC"));
                cliente.setMorada(""+request.getParameter("moradaC"));
                response.sendRedirect("index.htm");
            }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}


