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
import model.entity.Mesa;

/**
 *
 * @author CUINIC4
 */
public class Mesa_dao {
    private Connection con;
    private static Mesa mesa;
    
    public Mesa_dao(){
        this.con=new Conexao().getConexao();
        mesa=new Mesa();
        mesa.setNome("null");
    }
    public ArrayList<Mesa> getMesas(){
        String select="SELECT * FROM dahnani.mesa;";
        ArrayList <Mesa>bds=new ArrayList();
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                mesa=new Mesa();
                mesa.setIdmesa(Integer.parseInt(rs.getString("idmesa")));
                mesa.setNome(rs.getString("nome"));
                mesa.setPreco(Double.parseDouble(rs.getString("preco")));
                mesa.setDescricao(rs.getString("descricao"));
                mesa.setQuantLugares(Integer.parseInt(rs.getString("quantLugares")));
                bds.add(mesa);
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
