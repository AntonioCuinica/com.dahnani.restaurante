/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author CUINIC4
 */
public class ListaAcesso extends ArrayList<String[]> {
    public ListaAcesso(){
        String acesso1[]={"cuinica","123456"};
        String acesso2[]={"vumba","1234"};
        add(acesso1);
        add(acesso2);
    }
}
