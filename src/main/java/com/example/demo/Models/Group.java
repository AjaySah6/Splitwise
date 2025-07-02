package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity (name = "usergroup" ) // Change the table name
public class Group extends BaseModel {

    private String name;

    @ManyToMany
    private List<User> members;

    @OneToMany (mappedBy = "group")                     // Bi-directional Mapping, access all expenses from a group
    private List<Expense> expenses;




    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
