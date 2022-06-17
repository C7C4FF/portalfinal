package kr.ac.jejunu.user.service;

import kr.ac.jejunu.user.ImageUploader;
import kr.ac.jejunu.user.domain.MiniHome;
import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.UserProfileDto;
import kr.ac.jejunu.user.repository.MiniHomeRepository;
import kr.ac.jejunu.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MiniHomeService {

    private final MiniHomeRepository miniHomeRepository;
    private final UserRepository userRepository;


    @Transactional
    public void update(UserProfileDto userProfileDto, String path, User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        User user1 = optionalUser.get();
        if(user1.getMiniHome()==null){
            MiniHome miniHome=new MiniHome();
            miniHome.addUser(user1);
            miniHome.setIntroduction(userProfileDto.getIntroduction());
            miniHome.setPath(path);
            user1.setNickname(userProfileDto.getNickname());
            miniHomeRepository.save(miniHome);
            return;
        }
        MiniHome miniHome = user1.getMiniHome();
        miniHome.setIntroduction(userProfileDto.getIntroduction());
        miniHome.setPath(path);
        user1.setNickname(userProfileDto.getNickname());
    }
}
