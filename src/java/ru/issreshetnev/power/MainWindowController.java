package ru.issreshetnev.power;

import ru.issreshetnev.MainForm2;

import javax.swing.*;

public class MainWindowController {
    MainForm2 mainForm;
    JButton startButton;
    JTextArea inputFreqs;
    JTextArea outputFreqs;
    JComboBox order;
    JProgressBar progress;
        JLabel timeElapsed;

    public MainWindowController() {
        this.mainForm = new MainForm2();
        this.inputFreqs = this.mainForm.getInputFreq();
        this.outputFreqs = this.mainForm.getOutputFreq();
        this.order = this.mainForm.getOrder();
        this.startButton = this.mainForm.getGoButton();
        timeElapsed = this.mainForm.getTimeElapsed();
        progress = this.mainForm.getProgress();
        initListeners();
    }

    private void initListeners() {
        MakeFind l = new MakeFind(this.mainForm);
        startButton.addActionListener(l);
        this.mainForm.getStopButton().addActionListener(new StopFind(l));
    }

    public void show() {
        this.mainForm.setVisible(true);
    }
}
