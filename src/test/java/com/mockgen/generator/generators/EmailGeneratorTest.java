package com.mockgen.generator.generators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailGeneratorTest {

    @Test
    void generatesEmailWithAtSymbol() {
        EmailGenerator gen = new EmailGenerator();
        String email = gen.generate(new java.util.Random(123));

        assertTrue(email.contains("@"));
        assertTrue(email.contains("."));
        assertTrue(email.length() > 10);
    }
}