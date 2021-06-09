package ru.issreshetnev.power.bl;

import java.util.LinkedList;
import java.util.List;

public class CombinationUtils {
    public static List<Double> produceOutputFrequencyList(double centerFreq, double band, double deltaFreq) {
        LinkedList<Double> freqs = new LinkedList<>();
        double v = band / deltaFreq;
        double start = centerFreq - band / 2;
        double current = 0;
        int counter = 0;
        while (current < start + band) {
            current = start + counter * deltaFreq;
            freqs.add(current);
            counter++;
        }
        return freqs;
    }

    public static Long getCombinationNumber(long numberOfElementaryHarmonics, int harmonicOrder) {
        long l = numberOfElementaryHarmonics * numberOfElementaryHarmonics * harmonicOrder * harmonicOrder * 2;
        return l;
    }

    public static double calcCombinationMinus(double f1, double f2, int o1, int o2) {
        return o1 * f1 - o2 * f2;
    }

    public static double calcCombinationPlus(double f1, double f2, int o1, int o2) {
        return o1 * f1 + o2 * f2;
    }
}
