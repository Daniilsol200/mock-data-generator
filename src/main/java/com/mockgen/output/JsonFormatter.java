package com.mockgen.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mockgen.config.AppConfig;

import java.io.PrintWriter;
import java.util.List;

/**
 * Форматирование в JSON-массив объектов.
 */
public class JsonFormatter implements OutputFormatter {

    private final AppConfig config;
    private final ObjectMapper mapper = new ObjectMapper();
    private int rowCount = 0;
    private final int totalRows;

    public JsonFormatter(AppConfig config) {
        this.config = config;
        this.totalRows = config.getRowsCount();
    }

    @Override
    public void writeHeader(PrintWriter writer, List<AppConfig.FieldDefinition> fields) {
        writer.println("[");
    }

    @Override
    public void writeRow(PrintWriter writer, List<String> values) {
        rowCount++;
        ObjectNode node = mapper.createObjectNode();
        List<AppConfig.FieldDefinition> fields = config.getFields();

        for (int i = 0; i < fields.size(); i++) {
            node.put(fields.get(i).getName(), values.get(i));
        }

        try {
            String json = mapper.writeValueAsString(node);
            writer.print("  " + json);
            if (rowCount < totalRows) {
                writer.println(",");
            } else {
                writer.println();
            }
        } catch (Exception e) {
            throw new RuntimeException("JSON serialization error", e);
        }
    }

    @Override
    public void writeFooter(PrintWriter writer) {
        writer.println("]");
    }
}