package com.souparnikar.gameclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souparnikar.gameclub.modal.Transaction;
import com.souparnikar.gameclub.repository.TransactionRepository;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repo;

    // @PostMapping
    // public Transaction create(@RequestBody Transaction transaction) {
    //     transaction.setId(null); // Let MongoDB generate ObjectId
    //     transaction.setDateTime(new Date()); // Default to now
    //     return repo.save(transaction);
    // }

    @GetMapping
    public List<Transaction> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Transaction findById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    // @PutMapping("/{id}")
    // public Transaction update(@PathVariable String id, @RequestBody Transaction transaction) {
    //     return repo.findById(id).map(old -> {
    //         old.setMemberId(transaction.getMemberId());
    //         old.setGameId(transaction.getGameId());
    //         old.setAmount(transaction.getAmount());
    //         old.setDateTime(transaction.getDateTime() != null ? transaction.getDateTime() : old.getDateTime());
    //         return repo.save(old);
    //     }).orElse(null);
    // }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
