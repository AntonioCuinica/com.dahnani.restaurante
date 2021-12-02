/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.*;

/**
 *
 * @author CUINIC4
 */
public class Conexao {
    private String driver="com.mysql.jdbc.Driver";
    private String username="root";
    private String password="";
    private String hostname="localhost";
    private String bdname="dahnani";
   
    public Connection getConexao(){
        try{
            Class.forName(driver);
            return DriverManager.getConnection("jdbc:mysql://"+hostname+"/"+bdname,username,password);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException f){
            throw new RuntimeException(f);
        }
    }
}
