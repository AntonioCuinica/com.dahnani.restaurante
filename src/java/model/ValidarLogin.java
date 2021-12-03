/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import model.DAO.Garson_dao;
import model.entity.Garson;

/**
 *
 * @author CUINIC4
 */
public class ValidarLogin {
    
    public static boolean temAcesso(String username,String password,Connection con){
        Garson_dao gdao=new Garson_dao(con);
        Garson garson=gdao.getGarson(username, password);
        if(garson.getNome().equals("null")){
            return false;
        }
        else if(!garson.getUsuario().equals(username)){
            return false;
        }else if(!garson.getSenha().equals(password)){
            return false;
        }
        return true;
    }
}