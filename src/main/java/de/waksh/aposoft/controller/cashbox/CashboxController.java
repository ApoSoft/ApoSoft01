package de.waksh.aposoft.controller.cashbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.OrderItem;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.ProductReservation;
import de.waksh.aposoft.model.ProductAppointment;
import de.waksh.aposoft.repository.AppointmentCustomerRepository;
import de.waksh.aposoft.repository.CustomerRepository;
import de.waksh.aposoft.repository.ProductRepository;
import de.waksh.aposoft.repository.ProductReservationRepository;
import de.waksh.aposoft.repository.StoreRepository;
import de.waksh.aposoft.view.backend.ComboBoxModel;
import de.waksh.aposoft.view.cashbox.CashboxButtonPanel;
import de.waksh.aposoft.view.cashbox.CashboxPanel;
import de.waksh.aposoft.view.cashbox.CustomerPanel;

/**
 * 
 * @author ahofmann
 * 
 */

@Component
public class CashboxController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AppointmentCustomerRepository appointmentCustomerRepository;

    @Autowired
    private ProductReservationRepository productReservationRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Getter
    private CashboxPanel cashboxPanel;

    @Getter
    private CashboxButtonPanel cashboxButtonPanel;

    public CashboxController() {
        cashboxPanel = new CashboxPanel();
        cashboxButtonPanel = new CashboxButtonPanel();

        cashboxPanel.getInputAreaPanel().getTfCustomerNumber().addActionListener(actionListenerTextFieldCustomerNumber);
        cashboxPanel.getInputAreaPanel().getComboBox().addActionListener(actionListenerComboBox);
        cashboxPanel.getInputAreaPanel().getComboBox().addItemListener(itemListenerComboBox);

        cashboxPanel.getOutputAreaPanel().getTable().getSelectionModel()
                .addListSelectionListener(tableListSelectionListener);
        cashboxPanel.getOutputAreaPanel().getModel().addTableModelListener(tableModelListener);

        cashboxButtonPanel.getBtnAddProduct().addActionListener(actionListenerButtonAddProduct);
        cashboxButtonPanel.getBtnRemoveProduct().addActionListener(actionListenerButtonRemoveProduct);
    }

    private ActionListener actionListenerTextFieldCustomerNumber = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int customerNumber = -1;

            try {
                customerNumber = Integer.parseInt(e.getActionCommand());
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(cashboxPanel.getPanel(), "Ungültige Eingabe", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Customer customer = customerRepository.findOne(customerNumber);

            if (customer == null) {
                JOptionPane.showMessageDialog(cashboxPanel.getPanel(), "Kunde mit der Kundennummer [" + customerNumber
                        + "] nicht gefunden!", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            updateCustomerPanel(customer);
        }
    };

    private ActionListener actionListenerComboBox = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("comboBoxEdited")) {
                JComboBox<Product> box = cashboxPanel.getInputAreaPanel().getComboBox();
                String query = String.format("%%%s%%", box.getSelectedItem());

                List<Product> list = productRepository.findByName(query);

                box.setModel(new ComboBoxModel<Product>(list));
                box.showPopup();
            }
        }
    };

    private ItemListener itemListenerComboBox = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JComboBox<Product> box = cashboxPanel.getInputAreaPanel().getComboBox();
                int index = box.getSelectedIndex();

                if (index != -1) {
                    Product product = (Product) box.getSelectedItem();
                    box.setToolTipText(product.toString());

                    // TODO: Produkt wurde ausgewählt => Button "Hinzufügen"
                    // aktivieren
                }
            }
        }
    };

    private ListSelectionListener tableListSelectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Wird aufgerufen, wenn ein Element in der Tabelle selektiert wurde
            // TODO: Implement => Button "Entfernen" aktivieren
            System.out.println(e);
        }
    };

    private ActionListener actionListenerButtonAddProduct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<Product> box = cashboxPanel.getInputAreaPanel().getComboBox();
            int index = box.getSelectedIndex();

            if (index != -1) {
                Product product = (Product) box.getSelectedItem();

                cashboxPanel.getOutputAreaPanel().getModel().addItem(product);
                cashboxPanel.getOutputAreaPanel().getModel().update();
            }
        }
    };

    private ActionListener actionListenerButtonRemoveProduct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = cashboxPanel.getOutputAreaPanel().getTable().getSelectedRow();

            if (index != -1) {
                cashboxPanel.getOutputAreaPanel().getModel().removeItem(index);
                cashboxPanel.getOutputAreaPanel().getModel().update();
            }
        }
    };

    private TableModelListener tableModelListener = new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            // Wird aufgerufen, wenn sich die Daten in der Tabelle verändern
            // TODO: Implement => Tabelleninfo aktualisieren

            float sum = 0.0f;

            for (Product product : cashboxPanel.getOutputAreaPanel().getModel().getItems()) {
                sum += product.getPrice() * cashboxPanel.getOutputAreaPanel().getModel().getCount(product);
            }

            cashboxPanel.getCustomerPanel().getTxtSum().setText(String.format(Locale.US, "%.2f", sum));
        }
    };

    private void updateCustomerPanel(Customer customer) {
        cashboxPanel.getInputAreaPanel().getTfInsuranceNumber().setText(customer.getInsurance().getInsuranceIdNumber());

        CustomerPanel cp = cashboxPanel.getCustomerPanel();
        cp.getLblCustomerNumberData().setText("" + customer.getId());
        cp.getLblFirstNameData().setText(customer.getFirstName());
        cp.getLblLastNameData().setText(customer.getName());
        cp.getLblInsuranceNumberData().setText(customer.getInsurance().getInsuranceIdNumber());
        cp.getLblInsuranceData().setText(customer.getInsurance().getName());

        List<AppointmentCustomer> listAppCust = appointmentCustomerRepository.findByCustomer(customer);
        for (AppointmentCustomer appointmentCustomer : listAppCust) {
            for (OrderItem orderItem : appointmentCustomer.getItems()) {
                ProductAppointment productAppointment = new ProductAppointment();
                productAppointment.setProduct(orderItem.getProduct().getName());
                productAppointment.setAmount(orderItem.getAmount());
                productAppointment.setDate(appointmentCustomer.getDate());

                for (ActiveIngredient ac : orderItem.getProduct().getRecipe().getActiveIngredient()) {
                    String substances = productAppointment.getSubstances();
                    productAppointment.setSubstances(substances + "; " + ac.getName());
                }

                cp.getHistoryTableModel().addItem(productAppointment);
            }
        }

        List<ProductReservation> productReservations = productReservationRepository.findByCustomer(customer);
        for (ProductReservation productReservation : productReservations) {
            cp.getReservationTableModel().addItems(productReservation.getItems());
        }
        cp.getReservationTableModel().update();
        cp.getHistoryTableModel().update();
    }

}
