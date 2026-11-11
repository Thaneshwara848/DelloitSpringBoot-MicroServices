package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyConroller {

	 // PUBLIC API 1
    @GetMapping("/home")
    public String home() {
        return "Welcome to Home Page";
    }

    // PUBLIC API 2
    @GetMapping("/about")
    public String about() {
        return "Welcome to About Page";
    }

    // PRIVATE API 1
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to Dashboard";
    }

    // PRIVATE API 2
    @GetMapping("/profile")
    public String profile() {
        return "Welcome to Employee Profile";
    }
 // PRIVATE API 2
    @GetMapping("/xyz")
    public String xyz() {
        return "Welcome to XYZ Profile";
    }
}
