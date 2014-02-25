package de.waksh.aposoft.view.cashbox;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class CashboxButtonPanel {

    @Getter
    private JPanel panel;
    @Getter
    private JButton btnAddProduct;
    @Getter
    private JButton btnRemoveProduct;
    @Getter
    private JButton btnAddCustomer;

    public CashboxButtonPanel() {
        build();
    }

    private void build() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("pref, 3dlu", "3dlu, pref, 3dlu, pref, 3dlu, p");
        panel = new JPanel(layout);

        btnAddProduct = new JButton("Hinzufügen");
        btnAddProduct.setEnabled(false);
        btnRemoveProduct = new JButton("Entfernen");
        btnRemoveProduct.setEnabled(false);
        btnAddCustomer = new JButton("Kunden anlegen");

        panel.add(btnAddProduct, cc.xy(1, 2));
        panel.add(btnRemoveProduct, cc.xy(1, 4));
        panel.add(btnAddCustomer, cc.xy(1, 6));
    }

}
