package kr.ac.jejunu.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class MiniHome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "minihome_id")
    private Long id;
    private String path;
    private String introduction;
    @OneToOne(mappedBy = "miniHome")
    private User user;

    @OneToMany(mappedBy = "miniHome")
    private List<Comment> commentList=new ArrayList<>();

    public User addUser(User user){
        this.user=user;
        this.user.setMiniHome(this);
        return this.user;
    }
}
