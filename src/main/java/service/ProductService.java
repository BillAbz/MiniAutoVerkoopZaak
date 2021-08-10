package service;

import Entities.Product;
import Entities.ProductLine;

import java.util.Set;

public interface ProductService {

    void addProduct(Product product);

    Product getProductById(long id);

    Set<Product> getAllProduct();

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
