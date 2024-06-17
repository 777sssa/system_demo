package com.example.system_demo.mapper;

import com.example.system_demo.entity.Author;
import com.example.system_demo.vo.AuthorProfileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Select("select * from OAG.author")
    List<Author> findAll();

    //    @Select("SELECT * FROM OAG.author WHERE name LIKE CONCAT('%', #{name}, '%')")
    AuthorProfileVO findAuthorProfileByName(String name);

}