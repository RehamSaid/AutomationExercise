# Automation Exercise – Web Automation Final Project

## Project Description

An end-to-end web automation framework for the [Automation Exercise](https://automationexercise.com) website, built with **Java, Selenium WebDriver, TestNG and Cucumber (BDD)** using the **Page Object Model (POM)**.
It validates the site's critical functionality: user registration, login/logout, product browsing, cart and checkout, and form submissions. It also includes negative scenarios.

## Technologies Used

- Java 21
- Selenium WebDriver 4
- TestNG
- Cucumber (BDD – Gherkin)
- Maven
- WebDriverManager
- Page Object Model (POM)
- Cucumber HTML / JSON Reports

## Project Structure

```
AutomationExercise
├── pom.xml
├── testng.xml
├── reports/                          ← put the generated Cucumber report here before pushing
└── src
    ├── main/java
    │   ├── driver
    │   │   └── Driver.java           ← browser setup / quit (chrome | firefox | edge)
    │   ├── pages                     ← Page Object Model
    │   │   ├── BasePage.java         ← waits, safe click, ad handling
    │   │   ├── HomePage.java
    │   │   ├── LoginPage.java
    │   │   ├── SignupPage.java
    │   │   ├── AccountInformationPage.java
    │   │   ├── AccountCreatedPage.java
    │   │   ├── TestCasesPage.java
    │   │   ├── ProductsPage.java
    │   │   ├── ProductDetailsPage.java
    │   │   ├── CartPage.java
    │   │   ├── CheckoutPage.java
    │   │   ├── PaymentPage.java
    │   │   ├── OrderPlacedPage.java
    │   │   └── ContactUsPage.java
    │   └── utils
    │       └── ConfigReader.java
    └── test
        ├── java
        │   ├── hooks/Hooks.java      ← open/close browser, screenshot on failure
        │   ├── runner
        │   │   ├── CucumberTestRunner.java
        │   │   └── TestRunner.java   ← same scenarios as plain TestNG tests
        │   └── stepDefinitions/      ← one class per feature + CommonSteps
        └── resources
            ├── config.properties     ← browser, URL, test account
            ├── files/upload-test.txt ← file used by Contact Us upload
            └── features/             ← 15 .feature files
```

## Test Scenarios

### Positive
| # | Scenario | Feature file | Expected result |
|---|----------|--------------|-----------------|
| 1 | Register new user | `register.feature` | "ACCOUNT CREATED!" |
| 2 | Login with valid credentials | `login.feature` | "Logged in as &lt;username&gt;" |
| 3 | Add products to cart & checkout | `addProductToCart.feature` | "Added!" → address validated → "ORDER PLACED!" |
| 4 | Contact Us form | `contactUs.feature` | "Success! Your details have been submitted successfully." |
| 5 | Test Cases page | `testCases.feature` | "TEST CASES" page loads |
| 6 | All products & product details | `products.feature` | "ALL PRODUCTS" + name, category, price, availability, condition, brand |
| 7 | Logout | `logout.feature` | Redirected to Login / Signup page |
| 8 | Login with incorrect data | `invalidLogin.feature` | "Your email or password is incorrect!" |

### Negative
| Scenario | Feature file | Expected result |
|----------|--------------|-----------------|
| Signup with existing email | `signupWithExistingEmail.feature` | "Email Address already exist!" |
| Login with incorrect password | `loginWithIncorrectPassword.feature` | "Your email or password is incorrect!" |
| Checkout with empty cart | `emptyCart.feature` | "Cart is empty!" and no Proceed To Checkout button |
| Invalid Contact Us submission (no email) | `invalidContactUs.feature` | Browser validation message, stays on page |
| Invalid search text | `searchProduct.feature` | "SEARCHED PRODUCTS" with 0 results |
| Invalid payment info (empty card number) | `invalidPayment.feature` | Validation message, stays on payment page |
| Checkout without login | `checkoutWithoutLogin.feature` | "Register / Login account to proceed on checkout." |

## Setup (do this once)

1. Install **JDK 21** and **Maven** (or just use IntelliJ IDEA, which bundles Maven).
2. Nothing else: before the first scenario, `utils/TestAccount` creates the account from
   `src/test/resources/config.properties` through the site's API (API 11 – createAccount)
   if it doesn't exist yet. Login, checkout, logout and two negative scenarios use this account.
   The browser driver is downloaded automatically by Selenium Manager to match your Chrome version.

## How To Run

**IntelliJ IDEA:** open the project → let Maven download dependencies → right-click
`CucumberTestRunner` → *Run*. (Right-click `TestRunner` to run the plain TestNG version.)

**Command line:**
```bash
mvn clean test                                  # all Cucumber scenarios
mvn clean test -Dbrowser=firefox                # another browser
mvn clean test -Dheadless=true                  # no browser window
mvn clean test -Dcucumber.filter.tags="@negative"   # only negative scenarios
mvn clean test -Dcucumber.filter.tags="@smoke"      # register, login, checkout
```

## Report

After execution the reports are generated in:

```
target/cucumber-report.html
target/cucumber-report.json
```

Failed scenarios include a screenshot inside the HTML report.
Copy `target/cucumber-report.html` into the `reports/` folder before pushing to GitHub.

## Author

Reham Said Elshakra

## Demo Video

_Add your demo video link here._
