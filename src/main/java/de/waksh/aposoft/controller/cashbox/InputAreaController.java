package de.waksh.aposoft.controller.cashbox;

import de.waksh.aposoft.view.cashbox.InputAreaPanel;

public class InputAreaController {
    private InputAreaPanel inputAreaPanel;

    public InputAreaController() {
        inputAreaPanel = new InputAreaPanel(this);
    }

    public InputAreaPanel getInputAreaPanel() {
        return inputAreaPanel;
    }
}
