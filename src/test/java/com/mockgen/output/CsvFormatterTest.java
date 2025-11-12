package com.mockgen.output;

import com.mockgen.config.AppConfig;
import org.junit.jupiter.api.Test;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CsvFormatterTest {

    @Test
    void writesHeaderAndRowsCorrectly() {
        var config = new AppConfig(2, "CSV", List.of(
                new AppConfig.FieldDefinition("id", "int", List.of("1", "100")),
                new AppConfig.FieldDefinition("name", "name", List.of())
        ));

        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        var formatter = new CsvFormatter(config);

        formatter.writeHeader(writer, config.getFields());
        formatter.writeRow(writer, List.of("1", "John Doe"));
        formatter.writeRow(writer, List.of("2", "Jane Doe"));
        formatter.writeFooter(writer);
        writer.flush();

        // Кроссплатформенное сравнение
        String actual = sw.toString().replace("\r\n", "\n").replace("\r", "\n");
        String expected = "id,name\n1,John Doe\n2,Jane Doe\n";

        assertEquals(expected, actual);
    }
}