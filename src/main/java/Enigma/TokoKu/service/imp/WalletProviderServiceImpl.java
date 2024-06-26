package Enigma.TokoKu.service.imp;
import Enigma.TokoKu.model.WalletProvider;
import Enigma.TokoKu.repository.WalletProviderRepository;
import Enigma.TokoKu.service.WalletProviderService;
import Enigma.TokoKu.utill.SearchWalletProviderRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletProviderServiceImpl implements WalletProviderService {
    private final WalletProviderRepository walletProviderRepository;

    public WalletProviderServiceImpl(WalletProviderRepository walletProviderRepository){
        this.walletProviderRepository = walletProviderRepository;
    }

    @Override
    public List<WalletProvider> getAll(SearchWalletProviderRequest req) {
        return walletProviderRepository.findAll();
    }

    @Override
    public WalletProvider getOne(Integer id) {
        return walletProviderRepository.findById(id).orElse(null);
    }

    @Override
    public WalletProvider create(WalletProvider req) {
        return walletProviderRepository.save(req);
    }

    @Override
    public WalletProvider update(WalletProvider req, Integer id) {
        WalletProvider wp = this.getOne(id);
        wp.setName(req.getName());
        walletProviderRepository.save(req);
        return wp;
    }

    @Override
    public void delete(Integer id) {
        walletProviderRepository.deleteById(id);
    }

    private Specification<WalletProvider> getWalletProviderSpesification(SearchWalletProviderRequest req){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (req.getName() != null) {
                Predicate namePredicate = criteriaBuilder.like(
                        root.get("name"),"%"+req.getName()+"%"
                );
                predicate.add(namePredicate);
            }
            return query.where(predicate.toArray(new Predicate[]{})).getRestriction();
        });
    }
}
