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
import model.entity.Garson;

/**
 *
 * @author CUINIC4
 */
public class Garson_dao {
    private Connection con;
    private Garson garson;
    
    public Garson_dao(Connection con){
        this.con=con;
        garson=new Garson();
        garson.setNome("null");
    }
    
    public Garson getGarson(String user,String pwd){
        String select="select * from garson g join acesso a on a.garson_idgarson=g.idGarson where a.usuario=? and a.senha=? ;";
        try{
            PreparedStatement stmt=this.con.prepareStatement(select);
            stmt.setString(1,user);
            stmt.setString(2,pwd);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                garson=new Garson();
                garson.setNome(rs.getString("g.nome"));
                garson.setApelido(rs.getString("g.apelido"));
                garson.setNascimento(rs.getString("g.nascimento"));
                garson.setNacionalidade(rs.getString("g.nacionalidade"));
                garson.setProvincia(rs.getString("g.provincia"));
                garson.setCidade(rs.getString("g.cidade"));
                garson.setDistrito(rs.getString("g.distrito"));
                garson.setBairro(rs.getString("g.bairro"));
                garson.setQuarteirao(rs.getString("g.quarteirao"));
                garson.setCasa(rs.getString("g.casa"));
                garson.setNuit(rs.getString("g.NUIT"));
                garson.setBi(rs.getString("g.BI"));
                garson.setTelefone(rs.getString("g.telefone"));
                garson.setEmail(rs.getString("g.email"));
                garson.setUsuario(rs.getString("a.usuario"));
                garson.setSenha(rs.getString("a.senha"));
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return garson;
    }
}
