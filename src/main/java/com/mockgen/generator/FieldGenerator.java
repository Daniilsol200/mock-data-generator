package com.mockgen.generator;

import java.util.Random;

/**
 * Интерфейс для генераторов значений полей.
 */
@FunctionalInterface
public interface FieldGenerator {
    String generate(Random rng);
}