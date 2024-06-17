package com.example.system_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//public interface PaperMapper {
//    List<Paper> findByAuthorId(@Param("authorId") String authorId);
//
//    List<Author> findAuthorsByPaperId(String paperId);
//}
public interface PaperMapper {
    @Select({
            "SELECT * FROM paper_1 WHERE author_id = #{authorId}",
            "UNION ALL",
            "SELECT * FROM paper_2 WHERE author_id = #{authorId}",
            "UNION ALL",
            "SELECT * FROM paper_3 WHERE author_id = #{authorId}",
            "UNION ALL",
            "SELECT * FROM paper_4 WHERE author_id = #{authorId}",
            "UNION ALL",
            "SELECT * FROM paper_5 WHERE author_id = #{authorId}",
            "UNION ALL",
            "SELECT * FROM paper_6 WHERE author_id = #{authorId}",
            "UNION ALL",
            "SELECT * FROM paper_7 WHERE author_id = #{authorId}"
    })
    List<Paper> findByAuthorId(Page<Paper> page, @Param("authorId") String authorId);
}