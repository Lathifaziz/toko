package Enigma.TokoKu.service;

import Enigma.TokoKu.model.Transaction;
import Enigma.TokoKu.utill.DTO.TransactionRequestDTO;
import Enigma.TokoKu.utill.SearchTransactionRequest;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    Transaction getOne(Integer id);
    Transaction create(TransactionRequestDTO req);
    void delete(Integer id);
}
