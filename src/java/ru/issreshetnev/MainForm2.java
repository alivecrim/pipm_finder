package ru.issreshetnev;

import javax.swing.*;
import java.awt.*;

public class MainForm2 extends JFrame {
    private JPanel mainPanel;
    private JTextArea inputFreq;
    private JTextArea outputFreq;
    private JComboBox order;
    private JLabel progressLabel;
    private JButton goButton;

    public MainForm2() throws HeadlessException {
        int WIDTH_ = 1200;
        int HEIGHT_ = 600;
        setSize(WIDTH_, HEIGHT_);
        setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextArea getInputFreq() {
        return inputFreq;
    }

    public JTextArea getOutputFreq() {
        return outputFreq;
    }

    public JComboBox getOrder() {
        return order;
    }

    public JLabel getProgressLabel() {
        return progressLabel;
    }

    public JButton getGoButton() {
        return goButton;
    }
}
