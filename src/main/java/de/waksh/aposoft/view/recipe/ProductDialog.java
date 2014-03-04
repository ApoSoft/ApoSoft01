package de.waksh.aposoft.view.recipe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lombok.Getter;

public class ProductDialog {

    private JDialog dialog;
    @Getter
    private JTextField txtRecipeId;
    @Getter
    private JTextField txtProductGroup;
    @Getter
    private JTextField txtBranch;
    @Getter
    private JTextField txtAmount;
    private JLabel lblAmount;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblBestBefore;
    private JTextField txtBestBefore;
    @Getter
    private JButton btnSave;
    @Getter
    private JButton btnAbort;

    public ProductDialog() {
        initialize();
    }

    private void initialize() {
        dialog = new JDialog();
        dialog.setTitle("Produkt anlegen");
        dialog.setBounds(100, 100, 256, 236);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        dialog.getContentPane().setLayout(gridBagLayout);

        JLabel lblRecipeId = new JLabel("Rezeptur ID");
        GridBagConstraints gbc_lblRecipeId = new GridBagConstraints();
        gbc_lblRecipeId.insets = new Insets(5, 5, 5, 5);
        gbc_lblRecipeId.anchor = GridBagConstraints.WEST;
        gbc_lblRecipeId.gridx = 0;
        gbc_lblRecipeId.gridy = 0;
        dialog.getContentPane().add(lblRecipeId, gbc_lblRecipeId);

        txtRecipeId = new JTextField();
        txtRecipeId.setEditable(false);
        GridBagConstraints gbc_txtRecipeId = new GridBagConstraints();
        gbc_txtRecipeId.insets = new Insets(5, 5, 5, 5);
        gbc_txtRecipeId.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtRecipeId.gridx = 1;
        gbc_txtRecipeId.gridy = 0;
        dialog.getContentPane().add(txtRecipeId, gbc_txtRecipeId);
        txtRecipeId.setColumns(10);

        JLabel lblProductGroup = new JLabel("Produktgruppe");
        GridBagConstraints gbc_lblProductGroup = new GridBagConstraints();
        gbc_lblProductGroup.anchor = GridBagConstraints.WEST;
        gbc_lblProductGroup.insets = new Insets(5, 5, 5, 5);
        gbc_lblProductGroup.gridx = 0;
        gbc_lblProductGroup.gridy = 1;
        dialog.getContentPane().add(lblProductGroup, gbc_lblProductGroup);

        txtProductGroup = new JTextField();
        txtProductGroup.setText("Eigenherstellung");
        txtProductGroup.setEditable(false);
        GridBagConstraints gbc_txtProductGroup = new GridBagConstraints();
        gbc_txtProductGroup.insets = new Insets(5, 5, 5, 5);
        gbc_txtProductGroup.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtProductGroup.gridx = 1;
        gbc_txtProductGroup.gridy = 1;
        dialog.getContentPane().add(txtProductGroup, gbc_txtProductGroup);
        txtProductGroup.setColumns(10);

        JLabel lblBranch = new JLabel("Filiale");
        GridBagConstraints gbc_lblBranch = new GridBagConstraints();
        gbc_lblBranch.anchor = GridBagConstraints.WEST;
        gbc_lblBranch.insets = new Insets(5, 5, 5, 5);
        gbc_lblBranch.gridx = 0;
        gbc_lblBranch.gridy = 2;
        dialog.getContentPane().add(lblBranch, gbc_lblBranch);

        txtBranch = new JTextField();
        txtBranch.setEditable(false);
        GridBagConstraints gbc_txtBranch = new GridBagConstraints();
        gbc_txtBranch.insets = new Insets(5, 5, 5, 5);
        gbc_txtBranch.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBranch.gridx = 1;
        gbc_txtBranch.gridy = 2;
        dialog.getContentPane().add(txtBranch, gbc_txtBranch);
        txtBranch.setColumns(10);

        lblName = new JLabel("Produktname");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(5, 5, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 3;
        dialog.getContentPane().add(lblName, gbc_lblName);

        txtName = new JTextField("");
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.insets = new Insets(5, 5, 5, 5);
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.gridx = 1;
        gbc_txtName.gridy = 3;
        dialog.getContentPane().add(txtName, gbc_txtName);
        txtName.setColumns(10);

        lblAmount = new JLabel("Anzahl");
        GridBagConstraints gbc_lblAmount = new GridBagConstraints();
        gbc_lblAmount.insets = new Insets(5, 5, 5, 5);
        gbc_lblAmount.anchor = GridBagConstraints.WEST;
        gbc_lblAmount.gridx = 0;
        gbc_lblAmount.gridy = 4;
        dialog.getContentPane().add(lblAmount, gbc_lblAmount);

        txtAmount = new JTextField();
        txtAmount.setText("1");
        GridBagConstraints gbc_txtAmount = new GridBagConstraints();
        gbc_txtAmount.insets = new Insets(5, 5, 5, 5);
        gbc_txtAmount.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAmount.gridx = 1;
        gbc_txtAmount.gridy = 4;
        dialog.getContentPane().add(txtAmount, gbc_txtAmount);
        txtAmount.setColumns(10);

        lblBestBefore = new JLabel("MHD");
        GridBagConstraints gbc_lblBestBefore = new GridBagConstraints();
        gbc_lblBestBefore.anchor = GridBagConstraints.WEST;
        gbc_lblBestBefore.insets = new Insets(5, 5, 5, 5);
        gbc_lblBestBefore.gridx = 0;
        gbc_lblBestBefore.gridy = 5;
        dialog.getContentPane().add(lblBestBefore, gbc_lblBestBefore);

        txtBestBefore = new JTextField("");
        GridBagConstraints gbc_txtBestBefore = new GridBagConstraints();
        gbc_txtBestBefore.insets = new Insets(5, 5, 5, 5);
        gbc_txtBestBefore.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBestBefore.gridx = 1;
        gbc_txtBestBefore.gridy = 5;
        dialog.getContentPane().add(txtBestBefore, gbc_txtBestBefore);
        txtBestBefore.setColumns(10);

        btnAbort = new JButton("abbrechen");
        GridBagConstraints gbc_btnAbort = new GridBagConstraints();
        gbc_btnAbort.insets = new Insets(5, 5, 5, 5);
        gbc_btnAbort.gridx = 0;
        gbc_btnAbort.gridy = 6;
        dialog.getContentPane().add(btnAbort, gbc_btnAbort);

        btnSave = new JButton("speichern");
        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.insets = new Insets(5, 5, 5, 5);
        gbc_btnSave.gridx = 1;
        gbc_btnSave.gridy = 6;
        dialog.getContentPane().add(btnSave, gbc_btnSave);
    }

    /**
     * Returns {@link String text) of {@link JTextField txtName}.
     * 
     * @return {@link String txtName}
     */
    public String getProductName() {
        return txtName.getText();
    }

    /**
     * Returns {@link String text) of {@link JTextField txtBestBefore}.
     * 
     * @return {@link String txtBestBefore}
     */
    public String getBestBefore() {
        return txtBestBefore.getText();
    }

    /**
     * Returns {@link String text) of {@link JTextField txtAmount}.
     * 
     * @return {@link String txtAmount}
     */
    public String getAmount() {
        return txtAmount.getText();
    }

    /**
     * Disposes the {@link JDialog dialog}.
     */
    public void dispose() {
        dialog.dispose();
    }

    /**
     * Sets the dialog modal true or false.
     * 
     * @param {@link Boolean b}
     */
    public void setModal(boolean b) {
        dialog.setModal(b);
    }

    /**
     * Sets the dialog visible true or false
     * 
     * @param {@link Boolean b}
     */
    public void setVisible(boolean b) {
        dialog.setVisible(true);
    }
}
