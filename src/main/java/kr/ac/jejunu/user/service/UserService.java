package kr.ac.jejunu.user.service;

import kr.ac.jejunu.user.repository.UserRepository;
import kr.ac.jejunu.user.dto.UserSignUpDto;
import kr.ac.jejunu.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
