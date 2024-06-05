package com.example.system_demo.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Data
public class Paper {

    @Id
    @Column(name = "id", length = 24)
    private String id;

    @Column(name = "title", length = 1000)
    private String title;

    @Column(name = "abstract", columnDefinition = "MEDIUMTEXT")
    private String abstractText; // 使用 'abstractText' 作为字段名，因为 'abstract' 是 Java 的关键字

    @Column(name = "keywords", columnDefinition = "MEDIUMTEXT")
    private String keywords;

    @Column(name = "year", length = 10)
    private String year;

    @Column(name = "authors", columnDefinition = "LONGTEXT")
    private String authors;

    @Column(name = "references", columnDefinition = "LONGTEXT")
    private String references;

    @Column(name = "doi", length = 500)
    private String doi;

    @Column(name = "n_citation", length = 10)
    private String nCitation;

    @Column(name = "venue", columnDefinition = "TEXT")
    private String venue;
}
