package Enigma.TokoKu.service.imp;
import Enigma.TokoKu.model.Customer;
import Enigma.TokoKu.model.CustomerWallet;
import Enigma.TokoKu.model.WalletProvider;
import Enigma.TokoKu.repository.WalletProviderRepository;
import Enigma.TokoKu.service.CustomerService;
import Enigma.TokoKu.service.CustomerWalletService;
import Enigma.TokoKu.service.WalletProviderService;
import Enigma.TokoKu.utill.DTO.WalletProviderRequestDTO;
import Enigma.TokoKu.utill.SearchWalletProviderRequest;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletProviderServiceImpl implements WalletProviderService {
    private final WalletProviderRepository walletProviderRepository;
    private final CustomerService cService;
    private final CustomerWalletService cWService;

    @Override
    public List<WalletProvider> getAll(SearchWalletProviderRequest req) {
        return walletProviderRepository.findAll();
    }

    @Override
    public WalletProvider getOne(Integer id) {
        return walletProviderRepository.findById(id).orElse(null);
    }

    @Override
    public WalletProvider create(WalletProviderRequestDTO req) {
        Customer customer = cService.getOne(req.getCustomer_id());

        WalletProvider addWallet = new WalletProvider();
        addWallet.setCustomer(customer);
        WalletProvider addedWallet = walletProviderRepository.save(addWallet);

        CustomerWallet cWallet = new CustomerWallet();
        cWallet.setCustomer(customer);
        cWallet.setWalletProvider(addedWallet);
        cWallet.setBallance(req.getBallance());
        cWService.create(cWallet);

        return addedWallet;
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
