package gr.upatras.ceid.backend.config;

import gr.upatras.ceid.backend.models.Session;
import gr.upatras.ceid.backend.repositories.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SessionRepository.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(SessionRepository repository) {
        return strings -> {
            repository.save(new Session());
        };
    }
}
