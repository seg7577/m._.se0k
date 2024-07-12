package com.board.controller;

import com.board.entity.Post;
import com.board.entity.Member;
import com.board.service.MemberService;
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
    @Autowired
    private MemberService memberService;
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

    @GetMapping("/post/account")
    public String MemberShipAccount(Model model)
    {
        return "post/MembershipAccount";
    }
    /*  게시글 목록 조회
    *   @GetMapping("/") : 루트 경로 ('/')에 대한 GET 요청을 처리함
    *   'List<Post> posts = postService.findAll()' : 모든 게시글을 조회함
    *   'model.addAttribute("posts", posts)' : 조회된 게시글 목록을 모델에 추가하여 뷰에서 사용할 수 있게 한다.
    *   'return "list"' : 'list' 템플릿을 반환함.
    */
    @GetMapping("/post/{id}")
    public String detail(@PathVariable Long id, Model model) {
        //list.html에서 게시글의 제목을 클리하게 될 경우 호출된다.
        //@PathVariable은 경로 변수를 표시하기 위해 메서드에 매개변수로 사용되고 있는 것이다.
        Post post = postService.findById(id).orElse(null);
        //whitelabel Error Page가 뜸
        /*Mon Jul 08 17:10:56 KST 2024
          There was an unexpected error (type=Internal Server Error, status=500).
          Error resolving template [error/404], template might not exist or might not be accessible by any of the configured Template Resolvers

          주소를 보아하니 /post/id가 올바르게 뜸 finById를 통해서 Id를 가져오는 건 문제가 아닌듯 함

          2024-07-08T17:10:22.717+09:00 ERROR 11981 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.thymeleaf.exceptions.TemplateInputException: Error resolving template [error/404], template might not exist or might not be accessible by any of the configured Template Resolvers] with root cause
          Servlet : 동적 웹 페이지를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술로 웹 요청과 응답의 흐름을 간단한 메서드 호출만으로 체계적으로 다룰 수 있게 해주는 것
        */

        model.addAttribute("post", post);
        //@ModelAttribute를 사용하면 타입에 관계없이 파라미터를 Model에 담아서 전달한다. 기본 자료형의 경우 반드시 value 속성 값을 지정해야 한다.
        //post값을 model객체로 view에 전달한다.
        if(post == null)
            return "error/404";
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

    @PostMapping("/posts")
    public String create(@ModelAttribute Post post) {
        postService.Save(post);
        return "post/usercreate";
        //return "redirect:/";
    }
    /*  @PostMapping("/post/new") : 새 게시글 작성을 위한 post 요청을 처리함.
     *  @ModelAttribute Post post : 폼 데이터로부터 'Post' 객체를 생성함.
     *  postService.Save(post); : 새로운 게시글을 저장함.
     *  return "redirect:/"; : root 경로로 리다이렉션함(redirect : 사용자 처음 요청한 url이 아닌 다른 url을 보내는 것을 뜻함).
     */
    @PostMapping("/members")
    public String create(@ModelAttribute Member member) {
        memberService.Save(member);
        return "post/usercreate";
    }
    @PostMapping("/members/_check")
    public String check(@ModelAttribute Member member) {
        memberService.getEmail(member);
        memberService.getPassword(member);
    }

    @GetMapping("/posts")
    //글 작성 이후 "이전 페이지로 이동"의 하이퍼링크를 누를 경우 시작 페이지로 이동하게 해주는 메서드이다.
    public String test(@ModelAttribute Post post){
    //@ModelAttribute는 사용자가 요청시 전달하는 값을 Object 형태로 Mapping해주는 Anootation이다.
        return "redirect:/";
        //"/post/list"가 아닌 redirect:/을 사용하여 root 경로로 돌아가게 함
    }


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
