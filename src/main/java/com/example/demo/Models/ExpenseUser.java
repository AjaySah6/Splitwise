package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel {

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;

    public ExpenseUserType getExpenseUserType() {
        return expenseUserType;
    }

    public void setExpenseUserType(ExpenseUserType expenseUserType) {
        this.expenseUserType = expenseUserType;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
