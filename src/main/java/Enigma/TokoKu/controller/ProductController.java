package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.repository.ProductRepository;
import Enigma.TokoKu.service.ProductService;
import Enigma.TokoKu.utill.CustomerProjection;
import Enigma.TokoKu.utill.ProductProjection;
import Enigma.TokoKu.utill.SearchProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product create (@RequestBody Product req){
        return productService.create(req);
    }

    @GetMapping("/custom")
    public List<ProductProjection> getAllCustom(){
        return productRepository.findAllProjectedBy();
    }

    @GetMapping
    public List<Product> getAll (@RequestParam (required = false) String name,
                                 @RequestParam (required = false) Integer price){
        SearchProductRequest req = new SearchProductRequest();
        req.setName(name);
        req.setPrice(price);
        return productService.getAll(req);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Integer id){
        return productService.getOne(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id,@RequestBody Product req){
        return productService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
