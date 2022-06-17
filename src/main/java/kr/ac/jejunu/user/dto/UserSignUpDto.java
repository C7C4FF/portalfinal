package kr.ac.jejunu.user.dto;

import lombok.Data;

@Data
public class UserSignUpDto {
    private String username;
    private String password;
    private String nickname;
}
