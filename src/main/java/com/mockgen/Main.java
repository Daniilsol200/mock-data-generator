package com.mockgen;

import com.mockgen.config.AppConfig;
import com.mockgen.generator.DataGenerator;
import com.mockgen.output.CsvFormatter;
import com.mockgen.output.JsonFormatter;
import com.mockgen.output.OutputFormatter;

import java.io.PrintWriter;

/**
 * Генерирует моковые данные согласно конфигурации из app.properties.
 *
 * <p>Программа поддерживает следующие типы полей:
 * <ul>
 *   <li><code>int(min,max)</code> — случайное целое число в диапазоне</li>
 *   <li><code>name</code> — случайное имя и фамилия</li>
 *   <li><code>email</code> — email на основе имени</li>
 *   <li><code>uuid</code> — случайный UUID</li>
 * </ul>
 *
 * <p>Поддерживаемые форматы вывода:
 * <ul>
 *   <li>CSV</li>
 *   <li>JSON</li>
 * </ul>
 *
 * @author Daniilsol200
 * @version 1.0.0
 */

public class Main {
    public static void main(String[] args) {
        try {
            AppConfig config = AppConfig.load();
            DataGenerator generator = new DataGenerator(config);
            OutputFormatter formatter = config.getOutputFormat().equalsIgnoreCase("CSV")
                    ? new CsvFormatter(config)
                    : new JsonFormatter(config);

            try (PrintWriter writer = new PrintWriter(System.out)) {
                generator.generate(writer, formatter);
            }
        } catch (Exception e) {
            System.err.println("Error12: " + e.getMessage());
            e.printStackTrace();
        }
    }
}