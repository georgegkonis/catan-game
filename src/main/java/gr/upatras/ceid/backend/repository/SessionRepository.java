package gr.upatras.ceid.backend.repository;

import gr.upatras.ceid.backend.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, String> {
}
