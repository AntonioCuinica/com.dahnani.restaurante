/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import model.entity.Cliente;

/**
 *
 * @author CUINIC4
 */
public class Cliente_dao {
    private Connection con;
    private static Cliente cliente;
    
    public Cliente_dao(){
        this.con=new Conexao().getConexao();
        cliente=new Cliente();
        cliente.setNome("null");
    }
    
    public ArrayList<Cliente> getCliente(){
        String select="SELECT * FROM dahnani.cliente;";
        ArrayList <Cliente>bds=new ArrayList();
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                cliente=new Cliente();
                cliente.setIdcliente(Integer.parseInt(rs.getString("idbebida")));
                cliente.setNome(rs.getString("nome"));
                cliente.setApelido(rs.getString("apelido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setMorada(rs.getString("morada"));
                bds.add(cliente);
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return bds;
    }
    
}
