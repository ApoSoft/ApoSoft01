package de.waksh.aposoft.view.admin;

import javax.swing.JPanel;

import de.waksh.aposoft.controller.AdminController;

public class AdminPanel {

    private JPanel panel;

    public AdminPanel(AdminController adminController) {
        initialize();
    }

    private void initialize() {
        panel = new JPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

}
