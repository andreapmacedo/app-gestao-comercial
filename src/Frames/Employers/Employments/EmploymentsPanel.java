package Frames.Employers.Employments;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPanel;

public class EmploymentsPanel extends JPanel {

    public EmploymentsPanel() throws SQLException, ParseException {

        configPanel();
        initComps();
    }

    private void initComps() throws SQLException, ParseException {

        EmploymentsPanelSearch panelSerch = new EmploymentsPanelSearch();
        EmploymentsTable panelTable = new EmploymentsTable();
        add(BorderLayout.NORTH, panelSerch);
        add(BorderLayout.CENTER, panelTable);
    }

    private void configPanel() {
        setLayout(new BorderLayout());
    }

}
