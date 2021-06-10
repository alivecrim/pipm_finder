package ru.issreshetnev.power;

import ru.issreshetnev.power.bl.CombinationUtils;
import ru.issreshetnev.power.bl.InputFreqRange;
import ru.issreshetnev.power.bl.InputFreqRangePack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MakeFind implements ActionListener {
    private final MainForm2 mainForm;
    BackgroundWorker backgroundWorker;

    public MakeFind(MainForm2 mainForm) {
        this.mainForm = mainForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InputFreqRangePack inputFreqs = new InputFreqRangePack();
        String[] inputFreqSplit = this.mainForm.getInputFreq().getText().split("\n");
        Arrays.stream(inputFreqSplit).forEach(inputFreqLine -> {
            String[] ifline = inputFreqLine.split(" ");
            inputFreqs.add(new InputFreqRange(Double.parseDouble(ifline[0]), Double.parseDouble(ifline[1]), true));
        });

        Integer orderNumber = Integer.parseInt(Objects.requireNonNull(this.mainForm.getOrder().getSelectedItem()).toString());
        int[] orders = new int[orderNumber];
        for (int i = orders.length; i >= 1; i--) {
            orders[orders.length - i] = i;
        }
        String[] outputFreqSplit = this.mainForm.getOutputFreq().getText().split("\n");
        List<Double> outputDeltaFreqs = new LinkedList<>();
        Arrays.stream(outputFreqSplit).map(outputFreqLine -> {
            String[] ofline = outputFreqLine.split(" ");
            return CombinationUtils.produceOutputFrequencyList(Double.parseDouble(ofline[0]), Double.parseDouble(ofline[1]), Double.parseDouble(ofline[2]));
        }).forEach(outputDeltaFreqs::addAll);

        backgroundWorker = new BackgroundWorker(outputDeltaFreqs, orders, inputFreqs);
        try {
            backgroundWorker.execute();
            this.mainForm.getProgress().setValue(0);
            this.mainForm.getGoButton().setEnabled(false);
            this.mainForm.getStopButton().setEnabled(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        backgroundWorker.addPropertyChangeListener((evt) -> {
            if ("progress".equals(evt.getPropertyName())) {
                this.mainForm.getProgress().setValue((int) evt.getNewValue());
            }
            if ("workTime".equals(evt.getPropertyName())) {
                long timeDiff = ((long) evt.getNewValue()) - ((long) evt.getOldValue());
                this.mainForm.getTimeElapsed().setText(String.format("Прошло %s секунд", timeDiff / 1000.0));
            }
            if (backgroundWorker.isDone()) {
                this.mainForm.getGoButton().setEnabled(true);
                this.mainForm.getStopButton().setEnabled(false);
            }
            if ("result".equals(evt.getPropertyName())) {
                JOptionPane.showMessageDialog(this.mainForm, String.format("Найдено %s комбинашек! Если не 0, то смотри файл result.csv",evt.getNewValue()));
            }
        });
    }

    public void stopFind() {
        this.backgroundWorker.cancel(true);

    }
}
