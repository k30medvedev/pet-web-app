package com.mastery.java.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Hidden
@Tag(name = "Hidden", description = "Hidden controller")
@Controller
@RequestMapping("/swagger")
public class RootController {

    @GetMapping
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}