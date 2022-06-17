package kr.ac.jejunu.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
public class UserProfileDto {
    @NotBlank
    private String nickname;
    private String introduction;
}
