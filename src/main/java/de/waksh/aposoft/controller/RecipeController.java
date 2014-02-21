package de.waksh.aposoft.controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.view.RecipeButtonPanel;
import de.waksh.aposoft.view.RecipePanel;
import de.waksh.aposoft.view.MainFrame;

@Component
public class RecipeController {

    @Autowired
    private MainFrame mainFrame;

    private RecipePanel panel;
    private RecipeButtonPanel btnPanel;

    public RecipeController() {
        panel = new RecipePanel(this, new Recipe());
        btnPanel = new RecipeButtonPanel(this);
    }

    public RecipePanel getRecipePanel() {
        return panel;
    }

    public RecipeButtonPanel getRecipeButtonPanel() {
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
