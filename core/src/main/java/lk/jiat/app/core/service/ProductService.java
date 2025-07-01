package lk.jiat.app.core.service;

import lk.jiat.app.core.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    Product getProductByName(String name);
    List<Product> getProductSByCategory(String category);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
