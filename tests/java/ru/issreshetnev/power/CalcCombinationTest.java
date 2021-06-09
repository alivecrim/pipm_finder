package ru.issreshetnev.power;

import org.junit.jupiter.api.Test;
import ru.issreshetnev.power.bl.CombinationUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcCombinationTest {
    @Test
    void estimateNumberOfElementaryHarmonics() {
        // given
        double centerFreq = 20010e6;
        double band = 20e6;
        double deltaFreq = 1e3;
        List<Double> freqList = CombinationUtils.produceOutputFrequencyList(centerFreq, band, deltaFreq);
        assertEquals(20001, freqList.size());
    }

    @Test
    void calcNumberOfCombination() {
        int harmonicOrder;
        Long numberOfCombinations;
        long numberOfElementaryHarmonics;

        harmonicOrder = 2;
        numberOfElementaryHarmonics = 2;
        numberOfCombinations = CombinationUtils.getCombinationNumber(numberOfElementaryHarmonics, harmonicOrder);
        assertEquals(32, numberOfCombinations);

        harmonicOrder = 3;
        numberOfElementaryHarmonics = 3;
        numberOfCombinations = CombinationUtils.getCombinationNumber(numberOfElementaryHarmonics, harmonicOrder);
        assertEquals(81 * 2, numberOfCombinations);
    }


    @Test
    void createMainCombinationMethod() {
        int[] arr = new int[]{6, 10, 20};
        int[] order = new int[]{1, 2, 3};
        int counter = 0;
        for (int f = 0; f < arr.length; f++) {
            for (int s = 0; s < arr.length; s++) {
                for (int fo = 0; fo < order.length; fo++) {
                    for (int so = 0; so < order.length; so++) {
                        System.out.println(String.format("%s*%s + %s*%s", order[fo], arr[f], order[so], arr[s]));
                        counter++;
                    }
                }
            }
        }
        for (int i : arr) {
            for (int value : arr) {
                for (int item : order) {
                    for (int element : order) {
                        System.out.println(String.format("%s*%s - %s*%s", item, i, element, value));
                        counter++;
                    }
                }
            }
        }

    }
}
