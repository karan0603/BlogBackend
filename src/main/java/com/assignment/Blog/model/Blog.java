package com.assignment.Blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="blogs")
public class Blog {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String title;

   @Column(columnDefinition = "TEXT")
   private String content;

    private String author;

   @Column(columnDefinition = "TEXT")
   private String summary;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
