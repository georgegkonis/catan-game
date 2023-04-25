package gr.upatras.ceid.catangame.model.card.development;

import gr.upatras.ceid.catangame.model.card.Card;

public abstract class DevelopmentCard extends Card {
    
    private final String description;

    public DevelopmentCard(String description) {
        this.description = description;
    }

    public abstract void play();

    public String getDescription() {
        return description;
    }
}
