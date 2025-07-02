package com.example.demo.Strategy;

import com.example.demo.DTOs.Transaction;
import com.example.demo.Models.Expense;
import com.example.demo.Models.ExpenseUser;
import com.example.demo.Models.ExpenseUserType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class MinMaxHeapSettleUpStrategy implements SettleUpStrategy{

    @Override
    public List<Transaction> settle(List<Expense> expenses) {
//        for(Expense expense: expenses) {
//            List<ExpenseUser> expenseUsers = expense.getExpenseUsers();  // Users in each expense
//            for(ExpenseUser expenseUser: expenseUsers) {
//                extra_amount = 0;
//                if(expenseUser.getExpenseUserType() == ExpenseUserType.PAID) {
//                    amout_ex
//                }
//            }
//        }

        return null;
    }
}
