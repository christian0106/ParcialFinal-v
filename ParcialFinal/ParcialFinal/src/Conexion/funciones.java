/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Entidades.Usuario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author hugo
 */
public class funciones {
    public Conexion bd;

    public funciones() {
        bd = new Conexion();
    }
    public Usuario iniciarS(String username,String password) throws SQLException{
        boolean flag = false;
        Connection conn = bd.getConnection();
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                usuario.setUsername(rs.getString("usuario"));
                //usuario.setPassword(rs.getString("contrasena"));
                usuario.setId(rs.getInt("id_usuario"));
                
                
                flag = true;
            }
            if(!flag) usuario = null;
            //conn.close();
        }catch(SQLException ex){
            usuario = null;
            ex.printStackTrace();
        }
        return usuario;
    }
    public boolean crearCuenta(String username, String password) throws SQLException{
        System.out.println("llega0");
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query = "INSERT INTO usuario (usuario,contrasena) VALUES (?,?)";
        String query2 = "SELECT * FROM usuario WHERE usuario= ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            
            pstm2.setString(1, username);
            if(!pstm2.executeQuery().isFirst()){
                System.out.println("llega");
                pstm.execute();
                isSuccess = true;
            }
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean crearRonda(int id_usuario, int t1, int t2, int t3) throws SQLException{
        //System.out.println("llega0");
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query = "INSERT INTO ronda (id_usuario,puntaje_1,puntaje_2 ,puntaje_3) VALUES (?,?,?,?)";
        String query2 = "SELECT * FROM ronda WHERE id_usuario= ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setInt(1, id_usuario);
            pstm.setInt(2,t1);
            pstm.setInt(3,t2);
            pstm.setInt(4,t3);
            
            
            pstm2.setInt(1,id_usuario);
            if(true){
                System.out.println("llega");
                pstm.execute();
                isSuccess = true;
            }
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public ResultSet CrearInforme(Usuario su){

        ResultSet resultado=null;
        Connection conn = bd.getConnection();
        
        String query = " select u.usuario as Nombre ,r.puntaje_1 as Primer_Tiro ,r.puntaje_2 as Segundo_Tiro,r.puntaje_3 as Tercer_Tiro, (r.puntaje_1 + r.puntaje_2 + r.puntaje_3) as PuntajeTotal\n" +
                       " from usuario u, ronda r\n" +
                       " group by u.usuario, r.puntaje_1, r.puntaje_2, r.puntaje_3, u.id_usuario, r.id_usuario\n" +
                       " having u.id_usuario=?\n" +
                       " and r.id_usuario= u.id_usuario";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, su.getId());
            resultado = pstm.executeQuery();
            

            //conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return resultado;
    }
    

    
}
