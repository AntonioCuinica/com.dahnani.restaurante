/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import model.DAO.Conexao;
/**
 *
 * @author CUINIC4
 */
@WebFilter(urlPatterns={"/*"})
public class doConexao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        try {
            Connection con=new Conexao().getConexao();
            request.setAttribute("conexao", con);
            chain.doFilter(request, response);
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro de conexao doFilter1 : "+ex.getMessage());
            Logger.getLogger(doConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalStateException e){
            System.out.println("Erro no Filtro conexao: "+e.getMessage());
        }
    }

    
    
    @Override
    public void destroy() {
    }
    
}
