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
    @SuppressWarnings("PMD.UnusedPrivateField")
    private JPanel addCustomerPanel;

    private ActionListener actionListenerButtonCancel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addCustomerDialog.getAddCustomerDialog().dispose();
        }
    };

    private ActionListener actionListenerButtonAddCustomer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = addCustomerDialog.getTfFirstName().getText();
            String lastName = addCustomerDialog.getTfLastName().getText();
            String insuranceNo = addCustomerDialog.getTfInsuranceNo().getText();
    
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
        public void keyReleased(KeyEvent e) {
            Insurance insurance = insuranceRepository.findByInsuranceIdNumber(addCustomerDialog.getTfInsuranceNo()
                    .getText());
            addCustomerDialog.getTfInsuranceName().setText((insurance == null) ? "" : insurance.getName());
        }
    
        @Override
        public void keyTyped(KeyEvent e) {
            // unused
        }
    
        @Override
        public void keyPressed(KeyEvent e) {
            // unused
        }
    };

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

}
