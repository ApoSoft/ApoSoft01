package de.waksh.aposoft.view.recipe;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * 
 * @author jkuptz
 * 
 */
public class RecipeButtonPanel {
    @Getter
    private JPanel panel;

    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnNext;

    /**
     * Constructor of {@link RecipeButtonPanel}. Runs build().
     */
    public RecipeButtonPanel() {
        build();
    }

    private void build() {
        FormLayout formLayout = new FormLayout("3dlu, 70dlu", "3dlu,p,3dlu,p,3dlu,p");
        CellConstraints cc = new CellConstraints();

        panel = new JPanel(formLayout);

        btnAdd = new JButton("Hinzufügen");
        btnDelete = new JButton("Entfernen");
        btnNext = new JButton("Weiter");

        panel.add(btnAdd, cc.xy(2, 2));
        panel.add(btnDelete, cc.xy(2, 4));
        panel.add(btnNext, cc.xy(2, 6));
    }

    /**
     * Returns the {@link JButton btnAdd}.
     * 
     * @return {@link JButton btnAdd}
     */
    public JButton getBtnAdd() {
        return btnAdd;
    }

    /**
     * Returns the {@link JButton btnDelete}.
     * 
     * @return {@link JButton btnDelete}
     */
    public JButton getBtnDelete() {
        return btnDelete;
    }

    /**
     * Returns the {@link JButton btnNext}.
     * 
     * @return {@link JButton btnNext}
     */
    public JButton getBtnNext() {
        return btnNext;
    }
}
