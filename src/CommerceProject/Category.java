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

    // 카테고리의 제품을 추가 (펩시, 스테비아 방울 토마토 등등...개별상품)
    public void addProduct(Product product){
        products.add(product);
    }

}
