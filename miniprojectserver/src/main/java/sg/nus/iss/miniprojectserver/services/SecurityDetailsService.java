package sg.nus.iss.miniprojectserver.services;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sg.nus.iss.miniprojectserver.models.Roles;
import sg.nus.iss.miniprojectserver.models.User;
import sg.nus.iss.miniprojectserver.repositories.UserRepo;

@Service
public class SecurityDetailsService implements UserDetailsService{
    private UserRepo userRepo;

    public SecurityDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
}

private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Roles> roles) {//assigns authority to roles
    Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    return mapRoles;
}

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepo.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}
