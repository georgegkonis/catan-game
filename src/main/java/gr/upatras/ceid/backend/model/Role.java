package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.RoleType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
public class Role {

    @Id
    private final String id;
    private final RoleType type;
}
