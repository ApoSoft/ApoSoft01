package de.waksh.aposoft.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.waksh.aposoft.controller.MainController;

public class MainFrame {

    @SuppressWarnings("unused")
    private MainController controller;
    private JFrame frame;
    private BorderLayout borderLayout = new BorderLayout(0, 0);

    public MainFrame(MainController controller) {
        this.controller = controller;

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(borderLayout);

        frame.getContentPane().add(controller.getNavigationController().getNavigationPanel().getPanel(),
                BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }

    public void setCenter(JPanel panel) {
        if (frame.getContentPane().getComponentCount() >= 2) {
            frame.getContentPane().remove(borderLayout.getLayoutComponent(BorderLayout.CENTER));
            frame.getContentPane().add(panel, BorderLayout.CENTER);
        } else {
            frame.getContentPane().add(panel, BorderLayout.CENTER);
        }
        frame.pack();
    }

    public void setRight(JPanel panel) {
        if (frame.getContentPane().getComponentCount() >= 3) {
            frame.getContentPane().remove(borderLayout.getLayoutComponent(BorderLayout.EAST));
            frame.getContentPane().add(panel, BorderLayout.EAST);
        } else {
            frame.getContentPane().add(panel, BorderLayout.EAST);
        }
        frame.pack();
    }
}