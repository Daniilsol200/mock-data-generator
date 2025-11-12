package com.mockgen.generator.generators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntGeneratorTest {

    @Test
    void generatesNumberInRange() {
        IntGenerator gen = new IntGenerator(10, 20);
        String result = gen.generate(new java.util.Random(0)); // фиксированный seed

        int value = Integer.parseInt(result);
        assertTrue(value >= 10 && value <= 20);
    }
}