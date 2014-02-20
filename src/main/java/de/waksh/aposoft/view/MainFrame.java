package de.waksh.aposoft.view;

import java.awt.BorderLayout;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.controller.NavigationController;

/**
 * 
 * @author ahofmann
 * 
 */

@Component
public class MainFrame {

    @Autowired
    private NavigationController navigationController;

    private JFrame frame;
    private BorderLayout borderLayout = new BorderLayout(0, 0);

    public MainFrame() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(borderLayout);
    }

    @PostConstruct
    public void postConstruct() {
        frame.getContentPane().add(navigationController.getNavigationPanel().getPanel(), BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }

    public void setCenter(JPanel panel) {
        if (frame.getContentPane().getComponentCount() >= 2) {
            frame.getContentPane().remove(borderLayout.getLayoutComponent(BorderLayout.CENTER));
        }

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
    }

    public void setRight(JPanel panel) {
        if (frame.getContentPane().getComponentCount() >= 3) {
            frame.getContentPane().remove(borderLayout.getLayoutComponent(BorderLayout.EAST));
        }

        frame.getContentPane().add(panel, BorderLayout.EAST);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }
}