/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



/**
 *
 * @author CUINIC4
 */
@WebFilter(urlPatterns={"/redirect.jsp"})
public class doLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean temAcesso=false;
        try{
            temAcesso =(boolean)request.getAttribute("temAcesso");
        }catch(NullPointerException e){
            temAcesso=false;
        }
        if(!temAcesso){
            RequestDispatcher rs=request.getRequestDispatcher("./WEB-INF/jsp/login.jsp");
            rs.forward(request, response);
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }

    
}
