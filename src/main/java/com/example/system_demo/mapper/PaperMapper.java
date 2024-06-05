package com.example.system_demo.mapper;

import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {
    List<Paper> findByAuthorId(@Param("authorId") String authorId);

    List<Author> findAuthorsByPaperId(String paperId);
}
