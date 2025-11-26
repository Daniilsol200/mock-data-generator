# Mock Data Generator

**Генератор моковых данных на Java** с поддержкой различных типов полей и вывода в CSV/JSON.

- Чтение конфигурации из app.properties
- Поддержка полей: int(min,max), name, email;
- Вывод в форматах: **CSV** и **JSON**;
- Покрытие тестами (JUnit 5 + Mockito);
- Полная документация кода через **JavaDoc**;
- Сборка **fat JAR** через Shadow Plugin;
- CI/CD на **GitHub Actions** (JDK 11 / 17 / 21, кэширование, публикация артефактов)

## Технологии

- Java 17 (совместимо с 17, 21)
- Gradle 8.14 + Wrapper
- JUnit 5, Mockito
- Shadow JAR
- GitHub Actions

## Запуск

### Вариант 1: Через готовый JAR (рекомендуется)
