# JUnit Parallel Execution Exploration

This project is designed for educational purposes, focusing on the exploration of parallel execution in JUnit 5. It's aimed at understanding and experimenting with various parallel execution options available in JUnit 5, without any specific business application.

## Parallel Execution Properties

In this project, we configure parallel execution in JUnit 5 using the following properties in the `junit-platform.properties` file:

- `junit.jupiter.execution.parallel.enabled = true`: Enables parallel execution in JUnit 5.
- `junit.jupiter.execution.parallel.mode.default = concurrent`: Sets the default execution mode to concurrent for all methods.
- `junit.jupiter.execution.parallel.mode.classes.default = concurrent`: Allows concurrent execution for classes.
- *Commented out alternatives for different execution modes*:
    - `#junit.jupiter.execution.parallel.mode.default = same_thread`
    - `#junit.jupiter.execution.parallel.mode.classes.default = concurrent`
    - `#junit.jupiter.execution.parallel.mode.default = concurrent`
    - `#junit.jupiter.execution.parallel.mode.classes.default = same_thread`
- `junit.jupiter.execution.parallel.config.strategy = dynamic`: Adopts a dynamic strategy for parallelism.
- `junit.jupiter.execution.parallel.config.dynamic.factor = 10.0`: Sets the dynamic factor to 10.0 for parallel execution.
- *Commented out option for fixed strategy*:
    - `#junit.jupiter.execution.parallel.config.strategy = fixed`
    - `#junit.jupiter.execution.parallel.config.fixed.parallelism = 2`

## Console Log Summary

The console log from test executions demonstrates parallel execution behavior. It includes:

- Multiple `beforeAllMethod()` calls indicating the initialization phase of different test classes.
- `BeforeEachCallback` and `AfterEachCallback` extensions showing the setup and teardown for individual test methods across different classes (`org.example.FirstTest`, `org.example.SecondTest`, `org.example.ThirdTest`).
- Execution of various test methods like `testSum()` and `testSubtract()` in different classes, with some methods inducing sleep (`SLEEP in test...`) to simulate longer execution times.
- Calls to `beforeEachMethod()` and `afterEachMethod()`, linked to specific test classes, indicating the lifecycle of each test.
- The concluding `afterAllMethod()` calls, marking the end of the test executions for each class.

This log effectively illustrates the parallel and concurrent execution capabilities of JUnit 5 under the configured settings.

## JUnit 5 + Allure integration

- In this project, Allure Report is implemented as a powerful tool for test reporting and analysis. It is integrated using the `allure-junit5` dependency, which allows Allure to work seamlessly with JUnit 5 tests. To generate the Allure reports, test results are collected in the `target/allure-results` directory, as configured in the `maven-surefire-plugin`. This configuration ensures that all necessary data for report generation is available after test execution.

- To generate a full-fledged Allure report, the command `mvn site` can be used, which may be a part of the complete Maven lifecycle like `mvn clean test site`. This process compiles the raw data from `target/allure-results` into a comprehensive report. The `mvn site` command is especially useful when you need to publish the entire report, possibly on an internal server for demonstration to management or other stakeholders.

- However, for continuous integration environments like Jenkins, it's not mandatory to generate the full report during the build process. Instead, the Allure plugin in Jenkins can be configured to point to the raw data folder. This plugin will then automatically generate and publish the Allure report within Jenkins, providing convenient access to the results with a link.

- This setup, as evident from the project's `pom.xml` file, shows a clean and efficient integration of Allure with JUnit 5, leveraging Maven's capabilities to handle dependencies and plugins, thereby simplifying the process of test execution and reporting.