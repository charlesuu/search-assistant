package com.hyunho.springboot.service.posts;

import com.hyunho.springboot.domain.posts.Posts;
import com.hyunho.springboot.domain.posts.PostsRepository;
import com.hyunho.springboot.web.dto.PostsResponseDto;
import com.hyunho.springboot.web.dto.PostsSaveRequestDto;
import com.hyunho.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional//중간에 하나의 작업이라도 실패하면 모든 작업을 롤백, 동시성 문제로 인하여 auto_increment된 id는 롤백 되지 않는다.
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findByid(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}