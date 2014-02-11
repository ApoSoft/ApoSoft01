package de.waksh.aposoft.controller;

import de.waksh.aposoft.view.CashboxPanel;

public class CashboxController {

    private CashboxPanel panel;

    public CashboxController() {
        panel = new CashboxPanel(this);
    }

    public CashboxPanel getCashboxPanel() {
        return panel;
    }
}
