package kr.ac.jejunu.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class MiniHome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "minihome_id")
    private Long id;
    private String path;
    private String nickname;
    private String introduction;
    @OneToOne(mappedBy = "miniHome")
    private User user;
}
