package com.example.demo.Services;

import com.example.demo.DTOs.Transaction;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Models.Expense;
import com.example.demo.Models.ExpenseUser;
import com.example.demo.Models.User;
import com.example.demo.Repositories.ExpenseUserRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private SettleUpStrategy settleUpStrategy;
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;

    /*
    public SettleUpService() {
        // Hardcoded strategy, or any other strategy
        this.settleUpStrategy = new MinMaxHeapSettleUpStrategy();
    }

     */

    // or allow caller to pass strategy if needed
    public SettleUpService(SettleUpStrategy settleUpStrategy, UserRepository userRepository, ExpenseUserRepository expenseUserRepository) {
        this.settleUpStrategy = settleUpStrategy;
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    public List<Transaction> settleUpUser(Long userId){
        /*
        1. fetch user details
        2. get all the list of expense that user is involved in, from DB
        3. iterate through all expenses, to get who owes what and who will receive
        4. use min and max heap to algo to fins list of final transaction // strategy design pattern
        5. return the list of transaction
         */
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("please enter a valid user ID");
        }
        User user = userOptional.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        List<Expense> expenses = new ArrayList<>();

        for(ExpenseUser expenseUser: expenseUsers) {
            expenses.add(expenseUser.getExpense());
            expenseUser.getExpenseUserType();
        }

        //expenses have all the expenses where the current users and maybe other users are involved

        List<Transaction> transactions = settleUpStrategy.settle(expenses);

        List<Transaction> filteredTransactions = new ArrayList<>();
        for(Transaction transaction: transactions){
            if (transaction.getFrom().equals(user) || transaction.getTo().equals(user)){
                filteredTransactions.add(transaction);
            }
        }
        //this will give the transactions where our current user is a part of
        return filteredTransactions;
    }

    public List<Transaction> settleUPGroup(Long groupId){
        /*
         * 1. Get the group from database
         * 2. Get all the expenses that are part of that group
         * Everything else same as above
         */

        return null;
    }
}
