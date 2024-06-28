package Enigma.TokoKu.service.imp;

import Enigma.TokoKu.model.Transaction;
import Enigma.TokoKu.model.TransactionDetail;
import Enigma.TokoKu.repository.TransactionDetailRepository;
import Enigma.TokoKu.service.TransactionDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {
    private final TransactionDetailRepository transactionDetailRepository;

    public TransactionDetailServiceImpl(TransactionDetailRepository transactionDetailRepository) {
        this.transactionDetailRepository = transactionDetailRepository;
    }

    @Override
    public List<TransactionDetail> getAll() {
        return transactionDetailRepository.findAll();
    }

    @Override
    public TransactionDetail getOne(Integer id) {
    return transactionDetailRepository.findById(id).orElse(null);
    }

    @Override
    public TransactionDetail create(TransactionDetail req) {
        return transactionDetailRepository.save(req);
    }

    @Override
    public void delete(Integer id) {
        transactionDetailRepository.deleteById(id);
    }
}
