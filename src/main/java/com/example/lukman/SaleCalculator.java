package com.example.lukman;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaleCalculator {

    public static void calculateSale(String[] items) {
        double totalOriginalPrice = 0.0;
        double totalSalePrice = 0.0;

        for (String item : items) {
            String regex = "(\\w+)\\s+\\$([\\d.]+)\\s*(-?\\d+)%";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(item);

            if (matcher.find()) {
                String itemName = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int discountPercent = Integer.parseInt(matcher.group(3));

                // Ensure the discount is within the valid range of -100% to 100%
                discountPercent = Math.max(-100, Math.min(100, discountPercent));

                double discountedPrice = price * (1 - discountPercent / 100.0);
                totalOriginalPrice += price;
                totalSalePrice += discountedPrice;
            }
        }

        double amountSaved = totalOriginalPrice - totalSalePrice;

        System.out.printf("Input: %s%n", String.join(", ", items));
        System.out.printf("TotalOriginalPrice:$%.2f;TotalSalePrice:$%.2f;AmountSaved:$%.2f;%n",
                totalOriginalPrice, totalSalePrice, amountSaved);
    }

    public static void main(String[] args) {
        String[] input1 = {"Jacket $34 12%", "Hoodie $25 5%", "Shirt $12 50%"};
        calculateSale(input1);

        String[] input2 = {"Pants $20 -10%", "Shorts $15 -10%"};
        System.out.println("\n");
        calculateSale(input2);

        String[] input3 = {"Sweater $36 12%", "Shirt $12 50%"};
        System.out.println("\n");
        calculateSale(input3);

        String[] input4 = {"Bag $25.50 10%"};
        System.out.println("\n");
        calculateSale(input4);
    }
}
