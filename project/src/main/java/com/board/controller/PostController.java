package com.board.controller;

import com.board.entity.Post;
import com.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String list(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "detail.html";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post/detail";
    }

    @GetMapping("/post/new")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/form";
    }

    @PostMapping("/post/new")
    public String create(@ModelAttribute Post post) {
        postService.Save(post);
        return "redirect:/";
    }

    @GetMapping("/post/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post/form";
    }

    @PostMapping("/post/edit/{id}")
    public String edit(@ModelAttribute Post post, @PathVariable Long id) {
        post.setId(id);
        postService.Save(post);
        return "redirect:/";
    }

    @GetMapping("/post/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.deleteById(id);
        return "redirect:/";
    }
}
