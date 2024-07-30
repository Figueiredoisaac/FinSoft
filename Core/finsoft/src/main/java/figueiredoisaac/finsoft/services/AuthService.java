package figueiredoisaac.finsoft.services;

import figueiredoisaac.finsoft.config.JwtUtil;
import figueiredoisaac.finsoft.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticate(String username, String password) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            if (authentication.isAuthenticated()) {
                return jwtUtil.generateToken(userDetailsService.loadUserByUsername(username));
            } else {
                throw new Exception("Authentication failed");
            }
        } catch (Exception e) {
            throw new Exception("Invalid username or password", e);
        }
    }

    public String register(User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user to the database here
        // userRepository.save(user);
        return jwtUtil.generateToken(userDetailsService.loadUserByUsername(user.getUsername()));
    }
}
