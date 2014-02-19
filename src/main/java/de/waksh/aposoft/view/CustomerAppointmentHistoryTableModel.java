/**
 * 
 */
package de.waksh.aposoft.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.joda.time.LocalDate;

import de.waksh.aposoft.model.ProductAppointment;

/**
 * @author lhuebsch
 * 
 */
public class CustomerAppointmentHistoryTableModel implements TableModel {

    private List<ProductAppointment> productAppointments = new ArrayList<>();
    private List<TableModelListener> listeners = new ArrayList<>();

    public void addProductAppointment(ProductAppointment productAppointment) {
        int index = productAppointments.size();
        productAppointments.add(productAppointment);

        TableModelEvent e = new TableModelEvent(this, index, index, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

        for (int i = 0, n = listeners.size(); i < n; i++) {
            listeners.get(i).tableChanged(e);
        }
    }

    @Override
    public int getRowCount() {
        return productAppointments.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return "Datum";
        case 1:
            return "Medikament";
        case 2:
            return "Anzahl";
        case 3:
            return "Wirkstoffe";
        default:
            return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return LocalDate.class;
        case 1:
            return String.class;
        case 2:
            return Integer.class;
        case 3:
            return String.class;
        default:
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductAppointment productAppointment = productAppointments.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return productAppointment.getDate();
        case 1:
            return productAppointment.getProduct();
        case 2:
            return productAppointment.getAmount();
        case 3:
            return productAppointment.getSubstances();
        default:
            return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

}
