## 📌 Project Overview

This project is a **UI Test Automation Framework** developed using:

- Selenium WebDriver
- Java
- TestNG
- Maven

The framework automates test scenarios for the demo e-commerce website:

🔗 https://tutorialsninja.com/demo/

The website contains typical e-commerce functionality such as:

- User Registration
- Login
- Product search
- Add to cart
- Checkout functionality
- Navigation across categories

This makes it ideal for automation practice and framework development.

---

## 🚀 Features

✅ Page Object Model (POM) Design Pattern  
✅ Cross Browser Testing  
✅ Maven Build Management  
✅ TestNG Execution and Assertions  
✅ HTML Reports (Extent Reports / TestNG Reports)  
✅ Logging using Log4j2  
✅ Screenshot Capture on Failure  
✅ Parallel Execution Support  
✅ Configurable via properties file  
✅ Reusable utilities  

---

## 🌐 Cross Browser Support

This framework supports execution on:

| Browser | Supported |
|--------|-----------|
| Chrome | ✅ |
| Firefox | ✅ |
| Edge | ✅ |

Browser can be selected using:

```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```
---

### 🏗️ Project Structure
```
SeleniumFramework/
│
├── src/
│   ├── test/java/
│   │   ├── base/
│   │   │   └── BaseTest.java
│   │   │
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── HomePage.java
│   │   │   └── RegisterPage.java
│   │   │
│   │   ├── testcases/
│   │   │   ├── LoginTest.java
│   │   │   ├── RegisterTest.java
│   │   │   └── SearchTest.java
│   │   │
│   │   └── utilities/
│   │       ├── ConfigReader.java
│   │       ├── ScreenshotUtil.java
│   │       └── DriverFactory.java
│
├── src/test/resources/
│   ├── config.properties
│   ├── log4j2.xml
│   └── testng.xml
│
├── reports/
├── logs/
├── screenshots/
│
├── pom.xml
└── README.md
```
