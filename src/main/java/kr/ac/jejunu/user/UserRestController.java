package kr.ac.jejunu.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @GetMapping
    public User get(@RequestParam("id") Integer id, @RequestParam("name") String name){
        return User.builder().id(id).name(name).build();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return user;
    }

    @PutMapping("update/")
    public User modify(@RequestBody User user){
        user.setName("modified");
        return user;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@RequestParam Integer id){

    }
}
