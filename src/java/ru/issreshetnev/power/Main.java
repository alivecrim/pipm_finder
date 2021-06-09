package ru.issreshetnev.power;

import ru.issreshetnev.power.bl.*;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main extends JFrame{

    public static void main(String[] args) {
        MainWindowController uiController = new MainWindowController();
        SwingUtilities.invokeLater(uiController::show);
//        InputFreqRangePack inputFreqs = new InputFreqRangePack();
//        inputFreqs.add(new InputFreqRange(5725e6, 6725e6));
//        inputFreqs.add(new InputFreqRange(12750e6, 14750e6));
//        inputFreqs.add(new InputFreqRange(27000e6, 30000e6));
//
//        int[] orders = new int[]{4, 3, 2, 1};
//        List<Double> doubles1 = CombinationUtils.produceOutputFrequencyList(20255e6, 80e6, 1e6);
//        List<Double> doubles2 = CombinationUtils.produceOutputFrequencyList(20350e6, 80e6, 1e6);
//        List<Double> doubles3 = CombinationUtils.produceOutputFrequencyList(20445e6, 80e6, 1e6);
//        List<Double> doubles4 = CombinationUtils.produceOutputFrequencyList(20540e6, 80e6, 1e6);
//        List<Double> doubles5 = CombinationUtils.produceOutputFrequencyList(20785e6, 234e6, 1e6);
//        List<Double> doubles6 = CombinationUtils.produceOutputFrequencyList(21056e6, 236e6, 1e6);
//        List<Double> doubles7 = CombinationUtils.produceOutputFrequencyList(20624e6, 2e6, 10e3);
//        List<Double> doubles8 = CombinationUtils.produceOutputFrequencyList(32625e6, 234e6, 1e6);
//        List<Double> outputDeltaFreqs = new LinkedList<>();
//
//        outputDeltaFreqs.addAll(doubles1);
//        outputDeltaFreqs.addAll(doubles2);
//        outputDeltaFreqs.addAll(doubles3);
//        outputDeltaFreqs.addAll(doubles4);
//        outputDeltaFreqs.addAll(doubles5);
//        outputDeltaFreqs.addAll(doubles6);
//        outputDeltaFreqs.addAll(doubles7);
//        outputDeltaFreqs.addAll(doubles8);
//
//        CombinationEntitySupplier supplier = new CombinationEntitySupplier(outputDeltaFreqs, orders);
//        Map<Double, String> result = ResultTester.test(supplier.get(), inputFreqs);
//        ResultSaver.accept(result);
    }
}
