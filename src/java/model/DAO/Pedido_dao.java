/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import model.entity.Cliente;
import model.entity.Pedido;

/**
 *
 * @author CUINIC4
 */

public class Pedido_dao {
    private static Connection con;
    private static Pedido pedido;
    
    public Pedido_dao(){
        con=new Conexao().getConexao();
        pedido=new Pedido();
    }
    
    public static ArrayList<Pedido> getPedidos(){
        String select="SELECT * FROM dahnani.pedido where data=curdate();";
        ArrayList <Pedido>bds=new ArrayList();
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                pedido=new Pedido();
                String idpedido=rs.getString("idpedido");
                pedido.setData(rs.getString("data"));
                pedido.setIdpedido(Integer.parseInt(idpedido));
                pedido.setBebidaIdbebida(new Bebida_dao().getBebidaP(idpedido));
                pedido.setMesaIdmesa(new Mesa_dao().getMesaP(idpedido));
                pedido.setPratoIdprato(new Prato_dao().getPratoP(idpedido));
                bds.add(pedido);
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
    
    public static String getPedidoIdByMesa(String idmesa){
        String select="SELECT idpedido as max FROM dahnani.pedido where `pedido`.`mesa_idmesa`=? and `pedido`.`data`=curdate();";
        try{
            con=new Conexao().getConexao();
            PreparedStatement stmt=con.prepareStatement(select);
            stmt.setString(1, idmesa);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                return rs.getString("max");
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return "0";
    }
    
    public static void setPedidos(String pedido,String id,String idmesa,Cliente cliente){
        con=new Conexao().getConexao();
        String select="insert into dahnani.pedido (data,prato_idprato,bebida_idbebida,mesa_idmesa) values(?,?,?,?)";
        String select1="INSERT INTO `dahnani`.`registar_pedido`(`Garson_idGarson`,`Pedido_idPedido`) VALUES(?,?);";
        String select2="INSERT INTO `dahnani`.`requisitar_pedido` (`Garson_idGarson`,`cliente_idcliente`,`pedido_idpedido`) VALUES(?,?,?);";
        try{
            PreparedStatement stmt=con.prepareStatement(select);
            Calendar date= Calendar.getInstance();
            String data=new SimpleDateFormat("yyyy/MM/dd").format(date.getTime());
            stmt.setString(1,""+data);
            if(pedido.equals("prato")){
               stmt.setString(2,id);
               stmt.setString(3,"1");
            }
            else if(pedido.equals("bebida")){
               stmt.setString(2,"1");
               stmt.setString(3,id);
            }
            stmt.setString(4,idmesa);
            stmt.execute();
            
            System.out.println("Pedido: "+pedido);
            System.out.println("id: "+id);
            System.out.println("idmesa: "+idmesa);
            System.out.println("cliente: "+cliente.getNome());
            System.out.println("idGarson:   : "+Garson_dao.getGarson().getIdGarson());
           
            System.out.println("Cliente object:"+Cliente_dao.getClienteByMesa(idmesa,cliente));
            System.out.println("clienteid: "+Cliente_dao.getClienteByMesa(idmesa,cliente).getIdcliente());
            
            stmt=con.prepareStatement(select1);
            stmt.setString(1,""+Garson_dao.getGarson().getIdGarson());
            stmt.setString(2,""+getPedidoIdByMesa(idmesa));
            stmt.execute();

            stmt=con.prepareStatement(select2);
            stmt.setString(1,""+Garson_dao.getGarson().getIdGarson());
            stmt.setString(2,""+Cliente_dao.getClienteByMesa(idmesa,cliente).getIdcliente());
            stmt.setString(3,""+getPedidoIdByMesa(idmesa));
            stmt.execute();

            
            stmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Select error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
