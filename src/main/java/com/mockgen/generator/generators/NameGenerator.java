package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;

import java.util.random.RandomGenerator;

/**
 * Генерирует случайное имя и фамилию.
 */
public class NameGenerator implements FieldGenerator {

    private static final String[] FIRST_NAMES = {
            "Александр", "Дмитрий", "Максим", "Сергей", "Андрей",
            "Алексей", "Артем", "Илья", "Кирилл", "Михаил",
            "Екатерина", "Анна", "Мария", "Елена", "Ольга",
            "Наталья", "Светлана", "Татьяна", "Юлия", "Ирина"
    };

    private static final String[] LAST_NAMES = {
            "Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов",
            "Попов", "Лебедев", "Козлов", "Новиков", "Морозов",
            "Волкова", "Соловьёва", "Васильева", "Зайцева", "Павлова"
    };

    @Override
    public String generate(RandomGenerator rng) {
        String firstName = FIRST_NAMES[rng.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[rng.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
}