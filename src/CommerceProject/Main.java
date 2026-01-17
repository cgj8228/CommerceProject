package CommerceProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Product> products = new ArrayList<>();

            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            products.add(new Product(1,"Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 40));
            products.add(new Product(2,"iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
            products.add(new Product(3,"MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
            products.add(new Product(4,"AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70));

            // 상품 목록 출력
            for (Product p : products) {System.out.printf( "%d. | %-14s | %,9d | %-17s | %d%n",p.getId(), p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());}
            System.out.printf("%d. | %-14s%n", 0, "프로그램 종료");
            System.out.print("입력 쿠다사이: ");
            int input = sc.nextInt();
            if (input == 0) {break;}
            System.out.println();
        }
    }
}
