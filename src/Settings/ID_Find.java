/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import javax.swing.JTable;

/**
 *
 * @author Andre
 */
public class ID_Find {
    
    int IdPk;

    public ID_Find() {
     
        
    }
    
    
        

    public int ID_PK(JTable table) {

        int row = table.getSelectedRow();
        if (row != -1) {
            Object id = table.getValueAt(row, 0);
            String temp = String.valueOf(id);
            IdPk = Integer.parseInt(temp);           
        }
        return IdPk;

    }
}
