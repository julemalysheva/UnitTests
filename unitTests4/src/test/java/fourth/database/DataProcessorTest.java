package fourth.database;

/*
Задание №6
Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
Условие: У вас есть класс Database с методом public List<String> query(String sql),
который выполняет SQLзапрос и возвращает результат.
Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
выполнения запроса и обработки результатов.

 */


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class DataProcessorTest {

    @Mock
    private Database database;

    @Test
    public void testProcessData() {
        DataProcessor dataProcessor = new DataProcessor(database);

        String sql = "SELECT * FROM table";
        List<String> expectedData = Arrays.asList("Data1", "Data2", "Data3");

        // Устанавливаем поведение мока - при вызове метода query вернуть фиктивные данные
        when(database.query(sql)).thenReturn(expectedData);

        List<String> actualData = dataProcessor.processData(sql);

        assertEquals(expectedData, actualData);
        verify(database).query(sql); // Проверяем, что метод query был вызван с правильным аргументом
    }
}