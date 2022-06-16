package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(UserSignUp userSignUp){
        User user = new User();
        user.setUsername(userSignUp.getUsername());
        user.setNickname(userSignUp.getNickname());
        user.setPassword(passwordEncoder.encode(userSignUp.getPassword()));
        this.userRepository.save(user);
        return user;
    }

    public User login(String loginId, String password){
        return userRepository.findByUsername(loginId)
                .filter(m -> passwordEncoder.matches(password, m.getPassword()))
                .orElse(null);
    }
}
