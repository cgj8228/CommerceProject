package CommerceProject;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    Scanner sc = new Scanner(System.in);
    private List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        while (true) {
            printMain(); // 실시간 커머스 화면 - 입력
            int input = sc.nextInt();

            if (input == 0) {
                System.out.println("프로그램 종료");
                break;
            }

            Category categoryId2 = categoryId(input);
            if (categoryId2 == null) {
                System.out.println("없는 카테고리 입니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }
            categoryProduct(categoryId2);

//            categoryProduct(); // 제품들 출력
            // 상품 목록 출력
//            for (Product p : categories.get) {
//                System.out.printf("%d. | %-14s | %,9d | %-17s | %d%n", p.getId(), p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());
//            }
//            System.out.printf("%d. | %-14s%n", 0, "프로그램 종료");
//            System.out.print("입력 쿠다사이: ");

        }
    }

    // 메인 화면
    private void printMain() {
        System.out.println("[ 실시간 커머스 플랫폼 ]");
        for (Category c : categories) {
            System.out.printf("%d. | %-14s%n", c.getId(), c.getName());
        }
        System.out.printf("%d. | %-14s%n", 0, "프로그램 종료");
        System.out.print("입력 쿠다사이: ");
    }

    // 카테고리 ID
    private Category categoryId(int input) {
        for (Category c : categories) {
            if (c.getId() == input)
                return c;
        }
        return null;
    }

    // 제품 출력
    private void categoryProduct(Category category) {
        while (true) {
            System.out.printf("\n[ %s 카테고리 ]\n", category.getName());
            for (Product p : category.getProducts()) {
                System.out.printf("%d. | %-14s | %,9d | %-17s | %d%n", p.getId(), p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());
            }
            System.out.printf("%d. | %-14s%n", 0,"뒤로가기");
            System.out.print("입력 쿠다사이: ");
            int input = sc.nextInt();


            if(true) {
                for (Product p : category.getProducts()) {
                    if (p.getId() == input)
                        System.out.printf("선택한 상품 번호: %-14s | %,9d | %-17s | %d%n", p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());
                }
                System.out.println();
                break;
            }else{}

            if (input == 0) { System.out.println();break;}

        }
    }
}
