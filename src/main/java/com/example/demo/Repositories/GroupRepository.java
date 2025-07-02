package com.example.demo.Repositories;

import com.example.demo.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {
    @Override
    Optional<Group> findById(Long id);
}
