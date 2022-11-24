
package settings;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import start.AppSart;



/**
 *
 * @author Andre
 */
public class SET_Fame_1 extends javax.swing.JFrame{
    
    
    
    
    private Insets in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    

    //Resolução do sistema.
    public int systemWidth = dimension.width - (in.left + in.top);
    public int systemHeight = dimension.height - (in.top + in.bottom);
    
    
    public static void setAppearanceLocalSystemPattern(){
           // configurações para que o aplicativo fique com a aparencia do sistema em que esta sendo rodado
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppSart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AppSart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AppSart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AppSart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
    public void setAppearanceNimbus(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppSart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppSart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppSart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppSart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


     public void setAppearanceMetal(){
    try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }


}

    
}
