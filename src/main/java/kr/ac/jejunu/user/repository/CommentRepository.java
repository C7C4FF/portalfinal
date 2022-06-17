package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
