package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.repository.ProductGroupRepository;
import de.waksh.aposoft.repository.ProductRepository;
import de.waksh.aposoft.repository.ProductTypeRepository;
import de.waksh.aposoft.repository.ProtocolRepository;
import de.waksh.aposoft.repository.UnitRepository;
import de.waksh.aposoft.repository.VendorRepository;
import de.waksh.aposoft.view.ConfirmDialog;
import de.waksh.aposoft.view.recipe.RecipeButtonPanel;
import de.waksh.aposoft.view.recipe.RecipePanel;

/**
 * Controller für die Oberfläche der Rezeptur
 * 
 * @author jkuptz
 * 
 */
@Component
public class RecipeController {

    @Autowired
    private MainController mainController;

    @Autowired
    ProtocolRepository protocolRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductGroupRepository productGroupRepo;

    @Autowired
    VendorRepository vendorRepo;

    @Autowired
    UnitRepository unitRepo;

    @Autowired
    ProductTypeRepository productTypeRepo;

    @Getter
    private RecipePanel recipePanel;
    @Getter
    private RecipeButtonPanel recipeButtonPanel;
    private Recipe recipe;
    private ConfirmDialog confirmDialog;
    List<ActiveIngredient> acList = new ArrayList<>();

    /**
     * Constructor for {@link RecipeController}. Initializes the components.
     */
    public RecipeController() {
        recipe = new Recipe();
        recipePanel = new RecipePanel(this, recipe);
        recipeButtonPanel = new RecipeButtonPanel();

        recipeButtonPanel.getBtnAdd().addActionListener(listenerAdd);
        recipeButtonPanel.getBtnDelete().addActionListener(listenerDelete);
        recipeButtonPanel.getBtnNext().addActionListener(listenerNext);
    }

    /**
     * Adds a row and resets textFields in the {@link RecipePanel recipePanel}.
     */
    public void addRow() {
        DefaultTableModel model = recipePanel.getTableModel();
        String activeIngredient = recipePanel.getActiveIngredient();
        String amount = recipePanel.getAmount();
        String unity = recipePanel.getUnity();

        if (recipePanel.getActiveIngredient().equals("")) {
            JOptionPane.showMessageDialog(mainController.getFrame(), "Bitte Wirkstoff angeben.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Double.parseDouble(amount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainController.getFrame(), "Bitte bei Menge eine Zahl eingeben.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            recipePanel.selectAmount();
            return;
        }

        model.addRow(new Object[] { activeIngredient, amount + " " + unity });
        recipePanel.resetTextFields();
    }

    /**
     * Removes a Row.
     */
    public void removeRow() {
        DefaultTableModel model = recipePanel.getTableModel();
        JTable table = recipePanel.getTable();
        if (model.getRowCount() == 0 || table.getSelectedRow() == -1) {
            return;
        }
        model.removeRow(table.getSelectedRow());
    }

    /**
     * Shows next {@link Recipe recipe}.
     */
    public void next() {
        if (recipePanel.getTableModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(mainController.getFrame(), "Bitte erst Wirkstoffe hinzufügen.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        recipePanel.resetTextFields();
        confirmDialog = new ConfirmDialog();
        confirmDialog.getBtnOk().addActionListener(listenerConfirm);
        confirmDialog.setModal(true);
        confirmDialog.getPasswordField().setText("topSecret");
        confirmDialog.setVisible(true);
    }

    private ActionListener listenerConfirm = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            confirmDialog.dispose();
            DefaultTableModel tm = recipePanel.getTableModel();
            for (int i = 0; i < tm.getRowCount(); i++) {
                ActiveIngredient ac = new ActiveIngredient();
                ac.setName(tm.getValueAt(i, 0).toString());
                acList.add(ac);
            }
            new ProductDialogController(mainController, productRepo, recipePanel, protocolRepo, productGroupRepo,
                    vendorRepo, unitRepo, productTypeRepo, acList);
            acList.clear();
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