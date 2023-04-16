package sg.nus.iss.miniprojectserver.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sg.nus.iss.miniprojectserver.models.DataTransfer;
import sg.nus.iss.miniprojectserver.models.User;
import sg.nus.iss.miniprojectserver.repositories.RolesRepo;
import sg.nus.iss.miniprojectserver.repositories.UserRepo;

@Service
public class UserService implements UserFunctions{
    private UserRepo userRepo;
    private RolesRepo rolesRepo;
    private PasswordEncoder pwEncoder;

    public UserService(UserRepo userRepo,
    RolesRepo roleRepo,
    PasswordEncoder passwordEncoder) {
this.userRepo = userRepo;
this.rolesRepo= rolesRepo;
this.pwEncoder = pwEncoder;
}
    
    @Override
    public List<DataTransfer> findAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllUsers'");
    }
    @Override
    public void saveUser(DataTransfer dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }
    @Override
    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
    
}
