package CommerceProject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();

        Category electronics = new Category(1, "전자제품");
        electronics.addProduct(new Product(1,"Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 40));
        electronics.addProduct(new Product(2,"iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        electronics.addProduct(new Product(3,"MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        electronics.addProduct(new Product(4,"AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70));
        categories.add(electronics);

        Category clothes = new Category(2, "의류");
        clothes.addProduct(new Product(1, "후드티", 59000, "겨울용 기모 후드", 30));
        categories.add(clothes);

        Category food = new Category(3, "식품");
        food.addProduct(new Product(1, "프로틴바", 2500, "단백질 간식", 200));
        categories.add(food);

        CommerceSystem commerceSystem = new CommerceSystem(categories);
        commerceSystem.start();
    }
}