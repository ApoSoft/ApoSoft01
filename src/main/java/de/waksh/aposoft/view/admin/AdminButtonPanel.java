package de.waksh.aposoft.view.admin;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.waksh.aposoft.controller.AdminController;

public class AdminButtonPanel {

    private JPanel panel;

    public AdminButtonPanel(AdminController adminController) {
        initialize();
    }

    private void initialize() {
        panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        addButton("Rollen/Rechte");
        addButton("Protokoll");
        addButton("Filiale");
        addButton("Benutzerverwaltung");
        addButton("Mitarbeiterverwaltung");
        addButton("Produktgruppen");
        addButton("Kundengruppen");
    }

    public JPanel getPanel() {
        return panel;
    }

    private void addButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.add(button);
    }

}
