package de.waksh.aposoft.controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import de.waksh.aposoft.domain.ExtemporaneousProduct;
import de.waksh.aposoft.view.ExtemporaneousProductButtonPanel;
import de.waksh.aposoft.view.ExtemporaneousProductPanel;
import de.waksh.aposoft.view.MainFrame;

public class ExtemporaneousProductController {

    @Autowired
    private MainFrame mainFrame;

    private ExtemporaneousProductPanel panel;
    private ExtemporaneousProductButtonPanel btnPanel;

    public ExtemporaneousProductController() {
        panel = new ExtemporaneousProductPanel(this, new ExtemporaneousProduct());
        btnPanel = new ExtemporaneousProductButtonPanel(this);
    }

    public ExtemporaneousProductPanel getExtemporaneousProductPanel() {
        return panel;
    }

    public ExtemporaneousProductButtonPanel getExtemporaneousProductButtonPanel() {
        return btnPanel;
    }

    public void addRow() {
        DefaultTableModel model = panel.getTableModel();
        String activeIngredient = panel.getActiveIngredient();
        String amount = panel.getAmount();
        String unity = panel.getUnity();

        try {
            Double.parseDouble(amount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame.getFrame(), "Bitte bei Menge eine Fließkommazahl eingeben.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            panel.selectAmount();
            return;
        }

        model.addRow(new Object[] { activeIngredient, amount + " " + unity });
    }

    public void removeRow() {
        DefaultTableModel model = panel.getTableModel();
        JTable table = panel.getTable();
        model.removeRow(table.getSelectedRow());
    }

    public void next() {
        JOptionPane.showMessageDialog(mainFrame.getFrame(),
                "Wird implementiert, sobald die Mitarbeiterverwaltung fertig ist.");
        panel.resetTextFields();
    }
}
