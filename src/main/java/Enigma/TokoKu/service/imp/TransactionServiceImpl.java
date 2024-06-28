package Enigma.TokoKu.service.imp;

import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.model.Product;
import Enigma.TokoKu.model.Transaction;
import Enigma.TokoKu.model.TransactionDetail;
import Enigma.TokoKu.repository.TransactionRepository;
import Enigma.TokoKu.service.CustomerService;
import Enigma.TokoKu.service.ProductService;
import Enigma.TokoKu.service.TransactionDetailService;
import Enigma.TokoKu.service.TransactionService;
import Enigma.TokoKu.utill.DTO.TransactionRequestDTO;
import Enigma.TokoKu.utill.SearchTransactionRequest;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final TransactionDetailService transactionDetailService;

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getOne(Integer id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction create(TransactionRequestDTO req) {
        Customer customer = customerService.getOne(req.getCustomer_id());
        Product product = productService.getOne(req.getProduct_id());

        Transaction addTrans = new Transaction();
        addTrans.setCustomer(customer);
        Transaction addedTrans = transactionRepository.save(addTrans);

        TransactionDetail addTransD = new TransactionDetail();
        addTransD.setProduct(product);
        addTransD.setTransaction(addedTrans);
        addTransD.setPrice(product.getPrice());
        addTransD.setQuantity(req.getQuantity());
        transactionDetailService.create(addTransD);

        return addedTrans;
    }

    @Override
    public void delete(Integer id) {
    transactionRepository.deleteById(id);
    }

    private Specification<Transaction>getTransactionSpecification(SearchTransactionRequest req){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (req.getId() != null) {
                Predicate namePre = criteriaBuilder.like(
                        root.get("id"),"%"+ req.getId()+ "%"
                );
                predicate.add(namePre);
            }
            return query.where(predicate.toArray(new Predicate[]{})).getRestriction();
        });
    }
}
