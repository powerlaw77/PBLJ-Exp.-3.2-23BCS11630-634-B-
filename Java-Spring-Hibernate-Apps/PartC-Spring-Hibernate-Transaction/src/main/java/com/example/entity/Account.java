package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    private int acc_id;
    @Column private String name;
    @Column private double balance;

    public int getAcc_id() { return acc_id; }
    public void setAcc_id(int acc_id) { this.acc_id = acc_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}