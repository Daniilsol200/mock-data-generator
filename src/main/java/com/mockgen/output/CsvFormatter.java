package com.mockgen.output;

import com.mockgen.config.AppConfig;

import java.io.PrintWriter;
import java.util.List;

/**
 * Форматирование в CSV.
 */
public class CsvFormatter implements OutputFormatter {
    private final AppConfig config;

    public CsvFormatter(AppConfig config) { this.config = config; }

    @Override
    public void writeHeader(PrintWriter writer, List<AppConfig.FieldDefinition> fields) {
        writer.println(String.join(",", fields.stream().map(AppConfig.FieldDefinition::getName).toList()));
    }

    @Override
    public void writeRow(PrintWriter writer, List<String> values) {
        writer.println(String.join(",", values.stream().map(this::escapeCsv).toList()));
    }

    @Override
    public void writeFooter(PrintWriter writer) {}

    private String escapeCsv(String s) {
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}