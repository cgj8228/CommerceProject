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

        Category runningShoes = new Category(2, "러닝화");
        runningShoes.addProduct(new Product(1, "아디다스 아디제로 EVO SL", 135000, "아디다스 러닝화", 40));
        runningShoes.addProduct(new Product(2, "아식스 노바블라스트 5", 159000, "아식스 러닝화", 24));
        runningShoes.addProduct(new Product(3, "나이키 줌 플라이 6", 137000, "나이키 러닝화", 60));
        runningShoes.addProduct(new Product(4, "뉴발란스 퓨어셀 슈퍼컴프 엘리트V4", 274000, "뉴발란스 러닝화", 50));
        categories.add(runningShoes);

        Category food = new Category(3, "식품");
        food.addProduct(new Product(1, "프로틴바", 2500, "단백질 간식", 200));
        food.addProduct(new Product(2, "스테비아 대추방울토마토 2Kg", 23900, "달콤한 토마토", 12));
        food.addProduct(new Product(3, "펩시 제로슈거 라임향1.5L", 1900, "제로 칼로리 탄산음료", 1000));
        food.addProduct(new Product(4, "라라스윗 초콜릿 아이스크림474ml", 8290, "저칼로리 아이스크림", 120));
        categories.add(food);

        CommerceSystem commerceSystem = new CommerceSystem(categories);
        commerceSystem.start();
    }
}