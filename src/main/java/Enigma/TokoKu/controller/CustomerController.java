package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public  class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create (@RequestBody Customer req){
        return customerService.create(req);
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable Integer id){
        return customerService.getOne(id);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer req){
        return customerService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        customerService.delete(id);
    }

}