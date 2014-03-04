package de.waksh.aposoft.view.backend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Generic ComboBoxModel
 * 
 * @author Artem Hofmann
 * 
 * @param <T>
 *            type of items used in the model
 */
public class ComboBoxModel<T> implements javax.swing.ComboBoxModel<T>, ListDataListener {
    private List<ListDataListener> listeners;
    private List<T> items;
    private T selectedItem;

    /**
     * Construct the ComboBoxModel and initialize listeners and items lists
     */
    public ComboBoxModel() {
        listeners = new ArrayList<>();
        items = new ArrayList<T>();
    }

    /**
     * Initialize ComboBoxModel and add items to the model
     * 
     * @param items
     *            list of items to add initially
     */
    public ComboBoxModel(List<T> items) {
        this();
        addAll(items);
    }

    /**
     * Add an item to the model
     * 
     * @param item
     *            item to add
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Add a list of items to the model
     * 
     * @param items
     *            list of items to add
     */
    public void addAll(List<T> items) {
        this.items.addAll(items);
    }

    /**
     * Remove an item from the model
     * 
     * @param item
     *            item to remove
     */
    public void removeItem(T item) {
        items.remove(item);
    }

    /**
     * Remove all items from the model
     */
    public void clear() {
        items.clear();
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public T getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (T) anItem;
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        for (ListDataListener l : listeners) {
            l.contentsChanged(e);
        }
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        for (ListDataListener l : listeners) {
            l.intervalAdded(e);
        }
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        for (ListDataListener l : listeners) {
            l.intervalRemoved(e);
        }
    }

}
