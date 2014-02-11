package de.waksh.aposoft.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.waksh.aposoft.controller.MainController;

public class MainFrame {

    private MainController controller;
    private JFrame frame;

    public MainFrame(MainController controller) {
        this.controller = controller;

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        frame.getContentPane().add(controller.getNavigationController().getNavigationPanel().getPanel(),
                BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }

    public void setCenter(JPanel panel) {
        if (frame.getContentPane().getComponentCount() >= 2) {
            frame.getContentPane().remove(2);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
        }
    }

    public void setRight(JPanel panel) {
        if (frame.getContentPane().getComponentCount() >= 3) {
            frame.getContentPane().remove(3);
            frame.getContentPane().add(panel, BorderLayout.EAST);
        }
    }

}