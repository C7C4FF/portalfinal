package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
