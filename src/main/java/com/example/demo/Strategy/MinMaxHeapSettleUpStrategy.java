package com.example.demo.Strategy;

import com.example.demo.DTOs.Transaction;
import com.example.demo.Models.Expense;
import com.example.demo.Models.ExpenseUser;
import com.example.demo.Models.ExpenseUserType;
import com.example.demo.Models.User;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class MinMaxHeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Transaction> settle(List<Expense> expenses) {

        Map<User, Integer> userBalance = new HashMap<>();

        for (Expense expense : expenses) {
            List<ExpenseUser> expenseUsers = expense.getExpenseUsers();  // Users in each expense
            for (ExpenseUser expenseUser : expenseUsers) {
                User user = expenseUser.getUser();
                int amount = expenseUser.getAmount();

                userBalance.putIfAbsent(user, 0);

                if (expenseUser.getExpenseUserType() == ExpenseUserType.PAID) {
                    userBalance.put(user, userBalance.get(user)+ amount );            // this combines the total for each user, if they appear twice or thrice in a expense
                }else if(expenseUser.getExpenseUserType() == ExpenseUserType.HAD_TO_PAY){ // HAD_TO_PAY
                    userBalance.put(user, userBalance.get(user)-amount);
                }
            }
        }

        PriorityQueue<User> givers = new PriorityQueue<>(Comparator.comparingInt(userBalance::get));
        PriorityQueue<User> receivers = new PriorityQueue<>((a,b) -> Integer.compare(userBalance.get(b), userBalance.get(a) ));

        for (Map.Entry<User, Integer> entry : userBalance.entrySet()) {
            if (entry.getValue() < 0) {
                givers.add(entry.getKey());
            } else if (entry.getValue() > 0) {
                receivers.add(entry.getKey());
            }
        }

        // 3. Settlement logic
        List<Transaction> transactions = new ArrayList<>();

        while (!givers.isEmpty() && !receivers.isEmpty()) {
            User giver = givers.poll();
            User receiver = receivers.poll();

            int giverBalance = userBalance.get(giver);     // Negative
            int receiverBalance = userBalance.get(receiver); // Positive

            int amountToSettle = Math.min(receiverBalance, -giverBalance);

            // Create dummy transaction
            Transaction txn = new Transaction();
            txn.setFrom(giver);
            txn.setTo(receiver);
            txn.setAmount(amountToSettle);
            transactions.add(txn);

            // Update balances
            userBalance.put(giver, giverBalance + amountToSettle);
            userBalance.put(receiver, receiverBalance - amountToSettle);

            // Re-insert users if they are not settled yet
            if (userBalance.get(giver) < 0) {
                givers.add(giver);
            }
            if (userBalance.get(receiver) > 0) {
                receivers.add(receiver);
            }
        }

        return transactions;

    }
}
