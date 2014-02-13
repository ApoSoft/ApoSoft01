package de.waksh.aposoft.controller;

import de.waksh.aposoft.view.CashboxButtonPanel;
import de.waksh.aposoft.view.CashboxPanel;

public class CashboxController {

    private CashboxPanel panel;
    private CashboxButtonPanel btnPanel;

    public CashboxController() {
        panel = new CashboxPanel(this);
        btnPanel = new CashboxButtonPanel();
    }

    public CashboxPanel getCashboxPanel() {
        return panel;
    }

    public CashboxButtonPanel getCashboxButtonPanel() {
        return btnPanel;
    }
}
