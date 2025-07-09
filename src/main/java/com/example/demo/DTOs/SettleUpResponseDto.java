package com.example.demo.DTOs;

import java.util.List;


public class SettleUpResponseDto {

    private List<Transaction> transactions;

    public SettleUpResponseDto (List<Transaction> transactions){
        this.transactions = transactions;
    }


    // Getter and setters

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
