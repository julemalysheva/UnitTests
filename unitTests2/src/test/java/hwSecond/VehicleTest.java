package hwSecond;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    public void setUp() {
        car = new Car("Renault", "Kaptur", 2020);
        motorcycle = new Motorcycle("Ducati", "1098S", 2007);
    }

    /*
    Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
     */
    @Test
    public void testCarIsVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /*
    Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    public void testCarNumWheels() {
       assertEquals(4,car.getNumWheels(), "Объект Car должен создаваться с 4-мя колесами");
    }

    /*
    Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    public void testMotorcycleNumWheels() {
        assertEquals(2,motorcycle.getNumWheels(), "Объект Motorcycle должен создаваться с 2-мя колесами");
    }

    /*
    Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testDriveSpeedCar(){
        car.testDrive();
        assertEquals(60, car.getSpeed(), "" +
                "Объект Car должен развивать скорость 60 в режиме тестового вождения");
    }

    /*
    Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testDriveSpeedMotorcycle(){
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed(), "" +
                "Объект Motorcycle должен развивать скорость 75 в режиме тестового вождения");
    }

    /*
    Проверить, что в режиме парковки (сначала testDrive, потом park,
    т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
     */
    @Test
    public void testParkSpeedCar(){
        car.testDrive();
        car.park();
        int actualSpeed = car.getSpeed();
        assertEquals(0, actualSpeed, String.format(
                "Объект Car должен иметь скорость 0 в режиме парковки, а не %s", actualSpeed));
    }

    /*
    Проверить, что в режиме парковки (сначала testDrive, потом park,
    т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */
    @Test
    public void testParkSpeedMotorcycle(){
        motorcycle.testDrive();
        motorcycle.park();
        int actualSpeed = motorcycle.getSpeed();
        assertEquals(0, actualSpeed, String.format(
                "Объект Motorcycle должен иметь скорость 0 в режиме парковки, а не %s", actualSpeed));
    }

}
