package Enigma.TokoKu.service;

import Enigma.TokoKu.model.Bank;
import Enigma.TokoKu.utill.SearchBankRequest;

import java.util.List;

public interface BankService {
    List<Bank> getAll(SearchBankRequest req);
    Bank getOne(Integer id);
    Bank create(Bank req);
    Bank update(Integer id, Bank req);
    void delete (Integer id);
}
