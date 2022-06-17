package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.ImageUploader;
import kr.ac.jejunu.user.domain.User;
import kr.ac.jejunu.user.dto.UserProfileDto;
import kr.ac.jejunu.user.resolver.CurrentUser;
import kr.ac.jejunu.user.service.MiniHomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MiniHomeController {

    private final MiniHomeService miniHomeService;
    private final ImageUploader imageUploader;

    @GetMapping("/user/minihome/update")
    public String Update() {
        return "update";
    }

    @PostMapping("/user/minihome/update")
    public String update(@ModelAttribute UserProfileDto userProfileDto,
                         @RequestPart("file") MultipartFile multipartFile,
                         HttpServletRequest httpServletRequest,
                         @CurrentUser User user) throws IOException {
        log.info(multipartFile.getOriginalFilename());
        String save = imageUploader.save(multipartFile, httpServletRequest);
        miniHomeService.update(userProfileDto, save, user);
        return "redirect:/page";
    }
}
