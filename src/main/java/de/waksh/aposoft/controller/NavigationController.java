package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.waksh.aposoft.view.NavigationPanel;

public class NavigationController {

    private MainController controller;

    private NavigationPanel panel;

    public NavigationController(MainController controller) {
        this.controller = controller;

        panel = new NavigationPanel(this);
        panel.setCashboxListener(listenerCashbox);
        panel.setMaterialAdminListener(listenerMaterialAdmin);
        panel.setAdminListener(listenerAdmin);
    }

    public NavigationPanel getNavigationPanel() {
        return panel;
    }

    private ActionListener listenerCashbox = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CashboxController cashboxController = new CashboxController();
            controller.getMainFrame().setCenter(cashboxController.getCashboxPanel().getPanel());
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
}
