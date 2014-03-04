package de.waksh.aposoft.view;

import java.awt.BorderLayout;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Getter;

/**
 * The main frame consisting of navigation panel, main content and sub-menu
 * 
 * @author Artem Hofmann
 * 
 */

public class MainFrame {

    @Getter
    private JFrame frame;

    @Getter
    private BorderLayout layout = new BorderLayout();

    /**
     * Construct a new MainFrame, initializing a new JFrame and setting up the
     * layout
     */
    public MainFrame() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(layout);
    }

    /**
     * Initialize the panel after dependency injection is finished
     * 
     * @param navigationPanel
     *            the initialized panel of the NavigationPanel
     */
    @PostConstruct
    public void postConstruct(JPanel navigationPanel) {
        frame.getContentPane().add(navigationPanel, BorderLayout.WEST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}