package de.waksh.aposoft.view.cashbox;

import javax.swing.JPanel;

import lombok.Data;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

@Data
public class CashboxPanel {

    private JPanel panel;
    private InputAreaPanel inputAreaPanel;
    private OutputAreaPanel outputAreaPanel;
    private CustomerPanel customerPanel;

    public CashboxPanel() {
        build();
    }

    private void build() {

        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("3dlu, fill:pref:grow, 3dlu", "pref, 3dlu, fill:pref:grow, 3dlu, pref");

        panel = new JPanel(layout);

        inputAreaPanel = new InputAreaPanel();
        outputAreaPanel = new OutputAreaPanel();
        customerPanel = new CustomerPanel();

        panel.add(inputAreaPanel.getPanel(), cc.xy(2, 1));
        panel.add(outputAreaPanel.getPanel(), cc.xy(2, 3));
        panel.add(customerPanel.getPanel(), cc.xy(2, 5));
    }

}
