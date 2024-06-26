package Enigma.TokoKu.repository;

import Enigma.TokoKu.model.Bank;
import Enigma.TokoKu.utill.BankProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer>, JpaSpecificationExecutor<Bank> {

    Bank findByName(String name);

    @Query("select b.id as id, b.name as name from Bank b")
    List<BankProjection>findAllProjectedBy();
}
