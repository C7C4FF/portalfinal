package kr.ac.jejunu.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String nickname;

    @OneToOne
    @JoinColumn(name = "minihome_id")
    private MiniHome miniHome;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList=new ArrayList<>();

}
