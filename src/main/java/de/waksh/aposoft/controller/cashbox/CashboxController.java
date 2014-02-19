package de.waksh.aposoft.controller.cashbox;

import org.springframework.stereotype.Component;

import de.waksh.aposoft.controller.CustomerController;
import de.waksh.aposoft.view.cashbox.CashboxButtonPanel;
import de.waksh.aposoft.view.cashbox.CashboxPanel;

@Component
public class CashboxController {

    private InputAreaController inputAreaController;
    private OutputAreaController outputAreaController;
    private CustomerController customerController;

    private CashboxPanel cashboxPanel;
    private CashboxButtonPanel cashboxButtonPanel;

    public CashboxController() {
        inputAreaController = new InputAreaController();
        outputAreaController = new OutputAreaController();
        customerController = new CustomerController();

        cashboxPanel = new CashboxPanel(this);
        cashboxButtonPanel = new CashboxButtonPanel();

    }

    public CashboxPanel getCashboxPanel() {
        return cashboxPanel;
    }

    public CashboxButtonPanel getCashboxButtonPanel() {
        return cashboxButtonPanel;
    }

    public InputAreaController getInputAreaController() {
        return inputAreaController;
    }

    public OutputAreaController getOutputAreaController() {
        return outputAreaController;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

}
