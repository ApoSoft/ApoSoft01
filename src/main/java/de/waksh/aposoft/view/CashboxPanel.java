package de.waksh.aposoft.view;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.controller.CashboxController;

public class CashboxPanel {

    private CashboxController controller;

    private JPanel panel;

    public CashboxPanel(CashboxController controller) {
        this.controller = controller;

        build();
    }

    private void build() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("", "");
        panel = new JPanel(layout);
    }

    public JPanel getPanel() {
        return panel;
    }

}
