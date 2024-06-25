package Enigma.TokoKu.repository;

import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.utill.CustomerProjection;
import Enigma.TokoKu.utill.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    Product findByName(String name);
    Product findByPrice(Integer price);

    @Query("SELECT p.id as id, p.price as price from Product p")
    List<ProductProjection> findAllProjectedBy();



}
