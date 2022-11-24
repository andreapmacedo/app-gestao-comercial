package ex.XComponents;
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package Models.XComponents;
//
//import Models.JDoubleField.JDoubleField2;
//import br.com.gqferreira.JNumberField.JNumberField;
//import br.com.gqferreira.JXTextField.JXTextField;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
///**
// * 
// */
//public class TestaComponentes extends JFrame {
//
////    public static void main(String[] args) {
////        new TestaComponentes().setVisible(true);
////    }
//
//    public TestaComponentes() {
//        {
//            //Set Look & Feel
//            try {
//                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        this.setTitle("Componentes de texto customizados");
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setSize(350, 300);
//        this.setLocationRelativeTo(null);
//
//        this.setLayout(null);
//
//        JLabel lbPontoFlutuante = new JLabel("Valor real (double)");
//        lbPontoFlutuante.setBounds(20, 20, 180, 15);
//        this.add(lbPontoFlutuante);
//
//        JDoubleField2 dfPontoFlutuante = new JDoubleField2(100d, 8);
//        dfPontoFlutuante.setBounds(20, 40, 120, 25);
//        this.add(dfPontoFlutuante);
//
//        //---
//
//        JLabel lbNumber = new JLabel("Valor integer/long");
//        lbNumber.setBounds(20, 80, 180, 15);
//        this.add(lbNumber);
//
//        JNumberField nfNumerico = new JNumberField(50, 5);
//        nfNumerico.setBounds(20, 105, 120, 25);
//        this.add(nfNumerico);
//
//        //--
//
//        JLabel lbText = new JLabel("Campo de texto (sem acentos)");
//        lbText.setBounds(20, 140, 300, 15);
//        this.add(lbText);
//
//        final JXTextField tfTexto = new JXTextField("maiúsculo", 20, true, false);
//        tfTexto.setBounds(20, 170, 120, 25);
//        this.add(tfTexto);
//
//        JButton btRecuperarTextoSemAcento = new JButton("Recuperar texto sem acentos");
//        btRecuperarTextoSemAcento.setBounds(20, 205, 300, 25);
//        this.add(btRecuperarTextoSemAcento);
//        btRecuperarTextoSemAcento.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, tfTexto.getText());
//            }
//        });
//    }
//}
