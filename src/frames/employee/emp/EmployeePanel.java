package frames.employee.emp;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPanel;

public class EmployeePanel extends JPanel {

    public EmployeePanel() throws SQLException, ParseException {

        configPanel();
        initComps();
    }

    private void initComps() throws SQLException, ParseException {

        EmployeePanelSearch panelSerch = new EmployeePanelSearch();
        EmployeeTable panelTable = new EmployeeTable();
        add(BorderLayout.NORTH, panelSerch);
        add(BorderLayout.CENTER, panelTable);
    }

    private void configPanel() {
        setLayout(new BorderLayout());
    }

}
