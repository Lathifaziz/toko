package Enigma.TokoKu.service;

import Enigma.TokoKu.model.Bank;
import Enigma.TokoKu.model.WalletProvider;
import Enigma.TokoKu.utill.SearchWalletProviderRequest;

import java.util.List;

public interface WalletProviderService {
    List<WalletProvider> getAll(SearchWalletProviderRequest req);
    WalletProvider getOne(Integer id);
    WalletProvider create (WalletProvider req);
    WalletProvider update(WalletProvider req, Integer id);
    void delete (Integer id);
}
