package de.waksh.aposoft.view;

import java.awt.BorderLayout;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Getter;

/**
 * 
 * @author ahofmann
 * 
 */

public class MainFrame {

    @Getter
    private JFrame frame;

    @Getter
    private BorderLayout layout = new BorderLayout();

    public MainFrame() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(layout);
    }

    @PostConstruct
    public void postConstruct(JPanel navigationPanel) {
        frame.getContentPane().add(navigationPanel, BorderLayout.WEST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}