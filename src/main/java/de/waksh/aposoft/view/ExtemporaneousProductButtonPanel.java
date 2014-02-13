package de.waksh.aposoft.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ExtemporaneousProductButtonPanel {
    private JPanel panel;

    public ExtemporaneousProductButtonPanel() {
        build();
    }

    private void build() {
        panel = new JPanel();
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 44, 0 };
        gbl_panel.rowHeights = new int[] { 25, 0, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JButton btnAdd = new JButton("hinzufügen");
        GridBagConstraints gbc_btnAdd = new GridBagConstraints();
        gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAdd.insets = new Insets(5, 5, 5, 5);
        gbc_btnAdd.anchor = GridBagConstraints.NORTH;
        gbc_btnAdd.gridx = 0;
        gbc_btnAdd.gridy = 0;
        panel.add(btnAdd, gbc_btnAdd);

        JButton btnDelete = new JButton("entfernen");
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDelete.anchor = GridBagConstraints.NORTH;
        gbc_btnDelete.insets = new Insets(5, 5, 5, 5);
        gbc_btnDelete.gridx = 0;
        gbc_btnDelete.gridy = 1;
        panel.add(btnDelete, gbc_btnDelete);

        JButton btnNext = new JButton("weiter");
        GridBagConstraints gbc_btnNext = new GridBagConstraints();
        gbc_btnNext.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNext.insets = new Insets(5, 5, 5, 5);
        gbc_btnNext.anchor = GridBagConstraints.NORTH;
        gbc_btnNext.gridx = 0;
        gbc_btnNext.gridy = 2;
        panel.add(btnNext, gbc_btnNext);
    }

    public JPanel getPanel() {
        return panel;
    }
}
