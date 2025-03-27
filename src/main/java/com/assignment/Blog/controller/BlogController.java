package com.assignment.Blog.controller;

import com.assignment.Blog.model.Blog;
import com.assignment.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {

   @Autowired
   private BlogService blogService;

   @GetMapping("/greet")
   public String greet(){
       return "hello";
   }
   @PostMapping("/new")
    public Blog createBlog(@RequestBody Blog blog){
       return blogService.createBlog(blog);
   }
   @GetMapping("/all")
    public List<Blog> getAllBlogs(){
       return blogService.getAllBlogs();
   }

  @GetMapping("/{id}")
  public Optional<Blog> getBlogById(@PathVariable Long id){
       return blogService.getBlogById(id);
   }
   @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id,@RequestBody Blog blog){
       return blogService.updateBlog(id,blog);
   }
   @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id){
       blogService.deleteBlog(id);
   }

}
