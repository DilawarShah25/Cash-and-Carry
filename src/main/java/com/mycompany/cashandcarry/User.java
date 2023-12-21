package com.mycompany.cashandcarry;

package com.mycompany.cashandcarry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CashAndCarryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new CashAndCarryFrame();
            frame.setTitle("Cash and Carry App");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class CashAndCarryFrame extends JFrame {
    private JButton adminButton;
    private JButton customerButton;
    private JButton exitButton;

    public CashAndCarryFrame() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        adminButton = new JButton("Admin");
        adminButton.setBounds(100, 100, 150, 40);

        customerButton = new JButton("Customer");
        customerButton.setBounds(100, 150, 150, 40);

        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 200, 150, 40);

        add(adminButton);
        add(customerButton);
        add(exitButton);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle admin button click
                new AdminFrame().setVisible(true);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle customer button click
                new CustomerFrame().setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle exit button click
                System.exit(0);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle window closing event
                System.exit(0);
            }
        });
    }
}

