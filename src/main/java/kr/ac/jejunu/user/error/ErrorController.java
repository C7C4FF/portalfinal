package kr.ac.jejunu.user.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public String signupError(DataIntegrityViolationException dataIntegrityViolationException, Model model){
        model.addAttribute("doublecheck",true);

        return "signup";
    }
}
