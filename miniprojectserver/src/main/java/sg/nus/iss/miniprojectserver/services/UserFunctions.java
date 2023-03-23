package sg.nus.iss.miniprojectserver.services;

import java.util.List;

import sg.nus.iss.miniprojectserver.models.DataTransfer;
import sg.nus.iss.miniprojectserver.models.User;

public interface UserFunctions {
    List<DataTransfer> findAllUsers();

    void saveUser(DataTransfer dto);

    User findByEmail(String email);

    
    
}
