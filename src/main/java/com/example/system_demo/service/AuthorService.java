package com.example.system_demo.service;

import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.AuthorTest;
import com.example.system_demo.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;
    public List<Author> findAll() {
        return authorMapper.findAll();
    }

    public List<Author> findByName(String name) {
        return authorMapper.findByName(name);
    }
}
