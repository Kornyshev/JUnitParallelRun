package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * Абстрактный класс <code>BaseTest</code> служит основой для JUnit 5 тестовых классов.
 * Он предоставляет методы, аннотированные с <code>@BeforeAll</code> и <code>@AfterAll</code>,
 * которые выполняются до и после всех тестов в наследующих классах.
 *
 * <p>Метод <code>beforeAllMethod</code> выполняется один раз перед выполнением всех тестовых методов
 * в наследуемом классе. Обычно он используется для выполнения подготовительных действий, применимых
 * ко всем тестам (например, настройка тестового окружения).</p>
 *
 * <p>Метод <code>afterAllMethod</code> выполняется после завершения всех тестовых методов
 * в наследуемом классе. Этот метод обычно используется для очистки ресурсов или выполнения
 * других действий по завершению тестов.</p>
 *
 * <p>Этот класс предназначен для наследования другими тестовыми классами, где можно определить
 * конкретные тестовые методы.</p>
 */
public abstract class BaseTest {

    /**
     * Метод, выполняемый перед началом всех тестов.
     * Аннотирован с <code>@BeforeAll</code> для обеспечения его выполнения перед всеми тестами.
     */
    @BeforeAll
    static void beforeAllMethod() {
        System.out.println("beforeAllMethod()");
    }

    /**
     * Метод, выполняемый после завершения всех тестов.
     * Аннотирован с <code>@AfterAll</code> для обеспечения его выполнения после всех тестов.
     */
    @AfterAll
    static void afterAllMethod() {
        System.out.println("\nafterAllMethod()");
    }

}
