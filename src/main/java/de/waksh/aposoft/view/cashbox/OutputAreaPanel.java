package de.waksh.aposoft.view.cashbox;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lombok.Getter;
import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.view.backend.AbstractTableModel;

/**
 * Panel to show items currently on the cashbox
 * 
 * @author Artem Hofmann
 * 
 */
public class OutputAreaPanel {

    @Getter
    private JPanel panel;

    @Getter
    private JTable table;

    @Getter
    private TableModel model;

    /**
     * Construct and build new OutputAreaPanel
     */
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

    /**
     * OutputAreaPanel TableModel used in the main JTable
     * 
     * @author Artem Hofmann
     * 
     */
    public class TableModel extends AbstractTableModel<Product> {

        private Map<Product, Integer> productCounter;

        /**
         * Construct a new table model with the required column titles and
         * initialize new hashtable for products
         */
        public TableModel() {
            super(new String[] { "Anzahl", "Bezeichnung", "Hersteller", "Inhalt", "Wirkstoffe", "Art", "Einzelpreis",
                    "Gesamtpreis" });
            productCounter = new HashMap<>();
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

        /**
         * Gets the count for the given product on the counter
         * 
         * @param item
         *            product to search for
         * @return count of products on counter
         */
        public int getCount(Product item) {
            return productCounter.get(item);
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
                return getCount(product);
            case 1:
                return product.getName();
            case 2:
                return product.getVendor().getVendorCode();
            case 3:
                return product.getDosage() + " " + product.getUnit().getName();
            case 4:
                StringBuilder builder = new StringBuilder();
                for (ActiveIngredient ac : product.getRecipe().getActiveIngredients()) {
                    builder.append(ac.getName()).append(", ");
                }
                return builder.toString();
            case 5:
                return product.getProductType().getName();
            case 6:
                return product.getPrice();
            case 7:
                return product.getPrice() * getCount(product);
            default:
                return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public void setValueAt(Object obj, int rowIndex, int columnIndex) {
            Product product = items.get(rowIndex);

            switch (columnIndex) {
            case 0:
                productCounter.remove(product);
                productCounter.put(product, (int) obj);
                update();
                break;
            default:
                break;
            }

        }

    }

}
