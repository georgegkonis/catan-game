package gr.upatras.ceid.catangame.model.building;

import gr.upatras.ceid.catangame.Constants;
import gr.upatras.ceid.catangame.model.player.Player;

public class Road implements Buildable {
    
    private static int idCounter = Constants.INITIAL_ID_COUNTER;
    
    private final int id;
    private final Player owner;
    
    public Road(Player owner) {
        id = idCounter++;
        this.owner = owner;
    }
    public int getId() {
        return id;
    }

    public Player getOwner() {
        return owner;
    }
}
