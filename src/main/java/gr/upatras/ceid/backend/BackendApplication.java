package gr.upatras.ceid.backend;

import gr.upatras.ceid.backend.models.Session;
import gr.upatras.ceid.backend.repositories.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(SessionRepository repository) {
        return args -> {
            Session session = new Session();

            repository.insert(session);
        };
    }
}
