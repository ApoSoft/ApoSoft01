package de.waksh.aposoft.view.cashbox;

import java.awt.BorderLayout;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lombok.Data;
import de.waksh.aposoft.domain.ActiveIngredient;
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

        private Hashtable<Product, Integer> productCounter;

        public TableModel() {
            super(new String[] { "Anzahl", "Bezeichnung", "Hersteller", "Inhalt", "Wirkstoffe", "Art", "Einzelpreis",
                    "Gesamtpreis" });
            productCounter = new Hashtable<>();
        }

        @Override
        public void addItem(Product item) {
            super.addItem(item);
            productCounter.put(item, 1);
        }

        @Override
        public void addItems(List<Product> items) {
            super.addItems(items);
            for (Product item : items) {
                productCounter.put(item, 1);
            }
        }

        @Override
        public Product removeItem(int index) {
            Product item = super.removeItem(index);
            productCounter.remove(item);
            return item;
        }

        @Override
        public void removeItem(Product item) {
            super.removeItem(item);
            productCounter.remove(item);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return String.class;
            case 6:
            case 7:
                return Float.class;
            default:
                return null;
            }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Product product = items.get(rowIndex);

            switch (columnIndex) {
            case 0:
                return productCounter.get(product);
            case 1:
                return product.getName();
            case 2:
                return product.getVendor().getVendorCode();
            case 3:
                return product.getDosage() + " " + product.getUnit().getName();
            case 4:
                StringBuilder builder = new StringBuilder();
                for (ActiveIngredient ac : product.getRecipe().getActiveIngredient()) {
                    builder.append(ac.getName()).append(", ");
                }
                // TODO: Check if it works
                builder.setLength(builder.length() - 2);
                return builder.toString();
            case 5:
                return product.getProductType().getName();
            case 6:
                return product.getPrice();
            case 7:
                int count = productCounter.get(product);
                return product.getPrice() * count;
            default:
                return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return true;
            }
            return false;
        }

        @Override
        public void setValueAt(Object obj, int rowIndex, int columnIndex) {
            Product product = items.get(rowIndex);

            switch (columnIndex) {
            case 0:
                productCounter.remove(product);
                productCounter.put(product, Integer.parseInt((String) obj));
                break;
            }
        }

    }

}
