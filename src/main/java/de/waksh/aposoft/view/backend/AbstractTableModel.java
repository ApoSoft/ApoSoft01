package de.waksh.aposoft.view.backend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public abstract class AbstractTableModel<T> implements TableModel, TableModelListener {
    protected String[] columnNames;
    protected List<TableModelListener> listeners;
    protected List<T> items;

    public AbstractTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        listeners = new ArrayList<TableModelListener>();
        items = new ArrayList<T>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void addItems(List<T> items) {
        items.addAll(items);
        update();
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public T removeItem(int index) {
        return items.remove(index);
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        for (TableModelListener l : listeners) {
            l.tableChanged(e);
        }
    }

    public void update() {
        tableChanged(new TableModelEvent(this));
    }

}
