package project.unitTesting;

public class PriceEngine {

    public double calculateDiscount(Product... product) {
        final double discount = product.length * 0.01d;
        return Math.min(discount, 0.2d);
    }

}
