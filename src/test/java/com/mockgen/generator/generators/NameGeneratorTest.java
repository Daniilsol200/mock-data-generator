package com.mockgen.generator.generators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameGeneratorTest {

    @Test
    void generatesNameWithSpace() {
        NameGenerator gen = new NameGenerator();
        String name = gen.generate(new java.util.Random(42));

        assertTrue(name.contains(" "));
        assertTrue(name.split(" ").length == 2);
    }
}