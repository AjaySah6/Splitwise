package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    private int amount;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers; // will give us who paid; and who had to pay

    public List<ExpenseUser> getExpenseUsers() {
        return expenseUsers;
    }

    public void setExpenseUsers(List<ExpenseUser> expenseUsers) {
        this.expenseUsers = expenseUsers;
    }
}
