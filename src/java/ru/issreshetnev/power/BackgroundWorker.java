package ru.issreshetnev.power;

import ru.issreshetnev.power.bl.CombinationUtils;
import ru.issreshetnev.power.bl.InputFreqRangePack;
import ru.issreshetnev.power.bl.ResultSaver;
import ru.issreshetnev.power.bl.ResultTester;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackgroundWorker extends SwingWorker<Map<Double, String>, Long> {
    private final InputFreqRangePack pack;
    private List<Double> outputDeltaFreqs;
    private int[] orders;
    private Map<Double, String> result = new HashMap<>();

    public BackgroundWorker(List<Double> outputDeltaFreqs, int[] orders, InputFreqRangePack pack) {
        this.outputDeltaFreqs = outputDeltaFreqs;
        this.orders = orders;
        this.pack = pack;
    }

    @Override
    protected Map<Double, String> doInBackground() throws Exception {

        Map<Double, String> combinationMap = new HashMap<>();
        Long fullSize = CombinationUtils.getCombinationNumber(outputDeltaFreqs.size(), orders.length);
        long startTime = System.currentTimeMillis();
        long currentTime;
        long counter = 0;
        int percent = 0;
        long onePercent = fullSize / 100;
        for (double f1 : outputDeltaFreqs) {
            for (double f2 : outputDeltaFreqs) {
                for (int o1 : orders) {
                    for (int o2 : orders) {
                        double minus = CombinationUtils.calcCombinationMinus(f1, f2, o1, o2);
                        double plus = CombinationUtils.calcCombinationPlus(f1, f2, o1, o2);
                        if (minus > 0)
                            combinationMap.put(minus, getStr(f1, f2, o1, o2, true));
                        if (plus > 0) combinationMap.put(plus, getStr(f1, f2, o1, o2, false));
                        counter += 2;
                        if (counter % onePercent == 0) {
                            this.setProgress(percent++);
                        }
                        if (counter % 100000 == 0) {
                            if (this.isCancelled())
                                break;
                            currentTime = System.currentTimeMillis();
                            this.firePropertyChange("workTime", startTime, currentTime);
                        }
                    }
                    if (this.isCancelled()) break;
                }
                if (this.isCancelled()) break;
            }
            if (this.isCancelled()) break;
        }
        this.setProgress(percent);
        this.result = combinationMap;
        return combinationMap;
    }

    @Override
    protected void done() {
        this.firePropertyChange("done", true, true);
        Map<Double, String> result = ResultTester.test(this.result, pack);
        this.firePropertyChange("result", null, result.size());
        if (result.size()>0) {
            ResultSaver.accept(result);
        }
    }

    private String getStr(double f1, double f2, int o1, int o2, boolean b) {
        String sign = (b ? "-" : "+");
        return o1 + "*" + f1 + sign + o2 + "*" + f2;
    }
}
