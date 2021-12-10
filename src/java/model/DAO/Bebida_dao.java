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
import model.entity.Bebida;

/**
 *
 * @author CUINIC4
 */
public class Bebida_dao {
    private static Connection con;
    private static Bebida bebida;
    
    public Bebida_dao(){
        this.con=new Conexao().getConexao();
        bebida=new Bebida();
        bebida.setNome("null");
    }
    
    public ArrayList<Bebida> getBebidas(){
        String select="SELECT * FROM dahnani.bebida;";
        ArrayList <Bebida>bds=new ArrayList();
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                bebida=new Bebida();
                bebida.setIdbebida(Integer.parseInt(rs.getString("idbebida")));
                bebida.setNome(rs.getString("nome"));
                bebida.setPreco(Double.parseDouble(rs.getString("preco")));
                bebida.setMarca(rs.getString("marca"));
                bebida.setQuantidade(rs.getString("quantidade"));
                
                bds.add(bebida);
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
    
    public ArrayList<Bebida> getBebidaP(String idpedido){
        String select="SELECT * FROM bebida b join pedido p on p.bebida_idbebida=b.idbebida where p.idpedido=? ;";
        ArrayList <Bebida>bds=new ArrayList();
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, idpedido);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                bebida=new Bebida();
                bebida.setIdbebida(Integer.parseInt(rs.getString("b.idbebida")));
                bebida.setNome(rs.getString("b.nome"));
                bebida.setPreco(Double.parseDouble(rs.getString("b.preco")));
                bebida.setMarca(rs.getString("b.marca"));
                bebida.setQuantidade(rs.getString("b.quantidade"));
                bebida.setDataExpiracao(rs.getString("dataExpiracao"));
                bds.add(bebida);
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
    
    public  static void setBebida(Bebida b,String idpedido){
        String select="insert into bebida(nome,preco,marca,quantidade,dataExpriracao) values(?,?,?,?,?)";
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, b.getNome());    
            stmt.setString(2,""+b.getPreco());
            stmt.setString(3, b.getMarca());
            stmt.setString(4, b.getQuantidade());
            stmt.setString(5,""+b.getDataExpiracao());
            stmt.close();
            con.close();
            
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
}
