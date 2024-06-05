package com.example.system_demo.mapper;

import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.AuthorTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Select("select * from OAG.author")
    List<Author> findAll();

    //    @Select("SELECT * FROM OAG.author WHERE name LIKE CONCAT('%', #{name}, '%')")
    @Select("SELECT * FROM OAG.author WHERE name = #{name} LIMIT 1")
    Author findByName(String name);

}