package com.example.system_demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.service.AuthorService;
import com.example.system_demo.vo.AuthorProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> findByName(@RequestParam String name) {
//        ,@RequestParam int page, @RequestParam int size
        AuthorProfileVO authorProfile = authorService.getAuthorProfileByName(name);
//        Page<Paper> papers = authorService.getPapersByAuthorName(name, page, size);
        List<Paper> papers = authorService.getPapersByAuthorName(name);
        Map<String, Object> response = new HashMap<>();
        response.put("author", authorProfile);
//        response.put("papers", papers.getRecords());
//        response.put("total", papers.getTotal());
        response.put("papers", papers);
        return ResponseEntity.ok(response);
    }


}