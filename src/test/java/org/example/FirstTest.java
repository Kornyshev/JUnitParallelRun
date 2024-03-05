package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс <code>AppTest</code> содержит набор тестовых методов для демонстрации различных возможностей JUnit 5.
 * Этот класс расширяет базовый тестовый класс <code>BaseTest</code> и применяет пользовательское расширение <code>CustomAfterExtension</code>
 * для дополнительного поведения после каждого теста.
 */
@ExtendWith(CustomAfterExtension.class)
public class FirstTest extends BaseTest {

    /**
     * Метод, аннотированный <code>@BeforeEach</code>, который выполняется перед каждым тестовым методом.
     * Обычно используется для подготовки тестового окружения (например, инициализации общих ресурсов).
     */
    @BeforeEach
    void beforeEachMethod() {
        System.out.println("beforeEachMethod() -> " + this.getClass().getCanonicalName());
    }

    /**
     * Тестирование метода <code>sum</code> класса <code>Calculator</code>.
     * Следует структуре AAA: Arrange (подготовка данных), Act (выполнение действия), Assert (проверка результата).
     */
    @Test
    @DisplayName("Test sum() method of Calculator")
    public void testSum() throws InterruptedException {
        System.out.println("   testSum() ---> " + this.getClass().getCanonicalName());
        System.out.println("   SLEEP in testSum() ---> " + this.getClass().getCanonicalName());
        Thread.sleep(3000);
        // Arrange
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.sum(a, b);

        // Assert
        assertEquals(8, result, "Sum of 5 and 3 should be 8");
    }

    /**
     * Тестирование метода <code>subtract</code> класса <code>Calculator</code>.
     * Использует структуру AAA для проверки корректности выполнения метода.
     */
    @Test
    @DisplayName("Test subtract() method of Calculator")
    public void testSubtract() throws InterruptedException {
        System.out.println("   testSubtract() ---> " + this.getClass().getCanonicalName());
        System.out.println("   SLEEP in testSubtract() ---> " + this.getClass().getCanonicalName());
        Thread.sleep(3000);
        // Arrange
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(2, result, "Subtraction of 3 from 5 should be 2");
    }

    /**
     * Метод, аннотированный <code>@AfterEach</code>, выполняется после каждого теста.
     * Может использоваться для очистки или завершения действий, начатых в <code>@BeforeEach</code>.
     */
    @AfterEach
    void afterEachMethod() {
        System.out.println("afterEachMethod() -> " + this.getClass().getCanonicalName());
    }

}
