package de.waksh.aposoft.view.backend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ComboBoxModel<T> implements javax.swing.ComboBoxModel<T>, ListDataListener {
    private List<ListDataListener> listeners;
    private List<T> list;
    private T selectedItem;

    public ComboBoxModel() {
        listeners = new ArrayList<>();
        list = new ArrayList<T>();
    }

    public void addItem(T item) {
        list.add(item);
    }

    public void addAll(List<T> items) {
        list.addAll(items);
    }

    public void removeItem(T item) {
        list.remove(item);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public T getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

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
