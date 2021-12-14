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
                cliente.setIdcliente((rs.getString("idcliente")));
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
    
    public static Cliente getClienteByPedido(String idpedido){
        String select="SELECT * FROM dahnani.pedido p join requisitar_pedido r on r.pedido_idpedido=p.idPedido join cliente c on r.cliente_idcliente=c.idcliente where p.idPedido=? and data=curdate() ;";
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1,idpedido);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                cliente=new Cliente();
                cliente.setIdcliente((rs.getString("idcliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setApelido(rs.getString("apelido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setMorada(rs.getString("morada"));
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return cliente;
    }
    
    public static Cliente getClienteByMesa(String idmesa,Cliente cli){
        String select="SELECT * FROM dahnani.pedido p join requisitar_pedido r on r.pedido_idpedido=p.idPedido join cliente c on r.cliente_idcliente=c.idcliente where data=curdate();";
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                cliente=new Cliente();
                cliente.setIdcliente(rs.getString("c.idcliente"));
                cliente.setNome(rs.getString("c.nome"));
                cliente.setApelido(rs.getString("c.apelido"));
                cliente.setEmail(rs.getString("c.email"));
                cliente.setMorada(rs.getString("c.morada"));
                int num=Integer.parseInt(cliente.getIdcliente());
                if(num<=0){
                    System.out.println("cli.NOME: "+cli.getNome());
                    return getClienteByName(cli.getNome(),cli.getEmail());
                }
                if(!rs.getString("p.mesa_idmesa").equals(idmesa)){
                    System.out.println("cli.NOME: "+cli.getNome());
                    return getClienteByName(cli.getNome(),cli.getEmail());
                }
            }
            
            rs.close();
            stmt.close();
            con.close();
            System.out.println("dam@: clienteID: "+cliente.getIdcliente());
            System.out.println("dam@: clienteNome: "+cliente.getNome());
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }catch(NullPointerException f){
            System.out.println("Falhado man @@@@@@@@@@@@@@@@@@@@");
            return getClienteByName(cli.getNome(),cli.getEmail());
        }
        
        return cliente;
    }
    
   
    
    public static Cliente getClienteByName(String nome, String email){
        String select="SELECT * FROM dahnani.cliente where nome=? and email=?;";
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                cliente=new Cliente();
                cliente.setIdcliente((rs.getString("idcliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setApelido(rs.getString("apelido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setMorada(rs.getString("morada"));
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(NullPointerException f){
            return cliente;
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return cliente;
    }
    
    public static String getClienteId(String nome, String email){
        con=new Conexao().getConexao();
        String select="SELECT max(idcliente) as id FROM dahnani.cliente where nome=? and email=?;";
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                if(!rs.getString("id").equals("null")){
                    return rs.getString("id");
                } else {
                    return "-1";
                }
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(NullPointerException f){
            return "-1";
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return "-1";
    }
}
