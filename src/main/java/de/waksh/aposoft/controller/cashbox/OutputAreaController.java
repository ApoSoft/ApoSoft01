package de.waksh.aposoft.controller.cashbox;

import de.waksh.aposoft.view.cashbox.OutputAreaPanel;

public class OutputAreaController {
    private OutputAreaPanel outputAreaPanel;

    public OutputAreaController() {
        outputAreaPanel = new OutputAreaPanel(this);
    }

    public OutputAreaPanel getOutputAreaPanel() {
        return outputAreaPanel;
    }
}
