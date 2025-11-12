package com.mockgen.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для загрузки и хранения конфигурации приложения из app.properties.
 */
public class AppConfig {
    private static final Pattern FIELD_PATTERN = Pattern.compile("([^:]+):([^\\(]+)(\\(([^)]+)\\))?");

    private final int rowsCount;
    private final String outputFormat;
    private final List<FieldDefinition> fields;

    private AppConfig(int rowsCount, String outputFormat, List<FieldDefinition> fields) {
        this.rowsCount = rowsCount;
        this.outputFormat = outputFormat;
        this.fields = List.copyOf(fields);
    }

    /**
     * Загружает конфигурацию из classpath (src/main/resources/app.properties).
     */
    public static AppConfig load() throws IOException {
        Properties props = new Properties();
        try (InputStream is = AppConfig.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (is == null) throw new IOException("app.properties not found");
            props.load(is);
        }

        int rows = Integer.parseInt(props.getProperty("generator.rows.count", "10000").trim());
        String format = props.getProperty("output.format", "CSV").trim();
        String fieldsStr = props.getProperty("generator.fields", "").trim();

        if (fieldsStr.isEmpty()) throw new IllegalArgumentException("generator.fields is required");

        List<FieldDefinition> fields = parseFields(fieldsStr);
        return new AppConfig(rows, format, fields);
    }

    private static List<FieldDefinition> parseFields(String input) {
        List<FieldDefinition> result = new ArrayList<>();
        for (String part : input.split(",")) {
            Matcher m = FIELD_PATTERN.matcher(part.trim());
            if (!m.matches()) throw new IllegalArgumentException("Invalid field format: " + part);

            String name = m.group(1);
            String type = m.group(2);
            String argsStr = m.group(4);
            List<String> args = argsStr != null ? Arrays.stream(argsStr.split(",")).map(String::trim).toList() : List.of();

            result.add(new FieldDefinition(name, type, args));
        }
        return result;
    }

    public int getRowsCount() { return rowsCount; }
    public String getOutputFormat() { return outputFormat; }
    public List<FieldDefinition> getFields() { return fields; }

    public static class FieldDefinition {
        private final String name;
        private final String type;
        private final List<String> args;

        public FieldDefinition(String name, String type, List<String> args) {
            this.name = name;
            this.type = type;
            this.args = args;
        }

        public String getName() { return name; }
        public String getType() { return type; }
        public List<String> getArgs() { return args; }
    }
}