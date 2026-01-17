package CommerceProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    List<Product> products = new ArrayList<>();

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    public void start(){

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
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
