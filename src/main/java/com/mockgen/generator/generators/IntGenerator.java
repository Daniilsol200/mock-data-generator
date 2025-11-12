package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;

import java.util.Random;

/**
 * Генерирует случайное целое число в диапазоне [min, max].
 */
public class IntGenerator implements FieldGenerator {
    private final int min;
    private final int max;

    public IntGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String generate(Random rng) {
        int range = max - min + 1;
        return String.valueOf(rng.nextInt(range) + min);
    }
}