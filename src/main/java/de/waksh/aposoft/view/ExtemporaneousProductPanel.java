package de.waksh.aposoft.view;

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

import de.waksh.aposoft.controller.ExtemporaneousProductController;
import de.waksh.aposoft.domain.ExtemporaneousProduct;

public class ExtemporaneousProductPanel {

    @SuppressWarnings("unused")
    private ExtemporaneousProductController controller;

    private ExtemporaneousProduct extProd;

    private JPanel panel;
    private JTextField txtId;
    private JTextField txtMadeBy;
    private JTextField txtActiveIngredient;
    private JTextField txtAmount;
    private JComboBox<String> cmbUnity;
    private Vector<String> cmbUnityItems;
    private Vector<String> cmbTypeItems;
    private JTable table;
    private DefaultTableModel model;

    public ExtemporaneousProductPanel(ExtemporaneousProductController controller, ExtemporaneousProduct extProd) {
        this.controller = controller;
        this.extProd = extProd;

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
        model = new DefaultTableModel();
        model.addColumn("Wirkstoff");
        model.addColumn("Menge");
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
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setText(String.valueOf(extProd.getId()));
        GridBagConstraints gbc_txtId = new GridBagConstraints();
        gbc_txtId.insets = new Insets(5, 5, 5, 5);
        gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtId.gridx = 1;
        gbc_txtId.gridy = 0;
        panel.add(txtId, gbc_txtId);
        txtId.setColumns(10);

        JLabel lblMadeBy = new JLabel("<html>hergestellt<br>von</html>");
        GridBagConstraints gbc_lblMadeBy = new GridBagConstraints();
        gbc_lblMadeBy.anchor = GridBagConstraints.WEST;
        gbc_lblMadeBy.insets = new Insets(5, 5, 5, 5);
        gbc_lblMadeBy.gridx = 0;
        gbc_lblMadeBy.gridy = 1;
        panel.add(lblMadeBy, gbc_lblMadeBy);

        txtMadeBy = new JTextField();
        txtMadeBy.setEditable(false);
        if (extProd.getUser() != null) {
            txtMadeBy.setText(String.valueOf(extProd.getUser().getId()));
        } else {
            txtMadeBy.setText("no user set");
        }
        GridBagConstraints gbc_txtMadeBy = new GridBagConstraints();
        gbc_txtMadeBy.insets = new Insets(5, 5, 5, 5);
        gbc_txtMadeBy.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMadeBy.gridx = 1;
        gbc_txtMadeBy.gridy = 1;
        panel.add(txtMadeBy, gbc_txtMadeBy);
        txtMadeBy.setColumns(10);

        JLabel lblType = new JLabel("Art");
        GridBagConstraints gbc_lblType = new GridBagConstraints();
        gbc_lblType.anchor = GridBagConstraints.WEST;
        gbc_lblType.insets = new Insets(0, 5, 5, 5);
        gbc_lblType.gridx = 0;
        gbc_lblType.gridy = 2;
        panel.add(lblType, gbc_lblType);

        JComboBox<String> cmbType = new JComboBox<String>(cmbTypeItems);
        GridBagConstraints gbc_cmbType = new GridBagConstraints();
        gbc_cmbType.insets = new Insets(5, 5, 5, 5);
        gbc_cmbType.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbType.gridx = 1;
        gbc_cmbType.gridy = 2;
        panel.add(cmbType, gbc_cmbType);

        JLabel lblActiveIngredient = new JLabel("Wirkstoff");
        GridBagConstraints gbc_lblActiveIngredient = new GridBagConstraints();
        gbc_lblActiveIngredient.anchor = GridBagConstraints.WEST;
        gbc_lblActiveIngredient.insets = new Insets(5, 5, 5, 5);
        gbc_lblActiveIngredient.gridx = 0;
        gbc_lblActiveIngredient.gridy = 3;
        panel.add(lblActiveIngredient, gbc_lblActiveIngredient);

        txtActiveIngredient = new JTextField();
        GridBagConstraints gbc_txtActiveIngredient = new GridBagConstraints();
        gbc_txtActiveIngredient.insets = new Insets(5, 5, 5, 5);
        gbc_txtActiveIngredient.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtActiveIngredient.gridx = 1;
        gbc_txtActiveIngredient.gridy = 3;
        panel.add(txtActiveIngredient, gbc_txtActiveIngredient);
        txtActiveIngredient.setColumns(10);

        JLabel lblAmount = new JLabel("Menge");
        GridBagConstraints gbc_lblAmount = new GridBagConstraints();
        gbc_lblAmount.anchor = GridBagConstraints.EAST;
        gbc_lblAmount.insets = new Insets(5, 5, 5, 5);
        gbc_lblAmount.gridx = 2;
        gbc_lblAmount.gridy = 3;
        panel.add(lblAmount, gbc_lblAmount);

        txtAmount = new JTextField();
        GridBagConstraints gbc_txtAmount = new GridBagConstraints();
        gbc_txtAmount.insets = new Insets(5, 5, 5, 5);
        gbc_txtAmount.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAmount.gridx = 3;
        gbc_txtAmount.gridy = 3;
        panel.add(txtAmount, gbc_txtAmount);
        txtAmount.setColumns(10);

        JLabel lblEinheit = new JLabel("Einheit");
        GridBagConstraints gbc_lblEinheit = new GridBagConstraints();
        gbc_lblEinheit.insets = new Insets(5, 5, 5, 5);
        gbc_lblEinheit.anchor = GridBagConstraints.EAST;
        gbc_lblEinheit.gridx = 4;
        gbc_lblEinheit.gridy = 3;
        panel.add(lblEinheit, gbc_lblEinheit);

        cmbUnity = new JComboBox<String>(cmbUnityItems);
        GridBagConstraints gbc_cmbUnity = new GridBagConstraints();
        gbc_cmbUnity.insets = new Insets(5, 5, 5, 5);
        gbc_cmbUnity.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbUnity.gridx = 5;
        gbc_cmbUnity.gridy = 3;
        panel.add(cmbUnity, gbc_cmbUnity);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
        gbc_scrollPane.gridwidth = 6;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 4;
        panel.add(scrollPane, gbc_scrollPane);

        // table = new JTable(new String[][] {}, columnTitles);
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getActiveIngredient() {
        return txtActiveIngredient.getText();
    }

    public DefaultTableModel getTableModel() {
        return model;
    }

    public JTable getTable() {
        return table;
    }

    public String getAmount() {
        return txtAmount.getText();
    }

    public String getUnity() {
        return cmbUnity.getSelectedItem().toString();
    }

    public void selectAmount() {
        txtAmount.requestFocus();
        txtAmount.selectAll();
    }

    public void resetTextFields() {
        txtActiveIngredient.setText("");
        txtAmount.setText("");
        cmbUnity.setSelectedIndex(0);
    }
}
