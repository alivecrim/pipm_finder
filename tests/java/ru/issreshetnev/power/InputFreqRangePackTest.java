package ru.issreshetnev.power;

import org.junit.jupiter.api.Test;
import ru.issreshetnev.power.bl.InputFreqRange;
import ru.issreshetnev.power.bl.InputFreqRangePack;

import static org.junit.jupiter.api.Assertions.*;

class InputFreqRangePackTest {

    @Test
    void testInputFreqRangePack(){
        InputFreqRangePack inputFreqRangePack = new InputFreqRangePack();
        inputFreqRangePack.add(new InputFreqRange(10,15));
        inputFreqRangePack.add(new InputFreqRange(17,20));
        inputFreqRangePack.add(new InputFreqRange(22,25));
        assertTrue(inputFreqRangePack.test(14));
        assertTrue(inputFreqRangePack.test(18));
        assertTrue(inputFreqRangePack.test(22));
        assertFalse(inputFreqRangePack.test(16));
        assertFalse(inputFreqRangePack.test(21));
        assertFalse(inputFreqRangePack.test(26));
    }

}
