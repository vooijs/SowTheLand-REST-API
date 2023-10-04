package nl.novi.sowtheland.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.novi.sowtheland.Dto.UserDto;
import nl.novi.sowtheland.Model.Role;
import nl.novi.sowtheland.Model.User;
import nl.novi.sowtheland.Repository.RoleRepository;
import nl.novi.sowtheland.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor

@Service
public class UserService {
    private final UserRepository userRepos;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public ResponseEntity <Long> createUser (UserDto userDto) {
        User newUser = new User();

        newUser.setUserId(userDto.userId);
        newUser.setUserName(userDto.userName);
        newUser.setEmail(userDto.email);
        newUser.setPassword(encoder.encode(userDto.password));
        newUser.setGarden(userDto.garden);

        List<Role> userRoles = new ArrayList<>();
        for (String rolename : userDto.roles) {
            Optional<Role> or = roleRepository.findById("Role_" + rolename);
            userRoles.add(or.get());
        }
        newUser.setRoles(userRoles);

        userRepos.save(newUser);

        return new ResponseEntity<>(newUser.getUserId(), HttpStatus.CREATED);
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
    public Long updateUser (UserDto userDto,Long userId){
        User user =userRepos.findById(userId).get();

        user.setUserName(userDto.userName);
        user.setEmail(userDto.email);
        user.setPassword(userDto.password);

        userRepos.save(user);
        return user.getUserId();
    }
    public ResponseEntity<?> deleteUser (Long userid){
         userRepos.deleteById(userid);
         return (ResponseEntity<?>) ResponseEntity.ok();
    }


}
