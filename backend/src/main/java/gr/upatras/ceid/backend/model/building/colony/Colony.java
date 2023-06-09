package gr.upatras.ceid.backend.model.building.colony;

import gr.upatras.ceid.backend.model.building.Buildable;
import gr.upatras.ceid.backend.model.player.Player;
import gr.upatras.ceid.backend.Constants;

public abstract class Colony implements Buildable {

    private static int idCounter = Constants.INITIAL_ID_COUNTER;

    private final int id;
    private final Player owner;

    protected Colony(Player owner) {
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
