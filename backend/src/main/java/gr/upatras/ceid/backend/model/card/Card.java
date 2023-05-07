package gr.upatras.ceid.backend.model.card;

import gr.upatras.ceid.backend.Constants;
import gr.upatras.ceid.backend.model.player.Player;

public abstract class Card {
    
    private static int idCounter = Constants.INITIAL_ID_COUNTER;
    
    private final int id;
    private Player owner;

    protected Card() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public Player getOwner() {
        return owner;
    }
    
    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
