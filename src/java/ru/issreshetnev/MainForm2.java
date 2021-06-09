package ru.issreshetnev;

import javax.swing.*;
import java.awt.*;

public class MainForm2 extends JFrame {
    private JPanel mainPanel;
    private JTextArea inputFreq;
    private JTextArea outputFreq;
    private JComboBox order;
    private JButton goButton;
    private JProgressBar progress;
    private JLabel timeElapsed;
    private JButton stopButton;

    public MainForm2() throws HeadlessException {
        int WIDTH_ = 1200;
        int HEIGHT_ = 600;
        setSize(WIDTH_, HEIGHT_);
        setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
    }

    public JProgressBar getProgress() {
        return progress;
    }

    public JLabel getTimeElapsed() {
        return timeElapsed;
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

    public JButton getGoButton() {
        return goButton;
    }

    public JButton getStopButton() {
        return this.stopButton;
    }
}
