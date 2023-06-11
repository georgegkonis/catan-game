package gr.upatras.ceid.backend.model;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;
    @Size(max = 50)
    private String username;
    @Size(max = 50)
    private String password;
    @Size(max = 50)
    private String email;
    @DBRef
    private Set<Role> roles;
}
