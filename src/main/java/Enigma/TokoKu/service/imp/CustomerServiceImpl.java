package Enigma.TokoKu.service.imp;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.repository.CustomerRepository;
import Enigma.TokoKu.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
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

}
