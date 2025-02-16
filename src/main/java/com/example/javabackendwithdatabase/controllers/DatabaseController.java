package com.example.javabackendwithdatabase.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/database")
public class DatabaseController {

    @GetMapping(path="/status")
    public @ResponseBody String status() {
        String database = System.getenv("MYSQL_DATABASE_NAME");
        return "You are connected to database: " + database;
    }
}
