package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.Product;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void deleteById(Long id);
}
