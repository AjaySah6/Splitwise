package com.example.demo.Strategy;

import com.example.demo.DTOs.Transaction;
import com.example.demo.Models.Expense;

import java.util.List;

public interface SettleUpStrategy {

    public List<Transaction> settle(List<Expense> expenses);

}
