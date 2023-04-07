package franco.example.demo.controllers;

import franco.example.demo.controllers.dto.UserDTORequest;
import franco.example.demo.controllers.dto.UserDTOResponse;
import franco.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserDTOResponse createAUser (@RequestBody UserDTORequest request){
        return userService.createUser(request);
    }
}
