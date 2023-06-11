package gr.upatras.ceid.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
@Data
public class User {

    private final String id;
    private String username;
    private String password;
    private String email;
    private Set<Role> roles;
}
