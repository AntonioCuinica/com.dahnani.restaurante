/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CUINIC4
 */
public class ValidarLogin {
    
    public static boolean temAcesso(String username,String password){
        ListaAcesso a=new ListaAcesso();
        for(int i=0;i<a.size();i++){
            if(!username.equals(a.get(i)[0])){
                continue;
            }else if(!password.equals(a.get(i)[1])){
                continue;
            }else{
                return true;
            }
        }   
        return false;
    }
}