# Selenium Java Fortis

Automated testing framework built with **Selenium WebDriver**, **Cucumber**, and **JUnit**, designed to validate date generation logic through browser automation.

This project follows the **Page Object Model (POM)** design pattern and integrates utilities for scalability and maintainability.

---

## 🚀 Features
- Java-based test automation with **Cucumber BDD**.
- **Selenium WebDriver** integration for browser automation.
- **WebDriverManager** for automatic driver setup.
- **Page Object Model (POM)** for maintainable test structure.
- **Log4j2** for logging.
- Executable via **Maven** or directly in an IDE.

---

## 📂 Project Structure
```
src
 └── main
      ├── java
      │    ├── Actions/           # Encapsulates user actions
      │    ├── BrowserFactory/    # Driver initialization & hooks
      │    ├── Pages/             # Page Object classes with locators
      │    ├── Runner/            # Cucumber Test Runner
      │    ├── StepDefinitions/   # Step definitions for Cucumber
      │    └── Utils/             # Utility classes (click, sendKeys, select)
      └── resources/
           └── log4j2.xml         # Logging configuration
test
 └── resources/
      ├── features/               # Cucumber feature files
      └── application.properties  # Configurations
```

---

## ⚙️ Requirements
- **Java 17**
- **Maven 3.9.6+**
- **Google Chrome (latest)**

---

## ▶️ Running the Tests
You can run the tests in two ways:

### 1) From the command line (Maven)
```bash
mvn clean test
```

### 2) From your IDE
Simply run the class:

```
Runner/TestRunner.java
```

By default, Cucumber executes scenarios tagged with `@VerifyingDates`.

---

## 🧪 Example Test Flow
- Access initial page
- Submit values based on test criteria
- Validate if the results meet expectations

---

## 📖 Tech Stack
- **Language:** Java
- **Test Framework:** Cucumber + JUnit
- **Automation:** Selenium WebDriver
- **Dependency Management:** Maven
- **Driver Management:** WebDriverManager
- **Logging:** Log4j2

---

## 🔮 Future Improvements
- Add support for **parallel test execution**.
- Extend reporting with **Allure** or **Extent Reports**.
- Expand test coverage with additional feature files.