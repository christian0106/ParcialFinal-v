/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialfinal;

import Conexion.Conexion;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import views.Menu;

/**
 *
 * @author hugo
 */
public class ParcialFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu men = new Menu();
        men.setTitle("Menu principal");
        men.setVisible(true);
        
        
        //Conexion con = new Conexion();
         try{
                JFrame.setDefaultLookAndFeelDecorated(true);
                SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("temas/chaNinja-Bluethemepack.zip")); 
                UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
    }
    
}
