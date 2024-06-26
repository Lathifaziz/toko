package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.repository.CustomerRepository;
import Enigma.TokoKu.service.CustomerService;
import Enigma.TokoKu.utill.CustomerProjection;
import Enigma.TokoKu.utill.SearchCustomerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer create(@RequestBody Customer req) {
        return customerService.create(req);
    }

    @GetMapping
    public List<Customer> getAll(@RequestParam (required = false)String name,
                                 @RequestParam (required = false) String birthPlace)
    {
        SearchCustomerRequest req = new SearchCustomerRequest();
        req.setName(name);
        req.setBirthPlace(birthPlace);
        return customerService.getAll(req);
    }

    @GetMapping("/custom")
    public List<CustomerProjection> getAllCustom(){
        return customerRepository.findAllProjectedBy();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable Integer id) {
        return customerService.getOne(id);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer req) {
        return customerService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        customerService.delete(id);
    }

}