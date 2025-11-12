package com.mockgen;

import com.mockgen.config.AppConfig;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    @Test
    void parsesFieldsWithArgsCorrectly() throws Exception {
        String props = """
                generator.rows.count=10
                output.format=CSV
                generator.fields=id:int(1,100),user_name:name,user_email:email
                """;

        try (var is = new ByteArrayInputStream(props.getBytes(StandardCharsets.UTF_8))) {
            AppConfig config = AppConfig.load(is);

            assertEquals(10, config.getRowsCount());
            assertEquals("CSV", config.getOutputFormat());
            assertEquals(3, config.getFields().size());

            var f1 = config.getFields().get(0);
            assertEquals("id", f1.getName());
            assertEquals("int", f1.getType());
            assertEquals(List.of("1", "100"), f1.getArgs());
        }
    }
}