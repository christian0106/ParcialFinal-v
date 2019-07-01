/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Entidades.Usuario;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author rene
 */
public class Registro {
    ResultSet resultado;
    Date today;

    public Registro() {
       // this.resultado=data;
       today=Calendar.getInstance().getTime();
       
    }
    
    public void exportar(Usuario su) throws IOException, SQLException{
       
        funciones f = new funciones();
        try {
            
            CSVWriter writer = new CSVWriter(new FileWriter("Record-"+su.getUsername()+today+".csv"));
            //String[] header="Nombre,Puntaje 1,Puntaje 2,Puntaje 3".split(",");
            //writer.writeNext(header);
            
            ResultSet rs=f.CrearInforme(su);
            writer.writeAll(rs, true); //And the second argument is boolean which represents whether you want to write header columns (table column names) to file or not.
            writer.close();
            System.out.println("CSV file created succesfully.");
        } catch (Exception e) {
            System.out.println("exception :" + e.getMessage());
        }
    }
    
    
    
}
