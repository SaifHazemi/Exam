package tn.inetum.blm.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.inetum.blm.example.exam.Entities.User;
import tn.inetum.blm.example.exam.Service.User.IUserService;
import tn.inetum.blm.example.exam.Service.User.UserImpl;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserImpl user;
    @PostMapping()
    public void addUser(@RequestBody User ce) {
        user.addUser(ce);
    }
}
