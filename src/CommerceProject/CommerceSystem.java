package CommerceProject;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    Scanner sc = new Scanner(System.in);
    private List<Category> categories;
    private shoppingBasket basket = new shoppingBasket();

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

            // 장바구니 내역 + 주문 확정/메인 으로 돌아가기
            if (input == 4) {
                basket.printBasketItems();
                System.out.println();
                System.out.println("[ 총 주문 금액 ]");
                System.out.printf("%,d원\n", basket.getTotalPrice());
                System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
                int Confirmation = sc.nextInt();
                if (Confirmation == 1) {
                    System.out.printf("주문이 완료되었습니다! 총 금액: %,d\n", basket.getTotalPrice());
//                    System.out.println(basket.getOverlab());
                    systemDeductStock();
                    basket.Basketclear();
                }
                continue;
            }

            Category categoryId2 = categoryId(input);
            if (categoryId2 == null) {
                System.out.println("없는 카테고리 입니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }
            categoryProduct(categoryId2);
        }
        System.out.println();
    } // 카테고리, 메인, 장바구니

    // 재고 차감 *************************
    private void systemDeductStock() {
        for (Product p : basket.getOverLab()){
            int cnt = basket.getCount(p);
            p.setInventory(p.getInventory()-cnt);
        }
    }

    // 메인 화면
    private void printMain() {
        System.out.println("[ 실시간 커머스 플랫폼 ]");
        for (Category c : categories) {
            System.out.printf("%d. | %-14s%n", c.getId(), c.getName());
        }
        System.out.println();
        System.out.println("[ 주문 관리 ]");
        System.out.printf("%d. | %-14s%n", 4, "장바구니 확인");
        System.out.printf("%d. | %-14s%n", 0, "프로그램 종료");
        System.out.print("카테고리 입력 쿠다사이: ");
    }

    // 카테고리 ID
    private Category categoryId(int input) {
        for (Category c : categories) {
            if (c.getId() == input) return c;
        }
        return null;
    }

    // 제품 출력
    private void categoryProduct(Category category) {
        while (true) {
            System.out.printf("\n[ %s 카테고리 ]\n", category.getName());
            for (Product p : category.getProducts()) {
                System.out.printf("%d. | %-14s | %,9d | %-17s | 재고: %d%n", p.getId(), p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());
            }
            System.out.printf("%d. | %-14s%n", 0, "뒤로가기");
            System.out.print("제품 입력 쿠다사이: ");
            int input = sc.nextInt();


            if (input == 0) {
                System.out.println();
                break;
            }
            // 상품의 개수, 총 금액, 확정
            for (Product p : category.getProducts()) {
                if (p.getId() == input) {
                    System.out.printf("선택한 상품 번호: %-14s | %,9d | %-17s | %d%n",
                            p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());
                    System.out.print("몇개를 장바구니에 담겠습니까? ");
                    int buy = sc.nextInt();
                    basket.addShoppingBasket(p, buy);
                    System.out.println(); // 다음 담기 계속 진행
                    break;
                }
            }
            break;
        }
    }
}

