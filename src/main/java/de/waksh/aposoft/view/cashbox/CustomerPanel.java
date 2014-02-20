/**
 * 
 */
package de.waksh.aposoft.view.cashbox;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import lombok.Data;

import org.joda.time.LocalDate;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.model.ProductAppointment;
import de.waksh.aposoft.view.backend.AbstractTableModel;

/**
 * Panel for the informations about Customer at the bottom of the main panel.
 * 
 * @author lhuebsch
 * 
 */
@Data
public class CustomerPanel {

    private JPanel panel;
    private JLabel lblCustomerNumberData;
    private JLabel lblFirstNameData;
    private JLabel lblLastNameData;
    private JLabel lblInsuranceNumberData;
    private JLabel lblInsuranceData;

    private JTable historyTable;
    private HistoryTableModel historyTableModel;

    public CustomerPanel() {
        build();
    }

    private void build() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref:grow", "pref");

        panel = new JPanel(layout);

        lblCustomerNumberData = new JLabel();
        lblFirstNameData = new JLabel();
        lblLastNameData = new JLabel();
        lblInsuranceNumberData = new JLabel();
        lblInsuranceData = new JLabel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.putClientProperty("putClientProperty", Boolean.TRUE);

        tabbedPane.add("Data", buildDataPanel());
        tabbedPane.add("Historie", buildHistoryPanel());

        panel.add(tabbedPane, cc.xy(1, 1));

    }

    private JPanel buildHistoryPanel() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref:grow", "fill:pref");
        JPanel historyPanel = new JPanel(layout);

        historyTableModel = new HistoryTableModel();
        historyTable = new JTable(historyTableModel);

        JScrollPane scrollPane = new JScrollPane();
        Dimension dimension = new Dimension(450, 120);
        scrollPane.setPreferredSize(dimension);
        scrollPane.setViewportView(historyTable);

        historyPanel.add(scrollPane, cc.xy(1, 1));

        return historyPanel;
    }

    private JPanel buildDataPanel() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("3dlu, right:pref, 3dlu, left:pref, 3dlu", // coloumns
                "3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu"); // rows

        JPanel dataPanel = new JPanel(layout);

        dataPanel.add(new JLabel("Kundennummer: "), cc.xy(2, 2));
        dataPanel.add(lblCustomerNumberData, cc.xy(4, 2));
        dataPanel.add(new JLabel("Vorname: "), cc.xy(2, 4));
        dataPanel.add(lblFirstNameData, cc.xy(4, 4));
        dataPanel.add(new JLabel("Nachname: "), cc.xy(2, 6));
        dataPanel.add(lblLastNameData, cc.xy(4, 6));
        dataPanel.add(new JLabel("Krankenkasse-Nr: "), cc.xy(2, 8));
        dataPanel.add(lblInsuranceNumberData, cc.xy(4, 8));
        dataPanel.add(new JLabel("Krankenkasse: "), cc.xy(2, 10));
        dataPanel.add(lblInsuranceData, cc.xy(4, 10));

        return dataPanel;
    }

    public class HistoryTableModel extends AbstractTableModel<ProductAppointment> {

        public HistoryTableModel() {
            super(new String[] { "Datum", "Medikament", "Anzahl", "Wirkstoffe" });
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
        public Object getValueAt(int rowIndex, int columnIndex) {
            ProductAppointment productAppointment = items.get(rowIndex);
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
        public boolean isCellEditable(int arg0, int arg1) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void setValueAt(java.lang.Object arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub

        }

    }

}
