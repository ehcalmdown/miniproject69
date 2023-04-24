package sg.nus.iss.miniprojectserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sg.nus.iss.miniprojectserver.models.UserInfo;
import sg.nus.iss.miniprojectserver.repositories.UserInfoRepository;

@Service
public class UserInfoService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoRepository repository;
    
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
