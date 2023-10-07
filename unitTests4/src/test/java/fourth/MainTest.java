package fourth;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class MainTest {

    /**
     * 4.0. Проверка работы Mockito
     */
     @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("one");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова  “Hello World”,
     * и проверить это поведение с помощью утверждений
     */
    /*
     используется mock(Iterator.class) для создания мок-объекта Iterator.
     Затем мы настраиваем его поведение с помощью when() и thenReturn(). Мы говорим, ч
     то при первом вызове метода next() мок-объект должен возвращать строку "Hello",
     а при втором вызове - строку "World".
Затем, в блоке Act мы вызываем методы next() два раза и конкатенируем полученные строки с помощью оператора +.
В блоке Assert мы сравниваем результат с ожидаемым значением "Hello World" с помощью метода assertEquals().
Таким образом, этот тест проверяет, что мок-объект Iterator действительно возвращает строки "Hello" и "World"
при двух последовательных вызовах метода next().
     */
      @Test
      public void iteratorWillReturnHelloWorld() {
          // Arrange
          Iterator<String> iteratorMock = mock(Iterator.class);
          when(iteratorMock.next()).thenReturn("Hello", "World");

          // Act
          String result = iteratorMock.next() + " " + iteratorMock.next();

          // Assert
          assertEquals("Hello World", result);
      }

}