package sg.nus.iss.miniprojectserver.Security.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sg.nus.iss.miniprojectserver.repositories.UserRepo;

@Service
@RequiredArgsConstructor //trying something new, supposed to generate constructor/arguments for final fields, remove if not working
public class AuthService {
    private final UserRepo userRepo;
    private final
}
