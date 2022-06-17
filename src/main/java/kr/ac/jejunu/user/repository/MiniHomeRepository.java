package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.domain.MiniHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniHomeRepository extends JpaRepository<MiniHome, Long> {
}
