/**
 * 
 */
package de.waksh.aposoft.view.cashbox;

import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lombok.Getter;

import org.joda.time.LocalDate;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.domain.ProductReservationItem;
import de.waksh.aposoft.model.ProductAppointment;
import de.waksh.aposoft.view.backend.AbstractTableModel;

/**
 * Panel for the informations about Customer at the bottom of the main panel.
 * 
 * @author lhuebsch
 * 
 */
public class CustomerPanel {

    @Getter
    private JPanel panel;

    @Getter
    private JLabel lblCustomerNumberData;

    @Getter
    private JLabel lblFirstNameData;

    @Getter
    private JLabel lblLastNameData;

    @Getter
    private JLabel lblInsuranceNumberData;

    @Getter
    private JLabel lblInsuranceData;

    @Getter
    private JTextField txtDiscount;

    @Getter
    private JTextField txtSum;

    @Getter
    private JComboBox<String> comboBoxPaymentType;

    @Getter
    private JTextField txtReceive;

    @Getter
    private JTextField txtRetoure;

    private JTable historyTable;
    private JTable reservationTable;

    @Getter
    private HistoryTableModel historyTableModel;

    @Getter
    private ReservationTableModel reservationTableModel;

    public CustomerPanel() {
        build();
    }

    private void build() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref:grow, 3dlu, pref", "pref");

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
        tabbedPane.add("Reservierungen", buildReservationPanel());

        panel.add(tabbedPane, cc.xy(1, 1));
        panel.add(buildCashboxResultPanel(), cc.xy(3, 1));
    }

    private JPanel buildReservationPanel() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("fill:pref:grow", "fill:pref");
        JPanel reservationPanel = new JPanel(layout);

        reservationTableModel = new ReservationTableModel();
        reservationTable = new JTable(reservationTableModel);

        JScrollPane scrollPane = new JScrollPane();
        Dimension dimension = new Dimension(450, 120);
        scrollPane.setPreferredSize(dimension);
        scrollPane.setViewportView(reservationTable);

        reservationPanel.add(scrollPane, cc.xy(1, 1));
        return reservationPanel;
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

    private JPanel buildCashboxResultPanel() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("pref, 3dlu, 50dlu", "pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref");

        JPanel panel = new JPanel(layout);

        txtDiscount = new JTextField();
        txtDiscount.setEditable(false);
        txtDiscount.setHorizontalAlignment(JTextField.RIGHT);
        txtSum = new JTextField();
        txtSum.setEditable(false);
        txtSum.setHorizontalAlignment(JTextField.RIGHT);
        comboBoxPaymentType = new JComboBox<>();
        comboBoxPaymentType.setModel(new DefaultComboBoxModel<>(new String[] { "Bargeld", "Karte", "Rechnung" }));
        txtReceive = new JTextField();
        txtReceive.setHorizontalAlignment(JTextField.RIGHT);
        txtRetoure = new JTextField();
        txtRetoure.setEditable(false);
        txtRetoure.setHorizontalAlignment(JTextField.RIGHT);

        panel.add(new JLabel("Rabatt"), cc.xy(1, 1));
        panel.add(new JLabel("Summe"), cc.xy(1, 3));
        panel.add(new JLabel("Zahlungsart"), cc.xy(1, 5));
        panel.add(new JLabel("Gegeben"), cc.xy(1, 7));
        panel.add(new JLabel("Retoure"), cc.xy(1, 9));

        panel.add(txtDiscount, cc.xy(3, 1));
        panel.add(txtSum, cc.xy(3, 3));
        panel.add(comboBoxPaymentType, cc.xy(3, 5));
        panel.add(txtReceive, cc.xy(3, 7));
        panel.add(txtRetoure, cc.xy(3, 9));

        return panel;
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

    public class ReservationTableModel extends AbstractTableModel<ProductReservationItem> {

        public ReservationTableModel() {
            super(new String[] { "Medikament", "Anzahl", "Filiale", "Vorhanden", "Reserviert bis" });
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return Boolean.class;
            case 4:
                return LocalDate.class;
            default:
                return null;
            }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ProductReservationItem productReservationItem = items.get(rowIndex);
            switch (columnIndex) {
            case 0:
                return productReservationItem.getProduct().getName();
            case 1:
                return productReservationItem.getAmount();
            case 2:
                return productReservationItem.getBranch().getDescription();
            case 3:
                return productReservationItem.isAvailable();
            case 4:
                return productReservationItem.getReservedUntil();
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
