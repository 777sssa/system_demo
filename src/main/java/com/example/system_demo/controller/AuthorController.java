package com.example.system_demo.controller;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.AuthorTest;
import com.example.system_demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/findAll")
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/findByName")
    public List<Author> findByName(@RequestParam String name) {
        return authorService.findByName(name);
    }


}
