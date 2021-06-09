package ru.issreshetnev.power;

import ru.issreshetnev.power.bl.CombinationEntitySupplier;
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
    private final JLabel progressLabel;
    private final JTextArea inputFreqsTextArea;
    private final JTextArea outputFreqsTextArea;
    private final JComboBox orderComboBox;

    public MakeFind(JTextArea inputFreqsTextArea, JTextArea outputFreqsTextArea, JComboBox orderComboBox, JLabel progressLabel) {
        this.inputFreqsTextArea = inputFreqsTextArea;
        this.outputFreqsTextArea = outputFreqsTextArea;
        this.orderComboBox = orderComboBox;
        this.progressLabel = progressLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InputFreqRangePack inputFreqs = new InputFreqRangePack();
        String[] inputFreqSplit = this.inputFreqsTextArea.getText().split("\n");
        Arrays.stream(inputFreqSplit).forEach(inputFreqLine -> {
            String[] ifline = inputFreqLine.split(" ");
            inputFreqs.add(new InputFreqRange(Double.parseDouble(ifline[0]), Double.parseDouble(ifline[1]), true));
        });

        Integer orderNumber = Integer.parseInt(Objects.requireNonNull(orderComboBox.getSelectedItem()).toString());
        int[] orders = new int[orderNumber];
        for (int i = orders.length; i >= 1; i--) {
            orders[orders.length - i] = i;
        }
        String[] outputFreqSplit = this.outputFreqsTextArea.getText().split("\n");
        List<Double> outputDeltaFreqs = new LinkedList<>();
        Arrays.stream(outputFreqSplit).map(outputFreqLine -> {
            String[] ofline = outputFreqLine.split(" ");
            return CombinationUtils.produceOutputFrequencyList(Double.parseDouble(ofline[0]), Double.parseDouble(ofline[1]), Double.parseDouble(ofline[2]));
        }).forEach(outputDeltaFreqs::addAll);
        Long allCombinationNumber = CombinationUtils.getCombinationNumber(outputDeltaFreqs.size(), orderNumber);
        this.progressLabel.setText(0+"/"+allCombinationNumber);
//        CombinationEntitySupplier supplier = new CombinationEntitySupplier(outputDeltaFreqs, orders);
//        Map<Double, String> result = ResultTester.test(supplier.get(), inputFreqs);
//        ResultSaver.accept(result);

    }
}
