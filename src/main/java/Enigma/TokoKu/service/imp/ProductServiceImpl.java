package Enigma.TokoKu.service.imp;


import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.repository.ProductRepository;
import Enigma.TokoKu.service.ProductService;
import Enigma.TokoKu.utill.SearchProductRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAll(SearchProductRequest req) {
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

    private Specification<Product> getProductSpecification(SearchProductRequest req){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (req.getName() != null){
                Predicate namePredicate = criteriaBuilder.like (
                        root.get("name"), "%"+req.getName()+"%"
                );
                predicate.add(namePredicate);
            }
            if (req .getPrice() != 0) {
                Predicate pricePredicate = criteriaBuilder.like(
                        root.get("birthPlace"),"%"+ req.getPrice()+"%"
                );
                predicate.add(pricePredicate);
            }
            return query .where(predicate.toArray(new Predicate[]{})).getRestriction();
        }
        );
    }

}
