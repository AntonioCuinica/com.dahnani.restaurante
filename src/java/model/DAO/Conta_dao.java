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
import model.entity.Bebida;
import model.entity.Conta;

/**
 *
 * @author CUINIC4
 */
public class Conta_dao {
    private static Connection con;
    private static Conta conta;
    
    public Conta_dao(){
        this.con=new Conexao().getConexao();
        conta=new Conta();
    }
    
    public  static ArrayList<Conta> getContas(){
        String select="SELECT * FROM dahnani.conta where estado='aberta';";
        ArrayList <Conta>bds=new ArrayList();
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                conta=new Conta();
                conta.setData(rs.getString("data"));
                conta.setEstado(rs.getString("estado"));
                conta.setIdconta(rs.getString("idconta"));
                conta.setNrPedidos(rs.getString("nrPedidos"));
                conta.setPrecoTodal(rs.getString("precoTotal"));
                conta.setPedidoId(rs.getString("requisitar_pedido_idrequisitar_pedido"));
                conta.setClienteId(rs.getString("requisitar_pedido_cliente_idcliente"));
                conta.setGarsonId(rs.getString("requisitar_pedido_Garson_idGarson"));
                bds.add(conta);
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
    
    public static ArrayList<Conta> getContaId(String congta){
        String select="SELECT * FROM conta where idconta=? ;";
        ArrayList <Conta>bds=new ArrayList();
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, congta);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                conta=new Conta();
                conta.setData(rs.getString("data"));
                conta.setEstado(rs.getString("estado"));
                conta.setIdconta(rs.getString("idconta"));
                conta.setNrPedidos(rs.getString("nrPedidos"));
                conta.setPrecoTodal(rs.getString("precoTotal"));
                conta.setPedidoId(rs.getString("requisitar_pedido_idrequisitar_pedido"));
                bds.add(conta);
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
