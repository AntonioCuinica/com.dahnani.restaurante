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
import java.util.Date;
import model.entity.Bebida;

/**
 *
 * @author CUINIC4
 */
public class Bebida_dao {
    private Connection con;
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
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataExpiracao"));
                bebida.setDataExpiracao(data.getTime());
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
    
}
