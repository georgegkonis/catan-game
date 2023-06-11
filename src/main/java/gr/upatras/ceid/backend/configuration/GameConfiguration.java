package gr.upatras.ceid.backend.configuration;

import gr.upatras.ceid.backend.model.Session;
import gr.upatras.ceid.backend.provider.IdProvider;
import gr.upatras.ceid.backend.provider.UuidProvider;
import gr.upatras.ceid.backend.repository.SessionRepository;
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
    CommandLineRunner runner(SessionRepository repository) {
        return args -> {
            Session entity = new Session();
            repository.insert(entity);
        };
    }
}
