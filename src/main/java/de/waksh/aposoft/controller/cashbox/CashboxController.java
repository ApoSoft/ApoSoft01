package de.waksh.aposoft.controller.cashbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import lombok.Getter;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.controller.addcustomer.AddCustomerController;
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
    private AddCustomerController addCustomerController;

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

    private Customer customer;

    public CashboxController() {
        cashboxPanel = new CashboxPanel();
        cashboxButtonPanel = new CashboxButtonPanel();

        cashboxPanel.getInputAreaPanel().getTfCustomerNumber().addActionListener(actionListenerTextFieldCustomerNumber);
        cashboxPanel.getInputAreaPanel().getComboBox().addActionListener(actionListenerComboBox);
        cashboxPanel.getInputAreaPanel().getComboBox().addItemListener(itemListenerComboBox);

        cashboxPanel.getOutputAreaPanel().getTable().getSelectionModel()
                .addListSelectionListener(tableListSelectionListener);
        cashboxPanel.getOutputAreaPanel().getModel().addTableModelListener(tableModelListener);
        cashboxPanel.getCustomerPanel().getTxtReceive().addActionListener(actionListenerTextFieldReceive);
        cashboxPanel.getCustomerPanel().getHistoryTable().addMouseListener(historyTableMouseListener);
        cashboxPanel.getCustomerPanel().getComboBoxPaymentType().addItemListener(comboBoxPaymentTypeItemListener);

        cashboxButtonPanel.getBtnAddProduct().addActionListener(actionListenerButtonAddProduct);
        cashboxButtonPanel.getBtnRemoveProduct().addActionListener(actionListenerButtonRemoveProduct);
        cashboxButtonPanel.getBtnAddCustomer().addActionListener(actionListenerButtonAddCustomer);
        cashboxButtonPanel.getBtnConfirmPayment().addActionListener(actionListenerButtonConfirmPayment);
    }

    private ItemListener comboBoxPaymentTypeItemListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == 1) {
                if (e.getItem().equals("Rechnung")) {
                    cashboxButtonPanel.getBtnConfirmPayment().setEnabled(true);
                } else if (e.getItem().equals("Karte")) {
                    cashboxButtonPanel.getBtnConfirmPayment().setEnabled(false);
                } else {
                    cashboxButtonPanel.getBtnConfirmPayment().setEnabled(false);
                }
            }
        }
    };

    private MouseListener historyTableMouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int row = cashboxPanel.getCustomerPanel().getHistoryTable().getSelectedRow();
                if (row != -1) {
                    ProductAppointment productAppointment = cashboxPanel.getCustomerPanel().getHistoryTableModel()
                            .getItems().get(row);
                    Product product = new Product();
                    product.setName(productAppointment.getProduct());
                    cashboxPanel.getInputAreaPanel().getComboBox().getEditor().setItem(productAppointment.getProduct());
                    cashboxPanel.getInputAreaPanel().getComboBox().requestFocus();
                }
            }
        };
    };

    private ActionListener actionListenerButtonConfirmPayment = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customer == null) {
                JOptionPane.showMessageDialog(cashboxPanel.getPanel(), "Es wurde kein Kunde ausgewählt", "Hinweis",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            List<OrderItem> items = new ArrayList<>();
            for (Product p : cashboxPanel.getOutputAreaPanel().getModel().getItems()) {
                OrderItem item = new OrderItem();
                item.setProduct(p);
                item.setAmount(cashboxPanel.getOutputAreaPanel().getModel().getCount(p));
                items.add(item);
            }

            AppointmentCustomer ac = new AppointmentCustomer();
            ac.setCustomer(customer);
            ac.setItems(items);
            ac.setDate(new LocalDate());

            appointmentCustomerRepository.save(ac);

            cashboxPanel.getInputAreaPanel().getComboBox().setModel(new DefaultComboBoxModel<Product>());
            cashboxPanel.getInputAreaPanel().getTfCustomerNumber().setText("");
            cashboxPanel.getInputAreaPanel().getTfInsuranceName().setText("");
            cashboxPanel.getInputAreaPanel().getTfInsuranceNumber().setText("");
            cashboxPanel.getInputAreaPanel().getTfSubstance1().setText("");
            cashboxPanel.getInputAreaPanel().getTfSubstance2().setText("");
            cashboxPanel.getOutputAreaPanel().getModel().clear();
            cashboxPanel.getCustomerPanel().getTxtSum().setText("");
            cashboxPanel.getCustomerPanel().getTxtRetoure().setText("");
            cashboxPanel.getCustomerPanel().getTxtReceive().setText("");
            cashboxPanel.getCustomerPanel().getTxtDiscount().setText("");
            cashboxPanel.getCustomerPanel().getLblCustomerNumberData().setText("");
            cashboxPanel.getCustomerPanel().getLblFirstNameData().setText("");
            cashboxPanel.getCustomerPanel().getLblInsuranceData().setText("");
            cashboxPanel.getCustomerPanel().getLblInsuranceNumberData().setText("");
            cashboxPanel.getCustomerPanel().getLblLastNameData().setText("");
            cashboxPanel.getCustomerPanel().getHistoryTableModel().clear();
            cashboxPanel.getCustomerPanel().getReservationTableModel().clear();
            cashboxButtonPanel.getBtnAddProduct().setEnabled(false);
            cashboxButtonPanel.getBtnConfirmPayment().setEnabled(false);
            cashboxButtonPanel.getBtnRemoveProduct().setEnabled(false);
            cashboxPanel.getCustomerPanel().getComboBoxPaymentType().setSelectedIndex(0);
        }
    };

    private ActionListener actionListenerTextFieldReceive = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField field = (JTextField) e.getSource();

            float receive = 0.0f;
            float sum = 0.0f;

            try {
                receive = Float.parseFloat(field.getText());
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(cashboxPanel.getPanel(), "Ungültige Eingabe", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                sum = Float.parseFloat(cashboxPanel.getCustomerPanel().getTxtSum().getText());
            } catch (Exception e2) {
                return;
            }

            if (receive >= sum) {
                cashboxPanel.getCustomerPanel().getTxtRetoure().setText("" + String.format("%.2f", receive - sum));
                cashboxButtonPanel.getBtnConfirmPayment().setEnabled(true);
            } else {
                cashboxPanel.getCustomerPanel().getTxtRetoure().setText("Bitch, give me my MONEY!!!");
                cashboxButtonPanel.getBtnConfirmPayment().setEnabled(false);
            }
        }
    };

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

            customer = customerRepository.findOne(customerNumber);

            if (customer == null) {
                JOptionPane.showMessageDialog(cashboxPanel.getPanel(), "Kunde mit der Kundennummer [" + customerNumber
                        + "] nicht gefunden!", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            updateCustomerPanel(customer);
        }
    };
    private ActionListener actionListenerButtonAddCustomer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addCustomerController.showMeTheDialog();
            addCustomerController.getAddCustomerDialog().getAddCustomerDialog().setVisible(true);
        }
    };

    private ActionListener actionListenerComboBox = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("comboBoxEdited")) {
                JComboBox<Product> box = cashboxPanel.getInputAreaPanel().getComboBox();
                String query = String.format("%%%s%%", box.getSelectedItem());
                String substance1 = cashboxPanel.getInputAreaPanel().getTfSubstance1().getText();
                String substance2 = cashboxPanel.getInputAreaPanel().getTfSubstance2().getText();

                List<Product> list = productRepository.findByName(query);
                List<Product> remove = new ArrayList<>();

                for (Product p : list) {
                    boolean b = false;

                    List<String> ingredients = new ArrayList<>();

                    for (ActiveIngredient ai : p.getRecipe().getActiveIngredients()) {
                        ingredients.add(ai.getName());
                    }

                    if (!substance1.isEmpty() && !substance2.isEmpty()) {
                        if (!ingredients.contains(substance1) && !ingredients.contains(substance2)) {
                            b = true;
                        }
                    } else if (!substance1.isEmpty()) {
                        if (!ingredients.contains(substance1)) {
                            b = true;
                        }
                    } else if (!substance2.isEmpty()) {
                        if (!ingredients.contains(substance2)) {
                            b = true;
                        }
                    }

                    if (b) {
                        remove.add(p);
                    }
                }

                list.removeAll(remove);

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

                    cashboxButtonPanel.getBtnAddProduct().setEnabled(true);
                }
            }
        }
    };

    private ListSelectionListener tableListSelectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Wird aufgerufen, wenn ein Element in der Tabelle selektiert wurde
            // TODO: Implement => Button "Entfernen" aktivieren
            int row = cashboxPanel.getOutputAreaPanel().getTable().getSelectedRow();
            if (row != -1) {
                cashboxButtonPanel.getBtnRemoveProduct().setEnabled(true);
            } else {
                cashboxButtonPanel.getBtnRemoveProduct().setEnabled(false);
            }
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

                box.setModel(new DefaultComboBoxModel<Product>());
                cashboxButtonPanel.getBtnAddProduct().setEnabled(false);
                cashboxPanel.getInputAreaPanel().getTfSubstance1().setText("");
                cashboxPanel.getInputAreaPanel().getTfSubstance2().setText("");
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
            cashboxButtonPanel.getBtnConfirmPayment().setEnabled(false);
            cashboxPanel.getCustomerPanel().getTxtRetoure().setText("");
            cashboxPanel.getCustomerPanel().getTxtReceive().setText("");
        }
    };

    private void updateCustomerPanel(Customer customer) {
        if (customer.getInsurance() != null) {
            cashboxPanel.getInputAreaPanel().getTfInsuranceNumber()
                    .setText(customer.getInsurance().getInsuranceIdNumber());
            cashboxPanel.getInputAreaPanel().getTfInsuranceName().setText(customer.getInsurance().getName());
        }

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

                for (ActiveIngredient ac : orderItem.getProduct().getRecipe().getActiveIngredients()) {
                    String substances = productAppointment.getSubstances();
                    productAppointment.setSubstances((substances == null ? "" : substances + ";") + ac.getName());
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
