/**
 * 
 */
package de.waksh.aposoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.model.ProductAppointment;
import de.waksh.aposoft.repository.AppointmentCustomerRepository;
import de.waksh.aposoft.view.CustomerAppointmentHistoryTableModel;
import de.waksh.aposoft.view.cashbox.CustomerPanel;

/**
 * Controller for the customer panel.
 * 
 * @author lhuebsch
 * 
 */
public class CustomerController {

    private CustomerPanel panel;
    private Customer customer;
    private CustomerAppointmentHistoryTableModel tableModel1;
    private List<AppointmentCustomer> appointmentCustomers;
    @Autowired
    private AppointmentCustomerRepository appointmentCustomerRepository;

    public CustomerController() {
        tableModel1 = new CustomerAppointmentHistoryTableModel();
        panel = new CustomerPanel(this, tableModel1);
    }

    public CustomerPanel getCustomerPanel() {
        return panel;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        updateCustomer(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    private void updateCustomer(Customer customer) {
        appointmentCustomers = appointmentCustomerRepository.findByCustomer(customer);
        for (int i = 0; i < appointmentCustomers.size(); i++) {
            for (int j = 0; j < appointmentCustomers.get(i).getItems().size(); j++) {
                ProductAppointment productAppointment = new ProductAppointment();
                productAppointment.setProduct(appointmentCustomers.get(i).getItems().get(j).getProduct().getName());
                productAppointment.setAmount(appointmentCustomers.get(i).getItems().get(j).getAmount());
                productAppointment.setDate(appointmentCustomers.get(i).getDate());
                for (int k = 0; k < appointmentCustomers.get(i).getItems().get(j).getProduct().getRecipe().getItems()
                        .size(); k++) {
                    productAppointment.setSubstances(productAppointment.getSubstances()
                            + appointmentCustomers.get(i).getItems().get(j).getProduct().getRecipe().getItems().get(k)
                                    .getSubstance().getName());

                }
                tableModel1.addProductAppointment(productAppointment);
            }
        }

        panel.setCustomerData(customer);
    }

}
