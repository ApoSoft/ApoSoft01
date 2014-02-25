/**
 * 
 */
package de.waksh.aposoft.controller.addcustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.repository.CustomerRepository;
import de.waksh.aposoft.view.addcustomer.AddCustomerDialog;

/**
 * @author lhuebsch
 * 
 */
@Component
public class AddCustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Getter
    private AddCustomerDialog addCustomerDialog;
    @Getter
    private JPanel addCustomerPanel;

    public AddCustomerController() {
        showMeTheDialog();
    }

    public void showMeTheDialog() {
        addCustomerDialog = new AddCustomerDialog();

        addCustomerPanel = addCustomerDialog.getAddCustomerPanel();

        addCustomerDialog.getBtnCancel().addActionListener(actionListenerButtonCancel);
        addCustomerDialog.getBtnAddCustomer().addActionListener(actionListenerButtonAddCustomer);

    }

    private ActionListener actionListenerButtonCancel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addCustomerDialog.getAddCustomerDialog().dispose();
        }
    };

    private ActionListener actionListenerButtonAddCustomer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName;
            String lastName;
            String insuranceNo;

            firstName = addCustomerDialog.getTfFirstName().getText();
            lastName = addCustomerDialog.getTfLastName().getText();
            insuranceNo = addCustomerDialog.getTfInsuranceNo().getText();

            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setName(lastName);

            customerRepository.save(customer);

            addCustomerDialog.getAddCustomerDialog().dispose();
        }
    };

}
