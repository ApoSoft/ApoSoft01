package de.waksh.aposoft.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class RecipeButtonPanel {
    @Getter
    private JPanel panel;

    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnNext;

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

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnNext() {
        return btnNext;
    }
}
