package com.project.employee.Service;

import com.project.employee.DTO.User;
import com.project.employee.Entity.EmployeeData;
import com.project.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repo;


    @Override
    public EmployeeData registerTheUser(EmployeeData emp) {
       EmployeeData existingUser = repo.findByEmail(emp.getEmail());
       if(existingUser!=null){
           throw new RuntimeException("Already user is registered with this emailId");
       }
       else{
           return repo.save(emp);
       }
    }

    @Override
    public EmployeeData loginTheUser(User user) {
        EmployeeData presentUser = repo.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(presentUser==null){
            throw new RuntimeException("User not present please register");
        }
        else{
            return presentUser;
        }
    }

    @Override
    public List<EmployeeData> getAllTheUsers() {
         List<EmployeeData> allUsers = repo.findAll();
         if (allUsers.isEmpty()){
             throw new RuntimeException("No user found please register");
         }
         else{
             return allUsers;
         }
    }

    @Override
    public EmployeeData updateTheUser(Long id, EmployeeData emp) {
        Optional<EmployeeData> presentUser = repo.findById(id);
        if(presentUser.isEmpty()){
            throw new RuntimeException("Employee not found please try again");
        }
        else{
             EmployeeData needToUpdate = presentUser.get();
             needToUpdate.setEmail(emp.getEmail());
             needToUpdate.setPassword(emp.getPassword());
             needToUpdate.setUsername(emp.getUsername());
             return repo.save(needToUpdate);
        }
    }

    @Override
    public Boolean deleteTheUser(Long id) {
        Optional<EmployeeData> presentUser = repo.findById(id);
        if(presentUser.isEmpty()){
            throw new RuntimeException("No employee found to delete");
        }
        else{
            repo.deleteById(id);
            return true;
        }
    }
}
