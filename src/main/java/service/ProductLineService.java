package service;

import Entities.ProductLine;

import java.util.Set;

public interface ProductLineService {

    void addProductLine(ProductLine payment);

    ProductLine getProductLineById(long id);

    Set<ProductLine> getAllProductLines();

    void updateProductLine(ProductLine payment);

    void deleteProductLine(ProductLine payment);
}
