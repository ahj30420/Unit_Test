package project.unitTesting;

public class ProductRepository {

    public Product getById(int productId){
        return Product.getRandom();
    }
}
