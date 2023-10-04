package nl.novi.sowtheland.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.novi.sowtheland.Model.User;
import nl.novi.sowtheland.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
@Data
@AllArgsConstructor

public class MyUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findById(username);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new MyUserDetails(user);
        } else {
            throw new UsernameNotFoundException(username);
        }

        return null;
    }
}
