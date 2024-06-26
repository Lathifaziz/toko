package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.WalletProvider;
import Enigma.TokoKu.repository.WalletProviderRepository;
import Enigma.TokoKu.service.WalletProviderService;
import Enigma.TokoKu.utill.SearchWalletProviderRequest;
import Enigma.TokoKu.utill.WalletProviderProjection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet_provider")
public class WalletProviderController {
    public  WalletProviderController (WalletProviderService walletProviderService, WalletProviderRepository walletProviderRepository){
        this.walletProviderRepository = walletProviderRepository;
        this.walletProviderService = walletProviderService;
    }
    private final WalletProviderRepository walletProviderRepository;
    private final WalletProviderService walletProviderService;

    @PostMapping
    public WalletProvider create(@RequestBody WalletProvider req){
        return walletProviderService.create(req);
    }
    @GetMapping
    public List<WalletProvider> getAll(@RequestParam(required = false)String name){
        SearchWalletProviderRequest req = new SearchWalletProviderRequest();
        req.setName(name);
        return  walletProviderService.getAll(req);
    }
    @GetMapping("/custom")
    public List<WalletProviderProjection> getAllCustom(){
        return walletProviderRepository.findAllProjectedBy();
    }
    @GetMapping("/{id}")
    public WalletProvider getone(@PathVariable Integer id){
        return walletProviderService.getOne(id);
    }
    @PutMapping("/{id}")
    public WalletProvider update (@PathVariable Integer id, @RequestBody WalletProvider req){
        return walletProviderService.update(req, id);
    }
    @DeleteMapping("/{id}")
    public  void delete (@PathVariable Integer id){
        walletProviderService.delete(id);
    }
}
