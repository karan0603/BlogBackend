package com.assignment.Blog.service;

import com.assignment.Blog.model.Blog;
import com.assignment.Blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

   @Autowired
   private BlogRepository blogRepository;

   @Autowired
   private SummarizationService summarizationService;
    public Blog createBlog(Blog blog) {

        String summary = summarizationService.summarizeText(blog.getContent());
        blog.setSummary(summary);

        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(updatedBlog.getTitle());
            blog.setContent(updatedBlog.getContent());
            blog.setAuthor(updatedBlog.getAuthor());
            blog.setSummary(summarizationService.summarizeText(updatedBlog.getContent()));
            return blogRepository.save(blog);
        }).orElseThrow(()->new RuntimeException("Blog not found"));
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
