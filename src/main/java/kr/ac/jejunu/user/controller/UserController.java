package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.LoginFormDto;
import kr.ac.jejunu.user.dto.UserSignUpDto;
import kr.ac.jejunu.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("UserSignUp") UserSignUpDto userSignUpDto){
        userService.signUp(userSignUpDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginFormDto loginForm){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginFormDto loginForm,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request){

        if (bindingResult.hasErrors()){
            return "login";
        }
        User loginUser = userService.login(loginForm.getLoginId(), loginForm.getPassword());
        // redirectURL = String.valueOf(loginUser.getId());
        redirectURL = "page";
        if (loginUser == null){
            bindingResult.reject("Fail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("member",loginUser);
        return "redirect:" + redirectURL;
    }

    @GetMapping("/page")
    public String Page(){
        return "page";
    }
}
