package springmvcproject.springmvcprojectrest.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResources {

    private UserService userService;

    UserResources(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    List<UserDto>findAll(){
        return userService.findAll();
    }
}
