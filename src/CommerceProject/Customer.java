package CommerceProject;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String email;
    private String rating;
    private int totalAmount;

    public Customer(String customerName, String email, String rating, int totalAmount) {
        this.customerName = customerName;
        this.email = email;
        this.rating = rating;
        this.totalAmount = totalAmount;
    }

    public String getRating(String rating) {
        int t = totalAmount;
        if (t < 500_000) return "브론즈";
        if (t < 1_000_000) return "실버";
        if (t < 2_000_000) return "골드";
        return "플레티넘";
    }

    public void addOrderAmount(int amount) {
        totalAmount += amount;
    }
}