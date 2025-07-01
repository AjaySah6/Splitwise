package com.example.demo.DTOs;

import com.example.demo.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Transaction {
    private User from;
    private User to;
    private int amount;






    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
