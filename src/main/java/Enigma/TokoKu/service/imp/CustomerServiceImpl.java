package Enigma.TokoKu.service.imp;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.repository.CustomerRepository;
import Enigma.TokoKu.service.CustomerService;
import Enigma.TokoKu.utill.SearchCustomerRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll(SearchCustomerRequest req) {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer req) {
        return customerRepository.save(req);
    }

    @Override
    public Customer update(Integer id, Customer req) {
        Customer existcustomer = this.getOne(id);
        existcustomer.setName(req.getName());
        customerRepository.save(req);
        return existcustomer;
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    private Specification<Customer>getCustomerSpecifikation(SearchCustomerRequest req){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
                    if (req.getName() != null){
                        Predicate namePredicate = criteriaBuilder.like (
                                root.get("name"), "%"+req.getName()+"%"
                        );
                        predicate.add(namePredicate);
                    }
                    if (req .getBirthPlace() != null) {
                        Predicate birthPredicate = criteriaBuilder.like(
                                root.get("birthPlace"),"%"+ req.getBirthPlace()+"%"
                        );
                        predicate.add(birthPredicate);
                    }
                    return query .where(predicate.toArray(new Predicate[]{})).getRestriction();}
        );
    }
}
