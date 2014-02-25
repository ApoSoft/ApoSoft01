package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.repository.ProtocolRepository;
import de.waksh.aposoft.view.ConfirmDialog;
import de.waksh.aposoft.view.MainFrame;
import de.waksh.aposoft.view.recipe.RecipeButtonPanel;
import de.waksh.aposoft.view.recipe.RecipePanel;

/**
 * 
 * @author Jannik Kuptz
 * 
 */
@Component
public class RecipeController {

    @Autowired
    private MainFrame mainFrame;

    @Autowired
    ProtocolRepository repo;

    private RecipePanel panel;
    private RecipeButtonPanel btnPanel;
    private Recipe recipe;
    private ConfirmDialog confirmDialog;

    public RecipeController() {
        recipe = new Recipe();
        panel = new RecipePanel(this, recipe);
        btnPanel = new RecipeButtonPanel();

        btnPanel.getBtnAdd().addActionListener(listenerAdd);
        btnPanel.getBtnDelete().addActionListener(listenerDelete);
        btnPanel.getBtnNext().addActionListener(listenerNext);
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

        if (panel.getActiveIngredient().equals("")) {
            JOptionPane.showMessageDialog(mainFrame.getFrame(), "Bitte Wirkstoff angeben.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Double.parseDouble(amount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame.getFrame(), "Bitte bei Menge eine Fließkommazahl eingeben.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            panel.selectAmount();
            return;
        }

        model.addRow(new Object[] { activeIngredient, amount + " " + unity });
        panel.resetTextFields();
    }

    public void removeRow() {
        DefaultTableModel model = panel.getTableModel();
        JTable table = panel.getTable();
        model.removeRow(table.getSelectedRow());
    }

    public void next() {
        confirmDialog = new ConfirmDialog();
        confirmDialog.getBtnOK().addActionListener(enterPressed);
        panel.resetTextFields();
    }

    private ActionListener enterPressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // repo.save(new Protocol(new User(), "MA fügte Rezeptur mit ID: " +
            // recipe.getId() + " hinzu.", ""));
            confirmDialog.dispose();
        }
    };

    private ActionListener listenerAdd = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            addRow();
        }
    };

    private ActionListener listenerDelete = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            removeRow();
        }
    };

    private ActionListener listenerNext = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            next();
        }
    };
}