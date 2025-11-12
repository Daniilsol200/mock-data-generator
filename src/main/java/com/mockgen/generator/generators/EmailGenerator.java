package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;

import java.util.random.RandomGenerator;

/**
 * Генерирует случайный email на основе имени.
 */
public class EmailGenerator implements FieldGenerator {

    private static final String[] DOMAINS = {
            "gmail.com", "yandex.ru", "mail.ru", "outlook.com",
            "inbox.ru", "rambler.ru", "bk.ru", "icloud.com"
    };

    @Override
    public String generate(RandomGenerator rng) {
        StringBuilder sb = new StringBuilder();
        // 5-10 случайных букв
        int length = rng.nextInt(5, 11);
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + rng.nextInt(26));
            sb.append(i == 0 ? c : (rng.nextBoolean() ? c : Character.toUpperCase(c)));
        }
        sb.append(rng.nextInt(100));
        sb.append("@");
        sb.append(DOMAINS[rng.nextInt(DOMAINS.length)]);
        return sb.toString();
    }
}