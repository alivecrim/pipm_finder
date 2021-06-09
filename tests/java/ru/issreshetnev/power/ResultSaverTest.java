package ru.issreshetnev.power;

import org.junit.jupiter.api.Test;
import ru.issreshetnev.power.bl.ResultSaver;

class ResultSaverTest {
    @Test
    void equationTester() {
        ResultSaver.Equation equation = ResultSaver.eqParse("3*2.062422E10 - 1*3.2708E10");

    }

}
