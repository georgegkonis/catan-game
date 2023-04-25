package gr.upatras.ceid.catangame.model.board;

import gr.upatras.ceid.catangame.Constants;
import gr.upatras.ceid.catangame.enums.Terrain;
import gr.upatras.ceid.catangame.model.building.Buildable;

import java.util.ArrayList;
import java.util.List;

public class HexTerrain {
    
    private static int idCounter = Constants.INITIAL_ID_COUNTER;

    private final int id;
    private final Terrain terrain;
    private final int value;
    
    private final List<Buildable> roadSlots;
    private final List<Buildable> colonySlots;

    public HexTerrain(Terrain terrain, int value) {
        id = idCounter++;
        this.terrain = terrain;
        this.value = value;
        roadSlots = new ArrayList<>();
        colonySlots = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public int getValue() {
        return value;
    }

    public List<Buildable> getRoadSlots() {
        return roadSlots;
    }

    public List<Buildable> getColonySlots() {
        return colonySlots;
    }
}
