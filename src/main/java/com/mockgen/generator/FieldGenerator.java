package com.mockgen.generator;

import java.util.random.RandomGenerator;

/**
 * Интерфейс для генераторов значений полей.
 */
@FunctionalInterface
public interface FieldGenerator {
    String generate(RandomGenerator rng);
}