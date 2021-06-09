package ru.issreshetnev.power;

import ru.issreshetnev.MainForm2;

import javax.swing.*;

public class MainWindowController {
    MainForm2 mainForm;
    JButton startButton;
    JTextArea inputFreqs;
    JTextArea outputFreqs;
    JComboBox order;
    JLabel progressLabel;

    public MainWindowController() {
        this.mainForm = new MainForm2();
        this.inputFreqs = this.mainForm.getInputFreq();
        this.outputFreqs = this.mainForm.getOutputFreq();
        this.order = this.mainForm.getOrder();
        this.startButton = this.mainForm.getGoButton();
        progressLabel = this.mainForm.getProgressLabel();
        initListeners();
    }

    private void initListeners() {
        startButton.addActionListener(new MakeFind(inputFreqs, outputFreqs, order, progressLabel));
    }

    public void show() {
        this.mainForm.setVisible(true);
    }
}
