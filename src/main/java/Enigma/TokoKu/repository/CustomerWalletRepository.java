package Enigma.TokoKu.repository;

import Enigma.TokoKu.model.CustomerWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Integer> {
}
