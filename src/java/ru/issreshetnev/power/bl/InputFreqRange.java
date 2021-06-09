package ru.issreshetnev.power.bl;

public class InputFreqRange {
    double start;
    double stop;

    public InputFreqRange(double start, double stop) {
        this.start = start;
        this.stop = stop;
    }

    public InputFreqRange(double center, double band, boolean justForFun) {
        this.start = center - band / 2;
        this.stop = center + band / 2;
    }

    public boolean test(double combinationFrequency) {
        if (combinationFrequency >= start && combinationFrequency <= stop) return true;
        return false;
    }
}
