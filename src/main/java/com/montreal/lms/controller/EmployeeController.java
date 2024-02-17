package com.montreal.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    // add a request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "/employees/leaders";
    }

    // add a request mapping for /systems
    @GetMapping("/systems")
    public String showSystems(){
        return "/employees/systems";
    }

    // add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "/employees/access-denied";
    }
}
