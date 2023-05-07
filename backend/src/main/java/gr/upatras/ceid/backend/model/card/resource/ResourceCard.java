package gr.upatras.ceid.backend.model.card.resource;

import gr.upatras.ceid.backend.enums.Resource;
import gr.upatras.ceid.backend.model.card.Card;

public abstract class ResourceCard extends Card {
    
    private final Resource resource;

    public ResourceCard(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }
}
