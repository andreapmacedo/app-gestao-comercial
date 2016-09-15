package Main;

import Settings.SET_Fame_1;
import javax.swing.JFrame;

/**
 *
 * @author Andre
 */
public class APP_Start {

    public static void main(String[] args) {

        openMainFrame();

    }

    public static void openMainFrame() {
        java.awt.EventQueue.invokeLater(new Runnable() {//http://www.guj.com.br/java/206065-duvida-sobre--javaawteventqueueinvokelaternew-runnable-

            public void run() {

                SET_Fame_1 apearance = new SET_Fame_1(); //chamando sem static instanciando um objeto //http://pt.wikihow.com/Chamar-um-M%C3%A9todo-no-Java
                // apearance.setAppearanceNimbus();
                apearance.setAppearanceMetal();//chamando método com static  

                MAIN_FRM form = new MAIN_FRM();
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setVisible(true);

            }
        });

    }
}
