package ru.issreshetnev.power.bl;

import java.util.HashMap;
import java.util.Map;

public class ResultTester {
    public static Map<Double, String> test(Map<Double, String> wholeResult, InputFreqRangePack pack) {
        Map<Double, String> resultMap = new HashMap<>();
        wholeResult.entrySet().stream().filter(e -> pack.test(e.getKey())).forEach(e -> resultMap.put(e.getKey(), e.getValue()));
        return resultMap;
    }
}
