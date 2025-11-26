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
# 1. Скачать проект
# Перейдите на https://github.com/Daniilsol200/mock-data-generator
# Нажмите зелёную кнопку Code → Download ZIP
# Распакуйте архив в любую папку

# 2. Откройте папку с проектом в терминале
cd путь\к\папке\mock-data-generator

# 3. Первый запуск Gradle (скачает всё необходимое, 1–2 минуты)
# Windows:
gradlew.bat --version
# Mac/Linux:
./gradlew --version

# 4. Собрать исполняемый JAR
gradlew.bat shadowJar        # Windows
# или
./gradlew shadowJar          # Mac/Linux

# → JAR появится здесь:
# build/libs/mock-data-generator-1.0.0.jar

# 5. Запустить приложение
java -jar build\libs\mock-data-generator-1.0.0.jar   # Windows
# или
java -jar build/libs/mock-data-generator-1.0.0.jar   # Mac/Linux
