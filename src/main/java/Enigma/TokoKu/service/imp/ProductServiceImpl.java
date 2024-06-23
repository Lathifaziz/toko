package Enigma.TokoKu.service.imp;

import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.repository.ProductRepository;
import Enigma.TokoKu.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product req) {
        return productRepository.save(req);
    }

    @Override
    public Product update(Integer id, Product req) {
        Product product = this.getOne(id);
        product.setName(req.getName());
        productRepository.save(req);
        return product;
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
