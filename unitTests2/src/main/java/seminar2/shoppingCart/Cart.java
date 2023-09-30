package seminar2.shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public int getProductQuantity(Product product) {
        int productQuantity = 0;
        for (int i = 0; i < items.size(); i++) {
            Product shopProduct = items.get(i);
            if (shopProduct.getId() == product.getId()) {
                productQuantity = shopProduct.getQuantity();
                return productQuantity;
            }
        }
        return productQuantity;
    }

    public boolean containsProduct(Product product) {
        return items.contains(product);
    }
}
