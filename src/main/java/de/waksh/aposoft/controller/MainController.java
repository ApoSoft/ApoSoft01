package de.waksh.aposoft.controller;

import org.springframework.stereotype.Component;

import de.waksh.aposoft.view.MainFrame;

@Component
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
