package com.example.demo.Repositories;

import com.example.demo.Models.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Models.User;
import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
