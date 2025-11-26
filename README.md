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
Нажмите зелёную кнопку Code → Download ZIP на главной странице
Распакуйте архив в любую папку

2. **Откройте проект**
Откройте папку с проектом в удобной среде разработки(Рекомундуеться использовать Idea Intellij)
File → Open → выберите распакованную папку → OK

3. **Добвление**
Первый запуск потребует создать app.properties для корректной работы приложения
(Для данного примера используеться Idea Intellij) В дереве проекта:`src → main → правый клик → New → Directory → resources` (IDEA подсветит как рекомендуемую)  
 → В папке `resources`: правый клик → New → File → назовите `app.properties`

Вставьте в него пример конфигурации (можно менять под свои нужды):
```
generator.rows.count=10
output.format=CSV
generator.fields=id:int(1,100000),user_name:name,user_email:email
```

4. **Запуск**
Откройте файл src/main/java/com/mockgen/Main.java
Нажмите зеленую стрелочку в верхней панели или нажмите Shift + F10
