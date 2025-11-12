package com.mockgen.generator;

import com.mockgen.config.AppConfig;
import com.mockgen.generator.generators.*;
import com.mockgen.output.OutputFormatter;

import java.io.PrintWriter;
import java.util.*;
import java.util.random.RandomGenerator;

/**
 * Основной класс генерации данных.
 */
public class DataGenerator {
    private final AppConfig config;
    private final List<FieldGenerator> generators;
    private final RandomGenerator rng;

    public DataGenerator(AppConfig config) {
        this.config = config;
        this.rng = RandomGenerator.getDefault();
        this.generators = buildGenerators(config.getFields());
    }

    private List<FieldGenerator> buildGenerators(List<AppConfig.FieldDefinition> fields) {
        List<FieldGenerator> list = new ArrayList<>();
        for (var field : fields) {
            list.add(switch (field.getType()) {
                case "uuid" -> new UuidGenerator();
                case "name" -> new NameGenerator();
                case "email" -> new EmailGenerator();
                case "int" -> {
                    if (field.getArgs().size() != 2) throw new IllegalArgumentException("int requires min,max");
                    int min = Integer.parseInt(field.getArgs().get(0));
                    int max = Integer.parseInt(field.getArgs().get(1));
                    yield new IntGenerator(min, max);
                }
                default -> throw new IllegalArgumentException("Unknown type: " + field.getType());
            });
        }
        return list;
    }

    /**
     * Генерирует N строк и выводит через formatter.
     */
    public void generate(PrintWriter writer, OutputFormatter formatter) {
        formatter.writeHeader(writer, config.getFields());
        for (int i = 0; i < config.getRowsCount(); i++) {
            List<String> values = generators.stream()
                    .map(g -> g.generate(rng))
                    .toList();
            formatter.writeRow(writer, values);
        }
        formatter.writeFooter(writer);
    }
}