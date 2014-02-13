package de.waksh.aposoft.controller;

import de.waksh.aposoft.view.ExtemporaneousProductButtonPanel;
import de.waksh.aposoft.view.ExtemporaneousProductPanel;

public class ExtemporaneousProductController {
    private ExtemporaneousProductPanel panel;
    private ExtemporaneousProductButtonPanel btnPanel;

    public ExtemporaneousProductController() {
        panel = new ExtemporaneousProductPanel(this);
        btnPanel = new ExtemporaneousProductButtonPanel();
    }

    public ExtemporaneousProductPanel getExtemporaneousProductPanel() {
        return panel;
    }

    public ExtemporaneousProductButtonPanel getExtemporaneousProductButtonPanel() {
        return btnPanel;
    }
}
