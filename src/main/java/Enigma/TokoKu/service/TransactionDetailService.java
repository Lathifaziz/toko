package Enigma.TokoKu.service;


import Enigma.TokoKu.model.TransactionDetail;

import java.util.List;


public interface TransactionDetailService {
    List<TransactionDetail> getAll();
    TransactionDetail getOne(Integer id);
    TransactionDetail create(TransactionDetail req);
    void delete(Integer id);

}
