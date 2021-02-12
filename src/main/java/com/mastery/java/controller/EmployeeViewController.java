package com.mastery.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeViewController {

    @GetMapping("/view-employees")
    public String viewEmployees() {
        return "view-employees";
    }

    @GetMapping("/id")
    public String fillEmployeeId() {
        return "id";
    }

    @GetMapping("/id-delete")
    public String getIdToDelete() {
        return "id-delete";
    }

    @GetMapping ("/delete-by-id")
    public String deleteUserById() {
        return "delete-by-id";
    }

    @GetMapping("/find-by-id")
    public String viewEmployeeById() {
        return "find-by-id";
    }

    @GetMapping("/")
    public String mainPage() {
        return "start";
    }
}
