package gr.upatras.ceid.catangame.model.player;

import gr.upatras.ceid.catangame.model.card.development.DevelopmentCard;
import gr.upatras.ceid.catangame.model.card.resource.ResourceCard;

import static gr.upatras.ceid.catangame.Constants.INITIAL_ID_COUNTER;

public class Player {
    
    private static final int idCounter = INITIAL_ID_COUNTER;

    private final int id;
    private final Color color;
    private final CardDeck<DevelopmentCard> developmentCardCardDeck;
    private final CardDeck<ResourceCard> resourceCardCardDeck;
    
    private int victoryPoints;

    public Player(Color color) {
        id = INITIAL_ID_COUNTER;
        this.color = color;
        developmentCardCardDeck = new CardDeck<>();
        resourceCardCardDeck = new CardDeck<>();
        victoryPoints = 0;
    }
    
    private void calculateVictoryPoints() {
        victoryPoints = 0;
        // TODO
    }
    
    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public CardDeck<DevelopmentCard> getDevelopmentCardCardDeck() {
        return developmentCardCardDeck;
    }

    public CardDeck<ResourceCard> getResourceCardCardDeck() {
        return resourceCardCardDeck;
    }
}
