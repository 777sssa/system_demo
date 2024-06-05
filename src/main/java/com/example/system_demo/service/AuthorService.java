package com.example.system_demo.service;

import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.AuthorTest;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.mapper.AuthorMapper;
import com.example.system_demo.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private PaperMapper paperMapper;
    public List<Author> findAll() {
        return authorMapper.findAll();
    }

    public Author findByName(String name) {
//        List<Author> authors =authorMapper.findByName(name);
//        if (authors != null && !authors.isEmpty()) {
//            return authors.get(0); // 仅返回第一个匹配的作者
//        }
//        return null; // 如果没有匹配的作者，返回 null
        Author author=authorMapper.findByName(name);
        return author;
    }

    public List<Paper> getPapersByAuthorName(String name) {
        Author author = authorMapper.findByName(name);
        if (author != null) {
            return paperMapper.findByAuthorId(author.getId());
        }
        return Collections.emptyList();
    }

    public List<Author> getAuthorsByPaperId(String paperId) {
        return paperMapper.findAuthorsByPaperId(paperId);
    }
}