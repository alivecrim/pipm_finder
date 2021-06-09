package ru.issreshetnev.power;

import org.junit.jupiter.api.Test;
import ru.issreshetnev.power.bl.InputFreqRange;

import static org.junit.jupiter.api.Assertions.*;

class InputFreqRangeTest {
    @Test
    void testInputFreqRangeFreq(){
        InputFreqRange inputFreqRange = new InputFreqRange(10, 20);
        assertTrue(inputFreqRange.test(15));
        assertFalse(inputFreqRange.test(21));
        assertFalse(inputFreqRange.test(9));
    }

}
