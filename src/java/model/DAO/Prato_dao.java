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
import model.entity.Prato;

/**
 *
 * @author CUINIC4
 */
public class Prato_dao {
    private Connection con;
    private static Prato prato;
    
    public Prato_dao(){
        this.con=new Conexao().getConexao();
        prato=new Prato();
        prato.setNome("null");
    }
    
    public ArrayList<Prato> getPratos(String cat){
        String select="SELECT * FROM dahnani.prato where categoria=?;";
        ArrayList <Prato>bds=new ArrayList();
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, cat);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                prato=new Prato();
                prato.setIdprato(Integer.parseInt(rs.getString("idprato")));
                prato.setNome(rs.getString("nome"));
                prato.setPreco(Double.parseDouble(rs.getString("preco")));
                prato.setDescricao(rs.getString("descricao"));
                prato.setQuantidade(rs.getString("quantidade"));
                prato.setIngredientes(rs.getString("ingredientes"));
                prato.setCategoria(rs.getString("categoria"));
                bds.add(prato);
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
