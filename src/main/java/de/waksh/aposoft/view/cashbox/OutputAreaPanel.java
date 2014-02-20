package de.waksh.aposoft.view.cashbox;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lombok.Data;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.view.backend.AbstractTableModel;

@Data
public class OutputAreaPanel {

    private JPanel panel;
    private JTable table;
    private TableModel model;

    public OutputAreaPanel() {
        build();
    }

    private void build() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));

        model = new TableModel();
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        panel.add(scrollPane, BorderLayout.CENTER);
    }

    private class TableModel extends AbstractTableModel<Product> {

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
