package Enigma.TokoKu.service;

import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.utill.SearchCustomerRequest;
import Enigma.TokoKu.utill.SearchProductRequest;

import java.util.List;


public interface ProductService {
    List<Product> getAll(SearchProductRequest req);
    Product getOne(Integer id);
    Product create(Product req);
    Product update(Integer id,Product req);
    void delete(Integer id);
}
