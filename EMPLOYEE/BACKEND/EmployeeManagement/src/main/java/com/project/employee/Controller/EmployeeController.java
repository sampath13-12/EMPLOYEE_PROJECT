package com.project.employee.Controller;

import com.project.employee.DTO.User;
import com.project.employee.Entity.EmployeeData;
import com.project.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/register")
    public HashMap<String, Object> registerUser(@RequestBody EmployeeData emp){
        HashMap<String,Object> response = new HashMap<String,Object>();
        try{
            EmployeeData registeredUser = service.registerTheUser(emp);
            response.put("message","User registered successfully");
            response.put("User",registeredUser);
            return response;
        }
        catch (Exception e){
            response.put("error",e.getMessage());
            return response;
        }
    }

    @PostMapping("/login")
    public HashMap<String, Object> loginUser(@RequestBody User user){
        HashMap<String,Object> response = new HashMap<String,Object>();
        try{
            EmployeeData loggedUser = service.loginTheUser(user);
            response.put("message","User Logged in successfully");
            response.put("User",loggedUser);
            return response;
        }
        catch (Exception e){
            response.put("error",e.getMessage());
            return response;
        }
    }


    @GetMapping("/get-all-users")
    public HashMap<String, Object> getAllUsers(){
        HashMap<String,Object> response = new HashMap<String,Object>();
        try{
            List<EmployeeData> allUsers = service.getAllTheUsers();
            response.put("message","Employees fetched successfully");
            response.put("Employees",allUsers);
            return response;
        }
        catch (Exception e){
            response.put("error",e.getMessage());
            return response;
        }
    }

    @PutMapping("/update-users")
    public HashMap<String, Object> updateUser(@RequestParam Long id , @RequestBody EmployeeData emp){
        HashMap<String,Object> response = new HashMap<String,Object>();
        try{
            EmployeeData updatedEmployee = service.updateTheUser(id,emp);
            response.put("message","Employee updated successfully");
            response.put("Employee",updatedEmployee);
            return response;
        }
        catch (Exception e){
            response.put("error",e.getMessage());
            return response;
        }
    }


    @DeleteMapping("/delete-user")
    public HashMap<String, Object> deleteUser(@RequestParam Long id){
        HashMap<String,Object> response = new HashMap<String,Object>();
        try{
            Boolean deletedEmployee = service.deleteTheUser(id);
            response.put("message","Employee deleted successfully");
            response.put("Deleted",deletedEmployee);
            return response;
        }
        catch (Exception e){
            response.put("error",e.getMessage());
            return response;
        }
    }





}
