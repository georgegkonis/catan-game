package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Resource;
import lombok.Data;

@Data
public class ResourceCard {
    private Long id;
    private Resource resource;
    private String owner;
}
