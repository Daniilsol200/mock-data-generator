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

    private static final Pattern FIELD_PATTERN = Pattern.compile("([^:]+):([^:)]+)(?:\\(([^)]+)\\))?");

    private final int rowsCount;
    private final String outputFormat;
    private final List<FieldDefinition> fields;

    // Публичный конструктор для тестов
    public AppConfig(int rowsCount, String outputFormat, List<FieldDefinition> fields) {
        this.rowsCount = rowsCount;
        this.outputFormat = outputFormat;
        this.fields = List.copyOf(fields);
    }

    public static AppConfig load() throws IOException {
        Properties props = new Properties();
        try (InputStream is = AppConfig.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (is == null) throw new IOException("app.properties not found");
            props.load(is);
        }
        return loadFromProperties(props);
    }

    public static AppConfig load(InputStream inputStream) throws IOException {
        Properties props = new Properties();
        props.load(inputStream);
        return loadFromProperties(props);
    }

    private static AppConfig loadFromProperties(Properties props) {
        int rows = Integer.parseInt(props.getProperty("generator.rows.count", "100").trim());
        String format = props.getProperty("output.format", "CSV").trim();
        String fieldsStr = props.getProperty("generator.fields", "").trim();

        if (fieldsStr.isEmpty()) {
            throw new IllegalArgumentException("generator.fields is required");
        }

        List<FieldDefinition> fields = parseFields(fieldsStr);
        return new AppConfig(rows, format, fields);
    }

    private static List<FieldDefinition> parseFields(String input) {
        List<FieldDefinition> result = new ArrayList<>();
        int start = 0;
        int bracketLevel = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') bracketLevel++;
            else if (c == ')') bracketLevel--;
            else if (c == ',' && bracketLevel == 0) {
                String part = input.substring(start, i).trim();
                if (!part.isEmpty()) {
                    result.add(parseSingleField(part));
                }
                start = i + 1;
            }
        }

        String lastPart = input.substring(start).trim();
        if (!lastPart.isEmpty()) {
            result.add(parseSingleField(lastPart));
        }

        return result;
    }

    private static FieldDefinition parseSingleField(String part) {
        Matcher m = FIELD_PATTERN.matcher(part);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid field format: " + part);
        }

        String name = m.group(1).trim();
        String type = m.group(2).trim();
        String argsStr = m.group(3);
        List<String> args = argsStr != null
                ? Arrays.stream(argsStr.split(",")).map(String::trim).filter(s -> !s.isEmpty()).toList()
                : List.of();

        return new FieldDefinition(name, type, args);
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