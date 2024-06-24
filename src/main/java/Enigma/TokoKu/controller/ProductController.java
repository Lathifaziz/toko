package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public Product create (@RequestBody Product req){
        return productService.create(req);
    }

    @GetMapping
    public List<Product> getAll (){
        return productService.getAll();
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
