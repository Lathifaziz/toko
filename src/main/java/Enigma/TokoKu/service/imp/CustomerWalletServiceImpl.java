package Enigma.TokoKu.service.imp;

import Enigma.TokoKu.model.CustomerWallet;
import Enigma.TokoKu.repository.CustomerWalletRepository;
import Enigma.TokoKu.service.CustomerWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerWalletServiceImpl implements CustomerWalletService {
    private final CustomerWalletRepository customerWR;

    @Override
    public List<CustomerWallet> getAll() {
        return customerWR.findAll();
    }

    @Override
    public CustomerWallet create(CustomerWallet req) {
        return customerWR.save(req);
    }

    @Override
    public CustomerWallet getOne(Integer id) {
        return customerWR.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerWR.deleteById(id);
    }
}
