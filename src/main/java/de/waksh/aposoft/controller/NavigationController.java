package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.controller.cashbox.CashboxController;
import de.waksh.aposoft.view.MainFrame;
import de.waksh.aposoft.view.NavigationPanel;

@Component
public class NavigationController {

    @Autowired
    private MainFrame mainFrame;

    private NavigationPanel panel;

    public NavigationController() {
        panel = new NavigationPanel(this);
        panel.setCashboxListener(listenerCashbox);
        panel.setMaterialAdminListener(listenerMaterialAdmin);
        panel.setAdminListener(listenerAdmin);
        panel.setExtemporaneousProductListener(listenerExtemporaneousProduct);
    }

    public NavigationPanel getNavigationPanel() {
        return panel;
    }

    private ActionListener listenerCashbox = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CashboxController cashboxController = new CashboxController();
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

        }
    };

    private ActionListener listenerExtemporaneousProduct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExtemporaneousProductController epController = new ExtemporaneousProductController();
            mainFrame.setCenter(epController.getExtemporaneousProductPanel().getPanel());
            mainFrame.setRight(epController.getExtemporaneousProductButtonPanel().getPanel());
        }
    };
}
