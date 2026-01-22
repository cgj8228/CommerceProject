package CommerceProject;

import java.util.ArrayList;
import java.util.List;

public class shoppingBasket {
    private List<Product> products = new ArrayList<>();

    // 초기화
    public void Basketclear() {
        products.clear();
    }

    // 장바구니 추가
    public void addShoppingBasket(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    // 한 종류만 남기기
    public List<Product> getOverLab() {
        List<Product> overlab = new ArrayList<>();
        for (Product product : products) {
            boolean run = false;
            for (Product product1 : overlab) { // overlab에서 데이터 product1을 뽑는데 Product의 객체 타입임
                if (product1 == product) { // overlab에서 겹치는게 있는지
                    run = true;
                    break;
                }
            }
            if (!run) overlab.add(product);
        }
        return overlab;
    }

    // 재고 차감
    public int getCount(Product c) {
        int count = 0;
        for (Product product : products) {
            if (product == c) count++;
        }
        return count;
    }


    // 장바구니 내역
    public void printBasketItems() {
        System.out.println("---------------------------------------");
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ 장바구니 내역 ]");

        List<Product> printed = new ArrayList<>();
        for (Product p : products) {
            boolean ready = false;
            for (Product product : printed) {
                if (product == p) {
                    ready = true;
                    break;
                }
            }
            if (ready) continue;

            int count = 0;
            for (Product x : products) {
                if (x == p) count++;
            }
            System.out.printf("%s | %,d원 | %s | 수량: %d개%n",
                    p.getProductName(), p.getPrice(), p.getDescription(), count);
            printed.add(p);
        }
    }

    // 장바구니 금액
    public int getTotalPrice() {
        int total = 0;
        List<Product> printed = new ArrayList<>();
        for (Product p : products) {
            boolean ready = false;
            for (Product product : printed) {
                if (product == p) {
                    ready = true;
                    break;
                }
            }
            if (ready) continue;

            int count = 0;
            for (Product x : products) {
                if (x == p) count++;
            }
            total += p.getPrice() * count;
            printed.add(p);
        }
        return total;
    }


}
