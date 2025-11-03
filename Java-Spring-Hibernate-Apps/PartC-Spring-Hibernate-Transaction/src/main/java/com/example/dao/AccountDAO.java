package com.example.dao;

import com.example.entity.Account;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
    @PersistenceContext private EntityManager em;

    public Account findById(int id) { return em.find(Account.class, id); }
    public void update(Account account) { em.merge(account); }
}