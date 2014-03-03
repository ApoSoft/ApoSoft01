package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.controller.cashbox.CashboxController;
import de.waksh.aposoft.view.NavigationPanel;

/**
 * 
 * @author ahofmann
 * 
 */

@Component
public class NavigationController {

    @Autowired
    private MainController mainController;

    @Autowired
    private CashboxController cashboxController;

    @Autowired
    private AdminController adminController;

    @Autowired
    private RecipeController recipeController;

    private NavigationPanel panel;

    public NavigationController() {
        panel = new NavigationPanel();
        panel.getBtnCashbox().addActionListener(listenerCashbox);
        panel.getBtnMaterialAdmin().addActionListener(listenerMaterialAdmin);
        panel.getBtnAdmin().addActionListener(listenerAdmin);
        panel.getBtnRecipe().addActionListener(listenerRecipe);
    }

    public NavigationPanel getNavigationPanel() {
        return panel;
    }

    private ActionListener listenerCashbox = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainController.setCenter(cashboxController.getCashboxPanel().getPanel());
            mainController.setRight(cashboxController.getCashboxButtonPanel().getPanel());
        }
    };

    private ActionListener listenerMaterialAdmin = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    private ActionListener listenerAdmin = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainController.setCenter(adminController.getMainPanel());
            mainController.setRight(adminController.getButtonPanel());
        }
    };

    private ActionListener listenerRecipe = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainController.setCenter(recipeController.getRecipePanel().getPanel());
            mainController.setRight(recipeController.getRecipeButtonPanel().getPanel());
        }
    };
}
