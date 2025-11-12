package com.mockgen.generator.generators;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class UuidGeneratorTest {

    @Test
    void generatesValidUUID() {
        UuidGenerator gen = new UuidGenerator();
        String uuid = gen.generate(new java.util.Random());

        assertDoesNotThrow(() -> UUID.fromString(uuid));
        assertEquals(36, uuid.length());
    }
}