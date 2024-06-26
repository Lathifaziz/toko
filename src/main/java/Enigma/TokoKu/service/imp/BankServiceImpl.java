package Enigma.TokoKu.service.imp;


import Enigma.TokoKu.model.Bank;
import Enigma.TokoKu.repository.BankRepository;
import Enigma.TokoKu.service.BankService;
import Enigma.TokoKu.utill.SearchBankRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getAll(SearchBankRequest req) {
        return bankRepository.findAll();
    }

    @Override
    public Bank getOne(Integer id) {
        return bankRepository.findById(id).orElse(null);
    }

    @Override
    public Bank create(Bank req) {
        return bankRepository.save(req);
    }

    @Override
    public Bank update(Integer id, Bank req) {
        Bank bank = this.getOne(id);
        bank.setName(req.getName());
        bankRepository.save(req);
        return bank;
    }

    @Override
    public void delete(Integer id) {
        bankRepository.deleteById(id);
    }

    private Specification<Bank> getBankSpecification(SearchBankRequest req){
        return((root, query, criteriaBuilder) ->{
            List<Predicate> predicate = new ArrayList<>();
            if (req.getName() != null){
                Predicate namePredicated = criteriaBuilder.like(
                        root.get("name"),"%"+req.getName()+"%");
            predicate.add(namePredicated);
            }

            return query.where(predicate.toArray(new Predicate[]{})).getRestriction();
        }
        );
    }
}
