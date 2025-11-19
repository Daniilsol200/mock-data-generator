package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;

import java.util.Random;

/**
 * Генерирует случайные целые числа в заданном диапазоне [min, max].
 *
 * <p>Если границы не указаны, используется диапазон [0, 1000].
 *
 * <p>Примеры конфигурации:
 * <ul>
 *   <li>{@code id:int} → [0, 1000]</li>
 *   <li>{@code age:int(18,99)} → [18, 99]</li>
 * </ul>
 *
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