/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author hugo
 */
public class Conexion {//definimos el driver del motor que vamos a utilizar
    private final String DRIVER = "org.postgresql.Driver";  
    //Cadena de conexión
    private final String URL = "jdbc:postgresql://localhost:5432/ParcialFinal";  
    //usuario de la base de datos
    private final String USERNAME = "postgres";    
    // contraseña de la base de datos
<<<<<<< HEAD:src/Conexion/Conexion.java
    private final String PASSWORD = "pene1224"; 
=======
    private final String PASSWORD = "ethernanobull"; 
>>>>>>> a86a8fd5fe60737f75bed1911d064ee48bb857a8:ParcialFinal/ParcialFinal/src/Conexion/Conexion.java
    
    private Connection connection;

    //metodo que establece la conexion
    public Conexion() {
        connection = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
    public Connection getConnection(){
        return connection;
    }

}
