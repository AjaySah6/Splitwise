package com.example.demo.Repositories;

import com.example.demo.Models.Expense;
import com.example.demo.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroup(Group group); //works because Spring Data JPA derives a query from the method name. It knows group is a field in Expense, and it will query all Expense rows where group_id = ?
}
