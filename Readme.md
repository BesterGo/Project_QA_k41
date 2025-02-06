## ◻ Тест Проект - FoodNow

### ◺ Автор: [BesterGo](https://github.com/BesterGo/_Igor_Dause)

**FoodNow** — это веб-приложение для онлайн-заказа еды.  
Цель проекта — комплексное тестирование FoodNow для обеспечения его качества и надёжности.

---

## ◻ Test Plans and Documentation

- **T[est Plan](https://github.com/BesterGo/QA49_FoodNow_k41#:~:text=Plans%20and%20Documentation-,Test%20Plan,-Test%20Case%20Jira)**
- **Test Case Jira Design Map**
- **TestLink**

---

## ◻ Процесс тестирования

Тестирование началось с ручного тестирования функционала регистрации с использованием различных методик, в том числе:

### ◻ Example of a Bug Report in Jira
- **FE:** QA41-18 The product is added in duplicate
- **ОС:** Windows 10
- **Браузер:** Google Chrome 132.0

### ◻ Описание
Кнопка "Add to Cart" при нажатии на Rump Steak добавляет 2 товара.

### ◻ Steps to reproduce:
1. Перейти на страницу продуктов **MEAT**.
2. Выбрать **Rump Steak** и нажать **"Add to Cart"**.

**Actual result:** Продукт добавляется в корзину дважды.  
**Expected result:** Продукт должен быть добавлен в корзину в одном экземпляре.  
**Приоритет:** Medium  
**Статус:** Backlog

![Скриншот бага](Снимок%20экрана%202025-01-31%20193949.jpg)

---

## ◻ Используемые технологии

В проекте применяются следующие инструменты:

- **Selenium** – автоматизация тестирования пользовательского интерфейса
- **Postman** – тестирование API
- **TestLink** – управление тест-кейсами
- **Jenkins** – CI/CD и автоматический запуск тестов
- **Jira** – управление багами и задачами тестирования
- **Programming Language:** Java 17
- **Build Tool:** Gradle
- **Logging:** Logback Classic 1.5.9
- **Others:** WebDriverManager 5.9.2

Дополнительные возможности:
- Ведение журналов логирования
- Захват снимков экрана для удобного анализа ошибок

---

## ◻ Приложение FoodNow по замыслу предлагает следующие возможности:

- Регистрация и авторизация пользователя
- Просмотр и сортировка продуктов
- Добавление продуктов в корзину
- Оформление заказа
- Онлайн-оплата

---

## ◻ Project Structure

Проект включает в себя ведение журнала и захват скриншотов для облегчения отслеживания ошибок.

### ◺ Ключевые аспекты структуры проекта:

```
/src/main/java/com/foodNow/pages:
    RegisterPage – enterPersonalData()
    LoginPage – loginExistedUser()
    ProductAddPage – clickFoodCategory(), clickAddSteakToCart()
    ShopCartPage – addProductToCart()

/src/test/java/foodNow/tests:
    HomePageTest
    LoginTests
    OrderTests
    ProductAddTests
    RegistrNegativeTests
    RegistrPositiveTests
    ShopCartTests
```

---

## ◻ Required Components

- **Java JDK (17 or higher):** [Download from Oracle](https://www.oracle.com/java/)
- **Gradle:** [Download from Gradle](https://gradle.org/)
- **Git:** [Download and install from Git](https://git-scm.com/)

**Repository:** [FoodNow Repo](https://github.com/BesterGo/QA49_FoodNow_k41.git)

Для сборки проекта установите зависимости:
```sh
./gradlew build  # (или gradlew build в Windows)
```

Файл **build.gradle** должен включать все необходимые зависимости:

```gradle
dependencies {
   implementation 'org.seleniumhq.selenium:selenium-java:4.27.0'
   implementation 'io.cucumber:cucumber-java:7.20.1'
   implementation 'org.testng:testng:7.10.2'
   
   implementation 'ch.qos.logback:logback-classic:1.5.9'
   implementation 'io.github.bonigarcia:webdrivermanager:5.9.2'
   implementation 'io.github.bonigarcia:webdrivermanager:5.6.2'
   
   implementation 'org.seleniumhq.selenium:selenium-java:4.12.0'
   implementation 'net.coobird:thumbnailator:0.4.19'
   testImplementation 'org.testng:testng:7.7.0'
   implementation 'org.seleniumhq.selenium:selenium-java:4.1.0'
   implementation 'org.slf4j:slf4j-api:1.7.36'
   implementation 'ch.qos.logback:logback-classic:1.4.12'
}
```

---

## ◻ Examples of Code Usage

### Метод для создания скриншота
```java
public String takeScreenshot(String testName) {
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String filePath = "test_screenshots/" + testName + "_" + timestamp + ".png";

    try {
        FileUtils.copyFile(screenshot, new File(filePath));
        System.out.println("Screenshot saved: " + filePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return;
}   
   ```
git clone
https://github.com/BesterGo/QA49_FoodNow_k41.git  
