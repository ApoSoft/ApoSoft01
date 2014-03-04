package de.waksh.aposoft.view.recipe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lombok.Getter;
import de.waksh.aposoft.domain.Product;

/**
 * ProductDialog for adding a {@link Product product}.
 * 
 * @author jkuptz
 * 
 */
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

    /**
     * Constructor for {@link ProductDialog}. Runs initialize().
     */
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
        GridBagConstraints gbcLblRecipeId = new GridBagConstraints();
        gbcLblRecipeId.insets = new Insets(5, 5, 5, 5);
        gbcLblRecipeId.anchor = GridBagConstraints.WEST;
        gbcLblRecipeId.gridx = 0;
        gbcLblRecipeId.gridy = 0;
        dialog.getContentPane().add(lblRecipeId, gbcLblRecipeId);

        txtRecipeId = new JTextField();
        txtRecipeId.setEditable(false);
        GridBagConstraints gbcTxtRecipeId = new GridBagConstraints();
        gbcTxtRecipeId.insets = new Insets(5, 5, 5, 5);
        gbcTxtRecipeId.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtRecipeId.gridx = 1;
        gbcTxtRecipeId.gridy = 0;
        dialog.getContentPane().add(txtRecipeId, gbcTxtRecipeId);
        txtRecipeId.setColumns(10);

        JLabel lblProductGroup = new JLabel("Produktgruppe");
        GridBagConstraints gbcLblProductGroup = new GridBagConstraints();
        gbcLblProductGroup.anchor = GridBagConstraints.WEST;
        gbcLblProductGroup.insets = new Insets(5, 5, 5, 5);
        gbcLblProductGroup.gridx = 0;
        gbcLblProductGroup.gridy = 1;
        dialog.getContentPane().add(lblProductGroup, gbcLblProductGroup);

        txtProductGroup = new JTextField();
        txtProductGroup.setText("Eigenherstellung");
        txtProductGroup.setEditable(false);
        GridBagConstraints gbcTxtProductGroup = new GridBagConstraints();
        gbcTxtProductGroup.insets = new Insets(5, 5, 5, 5);
        gbcTxtProductGroup.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtProductGroup.gridx = 1;
        gbcTxtProductGroup.gridy = 1;
        dialog.getContentPane().add(txtProductGroup, gbcTxtProductGroup);
        txtProductGroup.setColumns(10);

        JLabel lblBranch = new JLabel("Filiale");
        GridBagConstraints gbcLblBranch = new GridBagConstraints();
        gbcLblBranch.anchor = GridBagConstraints.WEST;
        gbcLblBranch.insets = new Insets(5, 5, 5, 5);
        gbcLblBranch.gridx = 0;
        gbcLblBranch.gridy = 2;
        dialog.getContentPane().add(lblBranch, gbcLblBranch);

        txtBranch = new JTextField();
        txtBranch.setEditable(false);
        GridBagConstraints gbcTxtBranch = new GridBagConstraints();
        gbcTxtBranch.insets = new Insets(5, 5, 5, 5);
        gbcTxtBranch.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtBranch.gridx = 1;
        gbcTxtBranch.gridy = 2;
        dialog.getContentPane().add(txtBranch, gbcTxtBranch);
        txtBranch.setColumns(10);

        lblName = new JLabel("Produktname");
        GridBagConstraints gbcLblName = new GridBagConstraints();
        gbcLblName.anchor = GridBagConstraints.WEST;
        gbcLblName.insets = new Insets(5, 5, 5, 5);
        gbcLblName.gridx = 0;
        gbcLblName.gridy = 3;
        dialog.getContentPane().add(lblName, gbcLblName);

        txtName = new JTextField("");
        GridBagConstraints gbcTxtName = new GridBagConstraints();
        gbcTxtName.insets = new Insets(5, 5, 5, 5);
        gbcTxtName.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtName.gridx = 1;
        gbcTxtName.gridy = 3;
        dialog.getContentPane().add(txtName, gbcTxtName);
        txtName.setColumns(10);

        lblAmount = new JLabel("Anzahl");
        GridBagConstraints gbcLblAmount = new GridBagConstraints();
        gbcLblAmount.insets = new Insets(5, 5, 5, 5);
        gbcLblAmount.anchor = GridBagConstraints.WEST;
        gbcLblAmount.gridx = 0;
        gbcLblAmount.gridy = 4;
        dialog.getContentPane().add(lblAmount, gbcLblAmount);

        txtAmount = new JTextField();
        txtAmount.setText("1");
        GridBagConstraints gbcTxtAmount = new GridBagConstraints();
        gbcTxtAmount.insets = new Insets(5, 5, 5, 5);
        gbcTxtAmount.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtAmount.gridx = 1;
        gbcTxtAmount.gridy = 4;
        dialog.getContentPane().add(txtAmount, gbcTxtAmount);
        txtAmount.setColumns(10);

        lblBestBefore = new JLabel("MHD");
        GridBagConstraints gbcLblBestBefore = new GridBagConstraints();
        gbcLblBestBefore.anchor = GridBagConstraints.WEST;
        gbcLblBestBefore.insets = new Insets(5, 5, 5, 5);
        gbcLblBestBefore.gridx = 0;
        gbcLblBestBefore.gridy = 5;
        dialog.getContentPane().add(lblBestBefore, gbcLblBestBefore);

        txtBestBefore = new JTextField("");
        GridBagConstraints gbcTxtBestBefore = new GridBagConstraints();
        gbcTxtBestBefore.insets = new Insets(5, 5, 5, 5);
        gbcTxtBestBefore.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtBestBefore.gridx = 1;
        gbcTxtBestBefore.gridy = 5;
        dialog.getContentPane().add(txtBestBefore, gbcTxtBestBefore);
        txtBestBefore.setColumns(10);

        btnAbort = new JButton("abbrechen");
        GridBagConstraints gbcBtnAbort = new GridBagConstraints();
        gbcBtnAbort.insets = new Insets(5, 5, 5, 5);
        gbcBtnAbort.gridx = 0;
        gbcBtnAbort.gridy = 6;
        dialog.getContentPane().add(btnAbort, gbcBtnAbort);

        btnSave = new JButton("speichern");
        GridBagConstraints gbcBtnSave = new GridBagConstraints();
        gbcBtnSave.insets = new Insets(5, 5, 5, 5);
        gbcBtnSave.gridx = 1;
        gbcBtnSave.gridy = 6;
        dialog.getContentPane().add(btnSave, gbcBtnSave);
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
