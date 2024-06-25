package Enigma.TokoKu.repository;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.utill.CustomerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface CustomerRepository extends JpaRepository<Customer,Integer>,
        JpaSpecificationExecutor<Customer> {

    Customer findByName(String name);
    Customer findByBirthPlace(String birthPlace);

    @Query("SELECT c.id as id, c.name as name from Customer c")
    List<CustomerProjection> findAllProjectedBy();
}
