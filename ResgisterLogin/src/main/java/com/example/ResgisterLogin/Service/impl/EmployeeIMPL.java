package com.example.ResgisterLogin.Service.impl;
import com.example.ResgisterLogin.Dto.EmployeeDTO;
import com.example.ResgisterLogin.Dto.LoginDTO;
import com.example.ResgisterLogin.Entity.Employee;
import com.example.ResgisterLogin.Repo.EmployeeRepo;
import com.example.ResgisterLogin.Response.LoginResponse;
import com.example.ResgisterLogin.Response.SaveResponse;
import com.example.ResgisterLogin.Service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addEmployee(EmployeeDTO employeeDTO) {
       // String msg = "Registered Successfully";

        String msg = "{\"Message\":\"Registered Successfully\", \"Status\":\"OK\"}";
        Employee emplyoee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(emplyoee);
       // return emplyoee.getEmployeename();
        return msg;
    }

    /*public SaveResponse saveResponse(EmployeeDTO employeeDTO) {
        Employee employee1 = employeeRepo.findByEmail(employeeDTO.getEmail());
        if (employee1 !=null){
            String password = employeeDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwsRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwsRight){
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(employeeDTO.getEmail(), encodedPassword);
                if(employee.isPresent()){
                    return new SaveResponse("Login Successfully", true);
                }
                else{
                    return new SaveResponse("Login Failed", false);
                }
            }
            else{
                return new SaveResponse("Password Not matched", false);
            }
        }
        else{
            return new SaveResponse("Email not exist", false);
        }

    }*/
    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 !=null){
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwsRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwsRight){
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(employee.isPresent()){
                    return new LoginResponse("Login Successfully", true);
                }
                else{
                    return new LoginResponse("Login Failed", false);
                }
            }
            else{
                return new LoginResponse("Password Not matched", false);
            }
        }
        else{
            return new LoginResponse("Email not exist", false);
        }

    }
}
