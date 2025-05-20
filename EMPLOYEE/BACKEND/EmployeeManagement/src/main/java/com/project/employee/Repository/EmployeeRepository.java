package com.project.employee.Repository;

import com.project.employee.Entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData,Long> {
    EmployeeData findByEmail(String email);

    EmployeeData findByEmailAndPassword(String email, String password);
}
