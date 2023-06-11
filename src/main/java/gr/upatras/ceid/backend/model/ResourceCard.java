package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.Resource;
import lombok.Data;

@Data
public class ResourceCard {
    private final String id;
    private final Resource resource;
    private String owner;

    public ResourceCard(String id, Resource resource) {
        this.id = id;
        this.resource = resource;
    }
}
