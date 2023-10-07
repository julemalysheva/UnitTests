package fourth.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/*
Задание №4
Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
который обычно проверяет, доступен ли номер в отеле.
Вам необходимо проверить правильность работы класса BookingService, который
использует HotelService для бронирования номера, если он доступен.

 */
class BookingServiceTest {
    @Test
    public void bookingServiceShouldBookRoomIfAvailable() {
        // Arrange
        HotelService hotelServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelServiceMock);

        int roomId = 2;

        // Устанавливаем, что комната доступна
        when(hotelServiceMock.isRoomAvailable(roomId)).thenReturn(true);

        // Act
        boolean result = bookingService.bookRoom(roomId);

        // Assert
        assertTrue(result);
        verify(hotelServiceMock).isRoomAvailable(roomId);
    }

    @Test
    public void bookingServiceShouldNotBookRoomIfNotAvailable() {
        // Arrange
        HotelService hotelServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelServiceMock);

        int roomId = 3;

        // Устанавливаем, что комната не доступна
        when(hotelServiceMock.isRoomAvailable(roomId)).thenReturn(false);

        // Act
        boolean result = bookingService.bookRoom(roomId);

        // Assert
        assertFalse(result);
        verify(hotelServiceMock).isRoomAvailable(roomId);
    }

}

/*
В первом тесте bookingServiceShouldBookRoomIfAvailable() проверяется, что метод bookRoom()
класса BookingService правильно бронирует комнату, если она доступна. Для этого создается
мок-объект hotelServiceMock с помощью mock(HotelService.class), и настраивается его поведение с помощью метода when() и thenReturn(), чтобы возвращать true в методе isRoomAvailable(). Затем вызывается метод bookRoom() и проверяется, что он возвращает true и что метод isRoomAvailable() вызывается с переданным номером комнаты.

Во втором тесте bookingServiceShouldNotBookRoomIfNotAvailable() проверяется, что метод bookRoom()
не бронирует комнату, если она недоступна. Поведение мок-объекта hotelServiceMock настраивается по-разному,
чтобы метод isRoomAvailable() возвращал false. Затем вызывается метод bookRoom() и проверяется,
что он возвращает false и что метод isRoomAvailable() вызывается соответствующим образом.

Таким образом, с помощью использования мок-объекта HotelService и методов when() и thenReturn() мы
проверяем правильность работы класса BookingService при бронировании комнаты в зависимости от доступности.
 */