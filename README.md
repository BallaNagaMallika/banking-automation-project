# Banking Management Automation Framework

A Hybrid Automation Testing Framework developed using **Selenium WebDriver**, **TestNG**, and **REST Assured** for automating Banking Application UI and API testing.

---

# Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- REST Assured
- Maven
- Apache POI
- Log4j2
- Extent Reports
- WebDriverManager

---

# Framework Features

## UI Automation

- Login Validation
- User Registration
- Open New Account
- Account Overview Validation
- Negative Scenario Testing
- Screenshot Capture on Failure

## API Automation

- Authentication APIs
- User APIs
- Response Validation
- Status Code Validation
- JSON Payload Handling

## Framework Features

- Page Object Model (POM)
- Reusable Utility Methods
- Configurable Framework
- Extent Reports
- Log4j2 Logging
- Maven Build Management
- Data-Driven Testing Support

---

# Project Structure

```text
bankingManagement/
│
├── pom.xml
├── testng.xml
├── README.md
│
├── logs/
├── reports/
├── screenshots/
│
├── src/
│   ├── main/
│   │   ├── java/com/vit/bankingManagement/
│   │   │
│   │   ├── api/
│   │   ├── base/
│   │   ├── constants/
│   │   ├── listeners/
│   │   ├── pages/
│   │   └── utils/
│   │
│   ├── resources/
│   │   ├── config.properties
│   │   ├── log4j2.xml
│   │   ├── payloads/
│   │   └── testdata/
│   │
│   └── test/
│       └── java/com/vit/bankingManagement/tests/
```

---

# Design Pattern Used

## Page Object Model (POM)

Each page contains:

- Web elements
- Action methods
- Validation methods

### Benefits

- Easy maintenance
- Reusability
- Reduced code duplication
- Better readability

---

# Configuration

## config.properties

```properties
browser=chrome
baseUrl=https://parabank.parasoft.com/parabank/index.htm
apiBaseUrl=https://fakestoreapi.com
username=admin
password=admin
explicitWait=25
```

---

# Reporting

## Extent Reports

Report Location:

```text
reports/ExtentReport.html
```

### Features

- Pass/Fail Summary
- Execution Time
- Failure Screenshots
- Detailed Logs

---

# Logging

Implemented using Log4j2.

Log Location:

```text
logs/execution.log
```

---

# Screenshot Handling

Screenshots are captured automatically during failures.

Location:

```text
screenshots/
```

---

# Prerequisites

Install the following:

- Java 17
- Maven
- Chrome Browser
- Eclipse / IntelliJ IDEA

Verify installation:

```bash
java -version
mvn -version
```

---

# Clone Repository

```bash
git clone https://github.com/your-username/banking-automation-project.git
```

---

# Install Dependencies

```bash
mvn clean install
```

---

# Execute Tests

## Run Complete Suite

```bash
mvn test
```

## Run Specific Test

```bash
mvn -Dtest=LoginTest test
```

## Run Using TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# TestNG Suite

Configured test categories:

- UI Tests
- API Tests
- Integration Tests

---

# Key Maven Dependencies

## Selenium

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.21.0</version>
</dependency>
```

## TestNG

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
</dependency>
```

## REST Assured

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.4.0</version>
</dependency>
```

---

# Utilities Included

- ConfigReader
- ExcelReader
- ExcelWriter
- DateUtils
- ExtentManager
- ResponseValidator

---

# Advantages of Framework

- Scalable Design
- Industry Standard Structure
- Hybrid Automation Support
- Reusable Components
- Easy Maintenance
- Detailed Reporting
- Robust Logging

---

# Future Enhancements

- Parallel Execution
- Jenkins Integration
- Docker Support
- Selenium Grid
- Allure Reporting
- Retry Analyzer
- Database Validation

---

# Troubleshooting

## Browser Launch Issues

- Update Chrome Browser
- Run:

```bash
mvn clean install
```

---

## Dependency Issues

```bash
mvn clean install -U
```

---

# Author

Automation Testing Framework

Developed using Selenium + TestNG + REST Assured.

---

# Conclusion

This framework demonstrates:

- UI Automation
- API Automation
- Framework Development
- Reporting & Logging
- Real-world Enterprise Automation Architecture
