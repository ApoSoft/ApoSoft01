/**
 * 
 */
package de.waksh.aposoft.controller;

import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import de.waksh.aposoft.view.admin.AdminButtonPanel;
import de.waksh.aposoft.view.admin.AdminPanel;

/**
 * Controller for the administration panel.
 * 
 * @author Christoph Mende
 * 
 */
@Component
public class AdminController {

    private AdminPanel panel;
    private AdminButtonPanel buttonPanel;

    public AdminController() {
        panel = new AdminPanel(this);
        buttonPanel = new AdminButtonPanel();
    }

    public JPanel getMainPanel() {
        return panel.getPanel();
    }

    public JPanel getButtonPanel() {
        return buttonPanel.getPanel();
    }

}
