package com.example.ResgisterLogin.Service;

import com.example.ResgisterLogin.Dto.EmployeeDTO;
import com.example.ResgisterLogin.Dto.LoginDTO;
import com.example.ResgisterLogin.Response.LoginResponse;
import com.example.ResgisterLogin.Response.SaveResponse;

public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

    //SaveResponse saveResponse(EmployeeDTO employeeDTO);
    LoginResponse loginEmployee(LoginDTO loginDTO);

}
