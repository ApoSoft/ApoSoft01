package de.waksh.aposoft.view.backend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * AbstractTableModel for tableModels in the panels.
 * 
 * @author ahofmann
 * 
 * @param <T>
 *            type of items
 */
public abstract class AbstractTableModel<T> implements TableModel, TableModelListener {
    protected String[] columnNames;
    protected List<TableModelListener> listeners;
    protected List<T> items;

    /**
     * Constructor for {@link AbstractTableModel}. Creates the column names.
     * 
     * @param columnNames
     *            names of the coloumns
     */
    public AbstractTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        listeners = new ArrayList<TableModelListener>();
        items = new ArrayList<T>();
    }

    /**
     * Adds an item to {@link List items}
     * 
     * @param item
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Adds a {@link List} of items.
     * 
     * @param items
     *            {@link List} of items
     */
    public void addItems(List<T> items) {
        items.addAll(items);
        update();
    }

    /**
     * Removes an item from {@link List items}.
     * 
     * @param item
     *            item to be removed
     */
    public void removeItem(T item) {
        items.remove(item);
    }

    /**
     * Removes an item from {@link List items} at an {@link Integer index}.
     * 
     * @param index
     *            {@link Integer index}
     * @return {@link List items}
     */
    public T removeItem(int index) {
        return items.remove(index);
    }

    /**
     * Returns the {@link List items}.
     * 
     * @return {@link List items}
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * Removes all of the elements from this list (optional operation). The list
     * will be empty after this call returns.
     * 
     * Runs update().
     */
    public void clear() {
        items.clear();
        update();
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

    /**
     * Runs tableChanged() (This fine grain notification tells listeners the
     * exact range of cells, rows, or columns that changed.)
     */
    public void update() {
        tableChanged(new TableModelEvent(this));
    }

}
