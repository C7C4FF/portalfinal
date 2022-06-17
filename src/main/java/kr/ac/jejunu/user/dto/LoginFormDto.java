package kr.ac.jejunu.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginFormDto {
    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
}
