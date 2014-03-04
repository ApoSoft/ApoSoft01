package de.waksh.aposoft.view.cashbox;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Getter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.domain.Product;

/**
 * Input area to enter search terms in the cashbox
 * 
 * @author Artem Hofmann
 * 
 */
@Getter
public class InputAreaPanel {
    private JPanel panel;

    private JTextField tfCustomerNumber;
    private JTextField tfInsuranceNumber;
    private JTextField tfInsuranceName;

    private JComboBox<Product> comboBox;
    private JTextField tfSubstance1;
    private JTextField tfSubstance2;

    /**
     * Construct and build a new InputAreaPanel
     */
    public InputAreaPanel() {
        build();
    }

    private void build() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout(
                "3dlu, right:pref, 3dlu, 50dlu:grow, 3dlu, right:pref, 3dlu, 50dlu:grow, 3dlu, right:pref, 3dlu, 50dlu:grow, 3dlu",
                "3dlu, pref, 3dlu, pref");

        panel = new JPanel(layout);

        tfCustomerNumber = new JTextField();
        tfInsuranceNumber = new JTextField();
        tfSubstance1 = new JTextField();
        tfSubstance2 = new JTextField();
        tfInsuranceName = new JTextField();
        tfInsuranceName.setEditable(false);

        comboBox = new JComboBox<Product>();
        comboBox.setEditable(true);

        panel.add(new JLabel("Kundennummer"), cc.xy(2, 2));
        panel.add(tfCustomerNumber, cc.xy(4, 2));
        panel.add(new JLabel("Kassennummer"), cc.xy(6, 2));
        panel.add(tfInsuranceNumber, cc.xy(8, 2));
        panel.add(new JLabel("Krankenkasse"), cc.xy(10, 2));
        panel.add(tfInsuranceName, cc.xy(12, 2));

        panel.add(new JLabel("Produkt"), cc.xy(2, 4));
        panel.add(comboBox, cc.xy(4, 4));
        panel.add(new JLabel("Wirkstoff 1"), cc.xy(6, 4));
        panel.add(tfSubstance1, cc.xy(8, 4));
        panel.add(new JLabel("Wirkstoff 2"), cc.xy(10, 4));
        panel.add(tfSubstance2, cc.xy(12, 4));
    }

}
