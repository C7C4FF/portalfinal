package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(){
        return "signup.html";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("UserSignUp") UserSignUp userSignUp){
        userService.signUp(userSignUp);
        return "redirect:/";
    }
}
