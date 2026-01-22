package CommerceProject;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Product> products = new ArrayList<>();

    // 카테고리 선택
    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    // 게터
    public int getId() {return id;}
    public String getName() {return name;}
    public List<Product> getProducts() {return products;}

    public void addProduct(Product product){
        products.add(product);
    }

    public void deductStock(int productId, int quantity) {
        for (Product p : products) {
            if (p.getId() == productId) {
                p.setInventory(p.getInventory() - quantity);
                return;
            }
        }
    }
}
