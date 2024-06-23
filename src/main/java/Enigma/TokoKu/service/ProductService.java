package Enigma.TokoKu.service;

import Enigma.TokoKu.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getOne(Integer id);
    Product create(Product req);
    Product update(Integer id,Product req);
    void delete(Integer id);
}
