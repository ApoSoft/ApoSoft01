package de.waksh.aposoft.view.cashbox;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.controller.cashbox.CashboxController;

public class CashboxPanel {

    private CashboxController controller;

    private JPanel panel;

    public CashboxPanel(CashboxController controller) {
        this.controller = controller;
        build();
    }

    private void build() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("3dlu, fill:pref:grow, 3dlu", "pref, 3dlu, fill:pref:grow, 3dlu, pref");

        panel = new JPanel(layout);

        panel.add(controller.getInputAreaController().getInputAreaPanel().getPanel(), cc.xy(2, 1));
        panel.add(controller.getOutputAreaController().getOutputAreaPanel().getPanel(), cc.xy(2, 3));
        panel.add(controller.getCustomerController().getCustomerPanel().getPanel(), cc.xy(2, 5));
    }

    public JPanel getPanel() {
        return panel;
    }

}
