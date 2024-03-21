import java.util.HashMap;
import java.util.List;

public class Task5 implements Basket {

    private HashMap<String, Integer> basket;

    public Task5(HashMap<String, Integer> basket) {
        this.basket = basket;
    }

    @Override
    public void addProduct(String product, int quantity) {
        basket.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        basket.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        basket.put(product, quantity);
    }

    @Override
    public void clear() {
        basket.clear();
    }

    @Override
    public List<String> getProducts() {
        return basket.keySet().stream().toList();
    }

    @Override
    public int getProductQuantity(String product) {
        return basket.get(product);
    }
}
