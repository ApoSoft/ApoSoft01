package de.waksh.aposoft.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.controller.NavigationController;

public class NavigationPanel {
    @SuppressWarnings("unused")
    private NavigationController controller;

    private JPanel panel;
    private JButton btnCashbox;
    private JButton btnMaterialAdmin;
    private JButton btnAdmin;
    private JButton btnExtemporaneousProduct;

    public NavigationPanel(NavigationController controller) {
        this.controller = controller;
        build();
    }

    private void build() {
        btnCashbox = new JButton("Kasse");
        btnMaterialAdmin = new JButton("Materialwirtschaft");
        btnAdmin = new JButton("Administration");
        btnExtemporaneousProduct = new JButton("Rezeptur");

        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref", "pref, 3dlu, pref, 3dlu, pref, 3dlu, pref");
        panel = new JPanel(layout);

        panel.add(btnCashbox, cc.xy(1, 1));
        panel.add(btnMaterialAdmin, cc.xy(1, 3));
        panel.add(btnAdmin, cc.xy(1, 5));
        panel.add(btnExtemporaneousProduct, cc.xy(1, 7));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setCashboxListener(ActionListener listener) {
        btnCashbox.addActionListener(listener);
    }

    public void setMaterialAdminListener(ActionListener listener) {
        btnMaterialAdmin.addActionListener(listener);
    }

    public void setAdminListener(ActionListener listener) {
        btnAdmin.addActionListener(listener);
    }

    public void setExtemporaneousProductListener(ActionListener listener) {
        btnExtemporaneousProduct.addActionListener(listener);
    }
}
