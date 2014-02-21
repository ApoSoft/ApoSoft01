package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.controller.cashbox.CashboxController;
import de.waksh.aposoft.view.MainFrame;
import de.waksh.aposoft.view.NavigationPanel;

/**
 * 
 * @author ahofmann
 * 
 */

@Component
public class NavigationController {

    @Autowired
    private MainFrame mainFrame;

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
            mainFrame.setCenter(cashboxController.getCashboxPanel().getPanel());
            mainFrame.setRight(cashboxController.getCashboxButtonPanel().getPanel());
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
            mainFrame.setCenter(adminController.getMainPanel());
            mainFrame.setRight(adminController.getButtonPanel());
        }
    };

    private ActionListener listenerRecipe = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setCenter(recipeController.getRecipePanel().getPanel());
            mainFrame.setRight(recipeController.getRecipeButtonPanel().getPanel());
        }
    };
}
