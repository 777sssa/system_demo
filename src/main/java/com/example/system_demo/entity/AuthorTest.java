package com.example.system_demo.entity;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class AuthorTest {
    @Id
    private Integer id;
    private String name;
    private String author;

}