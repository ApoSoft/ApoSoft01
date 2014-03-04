package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.joda.time.LocalDate;

import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.ProductGroup;
import de.waksh.aposoft.domain.ProductType;
import de.waksh.aposoft.domain.Protocol;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.domain.Unit;
import de.waksh.aposoft.domain.User;
import de.waksh.aposoft.domain.Vendor;
import de.waksh.aposoft.repository.ProductGroupRepository;
import de.waksh.aposoft.repository.ProductRepository;
import de.waksh.aposoft.repository.ProductTypeRepository;
import de.waksh.aposoft.repository.ProtocolRepository;
import de.waksh.aposoft.repository.UnitRepository;
import de.waksh.aposoft.repository.VendorRepository;
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
    private ProductRepository productRepo;
    private ProtocolRepository protocolRepo;
    private LocalDate bestBeforeDate;
    private ConfirmDialog confirmDialog;
    private RecipePanel recipePanel;
    private ProductGroupRepository productGroupRepo;
    private ProductGroup productGroup;
    private VendorRepository vendorRepo;
    private UnitRepository unitRepository;
    private ProductTypeRepository productTypeRepo;
    List<ActiveIngredient> acList = new ArrayList<>();

    public ProductDialogController(MainController mainController, ProductRepository productRepo,
            RecipePanel recipePanel, ProtocolRepository protocolRepo, ProductGroupRepository productGroupRepo,
            VendorRepository vendorRepo, UnitRepository unitRepo, ProductTypeRepository productTypeRepo,
            List<ActiveIngredient> acList) {
        this.mainFrame = mainController;
        this.productRepo = productRepo;
        this.protocolRepo = protocolRepo;
        this.productGroupRepo = productGroupRepo;
        this.recipePanel = recipePanel;
        this.vendorRepo = vendorRepo;
        this.unitRepository = unitRepo;
        this.productTypeRepo = productTypeRepo;
        this.acList = acList;
        recipe = new Recipe();
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
            confirmDialog.getPasswordField().setText("topSecret");
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
            recipe.setActiveIngredients(acList);
            product.setRecipe(recipe);
            // toDo: Amount in Produkt speichern --> Feld in Produkt anlegen?
            product.setName(productDialog.getProductName());
            product.setBestBeforeDate(bestBeforeDate);
            Vendor vendor = new Vendor();
            vendor.setName("Eigenherstellung");
            vendor.setVendorCode("1");
            vendor = vendorRepo.save(vendor);
            product.setVendor(vendor);
            Unit unit = new Unit();
            unit.setName("Unit");
            unitRepository.save(unit);
            product.setUnit(unit);
            ProductType productType = new ProductType();
            productType.setName(recipePanel.getProductType());
            productTypeRepo.save(productType);
            product.setProductType(productType);
            product.setDosage(new Random().nextFloat());

            protocolRepo.save(new Protocol(new User(), "MA fügte Rezeptur mit ID: " + recipe.getId() + " hinzu.", ""));
            productGroupRepo.save(productGroup);
            productRepo.save(product);
            // führt zu: detached entity passed to persist

            recipePanel.removeAllRows();
            confirmDialog.dispose();
            productDialog.dispose();
            JOptionPane.showMessageDialog(mainFrame.getFrame(), "Ihr Produkt wurde angelegt.");
        }
    };

    private void createProduct() {
        product = new Product();
        productGroup = new ProductGroup("Eigenherstellung", "");
        product.setProductGroup(productGroup);
    }

    private void initialize() {
        productDialog.getTxtRecipeId().setText(String.valueOf(recipe.getId()));
        productDialog.getTxtBranch().setText("no branch set");
    }
}
