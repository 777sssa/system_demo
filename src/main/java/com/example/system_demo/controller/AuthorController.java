package com.example.system_demo.controller;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.AuthorTest;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.service.AuthorService;
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
        Author author = authorService.findByName(name);
        List<Paper> papers = authorService.getPapersByAuthorName(name);
        Map<String, Object> response = new HashMap<>();
        response.put("author", author);
        response.put("papers", papers);
//        for (Paper paper : papers) {
//            List<Author> coAuthors = authorService.getAuthorsByPaperId(paper.getId());
//            response.put("coAuthorsForPaper_" + paper.getId(), coAuthors);
//        }
        return ResponseEntity.ok(response);
    }


}