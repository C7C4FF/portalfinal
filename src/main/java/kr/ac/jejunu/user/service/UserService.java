package kr.ac.jejunu.user.service;

import kr.ac.jejunu.user.repository.UserRepository;
import kr.ac.jejunu.user.dto.UserSignUpDto;
import kr.ac.jejunu.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findUser(Long id){
        return userRepository.findById(id).get();
    }

    public User signUp(UserSignUpDto userSignUpDto){
        User user = new User();
        user.setUsername(userSignUpDto.getUsername());
        user.setNickname(userSignUpDto.getNickname());
        user.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
        this.userRepository.save(user);
        return user;
    }

    public User login(String loginId, String password){
        return userRepository.findByUsername(loginId)
                .filter(m -> passwordEncoder.matches(password, m.getPassword()))
                .orElse(null);
    }

    public Long getRamdomUser(User user) {
        List<User> all = userRepository.findAll();
        Random random=new Random(System.currentTimeMillis());
        int i = random.nextInt(all.size())+1;
        while (user.getId() == i){
            i = random.nextInt(all.size())+1;
        }
        return Long.valueOf(i);
    }
}
