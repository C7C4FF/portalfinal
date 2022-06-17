package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.CommentDto;
import kr.ac.jejunu.user.resolver.CurrentUser;
import kr.ac.jejunu.user.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@Slf4j
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment/{id}")
    public String comment(@ModelAttribute CommentDto commentDto,
                          @PathVariable("id")Long id,
                          @CurrentUser User user){
        log.info("commen 실행");
        Long saveCommentHomeId = commentService.saveComment(commentDto, id, user);
        return "redirect:/page/"+saveCommentHomeId;
    }
}
