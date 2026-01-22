package CommerceProject;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String email;
    private String rating;
    private int totalAmount;

    public Customer(String customerName, String email, int totalAmount) {
        this.customerName = customerName;
        this.email = email;
        this.totalAmount = totalAmount;
    }

    public String getRating() {
        if (totalAmount < 500_000) return "브론즈";
        if (totalAmount < 1_000_000) return "실버";
        if (totalAmount < 2_000_000) return "골드";
        return "플레티넘";
    }

    public void addOrderAmount(int amount) {
        totalAmount += amount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public double getDiscountRate() {
        if (totalAmount < 500_000) return 0.00;
        if (totalAmount < 1_000_000) return 0.05;
        if (totalAmount < 2_000_000) return 0.10;
        return 0.15;
    }

}