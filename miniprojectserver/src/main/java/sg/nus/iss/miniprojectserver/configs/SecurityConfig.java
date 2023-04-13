package sg.nus.iss.miniprojectserver.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.RequiredArgsConstructor;
import sg.nus.iss.miniprojectserver.repositories.UserRepo;

@Configuration
@RequiredArgsConstructor //Testing something new, remove if not working

public class SecurityConfig {
    private final UserRepo userRepo;
    
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepo.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}
