package com.example.crudapp.repo;

import com.example.crudapp.model.SecurityGuard;
import com.example.crudapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for managing SecurityGuard entities
public interface SecurityGuardRepo extends JpaRepository<SecurityGuard, Long>  {
}
