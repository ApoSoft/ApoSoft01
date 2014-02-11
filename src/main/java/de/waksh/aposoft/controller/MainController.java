package de.waksh.aposoft.controller;

import de.waksh.aposoft.view.MainFrame;

public class MainController {

    private NavigationController navigationController;

    private MainFrame mainFrame;

    public MainController() {
        navigationController = new NavigationController(this);
    }

    public void init() {
        mainFrame = new MainFrame(this);
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
