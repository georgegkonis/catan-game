package gr.upatras.ceid.backend.configuration;

import gr.upatras.ceid.backend.models.Session;
import gr.upatras.ceid.backend.providers.IdProvider;
import gr.upatras.ceid.backend.providers.UuidProvider;
import gr.upatras.ceid.backend.repositories.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

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
