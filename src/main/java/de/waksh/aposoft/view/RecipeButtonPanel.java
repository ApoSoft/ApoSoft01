package de.waksh.aposoft.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.controller.RecipeController;

public class RecipeButtonPanel {
    @Getter
    private JPanel panel;
    private RecipeController controller;

    public RecipeButtonPanel(RecipeController controller) {
        this.controller = controller;
        build();
    }

    private void build() {
        FormLayout formLayout = new FormLayout("3dlu, 70dlu", "3dlu,p,3dlu,p,3dlu,p");
        CellConstraints cc = new CellConstraints();

        panel = new JPanel(formLayout);

        JButton btnAdd = new JButton("Hinzufügen");
        JButton btnDelete = new JButton("Entfernen");
        JButton btnNext = new JButton("Weiter");

        panel.add(btnAdd, cc.xy(2, 2));
        panel.add(btnDelete, cc.xy(2, 4));
        panel.add(btnNext, cc.xy(2, 6));

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.addRow();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.removeRow();
            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.next();
            }
        });
    }
}
