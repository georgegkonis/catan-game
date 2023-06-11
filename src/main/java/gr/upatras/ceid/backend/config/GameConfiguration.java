package gr.upatras.ceid.backend.config;

import gr.upatras.ceid.backend.model.Session;
import gr.upatras.ceid.backend.model.User;
import gr.upatras.ceid.backend.provider.IdProvider;
import gr.upatras.ceid.backend.provider.UuidProvider;
import gr.upatras.ceid.backend.repository.SessionRepository;
import gr.upatras.ceid.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public IdProvider<String> idProvider() {
        return new UuidProvider();
    }

    @Bean
    CommandLineRunner runner(SessionRepository sessionRepository, UserRepository userRepository) {
        return args -> {
            sessionRepository.save(new Session("id", 0));
            userRepository.save(new User());
        };
    }
}
