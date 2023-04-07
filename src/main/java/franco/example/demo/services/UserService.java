package franco.example.demo.services;

import franco.example.demo.controllers.dto.UserDTORequest;
import franco.example.demo.controllers.dto.UserDTOResponse;
import franco.example.demo.entitites.User;
import franco.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTOResponse createUser(UserDTORequest request){
        return entityToResponse(userRepository.save(requestToEntity(request)));
    }

    private UserDTOResponse entityToResponse (User user){
        UserDTOResponse response = new UserDTOResponse();
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        return response;
    }
    private User requestToEntity (UserDTORequest request){
        User user = new User();
        return requestToEntity(request,user);
    }

    private User requestToEntity(UserDTORequest request, User user){
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        return user;
    }


}
