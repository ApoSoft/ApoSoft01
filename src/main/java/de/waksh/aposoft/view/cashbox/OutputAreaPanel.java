package de.waksh.aposoft.view.cashbox;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.waksh.aposoft.controller.cashbox.OutputAreaController;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.view.backend.AbstractTableModel;

public class OutputAreaPanel {

    private OutputAreaController controller;

    private JPanel panel;
    private JTable table;
    private TableModel<Product> model;

    public OutputAreaPanel(OutputAreaController controller) {
        this.controller = controller;

        build();
    }

    private void build() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));

        model = new TableModel<Product>();
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    private class TableModel<Product> extends AbstractTableModel<Product> {

        public TableModel() {
            super(new String[] { "Anzahl", "Bezeichnung", "Hersteller", "Inhalt", "Wirkstoffe", "Art", "Einzelpreis",
                    "Gesamtpreis" });
        }

        @Override
        public Class<?> getColumnClass(int index) {
            return null;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public void setValueAt(Object obj, int rowIndex, int columnIndex) {

        }

    }

}
