package gr.upatras.ceid.backend.model.card.development.victory;

import gr.upatras.ceid.backend.model.card.development.DevelopmentCard;

public class VictoryCard extends DevelopmentCard {
    
    private final String name;
    private final int victoryPoints;

    public VictoryCard(String description, String name, int victoryPoints) {
        super(description);
        this.name = name;
        this.victoryPoints = victoryPoints;
    }

    @Override
    public void play() {

    }

    public String getName() {
        return name;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }
}
