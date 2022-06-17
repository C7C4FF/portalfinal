package kr.ac.jejunu.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String commentbody;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "minihome_id")
    private MiniHome miniHome;

    public void addUser(User user){
        this.user=user;
        this.user.getCommentList().add(this);
    }
    public void addMiniHome(MiniHome miniHome){
        this.miniHome=miniHome;
        this.miniHome.getCommentList().add(this);
    }
}
