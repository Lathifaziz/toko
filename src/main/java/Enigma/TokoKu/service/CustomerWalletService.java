package Enigma.TokoKu.service;

import Enigma.TokoKu.model.CustomerWallet;

import java.util.List;

public interface CustomerWalletService {
    List<CustomerWallet>getAll();
    CustomerWallet create(CustomerWallet req);
    CustomerWallet getOne(Integer id);
    void delete(Integer id);
}
