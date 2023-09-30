package seminar2.shoppingCart;
/*
Задание №1
Разработайте модульный тест для проверки, что общая стоимость корзины с разными
товарами корректно рассчитывается
💡 Ожидаемый результат: Стоимость корзины посчиталась корректно
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    //создаем поле в классе для создания экз-ра класса корзины - будет использоваться перед каждым тестом
    private Cart cart;
    private Product product1;
    private Product product2;
    private Shop shop;

    //будет использоваться перед каждым тестом - создавать экземпляр корзины
    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Товар 1", 500.0, 1);
        product2 = new Product(2, "Товар 2", 300.0, 1);
        shop = new Shop();
    }

    @Test
    public void testCalculateTotalWithMultipleProducts() {
// Создаем несколько продуктов
        Product product1 = new Product(1, "Товар 1", 500.0, 1);
        Product product2 = new Product(2, "Товар 2", 300.0, 1);
        Product product3 = new Product(3, "Товар 3", 200.0, 1);

// Добавляем продукты в корзину
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

// Проверяем, что общая стоимость корзины рассчитывается корректно
        double expectedTotalPrice = 1000.0; // 500 + 300 + 200
        double actualTotalPrice = cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
        // Погрешность 0.01 для сравнения с плавающей точкой
    }

    @Test
    public void testCalculateTotalWithEmptyCart() {
    // Проверяем, что общая стоимость пустой корзины равна 0.0
        double expectedTotalPrice = 0.0;
        double actualTotalPrice = cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    @Test
    public void testCalculateTotalWithSingleProduct() {
    // Создаем один продукт
        Product product = new Product(1, "Товар 1", 500.0, 1);

    // Добавляем продукт в корзину
        cart.addProduct(product);

    // Проверяем, что общая стоимость корзины с одним товаром равна цене этого товара
        double expectedTotalPrice = 500.0;
        double actualTotalPrice = cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    /*
    Задание №2
Создайте модульный тест для проверки, что общая стоимость корзины с множественными
экземплярами одного и того же продукта корректно рассчитывается.
💡 Ожидаемый результат: Стоимость корзины посчиталась корректно
     */
    @Test
    public void testCalculateTotalWithSingleProducts() {
// Создаем один продукт
        Product product1 = new Product(1, "Товар 1", 500.0, 1);

// Добавляем продукты в корзину
        cart.addProduct(product1);
        cart.addProduct(product1);
        cart.addProduct(product1);

// Проверяем, что общая стоимость корзины рассчитывается корректно
        double expectedTotalPrice = 1500.0; // 500 * 3
        double actualTotalPrice = cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
        // Погрешность 0.01 для сравнения с плавающей точкой
    }

    /*
    Задание №3
Напишите модульный тест для проверки, что при удалении товара из
корзины происходит перерасчет общей стоимости корзины.
💡 Ожидаемый результат: Вызывается метод пересчета стоимости
корзины, стоимость корзины меняется
     */
    @Test
    public void testRecalculateTotalAfterRemovingProduct() {
// Добавляем продукты в корзину
        cart.addProduct(product1);
        cart.addProduct(product2);

// Первоначальная стоимость корзины
        double initialTotalPrice = cart.calculateTotal();

// Удаляем продукт из корзины
        cart.removeProduct(product1);

// Получаем обновленную стоимость корзины после удаления товара
        double updatedTotalPrice = cart.calculateTotal();

// Проверяем, что стоимость корзины изменилась после удаления товара
        assertNotEquals(initialTotalPrice, updatedTotalPrice, 0.01); // Погрешность 0.01 для сравнения с плавающей точкой
    }

    /*
    Задание №4. Разработайте модульный тест для проверки, что при добавлении определенного количества
    товара в корзину, общее количество этого товара в магазине соответствующим образом
    уменьшается.
    💡 Ожидаемый результат: Количество товара в магазине
    уменьшается на число продуктов в корзине пользователя
     */
    @Test
    public void testDecreaseProductQuantityInShop() {
        //или инициализацию экземпляра магазина делать в setUp?
    // Создаем продукт и добавляем его в магазин
        Product product = new Product(1, "Товар 1", 500.0, 5);
        shop.addProduct(product);

    // Добавляем продукт в корзину пользователя
        cart.addProduct(product);

    // Проверяем, что количество продукта в магазине уменьшилось на количество продуктов в корзине
        int initialQuantity = shop.getProductQuantity(product);
        int cartQuantity = cart.getProductQuantity(product);

        shop.decreaseProductQuantity(product, cartQuantity);

        int updatedQuantity = shop.getProductQuantity(product);
        int expectedQuantity = initialQuantity - cartQuantity;

        assertEquals(expectedQuantity, updatedQuantity);

//        //другой вариант
//        // Добавляем 3 товара в корзину
//        cart.addProduct(product, 3);
//
//// Проверяем, что количество товара в магазине уменьшилось на 3
//        int expectedQuantityInShop = 2; // 5 - 3
//        int actualQuantityInShop = shop.findProductById(product.getId()).getQuantity();
//        assertEquals(expectedQuantityInShop, actualQuantityInShop);
    }

    /*
    Задание №5
Создайте модульный тест для проверки, что если пользователь забирает все имеющиеся
продукты определенного типа из магазина, эти продукты больше не доступны для заказа.
💡 Ожидаемый результат: Больше такой продукт заказать нельзя, он не появляется на полке
     */
    //здесь использовать код с семинара

//    @Test
//    public void testProductQuantityInShop() {
//        // Создаем продукт и добавляем его в магазин
//        Product product = new Product(1, "Товар 1", 500.0, 3);
//        shop.addProduct(product);
//
//        // Добавляем продукт в корзину пользователя
//        cart.addProduct(product);
//        cart.addProduct(product);
//        cart.addProduct(product);
//        cart.addProduct(product);
//
//        // Проверяем, что первый продукт больше недоступен для заказа
//        assertFalse(cart.containsProduct(product));//не доработан код исходников для этих тестов
//        //странная логика, переписать, продукт так или иначе уже будет в корзине, нужно смотреть как-то
//        // в несколько этапов
//
//        //его вариант
//        // Добавляем продукты в корзину
//        cart.addProduct(product1);
//        cart.addProduct(product2);
//
//// Проверяем, что продукты присутствуют в корзине
//        assertTrue(cart.containsProduct(product1));
//        assertTrue(cart.containsProduct(product2));
//
//// Удаляем один из продуктов из корзины
//        cart.removeProduct(product1);
//
//// Проверяем, что удаляемый продукт больше не присутствует в корзине
//        assertFalse(cart.containsProduct(product1));
//        assertTrue(cart.containsProduct(product2));
//    }
//    }


}


