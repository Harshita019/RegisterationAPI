package com.example.ResgisterLogin.EmployeeController;

import com.example.ResgisterLogin.Dto.EmployeeDTO;
import com.example.ResgisterLogin.Dto.LoginDTO;
import com.example.ResgisterLogin.Response.LoginResponse;
import com.example.ResgisterLogin.Response.SaveResponse;
import com.example.ResgisterLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController   //because rest api
@CrossOrigin
@RequestMapping("api/v1/employee")

public class EmployeeController {

  @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

   /* @PostMapping(path = "/save")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        SaveResponse saveResponse = employeeService.saveResponse(employeeDTO);
        return ResponseEntity.ok(saveResponse);
    }*/

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);

    }
}
