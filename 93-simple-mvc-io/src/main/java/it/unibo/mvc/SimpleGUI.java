package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    final JFrame frame = new JFrame("My first java graphical interface");

    public SimpleGUI(final Controller controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    final String content = textArea.getText();
                    controller.inputString(content);
                    JOptionPane.showMessageDialog(frame, "File saved succesfully!");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        final Controller controller = new Controller();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleGUI(controller);
            }
        });
    }

}
