package de.waksh.aposoft.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class ConfirmDialog {

    private JDialog dialog;
    private JPasswordField passwordField;
    private JButton btnOk;

    public ConfirmDialog() {
        initialize();
        dialog.setVisible(true);
    }

    private void initialize() {
        dialog = new JDialog();
        dialog.setTitle("Passwort bestätigen");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(100, 100, 274, 55);
        dialog.setLocationRelativeTo(null);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
        dialog.getContentPane().setLayout(gridBagLayout);

        JLabel lblPassword = new JLabel("Passwort:");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.insets = new Insets(5, 5, 5, 5);
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.gridx = 0;
        gbc_lblPassword.gridy = 0;
        dialog.getContentPane().add(lblPassword, gbc_lblPassword);

        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(5, 5, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 0;
        dialog.getContentPane().add(passwordField, gbc_passwordField);

        btnOk = new JButton("OK");
        dialog.getRootPane().setDefaultButton(btnOk);
        GridBagConstraints gbc_btnOk = new GridBagConstraints();
        gbc_btnOk.insets = new Insets(5, 5, 5, 5);
        gbc_btnOk.gridx = 2;
        gbc_btnOk.gridy = 0;
        dialog.getContentPane().add(btnOk, gbc_btnOk);
    }

    public JButton getBtnOK() {
        return btnOk;
    }

    public void dispose() {
        dialog.dispose();
    }
}
