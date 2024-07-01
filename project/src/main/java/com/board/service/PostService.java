package com.board.service;

import com.board.entity.Post;
import com.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//이 클래스가 서비스 계층 컴포넌트임을 나타냄. Spring이 이 클래스를 서비스 빈으로 등록함
public class PostService {
    @Autowired//Spring이 'PostRepository'타입의 빈을 주입하도록 지시
    private PostRepository postRepository;//'PostRepository' 인터페이스의 인스턴스를 저장하는 필드이며, 이 인터페이스는 데이터베이스와 상호작용하는데 사용됨

    public List<Post> findAll(){
        //모든 게시물을 조회, findAll() 메서드를 통해 데이터베이스에서 모든 게시물을 가져옴
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id){
        //주어진 id로 게시물을 조회함. findById 메서드는 존재하지 않을 수 있는 객체를 반환하므로, java 8의 Optional 클래스를 사용함
        return postRepository.findById(id);//postRepository에서 제공하는 findById 메서드를 호출하여 데이터베이스에서 해당 id의 게시물을 가져옴
    }
    public Post Save(Post post){
        //주어진 게시물을 저장함
        return postRepository.save(post);//PostRepository에서 제공하는 save 메서드를 호출하여 데이터베이스에 게시물을 저장. save 메서드는 저장된 엔티티를 반환함
    }
    public void deleteById(Long id){
        //주어진 ID로 게시물을 삭제함
        postRepository.deleteById(id);//PostRepository에서 제공하는 deleteById 메서드를 호출하여 데이터베이스에서 해당 ID의 게시물을 삭제합니다.
    }

}
