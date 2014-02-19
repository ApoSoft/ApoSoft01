/**
 * 
 */
package de.waksh.aposoft.view.cashbox;

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
import de.waksh.aposoft.view.CustomerAppointmentHistoryTableModel;

/**
 * Panel for the informations about Customer at the bottom of the main panel.
 * 
 * @author lhuebsch
 * 
 */
@Data
public class CustomerPanel {

    private JPanel panel;
    private JLabel customerNumberData;
    private JLabel firstNameData;
    private JLabel lastNameData;
    private JLabel insuranceNumberData;
    private JLabel insuranceData;
    private CustomerController controller;
    private CustomerAppointmentHistoryTableModel customerAppointmentHistoryTableModel;

    public CustomerPanel(CustomerController customerController, CustomerAppointmentHistoryTableModel tableModel1) {
        controller = customerController;
        customerAppointmentHistoryTableModel = tableModel1;
        init();
    }

    private void init() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref:grow", "pref");

        panel = new JPanel(layout);

        customerNumberData = new JLabel();
        firstNameData = new JLabel();
        lastNameData = new JLabel();
        insuranceNumberData = new JLabel();
        insuranceData = new JLabel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.putClientProperty("putClientProperty", Boolean.TRUE);

        tabbedPane.add("Data", buildDataPanel());
        tabbedPane.add("Historie", buildHistoryPanel());

        panel.add(tabbedPane, cc.xy(1, 1));

    }

    private JPanel buildHistoryPanel() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref:grow", "fill:pref:grow");
        JPanel historyPanel = new JPanel(layout);

        JTable historyTable = new JTable(customerAppointmentHistoryTableModel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(historyTable);

        historyPanel.add(scrollPane, cc.xy(1, 1));

        return historyPanel;
    }

    private JPanel buildDataPanel() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("3dlu, right:pref, 3dlu, left:pref, 3dlu",
                "3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu");

        JPanel dataPanel = new JPanel(layout);

        dataPanel.add(new JLabel("Kundennummer: "), cc.xy(2, 2));
        dataPanel.add(customerNumberData, cc.xy(4, 2));
        dataPanel.add(new JLabel("Vorname: "), cc.xy(2, 4));
        dataPanel.add(firstNameData, cc.xy(4, 4));
        dataPanel.add(new JLabel("Nachname: "), cc.xy(2, 6));
        dataPanel.add(lastNameData, cc.xy(4, 6));
        dataPanel.add(new JLabel("Krankenkasse-Nr: "), cc.xy(2, 8));
        dataPanel.add(insuranceNumberData, cc.xy(4, 8));
        // dataPanel.add(insuranceNoData, cc.xy(4, 8));
        // dataPanel.add(insuranceLabel, cc.xy(2, 10));
        // dataPanel.add(insuranceData, cc.xy(4, 10));

        return dataPanel;
    }

    public void setCustomerData(Customer customer) {
        customerNumberData.setText(customer.getId() + "");
        firstNameData.setText(customer.getFirstName());
        lastNameData.setText(customer.getName());
        insuranceNumberData.setText(customer.getInsurance().getInsuranceIdNumber());
        insuranceData.setText(customer.getInsurance().getName());
    }

}
