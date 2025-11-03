package com.example.service;

import com.example.dao.AccountDAO;
import com.example.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    @Autowired private AccountDAO accountDAO;

    @Transactional
    public void transfer(int fromAcc, int toAcc, double amount) {
        Account from = accountDAO.findById(fromAcc);
        Account to = accountDAO.findById(toAcc);

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds in account " + from.getName());
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountDAO.update(from);
        accountDAO.update(to);

        System.out.println("Transaction successful!");
    }
}