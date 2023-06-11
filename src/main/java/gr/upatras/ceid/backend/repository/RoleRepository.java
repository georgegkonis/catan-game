package gr.upatras.ceid.backend.repository;

import gr.upatras.ceid.backend.enums.RoleType;
import gr.upatras.ceid.backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByType(RoleType type);
}
