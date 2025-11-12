package com.mockgen.generator;

import com.mockgen.config.AppConfig;
import com.mockgen.output.CsvFormatter;
import org.junit.jupiter.api.Test;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DataGeneratorTest {

    @Test
    void generatesCorrectNumberOfRows() {
        var config = new AppConfig(3, "CSV", List.of(
                new AppConfig.FieldDefinition("id", "int", List.of("1", "100"))
        ));

        DataGenerator generator = new DataGenerator(config);
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        var formatter = new CsvFormatter(config);

        generator.generate(writer, formatter);
        writer.flush();

        String[] lines = sw.toString().split("\n");
        assertEquals(4, lines.length); // заголовок + 3 строки
        assertEquals("id", lines[0].trim());
    }
}