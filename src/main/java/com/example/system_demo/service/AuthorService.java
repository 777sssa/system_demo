package com.example.system_demo.service;

import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.mapper.AuthorMapper;
import com.example.system_demo.mapper.PaperMapper;
import com.example.system_demo.vo.AuthorProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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

    public AuthorProfileVO getAuthorProfileByName(String name) {
        return authorMapper.findAuthorProfileByName(name);
    }

    public Page<Paper> getPapersByAuthorName(String name, int page, int size) {
        AuthorProfileVO authorProfile = authorMapper.findAuthorProfileByName(name);
        if (authorProfile != null && authorProfile.getAuthorId() != null) {
            Page<Paper> paperPage = new Page<>(page, size);
            List<Paper> papers = paperMapper.findByAuthorId(paperPage, authorProfile.getAuthorId());
            paperPage.setRecords(papers);
            return paperPage;
        }
        return new Page<>();
    }

}