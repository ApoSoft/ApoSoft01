package de.waksh.aposoft.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Data;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * 
 * @author ahofmann
 * 
 */

@Data
public class NavigationPanel {
    private JPanel panel;
    private JButton btnCashbox;
    private JButton btnMaterialAdmin;
    private JButton btnAdmin;
    private JButton btnRecipe;

    public NavigationPanel() {
        build();
    }

    private void build() {
        btnCashbox = new JButton("Kasse");
        btnMaterialAdmin = new JButton("Materialwirtschaft");
        btnAdmin = new JButton("Administration");
        btnRecipe = new JButton("Rezeptur");

        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref", "pref, 3dlu, pref, 3dlu, pref, 3dlu, pref");
        panel = new JPanel(layout);

        panel.add(btnCashbox, cc.xy(1, 1));
        panel.add(btnMaterialAdmin, cc.xy(1, 3));
        panel.add(btnAdmin, cc.xy(1, 5));
        panel.add(btnRecipe, cc.xy(1, 7));
    }
}
