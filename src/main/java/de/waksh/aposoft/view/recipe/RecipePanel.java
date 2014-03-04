package de.waksh.aposoft.view.recipe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import lombok.Getter;
import de.waksh.aposoft.controller.RecipeController;
import de.waksh.aposoft.domain.Recipe;

/**
 * RecipePanel for adding a {@link Recipe recipe}.
 * 
 * @author jkuptz
 * 
 */
public class RecipePanel {

    @SuppressWarnings("unused")
    private RecipeController controller;

    private Recipe recipe;

    @Getter
    private JPanel panel;
    private JTextField txtId;
    private JTextField txtMadeBy;
    private JTextField txtActiveIngredient;
    private JTextField txtAmount;
    private JComboBox<String> cmbUnity;
    private Vector<String> cmbUnityItems;
    private Vector<String> cmbTypeItems;
    @Getter
    private JTable table;
    @Getter
    private DefaultTableModel tableModel;
    private JComboBox<String> cmbType;

    /**
     * Constructor for {@link RecipePanel}. Sets the {@link RecipeController}
     * and the {@link Recipe}.
     * 
     * @param {@link RecipeController controller}
     * @param {@link Recipe recipe}
     */
    public RecipePanel(RecipeController controller, Recipe recipe) {
        this.controller = controller;
        this.recipe = recipe;

        initialize();
        build();
    }

    private void initialize() {
        cmbUnityItems = new Vector<String>();
        cmbUnityItems.add("g");
        cmbUnityItems.add("mg");
        cmbUnityItems.add("ml");
        cmbUnityItems.add("l");

        cmbTypeItems = new Vector<String>();
        cmbTypeItems.add("Salbe");
        cmbTypeItems.add("Tabletten");

        // columnTitles = new String[] { "Wirkstoff", "Menge" };
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Wirkstoff");
        tableModel.addColumn("Menge");
    }

    private void build() {
        panel = new JPanel();
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 108, 32, 48, 4, 49, 0, 0 };
        gbl_panel.rowHeights = new int[] { 19, 19, 24, 19, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblNewLabel = new JLabel("ID");
        GridBagConstraints gbcLblNewLabel = new GridBagConstraints();
        gbcLblNewLabel.anchor = GridBagConstraints.WEST;
        gbcLblNewLabel.insets = new Insets(5, 5, 5, 5);
        gbcLblNewLabel.gridx = 0;
        gbcLblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbcLblNewLabel);

        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setText(String.valueOf(recipe.getId()));
        GridBagConstraints gbcTxtId = new GridBagConstraints();
        gbcTxtId.insets = new Insets(5, 5, 5, 5);
        gbcTxtId.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtId.gridx = 1;
        gbcTxtId.gridy = 0;
        panel.add(txtId, gbcTxtId);
        txtId.setColumns(10);

        JLabel lblMadeBy = new JLabel("<html>hergestellt<br>von</html>");
        GridBagConstraints gbcLblMadeBy = new GridBagConstraints();
        gbcLblMadeBy.anchor = GridBagConstraints.WEST;
        gbcLblMadeBy.insets = new Insets(5, 5, 5, 5);
        gbcLblMadeBy.gridx = 0;
        gbcLblMadeBy.gridy = 1;
        panel.add(lblMadeBy, gbcLblMadeBy);

        txtMadeBy = new JTextField();
        txtMadeBy.setEditable(false);
        if (recipe.getUser() != null) {
            txtMadeBy.setText(String.valueOf(recipe.getUser().getId()));
        } else {
            txtMadeBy.setText("no user set");
        }
        GridBagConstraints gbcTxtMadeBy = new GridBagConstraints();
        gbcTxtMadeBy.insets = new Insets(5, 5, 5, 5);
        gbcTxtMadeBy.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtMadeBy.gridx = 1;
        gbcTxtMadeBy.gridy = 1;
        panel.add(txtMadeBy, gbcTxtMadeBy);
        txtMadeBy.setColumns(10);

        JLabel lblType = new JLabel("Art");
        GridBagConstraints gbcLblType = new GridBagConstraints();
        gbcLblType.anchor = GridBagConstraints.WEST;
        gbcLblType.insets = new Insets(0, 5, 5, 5);
        gbcLblType.gridx = 0;
        gbcLblType.gridy = 2;
        panel.add(lblType, gbcLblType);

        cmbType = new JComboBox<String>(cmbTypeItems);
        GridBagConstraints gbcCmbType = new GridBagConstraints();
        gbcCmbType.insets = new Insets(5, 5, 5, 5);
        gbcCmbType.fill = GridBagConstraints.HORIZONTAL;
        gbcCmbType.gridx = 1;
        gbcCmbType.gridy = 2;
        panel.add(cmbType, gbcCmbType);

