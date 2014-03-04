/**
 * 
 */
package de.waksh.aposoft.controller.addcustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.Insurance;
import de.waksh.aposoft.repository.CustomerRepository;
import de.waksh.aposoft.repository.InsuranceRepository;
import de.waksh.aposoft.view.addcustomer.AddCustomerDialog;

/**
 * Controller for the {@link AddCustomerDialog}.
 * 
 * @author lhuebsch
 * 
 */
@Component
public class AddCustomerController {

    @Autowired
    InsuranceRepository insuranceRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Getter
    private AddCustomerDialog addCustomerDialog;
    @Getter
    private JPanel addCustomerPanel;

    /**
     * Constuctor for AddCustomerController. Runs the showMeTheDialog() methode.
     */
    public AddCustomerController() {
        showMeTheDialog();
    }

    /**
     * Builds the AddCustomerDialog and adds the ActionListener for btnCancel,
     * btnAddCustomer and tfInsuranceNo.
     */
    public void showMeTheDialog() {
        addCustomerDialog = new AddCustomerDialog();

        addCustomerPanel = addCustomerDialog.getAddCustomerPanel();

        addCustomerDialog.getBtnCancel().addActionListener(actionListenerButtonCancel);
        addCustomerDialog.getBtnAddCustomer().addActionListener(actionListenerButtonAddCustomer);
        addCustomerDialog.getTfInsuranceNo().addKeyListener(keyListenerInsuranceNoTextField);

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

            customer.setInsurance(insuranceRepository.findByInsuranceIdNumber(insuranceNo));

            customerRepository.save(customer);

            addCustomerDialog.getAddCustomerDialog().dispose();
        }
    };

    private KeyListener keyListenerInsuranceNoTextField = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            Insurance insurance = insuranceRepository.findByInsuranceIdNumber(addCustomerDialog.getTfInsuranceNo()
                    .getText());
            if (!(insurance == null)) {
                addCustomerDialog.getTfInsuranceName().setText(insurance.getName());
            } else {
                addCustomerDialog.getTfInsuranceName().setText("");
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub

        }
    };

}
