package start;

import javax.swing.JFrame;

import settings.SET_Fame_1;

/**
 *
 * @author Andre
 */
public class AppSart {

    public static void main(String[] args) {

        openMainFrame();

    }

    public static void openMainFrame() {
    	//http://www.guj.com.br/java/206065-duvida-sobre--javaawteventqueueinvokelaternew-runnable-
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                SET_Fame_1 apearance = new SET_Fame_1(); 
                // apearance.setAppearanceNimbus();
                apearance.setAppearanceMetal();  

                MainWindow form = new MainWindow();
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setVisible(true);

            }
        });

    }
}
