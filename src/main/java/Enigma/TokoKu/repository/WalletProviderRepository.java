package Enigma.TokoKu.repository;

import Enigma.TokoKu.model.WalletProvider;
import Enigma.TokoKu.utill.WalletProviderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletProviderRepository extends
        JpaRepository<WalletProvider,Integer>,
        JpaSpecificationExecutor<WalletProvider> {

    WalletProvider findByName(String name);

    @Query("SELECT w_p.id as id, w_p.name as name from WalletProvider w_p")
    List<WalletProviderProjection> findAllProjectedBy();
}
