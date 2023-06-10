package gr.upatras.ceid.backend.repositories;

import gr.upatras.ceid.backend.models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, String> { }
