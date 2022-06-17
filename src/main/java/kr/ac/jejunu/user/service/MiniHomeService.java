package kr.ac.jejunu.user.service;

import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.UserProfileDto;
import kr.ac.jejunu.user.repository.MiniHomeRepository;
import kr.ac.jejunu.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MiniHomeService {

    private final MiniHomeRepository miniHomeRepository;
    private final UserRepository userRepository;
    public void update(UserProfileDto userProfileDto, MultipartFile multipartFile, User user) {


    }
}
