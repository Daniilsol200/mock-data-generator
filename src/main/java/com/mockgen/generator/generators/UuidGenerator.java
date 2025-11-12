package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;

import java.util.Random;

/**
 * Генерирует случайный UUID.
 */
public class UuidGenerator implements FieldGenerator {
    @Override
    public String generate(Random rng) {
        return java.util.UUID.randomUUID().toString();
    }
}