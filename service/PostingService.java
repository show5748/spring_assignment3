package com.hanghae.blog.service;

import com.hanghae.blog.models.Posting;
import com.hanghae.blog.repository.PostingRepository;
import com.hanghae.blog.dto.PostingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final 즉, 필수적으로 생성되어야 할 멤버 변수를 자동으로 생성하는 annotation
@Service //클래스에게 service임을 알려주는 annotation
public class PostingService {

    private final PostingRepository postingRepository;

    @Transactional //업뎃할때 DB에 반영 돼야 한다고
    public Long update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        posting.update(requestDto);
        return posting.getId();
    }
}