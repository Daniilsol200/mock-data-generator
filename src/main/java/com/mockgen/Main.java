package com.mockgen;

import com.mockgen.config.AppConfig;
import com.mockgen.generator.DataGenerator;
import com.mockgen.output.CsvFormatter;
import com.mockgen.output.JsonFormatter;
import com.mockgen.output.OutputFormatter;

import java.io.PrintWriter;

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
            System.err.println("Error1: " + e.getMessage());
            e.printStackTrace();
        }
    }
}