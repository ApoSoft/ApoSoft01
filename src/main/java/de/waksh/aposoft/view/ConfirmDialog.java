package de.waksh.aposoft.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import lombok.Getter;

/**
 * Generic dialog to confirm using a password
 * 
 * @author Jannik Kuptz
 * 
 */
public class ConfirmDialog {

    private JDialog dialog;
    @Getter
    private JPasswordField passwordField;
    @Getter
    private JButton btnOk;

    /**
     * Construct and initialize the ConfirmDialog
     */
    public ConfirmDialog() {
        initialize();
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
        GridBagConstraints gbcLblPassword = new GridBagConstraints();
        gbcLblPassword.insets = new Insets(5, 5, 5, 5);
        gbcLblPassword.anchor = GridBagConstraints.EAST;
        gbcLblPassword.gridx = 0;
        gbcLblPassword.gridy = 0;
        dialog.getContentPane().add(lblPassword, gbcLblPassword);

        passwordField = new JPasswordField();
        GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.insets = new Insets(5, 5, 5, 5);
        gbcPasswordField.fill = GridBagConstraints.HORIZONTAL;
        gbcPasswordField.gridx = 1;
        gbcPasswordField.gridy = 0;
        dialog.getContentPane().add(passwordField, gbcPasswordField);

        btnOk = new JButton("OK");
        dialog.getRootPane().setDefaultButton(btnOk);
        GridBagConstraints gbcBtnOk = new GridBagConstraints();
        gbcBtnOk.insets = new Insets(5, 5, 5, 5);
        gbcBtnOk.gridx = 2;
        gbcBtnOk.gridy = 0;
        dialog.getContentPane().add(btnOk, gbcBtnOk);
    }

    /**
     * {@inheritDoc Window#dispose()}
     */
    public void dispose() {
        dialog.dispose();
    }

    /**
     * {@inheritDoc Dialog#setModal(boolean)}
     */
    public void setModal(boolean b) {
        dialog.setModal(b);
    }

    /**
     * {@inheritDoc Dialog#setVisible(boolean)}
     */
    public void setVisible(boolean b) {
        dialog.setVisible(true);
    }

}
