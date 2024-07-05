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
    /*  @Controller : 이 클래스가 Spring MVC의 컨트롤러임을 나타냄
    *   @Autowired : Spring이 'postService' 객체를 자동으로 주입하도록 함
    *   'postService' : 게시글 관련 비즈니스 로직을 처리하는 서비스
    */

    @GetMapping("/")
    //http://localhost:8080
    public String list(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "/post/list";
    }
    /*  게시글 목록 조회
    *   @GetMapping("/") : 루트 경로 ('/')에 대한 GET 요청을 처리함
    *   'List<Post> posts = postService.findAll()' : 모든 게시글을 조회함
    *   'model.addAttribute("posts", posts)' : 조회된 게시글 목록을 모델에 추가하여 뷰에서 사용할 수 있게 한다.
    *   'return "list"' : 'list' 템플릿을 반환함.
    */
    @GetMapping("/post/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post/detail";
    }
    /*  게시글 상세 조회
    *   @GetMapping("/post/{id}") : 특정 게시글에 대한 GET 요청을 처리함
    *   @PathVariable Long id : URL 경로에서 게시글 ID를 추출하여 사용한다.
    *   "Post post = postService.findById(id).orElse(null);" : 주어진 ID로 게시글을 조회함
    *   "return "post/detail";" : 'post/detai.html' 템플릿을 반환한다.
    */

    @GetMapping("/post/new")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/form";
    }
    /*  게시글 생성 폼
    *   @GetMapping("/post/new") : 새 게시글 작성을 위한 GET 요청을 처리함
    *   model.addAttribute("post", new Post()); : 빈 'Post' 객체를 모델에 추가하여 뷰에서 사용할 수 있게 함
    *   return "post/form"; "post/form.html" 템플릿을 반환함
    */

    @PostMapping("/post/new")
    public String create(@ModelAttribute Post post) {
        postService.Save(post);
        return "redirect:/";
    }
    /*  @PostMapping("/post/new") : 새 게시글 작성을 위한 post 요청을 처리함.
     *  @ModelAttribute Post post : 폼 데이터로부터 'Post' 객체를 생성함.
     *  postService.Save(post); : 새로운 게시글을 저장함.
     *  return "redirect:/"; : root 경로로 리다이렉션함(redirect : 사용자 처음 요청한 url이 아닌 다른 url을 보내는 것을 뜻함).
    */

    @GetMapping("/post/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post/form";
    }
    /*  @GetMapping("/post/edit/{id}") : 게시글 수정을 위한 GET 요청을 처리함.
    *   @PathVariable Long id : URL 경로에서 게시글 ID를 추출하여 사용함.
    *   'Post post = postService.findById(id).orElse(null) : 주어진 ID로 게시글을 조회함.
    *   'model.addAttribute("post", post) : 조회된 게시글을 모델에 추가함.
    *   'return "post/form" : post/form.html 템플릿을 반환함.'
    */

    @PostMapping("/post/edit/{id}")
    public String edit(@ModelAttribute Post post, @PathVariable Long id) {
        post.setId(id);
        postService.Save(post);
        return "redirect:/";
    }
    /*  '@PostMapping("/post/edit/{id}") : 게시글 수정을 위한 POST 요청을 처리합니다.
        @ModelAttribute Post post : 폼 데이터로부터 Post 객체를 생성합니다.
        @PathVariable Long id : URL 경로에서 게시글 ID를 추출하여 사용합니다.
        post.setId(id) : 수정할 게시글의 ID를 설정합니다.
        postService.Save(post) : 게시글을 저장합니다.
        return "redirect:/" : 루트 경로로 리다이렉션합니다.'
    */
    @GetMapping("/post/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.deleteById(id);
        return "redirect:/";
    }
    /*  '@GetMapping("/post/delete/{id}") : 게시글 삭제를 위한 GET 요청을 처리합니다.'
        '@PathVariable Long id : URL 경로에서 게시글 ID를 추출하여 사용합니다.'
        'postService.deleteById(id) : 주어진 ID로 게시글을 삭제합니다. '
        'return "redirect:/" : 루트 경로로 리다이렉션합니다.'
    */
}
