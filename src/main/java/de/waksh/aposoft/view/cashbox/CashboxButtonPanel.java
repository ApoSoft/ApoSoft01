package de.waksh.aposoft.view.cashbox;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;

public class CashboxButtonPanel {

    private JPanel panel;

    public CashboxButtonPanel() {
        build();
    }

    private void build() {
        FormLayout layout = new FormLayout("", "");
        panel = new JPanel(layout);
    }

    public JPanel getPanel() {
        return panel;
    }

}
