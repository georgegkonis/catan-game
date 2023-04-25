package gr.upatras.ceid.catangame.model.card.resource;

import gr.upatras.ceid.catangame.enums.Resource;
import gr.upatras.ceid.catangame.model.card.Card;

public abstract class ResourceCard extends Card {
    
    private final Resource resource;

    public ResourceCard(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }
}
