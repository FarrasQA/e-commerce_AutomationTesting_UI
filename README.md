# E-Commerce UI Automation Testing

## Project Description

This project is an automated UI testing framework for an e-commerce web application using Selenium WebDriver and TestNG.

The test scenario is implemented on the following website:
https://practice.expandtesting.com/bookstore/

The main test scenario covers an end-to-end purchase flow, including:

* User login
* Navigate to product page
* Add product to cart
* Checkout process
* Payment form submission
* Purchase validation

---

## How to Run (Smoke Test)

This project uses a TestNG suite file (`smoke.xml`) to execute smoke tests.

### Run via Terminal (Gradle)

```bash
./gradlew test -Psuite="smoke.xml"
```

---

## Key Features

* Page Object Model (POM)
* Custom BasePage (safeClick, safeType, explicit waits)
* No `Thread.sleep` (optimized with WebDriverWait)
* Reusable and scalable structure
* Smoke test grouping with TestNG
