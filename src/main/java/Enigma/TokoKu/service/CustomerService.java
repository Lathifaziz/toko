package Enigma.TokoKu.service;

import Enigma.TokoKu.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getOne(Integer id);
    Customer create(Customer req);
    Customer update(Integer id,Customer req);
    void delete(Integer id);
}
