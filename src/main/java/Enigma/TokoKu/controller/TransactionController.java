package Enigma.TokoKu.controller;

import Enigma.TokoKu.model.Transaction;
import Enigma.TokoKu.service.TransactionDetailService;
import Enigma.TokoKu.service.TransactionService;
import Enigma.TokoKu.utill.DTO.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionDetailService transactionDetailService;

    @PostMapping
    public Transaction create(@RequestBody TransactionRequestDTO req){
        return transactionService.create(req);
    }


    public List<Transaction> getAll() {
        return transactionService.getAll();
    }
}
