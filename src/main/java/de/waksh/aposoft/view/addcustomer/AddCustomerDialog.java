/**
 * 
 */
package de.waksh.aposoft.view.addcustomer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Getter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author lhuebsc
 * 
 */
public class AddCustomerDialog {

    @Getter
    private JDialog addCustomerDialog;
    @Getter
    private JPanel addCustomerPanel;
    @Getter
    private JLabel lblFirstName;
    @Getter
    private JTextField tfFirstName;
    @Getter
    private JLabel lblLastName;
    @Getter
    private JTextField tfLastName;
    @Getter
    private JLabel lblInsuranceNo;
    @Getter
    private JTextField tfInsuranceNo;
    @Getter
    private JLabel lblInsuranceName;
    @Getter
    private JTextField tfInsuranceName;
    @Getter
    private JButton btnAddCustomer;
    @Getter
    private JButton btnCancel;

    public AddCustomerDialog() {
        build();

        addCustomerDialog = new JDialog();
        addCustomerDialog.setAlwaysOnTop(Boolean.TRUE);
        addCustomerDialog.getContentPane().add(addCustomerPanel);
        addCustomerDialog.setModal(Boolean.TRUE);
        addCustomerDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addCustomerDialog.pack();
        addCustomerDialog.setLocationRelativeTo(null);
        addCustomerDialog.setResizable(Boolean.FALSE);
    }

    private void build() {
        lblFirstName = new JLabel("Vorname: ");
        lblLastName = new JLabel("Nachname: ");
        lblInsuranceNo = new JLabel("Versicherungsnummer: ");
        lblInsuranceName = new JLabel("Versicherung: ");

        tfFirstName = new JTextField();
        tfLastName = new JTextField();
        tfInsuranceNo = new JTextField();
        tfInsuranceName = new JTextField();
        tfInsuranceName.setEnabled(Boolean.FALSE);

        btnAddCustomer = new JButton("Übernehmen");
        btnCancel = new JButton("Abbrechen");

        CellConstraints cc = new CellConstraints();
        FormLayout formLayout = new FormLayout("3dlu, p, 3dlu, 70dlu:grow, 3dlu, 70dlu:grow", // coloumns
                "3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p,3dlu"); // rows

        addCustomerPanel = new JPanel(formLayout);
        // Label
        addCustomerPanel.add(lblFirstName, cc.xy(2, 2));
        addCustomerPanel.add(lblLastName, cc.xy(2, 4));
        addCustomerPanel.add(lblInsuranceNo, cc.xy(2, 6));
        addCustomerPanel.add(lblInsuranceName, cc.xy(2, 8));
        // Textfield
        addCustomerPanel.add(tfFirstName, cc.xy(4, 2));
        addCustomerPanel.add(tfLastName, cc.xy(4, 4));
        addCustomerPanel.add(tfInsuranceNo, cc.xy(4, 6));
        addCustomerPanel.add(tfInsuranceName, cc.xy(4, 8));
        // Button
        addCustomerPanel.add(btnAddCustomer, cc.xy(6, 2));
        addCustomerPanel.add(btnCancel, cc.xy(6, 4));

    }
}
