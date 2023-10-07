package fourth.book;

/*
Задание 2.

У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о
книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания
мок-объекта BookRepository.
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindBookById() {
        // Создаем экземпляр класса Book, который ожидаем получить от репозитория
        Book expectedBook = new Book("1", "Mock Book", "Mock Author");
        // Задаем ожидаемое поведение мока - при вызове метода findById с аргументом "1" вернуть expectedBook
        when(bookRepository.findById("1")).thenReturn(expectedBook);

        // Выполняем метод findBookById и проверяем, что получаем ожидаемую книгу
        Book actualBook = bookService.findBookById("1");

        assertEquals(expectedBook, actualBook);
        // Проверяем, что метод findById был вызван с аргументом "1"
        verify(bookRepository).findById("1");
    }

    @Test
    public void testFindAllBooks() {
        // Создаем список книг, который ожидаем получить от репозитория
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Book 1", "Author 1"),
                new Book("2", "Book 2", "Author 2")
        );

        // Задаем ожидаемое поведение мока - при вызове метода findAll вернуть expectedBooks
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Выполняем метод findAllBooks и проверяем, что получаем ожидаемый список книг
        List<Book> actualBooks = bookService.findAllBooks();

        assertEquals(expectedBooks, actualBooks);
        // Проверяем, что метод findAll был вызван
        verify(bookRepository).findAll();
    }
}