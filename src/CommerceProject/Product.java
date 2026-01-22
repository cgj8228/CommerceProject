package CommerceProject;

public class Product {
    private int id;
    private String productName; // 제품명
    private int price; // 가격
    private String description; // 설명
    private int inventory; // 재고
    private shoppingBasket basket = new shoppingBasket();
    // 생성자 초기화
    public Product(int id, String productName, int price, String description, int inventory) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.inventory = inventory;
    }

    // 게터 모음
    public int getId() {return id;}
    public String getProductName() {return productName;}
    public int getPrice() {return price;}
    public String getDescription() {return description;}
    public int getInventory() {return inventory;}

    // 세터

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
