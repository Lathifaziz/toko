package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.Bank;
import Enigma.TokoKu.repository.BankRepository;
import Enigma.TokoKu.service.BankService;
import Enigma.TokoKu.utill.BankProjection;
import Enigma.TokoKu.utill.SearchBankRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    public  BankController(BankRepository bankRepository,BankService bankService){
        this.bankRepository = bankRepository;
        this.bankService = bankService;
    }

    private final BankService bankService;
    private final BankRepository bankRepository;

    @PostMapping
    public Bank create(@RequestBody Bank req){
        return bankService.create(req);
    }
    @GetMapping
    public List<Bank> getAll(@RequestParam (required =false) String name){
        SearchBankRequest req = new SearchBankRequest();
        req.setName(name);
        return bankService.getAll(req);
    }
    @GetMapping("/cutom")
    public List<BankProjection> getAllCustom(){
        return bankRepository.findAllProjectedBy();
    }
    @GetMapping("/{id}")
    public Bank getOne (@PathVariable Integer id){
        return bankService.getOne(id);
    }
    @PutMapping("/{id}")
    public Bank update(@PathVariable Integer id,@RequestBody Bank req){
        return bankService.update(id, req);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        bankService.delete(id);
    }

}
