package ru.issreshetnev.power.bl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InputFreqRangePack {
    List<InputFreqRange> range = new LinkedList<>();

    public boolean test(double combinationFrequency) {
        List<Boolean> collect = range.stream().map(r -> r.test(combinationFrequency)).filter(res -> res).collect(Collectors.toList());
        return collect.size() > 0;
    }

    public void add(InputFreqRange inputFreqRange) {
        range.add(inputFreqRange);
    }
}
