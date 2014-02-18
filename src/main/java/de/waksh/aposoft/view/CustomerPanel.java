/**
 * 
 */
package de.waksh.aposoft.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import lombok.Data;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.controller.CustomerController;
import de.waksh.aposoft.domain.Customer;

/**
 * Panel for the informations about Customer at the bottom of the main panel.
 * 
 * @author lhuebsch
 * 
 */
@Data
public class CustomerPanel {

    private JPanel panel;
    private JLabel customerNoLabel;
    private JLabel customerNoData;
    private JLabel firstNameLabel;
    private JLabel firstNameData;
    private JLabel lastNameLabel;
    private JLabel lastNameData;
    private JLabel insuranceNoLabel;
    private JLabel insuranceNoData;
    private JLabel insuranceLabel;
    private JLabel insuranceData;
    private CustomerController controller;
    private CustomerAppointmentHistoryTableModel customerAppointmentHistoryTableModel;

    public CustomerPanel(CustomerController customerController, CustomerAppointmentHistoryTableModel tableModel1) {
        controller = customerController;
        customerAppointmentHistoryTableModel = tableModel1;
        init();
    }

    private void init() {
        panel = new JPanel();

        customerNoData = new JLabel();
        firstNameData = new JLabel();
        lastNameData = new JLabel();
        insuranceNoData = new JLabel();
        insuranceData = new JLabel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.putClientProperty("putClientProperty", Boolean.TRUE);

        tabbedPane.add("Data", buildDataPanel());
        tabbedPane.add("Historie", buildHistoryPanel());

        panel.add(tabbedPane);

    }

    private JPanel buildHistoryPanel() {
        JTable historyTable = new JTable(customerAppointmentHistoryTableModel);

        JPanel historyPanel = new JPanel();

        historyPanel.add(new JScrollPane(historyTable), BorderLayout.CENTER);
        return historyPanel;
    }

    private JPanel buildDataPanel() {
        customerNoLabel = new JLabel("Kundennummer: ");
        firstNameLabel = new JLabel("Vorname: ");
        lastNameLabel = new JLabel("Nachname: ");
        insuranceNoLabel = new JLabel("Krankenkasse-Nr: ");
        insuranceNoData = new JLabel("Krankenkasse: ");

        FormLayout layout = new FormLayout("7dlu, right:pref, 3dlu, left:pref", // columns
                "5dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, p"); // rows

        JPanel dataPanel = new JPanel(layout);

        CellConstraints cc = new CellConstraints();

        dataPanel.add(customerNoLabel, cc.xy(2, 2));
        dataPanel.add(customerNoData, cc.xy(4, 2));
        dataPanel.add(firstNameLabel, cc.xy(2, 4));
        dataPanel.add(firstNameData, cc.xy(4, 4));
        dataPanel.add(lastNameLabel, cc.xy(2, 6));
        dataPanel.add(lastNameData, cc.xy(4, 6));
        dataPanel.add(insuranceNoLabel, cc.xy(2, 8));
        dataPanel.add(insuranceNoData, cc.xy(4, 8));
        dataPanel.add(insuranceLabel, cc.xy(2, 10));
        dataPanel.add(insuranceData, cc.xy(4, 10));

        return dataPanel;
    }

    public void setCustomerData(Customer customer) {
        customerNoData.setText(customer.getId() + "");
        firstNameData.setText(customer.getFirstName());
        lastNameData.setText(customer.getName());
        insuranceNoData.setText(customer.getInsurance().getInsuranceIdNumber());
        insuranceData.setText(customer.getInsurance().getName());
    }

}
