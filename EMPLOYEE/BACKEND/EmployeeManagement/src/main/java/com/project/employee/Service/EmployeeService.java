package com.project.employee.Service;

import com.project.employee.DTO.User;
import com.project.employee.Entity.EmployeeData;

import java.util.List;

public interface EmployeeService {

    EmployeeData registerTheUser(EmployeeData emp);

    EmployeeData loginTheUser(User user);

    List<EmployeeData> getAllTheUsers();

    EmployeeData updateTheUser(Long id, EmployeeData emp);

    Boolean deleteTheUser(Long id);
}
