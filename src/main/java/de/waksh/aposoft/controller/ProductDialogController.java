package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.joda.time.LocalDate;

import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.ProductGroup;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.repository.ProductRepository;
import de.waksh.aposoft.view.ConfirmDialog;
import de.waksh.aposoft.view.recipe.ProductDialog;
import de.waksh.aposoft.view.recipe.RecipePanel;

/**
 * 
 * @author Jannik Kuptz
 * 
 */
public class ProductDialogController {
    private MainController mainFrame;

    private ProductDialog productDialog;
    private Recipe recipe;
    private Product product;
    @SuppressWarnings("unused")
    private ProductRepository productRepo;
    private LocalDate bestBeforeDate;
    private ConfirmDialog confirmDialog;
    private RecipePanel recipePanel;

    public ProductDialogController(Recipe recipe, MainController mainController, ProductRepository productRepo,
            RecipePanel recipePanel) {
        this.recipe = recipe;
        this.mainFrame = mainController;
        this.productRepo = productRepo;
        this.recipePanel = recipePanel;
        productDialog = new ProductDialog();
        productDialog.getBtnAbort().addActionListener(listenerAbort);
        productDialog.getBtnSave().addActionListener(listenerSave);
        productDialog.setModal(true);

        createProduct();

        initialize();
        productDialog.setVisible(true);
    }

    private ActionListener listenerSave = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (productDialog.getProductName().equals("") || productDialog.getBestBefore().equals("")
                    || productDialog.getAmount().equals("")) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(), "Bitte alle Felder ausfüllen.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Integer.parseInt(productDialog.getAmount());
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(), "Bitte bei Menge eine Zahl eingeben.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                bestBeforeDate = LocalDate.parse(productDialog.getBestBefore());
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(mainFrame.getFrame(), "Bitte gültiges Datum angeben. (yyyy-mm-dd)",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            confirmDialog = new ConfirmDialog();
            confirmDialog.getBtnOK().addActionListener(listenerConfirm);
            confirmDialog.setModal(true);
            confirmDialog.setVisible(true);
        }
    };

    private ActionListener listenerAbort = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            recipePanel.removeAllRows();
            productDialog.dispose();
        }
    };

    private ActionListener listenerConfirm = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // toDo: Produkt zum Lager hinzufügen --> zu Store?
            product.setRecipe(recipe);
            // toDo: Amount in Produkt speichern --> Feld in Produkt anlegen?
            product.setName(productDialog.getProductName());
            product.setBestBeforeDate(bestBeforeDate);

            // productRepo.save(product);
            // führt zu: user lacks privilege or object not found: PRODUCTGROUP

            recipePanel.removeAllRows();
            confirmDialog.dispose();
            productDialog.dispose();
            JOptionPane.showMessageDialog(mainFrame.getFrame(),
                    "Ihr Produkt wurde angelegt.\n(Wird noch nicht in die Datenbank gespeichert)");
        }
    };

    private void createProduct() {
        product = new Product();
        ProductGroup productGroup = new ProductGroup("Eigenherstellung", "");
        product.setProductGroup(productGroup);
    }

    private void initialize() {
        productDialog.getTxtRecipeId().setText(String.valueOf(recipe.getId()));
        productDialog.getTxtBranch().setText("no branch set");
    }
}
