package com.mockgen.generator.generators;

import com.mockgen.generator.FieldGenerator;

import java.util.Random;

/**
 * Generates a random first name and last name in English.
 */
public class NameGenerator implements FieldGenerator {

    private static final String[] FIRST_NAMES = {
            "James", "Emma", "Michael", "Olivia", "William", "Ava", "Alexander", "Sophia",
            "Daniel", "Isabella", "Matthew", "Mia", "Joseph", "Charlotte", "David", "Amelia",
            "John", "Harper", "Robert", "Evelyn", "Christopher", "Abigail", "Andrew", "Emily"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
            "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson", "White"
    };

    @Override
    public String generate(Random rng) {
        String firstName = FIRST_NAMES[rng.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[rng.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
}