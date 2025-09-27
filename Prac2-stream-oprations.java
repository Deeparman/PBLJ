import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class Ques3 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200, "Electronics"),
            new Product("Smartphone", 900, "Electronics"),
            new Product("T-Shirt", 25, "Clothing"),
            new Product("Jeans", 40, "Clothing"),
            new Product("Coffee Maker", 80, "Home Appliances"),
            new Product("Blender", 60, "Home Appliances"),
            new Product("Book", 15, "Books"),
            new Product("Novel", 20, "Books")
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, prods) -> {
            System.out.println(category + ": " + prods);
        });

        Map<String, Optional<Product>> maxPricedProductByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        System.out.println("\nMost expensive product in each category:");
        maxPricedProductByCategory.forEach((category, productOpt) -> {
            productOpt.ifPresent(product -> 
                System.out.println(category + ": " + product));
        });

        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
