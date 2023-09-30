package seminar2.shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

//    public void decreaseProductQuantity(Product product, int quantity) {
//        Product shopProduct = findProductById(product.getId());
//        if (shopProduct != null) {
//            int currentQuantity = shopProduct.getQuantity();
//            if (currentQuantity >= quantity) {
//                shopProduct.setQuantity(currentQuantity - quantity);
//            } else {
//        // Можно выбросить исключение или обработать ситуацию, когда пытаемся уменьшить количество товара,
//        // которого нет в достаточном количестве в магазине
//                throw new IllegalArgumentException("Недостаточное количество товара в магазине");
//            }
//        }
//    }
public void decreaseProductQuantity(Product product, int quantity) {
    for (int i = 0; i < products.size(); i++) {
        Product shopProduct = products.get(i);
        if (shopProduct.getId() == product.getId()) {
            int currentQuantity = shopProduct.getQuantity();
            if (currentQuantity >= quantity) {
                shopProduct.setQuantity(currentQuantity - quantity);
                if (currentQuantity - quantity == 0) {
// Если количество товара стало равным нулю, удаляем товар из магазина
                    removeProduct(shopProduct);
                }
                return; // Завершаем поиск, так как товар найден и обработан
            } else {
// Можно выбросить исключение или обработать ситуацию, когда пытаемся уменьшить количество товара,
// которого нет в достаточном количестве в магазине
                throw new IllegalArgumentException("Недостаточное количество товара в магазине");
            }
        }
    }
}

//добавила примерный недоработанный метод, не хватало для тестов
    public int getProductQuantity(Product product) {
        int productQuantity = 0;
        for (int i = 0; i < products.size(); i++) {
            Product shopProduct = products.get(i);
            if (shopProduct.getId() == product.getId()) {
                productQuantity = shopProduct.getQuantity();
                return productQuantity;
            }
        }
        return productQuantity;
    }
}
