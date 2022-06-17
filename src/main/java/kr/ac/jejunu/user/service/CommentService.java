package kr.ac.jejunu.user.service;

import kr.ac.jejunu.user.domain.Comment;
import kr.ac.jejunu.user.domain.MiniHome;
import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.CommentDto;
import kr.ac.jejunu.user.repository.CommentRepository;
import kr.ac.jejunu.user.repository.MiniHomeRepository;
import kr.ac.jejunu.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MiniHomeRepository miniHomeRepository;
    private final UserRepository userRepository;


    public Long saveComment(CommentDto commentDto, Long id, User requestUser) {
        Optional<User> optionalUser = userRepository.findById(requestUser.getId());
        Optional<User> miniHomeUserOptional = userRepository.findById(id);
        miniHomeUserOptional.orElseThrow(()->new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        optionalUser.orElseThrow(()->new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        User user = optionalUser.get();
        User miniHomeUser = miniHomeUserOptional.get();
        Comment comment = new Comment();
        comment.addUser(user);
        comment.addMiniHome(miniHomeUser.getMiniHome());
        comment.setCommentbody(commentDto.getComment());
        commentRepository.save(comment);
        return miniHomeUser.getId();
    }
}
