package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("UserSignUp") UserSignUp userSignUp){
        userService.signUp(userSignUp);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL){
        redirectURL = "";

        if (bindingResult.hasErrors()){
            return "login";
        }
        User loginUser = userService.login(loginForm.getLoginId(), loginForm.getPassword());

        if (loginUser == null){
            bindingResult.reject("Fail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }
        
        return "redirect:" + redirectURL;
    }

}
