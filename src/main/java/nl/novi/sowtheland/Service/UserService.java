package nl.novi.sowtheland.Service;

import nl.novi.sowtheland.Dto.UserDto;
import nl.novi.sowtheland.Model.User;
import nl.novi.sowtheland.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepos;

    public UserService (UserRepository userRepos){
        this.userRepos = userRepos;
    }

    public ResponseEntity <Long> createUser (UserDto userDto) {
        User user = new User();

        user.setUserId(userDto.userId);
        user.setUserName(userDto.userName);
        user.setEmail(userDto.email);
        user.setPassword(userDto.password);

        userRepos.save(user);

        return new ResponseEntity<>(user.getUserId(), HttpStatus.CREATED);
    }

    public List<UserDto> getAllUsers (){
        Iterable<User> users = userRepos.findAll();
        List<UserDto> allUsers = new ArrayList<>();

        for(User user : users){
          UserDto userDto = new UserDto();

          userDto.userId = user.getUserId();
          userDto.userName = user.getUserName();
          userDto.email = user.getEmail();
          userDto.password = user.getPassword();
          allUsers.add(userDto);
        }
        return allUsers;
    }
    public UserDto getUser(String email){
        User user = userRepos.findUserByEmail(email);

        UserDto foundUser = new UserDto();
        foundUser.userId = user.getUserId();
        foundUser.userName = user.getUserName();
        foundUser.email = user.getEmail();
        foundUser.password = user.getPassword();

        return foundUser;
    }


}
