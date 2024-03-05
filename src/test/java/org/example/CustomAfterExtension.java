package org.example;

import org.junit.jupiter.api.extension.*;

/**
 * Класс <code>CustomAfterExtension</code> реализует интерфейс <code>AfterEachCallback</code> JUnit 5,
 * предоставляя пользовательское расширение, которое выполняется после каждого тестового метода.
 *
 * <p>Этот класс определяет логику, которая должна выполняться после каждого теста в тестовом классе,
 * где используется это расширение. В частности, расширение проверяет, произошло ли исключение во время
 * выполнения теста, и выводит стандартное сообщение в случае его наличия.</p>
 *
 * <p>Метод <code>afterEach</code> вызывается автоматически после каждого теста. Если в контексте выполнения
 * теста (<code>ExtensionContext</code>) присутствует исключение, выводится сообщение <code>DEFAULT_MESSAGE</code>.</p>
 *
 * <p>Это расширение может быть использовано для добавления дополнительных действий или логирования в случае
 * неудачного выполнения тестов, улучшая таким образом отладку и анализ результатов тестирования.</p>
 */
public class CustomAfterExtension implements AfterEachCallback, BeforeEachCallback {

    private static final String DEFAULT_MESSAGE_ON_FAILURE = "The test failed!";
    private static final String DEFAULT_MESSAGE_AFTER_EACH = "AfterEachCallback Extension";
    private static final String DEFAULT_MESSAGE_BEFORE_EACH = "BeforeEachCallback Extension";

    /**
     * Вызывается после выполнения каждого тестового метода.
     * Выводит сообщение, если тест завершился с исключением.
     *
     * @param context Контекст выполнения теста, предоставляющий информацию о тесте и его выполнении.
     * @throws Exception Может выбрасываться в случае возникновения исключения в методе.
     */
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("\n" + DEFAULT_MESSAGE_AFTER_EACH
                + ". Class: " + context.getRequiredTestClass().getCanonicalName()
                + ", Test: " + context.getRequiredTestMethod().getName() + "\n");
        if (context.getExecutionException().isPresent()) {
            System.out.println(DEFAULT_MESSAGE_ON_FAILURE);
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("\n" + DEFAULT_MESSAGE_BEFORE_EACH
                + ". Class: " + context.getRequiredTestClass().getCanonicalName()
                + ", Test: " + context.getRequiredTestMethod().getName() + "\n");
    }
}
