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

### Вариант 1: Через Полную установку проекта локально (рекомендуется)
1. **Скачайте проект**
- Нажмите зелёную кнопку Code → Download ZIP на главной странице
- Распакуйте архив в любую папку

- 2. Откройте папку с проектом в удобной среде разработки(Рекомундуеться использовать Idea Intellij)

- 3. Первый запуск потребует создать app.properties для корректной работы приложения
- (Для данного примера используеться Idea Intellij) Откройте структуру проекта и и кликните правой кнопкой по папке main и создайте директорию resources она выскочит как рекомендованная
- Создайте папку app.properties и вставте код как в примере при желании можете изменить параметры.

- generator.rows.count=10
- output.format=CSV
- generator.fields=id:int(1,100000),user_name:name,user_email:email
  
- 4. Перейдите в папку main и запустите проект нажав на зеленую стрелочку вы увидите выполненную программу в окне терминала

- 5. Для расширения функционала генерации необходимо добавлять новые классы для генерации необходимой информации в директорию generators
  6. 
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
