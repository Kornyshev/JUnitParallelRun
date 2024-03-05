package org.example;

/**
 * Класс <code>Calculator</code> представляет собой простой калькулятор, реализующий базовые арифметические операции.
 * Этот класс используется в качестве примера для демонстрации JUnit тестирования.
 *
 * <p>Класс включает методы <code>sum</code> и <code>subtract</code> для выполнения сложения и вычитания соответственно.</p>
 *
 * <p>Метод <code>sum</code> принимает два целых числа и возвращает их сумму. Метод <code>subtract</code>
 * также принимает два целых числа и возвращает результат вычитания второго числа из первого.</p>
 *
 * <p>Эти методы можно использовать в JUnit тестах для проверки корректности арифметических операций,
 * реализованных в классе.</p>
 */
public class Calculator {

    // Method to sum two numbers
    public int sum(int a, int b) {
        return a + b;
    }

    // Method to subtract one number from another
    public int subtract(int a, int b) {
        return a - b;
    }
}
