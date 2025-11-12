package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;
import java.util.random.RandomGenerator;

/**
 * Генерирует случайный UUID.
 */
public class UuidGenerator implements FieldGenerator {
    @Override
    public String generate(RandomGenerator rng) {
        return java.util.UUID.randomUUID().toString();
    }
}