        JLabel lblActiveIngredient = new JLabel("Wirkstoff");
        GridBagConstraints gbcLblActiveIngredient = new GridBagConstraints();
        gbcLblActiveIngredient.anchor = GridBagConstraints.WEST;
        gbcLblActiveIngredient.insets = new Insets(5, 5, 5, 5);
        gbcLblActiveIngredient.gridx = 0;
        gbcLblActiveIngredient.gridy = 3;
        panel.add(lblActiveIngredient, gbcLblActiveIngredient);

        txtActiveIngredient = new JTextField();
        GridBagConstraints gbcTxtActiveIngredient = new GridBagConstraints();
        gbcTxtActiveIngredient.insets = new Insets(5, 5, 5, 5);
        gbcTxtActiveIngredient.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtActiveIngredient.gridx = 1;
        gbcTxtActiveIngredient.gridy = 3;
        panel.add(txtActiveIngredient, gbcTxtActiveIngredient);
        txtActiveIngredient.setColumns(10);

        JLabel lblAmount = new JLabel("Menge");
        GridBagConstraints gbcLblAmount = new GridBagConstraints();
        gbcLblAmount.anchor = GridBagConstraints.EAST;
        gbcLblAmount.insets = new Insets(5, 5, 5, 5);
        gbcLblAmount.gridx = 2;
        gbcLblAmount.gridy = 3;
        panel.add(lblAmount, gbcLblAmount);

        txtAmount = new JTextField();
        GridBagConstraints gbcTxtAmount = new GridBagConstraints();
        gbcTxtAmount.insets = new Insets(5, 5, 5, 5);
        gbcTxtAmount.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtAmount.gridx = 3;
        gbcTxtAmount.gridy = 3;
        panel.add(txtAmount, gbcTxtAmount);
        txtAmount.setColumns(10);

        JLabel lblEinheit = new JLabel("Einheit");
        GridBagConstraints gbcLblEinheit = new GridBagConstraints();
        gbcLblEinheit.insets = new Insets(5, 5, 5, 5);
        gbcLblEinheit.anchor = GridBagConstraints.EAST;
        gbcLblEinheit.gridx = 4;
        gbcLblEinheit.gridy = 3;
        panel.add(lblEinheit, gbcLblEinheit);

        cmbUnity = new JComboBox<String>(cmbUnityItems);
        GridBagConstraints gbcCmbUnity = new GridBagConstraints();
        gbcCmbUnity.insets = new Insets(5, 5, 5, 5);
        gbcCmbUnity.fill = GridBagConstraints.HORIZONTAL;
        gbcCmbUnity.gridx = 5;
        gbcCmbUnity.gridy = 3;
        panel.add(cmbUnity, gbcCmbUnity);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbcScrollPane = new GridBagConstraints();
        gbcScrollPane.insets = new Insets(5, 5, 5, 5);
        gbcScrollPane.gridwidth = 6;
        gbcScrollPane.fill = GridBagConstraints.BOTH;
        gbcScrollPane.gridx = 0;
        gbcScrollPane.gridy = 4;
        panel.add(scrollPane, gbcScrollPane);

        // table = new JTable(new String[][] {}, columnTitles);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
    }

    /**
     * Returns the {@link String text} of txtActiveIngredient.
     * 
     * @return {@link String}
     */
    public String getActiveIngredient() {
        return txtActiveIngredient.getText();
    }

    /**
     * Returns the {@link String text} of txtAmount.
     * 
     * @return {@link String}
     */
    public String getAmount() {
        return txtAmount.getText();
    }

    /**
     * Returns the {@link String text} of the selected item in cmbUnity.
     * 
     * @return {@link String}
     */
    public String getUnity() {
        return cmbUnity.getSelectedItem().toString();
    }

    /**
     * Selects the Amount.
     */
    public void selectAmount() {
        txtAmount.requestFocus();
        txtAmount.selectAll();
    }

    /**
     * Resets the {@link JTextField textFields}.
     */
    public void resetTextFields() {
        txtActiveIngredient.setText("");
        txtAmount.setText("");
        cmbUnity.setSelectedIndex(0);
    }

    /**
     * Removes all rows.
     */
    public void removeAllRows() {
        if (tableModel.getRowCount() > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                tableModel.removeRow(i);
            }
        }
    }

    /**
     * Returns the {@link String productType}.
     * 
     * @return {@link String product Type}
     */
    public String getProductType() {
        return cmbType.getSelectedItem().toString();
    }
}
