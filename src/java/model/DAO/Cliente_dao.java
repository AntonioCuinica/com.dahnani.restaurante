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
import model.entity.Cliente;

/**
 *
 * @author CUINIC4
 */
public class Cliente_dao {
    private static Connection con;
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
    
    public  static void setCliente(Cliente cliente){
        int id=Integer.parseInt(getClienteId(cliente.getNome(),cliente.getEmail()));
        boolean teste=(id == -1);
        if(teste){
            con=new Conexao().getConexao();
            String select="insert into cliente(nome,apelido,email,morada) values(?,?,?,?)";
            try{
                PreparedStatement stmt=con.prepareStatement(select);
                stmt.setString(1,cliente.getNome());    
                stmt.setString(2,cliente.getApelido());
                stmt.setString(3,cliente.getEmail());
                stmt.setString(4,cliente.getMorada());
                stmt.execute();
                stmt.close();
                con.close();
            }catch(SQLException e){
                System.out.println("Select error: "+e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
    
    public static String getClienteId(String nome, String email){
        con=new Conexao().getConexao();
        String select="SELECT max(idcliente) FROM dahnani.cliente where nome=? and email=?;";
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                return rs.getString("idcliente");
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return "-1";
    }
}
