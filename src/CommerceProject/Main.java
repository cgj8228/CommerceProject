package CommerceProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1,"Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 40));
        products.add(new Product(2,"iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        products.add(new Product(3,"MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        products.add(new Product(4,"AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70));

        CommerceSystem commerceSystem = new CommerceSystem(products);
        commerceSystem.start();
    }
}