package ru.issreshetnev.power.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class CombinationEntitySupplier implements Supplier<Map<Double, String>> {
    private List<Double> outputDeltaFreqs;
    private int[] orders;

    public CombinationEntitySupplier(List<Double> outputDeltaFreqs, int[] orders) {
        this.outputDeltaFreqs = outputDeltaFreqs;
        this.orders = orders;
    }

    @Override
    public Map<Double, String> get() {
        Map<Double, String> combinationMap = new HashMap<>();
        Long combinationNumber = CombinationUtils.getCombinationNumber(outputDeltaFreqs.size(), orders.length);
        System.out.println("Combination number:\t" + combinationNumber);
        long startTime = System.currentTimeMillis();
        for (double f1 : outputDeltaFreqs) {
            for (double f2 : outputDeltaFreqs) {
                for (int o1 : orders) {
                    for (int o2 : orders) {
                        double minus = CombinationUtils.calcCombinationMinus(f1, f2, o1, o2);
                        double plus = CombinationUtils.calcCombinationPlus(f1, f2, o1, o2);
                        if (minus > 0) combinationMap.put(minus, getStr(f1, f2, o1, o2, true));
                        if (plus > 0) combinationMap.put(plus, getStr(f1, f2, o1, o2, false));
                    }
                }
            }
        }
        System.out.println("Execute time:\t\t" + (System.currentTimeMillis() - startTime) / 1000.0);
        return combinationMap;
    }

    private String getStr(double f1, double f2, int o1, int o2, boolean b) {
        String sign = (b ? "-" : "+");
        return o1 + "*" + f1 + sign + o2 + "*" + f2;
    }
}
