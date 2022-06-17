package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.UserProfileDto;
import kr.ac.jejunu.user.resolver.CurrentUser;
import kr.ac.jejunu.user.service.MiniHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class MiniHomeController {

    private final MiniHomeService miniHomeService;

    @GetMapping("/user/minihome/update")
    public String Update() {
        return "update";
    }

    @PostMapping("/user/minihome/update")
    public String update(@ModelAttribute UserProfileDto userProfileDto,
                         @RequestPart("propic") MultipartFile multipartFile,
                         @CurrentUser User user) {
        miniHomeService.update(userProfileDto, multipartFile, user);
        return null;
    }
}
