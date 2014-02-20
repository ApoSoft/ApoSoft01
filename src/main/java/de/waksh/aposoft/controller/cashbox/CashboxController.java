package de.waksh.aposoft.controller.cashbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.OrderItem;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.SubstanceItem;
import de.waksh.aposoft.model.ProductAppointment;
import de.waksh.aposoft.repository.AppointmentCustomerRepository;
import de.waksh.aposoft.repository.CustomerRepository;
import de.waksh.aposoft.repository.ProductRepository;
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
@Data
public class CashboxController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AppointmentCustomerRepository appointmentCustomerRepository;

    private CashboxPanel cashboxPanel;
    private CashboxButtonPanel cashboxButtonPanel;

    public CashboxController() {
        cashboxPanel = new CashboxPanel();
        cashboxButtonPanel = new CashboxButtonPanel();

        cashboxPanel.getInputAreaPanel().getTfCustomerNumber().addActionListener(actionListenerTextFieldCustomerNumber);
        cashboxPanel.getInputAreaPanel().getComboBox().addActionListener(actionListenerComboBox);
    }

    private ActionListener actionListenerTextFieldCustomerNumber = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int customerNumber = -1;

            try {
                customerNumber = Integer.parseInt(e.getActionCommand());
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(cashboxButtonPanel.getPanel(), "Ungültige Eingabe", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Customer customer = customerRepository.findOne(customerNumber);

            if (customer == null) {
                JOptionPane.showMessageDialog(cashboxButtonPanel.getPanel(), "Kunde mit der Kundennummer ["
                        + customerNumber + "] nicht gefunden!", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            updateCustomerPanel(customer);
        }
    };

    private ActionListener actionListenerComboBox = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("comboBoxChanged")) {
                JComboBox box = (JComboBox) e.getSource();
                String query = String.format("%%%s%%", box.getSelectedItem());

                List<Product> list = productRepository.findByName(query);
                box.setModel(new ComboBoxModel<Product>(list));
            }
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

        List<AppointmentCustomer> list = appointmentCustomerRepository.findByCustomer(customer);
        for (AppointmentCustomer appointmentCustomer : list) {
            for (OrderItem orderItem : appointmentCustomer.getItems()) {
                ProductAppointment productAppointment = new ProductAppointment();
                productAppointment.setProduct(orderItem.getProduct().getName());
                productAppointment.setAmount(orderItem.getAmount());
                productAppointment.setDate(appointmentCustomer.getDate());

                for (SubstanceItem substanceItem : orderItem.getProduct().getRecipe().getItems()) {
                    String substances = productAppointment.getSubstances();
                    productAppointment.setSubstances(substances + "; " + substanceItem.getSubstance().getName());
                }

                cp.getHistoryTableModel().addItem(productAppointment);
            }
        }

        cp.getHistoryTableModel().update();
    }
}
