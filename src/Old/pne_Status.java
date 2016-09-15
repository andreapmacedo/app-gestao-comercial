/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pne_Status.java
 *
 * Created on 09/09/2011, 01:50:25
 */
package Old;


import Main.MAIN_FRM;
import java.awt.Color;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Andre
 */
public class pne_Status extends javax.swing.JPanel {

    private final String className = "Classe ->" + this.getClass().getSimpleName();
    public static JTextField tfStatus, tfLog;
    private static JTextField tfHora, tfData;
    public static JProgressBar pbProgress;
    private final MAIN_FRM tela;
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    Date agora = new Date();
    private final int progress = 0;

    /** Creates new form pne_Status */
    public pne_Status(MAIN_FRM tela) {
        System.out.println(className + " -> Construtor");
        this.tela = tela;
        initComponents();
        inicializarComponentes();
       // progressBar();
        executeProgressBar(progress);
        Timer timer = new Timer(1000, new ClockListener());
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public static void executeProgressBar(int progress) {
        pbProgress.setValue(pbProgress.getValue() + progress);
//        if (pbProgress.getValue() == 100) {
//            pbProgress.setValue(0);
//        }
    }

    class ClockListener implements ActionListener {

        private final String className = "Classe ->" + this.getClass().getSimpleName();

        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            tfData.setText(String.format("%1$tH:%1$tM:%1$tS", now));
            tfHora.setText(dateFormat.format(agora));
        }
    }

   /* public void progressBar(){
   final SwingWorker worker = new SwingWorker<Void, Integer>() {  
            protected Void doInBackground() throws Exception {  
                for(int i=0; i <= 10000; i++){  
                    System.out.println("Numero: "+i);  
                    publish(i);  
                }  
                return null;  
            }  
  
            protected void process(List<Integer> progress){  
                pbProgress.setValue(progress.get(progress.size()-1));  
            }    
  
                      
        };  
  
        worker.execute();  
         
    }*/

    private void inicializarComponentes() {



        int width = dimension.width;
        int height = dimension.height;

        System.out.println("width" + width);
        System.out.println("height" + height);

        int tela = width / 10;
        int x = tela * 3;
        int y = tela * 3;
        int z = tela * 1;
        int w = tela * 2;
        int u = tela * 1;

        tfStatus = new JTextField();
        add(tfStatus);
        tfStatus.setBounds(0, 0, x, 30);
        tfStatus.setEditable(false);
        tfStatus.setText("Tela Principal");
        tfStatus.setBackground(Color.white);
        tfStatus.setForeground(Color.black);

        tfLog = new JTextField();
        add(tfLog);
        tfLog.setBounds(x, 0, y, 30);
        tfLog.setEditable(false);
        tfLog.setText("Log");
        tfLog.setBackground(Color.white);
        tfLog.setForeground(Color.black);

        pbProgress = new JProgressBar();
        add(pbProgress);
        pbProgress.setBounds(x + y, 0, u, 30);
        pbProgress.setStringPainted(true); 


        tfData = new JTextField();
        add(tfData);
        tfData.setBounds(x + y + u, 0, z, 30);
        tfData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfData.setEditable(false);
        tfData.setText("Data");
        tfData.setBackground(new java.awt.Color(255, 255, 153));
        tfData.setForeground(Color.black);

        tfHora = new JTextField();
        add(tfHora);
        tfHora.setBounds(x + y + z + u, 0, w, 30);
        tfHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfHora.setEditable(false);
        tfHora.setText("Hora");
        tfHora.setBackground(Color.white);
        tfHora.setForeground(Color.black);


    }
}
