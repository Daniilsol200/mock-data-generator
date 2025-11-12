package com.mockgen.output;

import com.mockgen.config.AppConfig;

import java.io.PrintWriter;
import java.util.List;

/**
 * Интерфейс для форматирования вывода данных (CSV, JSON и др.).
 */
public interface OutputFormatter {

    /**
     * Записывает заголовок (например, имена колонок в CSV).
     */
    void writeHeader(PrintWriter writer, List<AppConfig.FieldDefinition> fields);

    /**
     * Записывает одну строку данных.
     */
    void writeRow(PrintWriter writer, List<String> values);

    /**
     * Записывает завершающую часть (например, закрывающую скобку в JSON).
     */
    void writeFooter(PrintWriter writer);
}