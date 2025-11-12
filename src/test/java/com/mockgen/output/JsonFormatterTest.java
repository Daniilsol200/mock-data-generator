package com.mockgen.output;

import com.mockgen.config.AppConfig;
import org.junit.jupiter.api.Test;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JsonFormatterTest {

    @Test
    void writesValidJsonArray() throws Exception {
        var config = new AppConfig(2, "JSON", List.of(
                new AppConfig.FieldDefinition("id", "int", List.of("1", "100")),
                new AppConfig.FieldDefinition("email", "email", List.of())
        ));

        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        var formatter = new JsonFormatter(config);

        formatter.writeHeader(writer, config.getFields());
        formatter.writeRow(writer, List.of("1", "a@example.com"));
        formatter.writeRow(writer, List.of("2", "b@example.com"));
        formatter.writeFooter(writer);
        writer.flush();

        String json = sw.toString().replaceAll("\\s+", "");
        String expected = "[{\"id\":\"1\",\"email\":\"a@example.com\"},{\"id\":\"2\",\"email\":\"b@example.com\"}]";

        assertEquals(expected, json);
    }
}