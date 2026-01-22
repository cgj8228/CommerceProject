package CommerceProject;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    Scanner sc = new Scanner(System.in);
    private List<Category> categories;
    private shoppingBasket basket = new shoppingBasket();
    private Customer customer = new Customer("최길중", "choil8228@gmail.com", 0);

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        while (true) {
            printMain(); // 실시간 커머스 화면 - 입력
            int input = 0;

            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine();
                System.out.println("---------------------------------------");
                continue;
            }

            if (input == 0) {
                System.out.println("프로그램 종료");
                break;
            }

            // 장바구니 내역 + 주문 확정/메인 으로 돌아가기, 할인 금액
            if (input == 4) {
                basket.printBasketItems();
                System.out.println("[ 총 주문 금액 ]");
                System.out.printf("%,d원\n", basket.getTotalPrice());
                System.out.println("1. 주문 확정      2. 메인으로 돌아가기");

                int Confirmation = 0;
                try {
                    Confirmation = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력해 주세요");
                    System.out.println("---------------------------------------");
                    sc.nextLine();
                    continue;
                }
                if (Confirmation == 1) {
                    int originalTotal = basket.getTotalPrice();  // 할인 전
                    double rate = customer.getDiscountRate();    // 0.0~0.15
                    int discountedTotal = (int) Math.round(originalTotal * (1 - rate));

                    System.out.printf("주문이 완료되었습니다! 총 금액: %,d\n", basket.getTotalPrice());
                    System.out.printf("[%s 등급] 할인된 총 금액: %,d\n",customer.getRating(),discountedTotal);
                    System.out.println("---------------------------------------");
                    customer.addOrderAmount(basket.getTotalPrice());
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
        for (Product p : basket.getOverLab()) {
            int cnt = basket.getCount(p);
            p.setInventory(p.getInventory() - cnt);
        }
    }

    // 메인 화면
    private void printMain() {
        System.out.printf("[ 실시간 커머스 플랫폼 ]-[등급: %s]\n", customer.getRating());
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

    // 카테고리 제품 장바구니에 담기
    private void categoryProduct(Category category) {
        while (true) {
            System.out.printf("[ %s 카테고리 ]\n", category.getName());
            for (Product p : category.getProducts()) {
                System.out.printf("%d. | %-14s | %,9d | %-17s | 재고: %d%n",
                        p.getId(), p.getProductName(), p.getPrice(), p.getDescription(), p.getInventory());
            }
            System.out.printf("%d. | %-14s%n", 0, "뒤로가기");
            System.out.print("제품 입력 쿠다사이: ");
            int input = 0;
            try {

                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                System.out.println("---------------------------------------");
                sc.nextLine();
                continue;
            }
            if (input == 0) {
                System.out.println();
                break; // 카테고리 나가기
            }

            // 상품 찾기
            Product selected = null;
            for (Product p : category.getProducts()) {
                if (p.getId() == input) {
                    selected = p;
                    break;
                }
            }

            // 없는 상품 번호면 다시 카테고리 화면
            if (selected == null) {
                System.out.println("존재하지 않는 상품 입니다. 다시 입력해주세요");
                continue;
            }

            // 상품 찾았으면 정보 출력
            System.out.printf("선택한 상품 번호: %-14s | %,9d | %-17s | %d%n",
                    selected.getProductName(), selected.getPrice(), selected.getDescription(), selected.getInventory());

            // 수량만 다시 입력 받기
            while (true) {
                System.out.print("몇개를 장바구니에 담겠습니까? ");
                int buy = 0;
                try {
                buy = sc.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("숫자만 입력해주세요.");
                    sc.nextLine();
                    System.out.println("---------------------------------------");
                    continue;
                }
                System.out.println("---------------------------------------");

                if (selected.getInventory() < buy) {
                    System.out.println("구매하시려는 양이 재고 보다 많습니다. 다시 입력해주세요");
                    continue; // 수량만 다시 입력
                }

                basket.addShoppingBasket(selected, buy); // 담기
                break; // 수량 입력 while 탈출
            }

        }
    }

}

