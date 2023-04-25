package gr.upatras.ceid.catangame.model.board;

import gr.upatras.ceid.catangame.model.building.colony.Colony;

import java.util.Map;

public class Board {
    
    private Map<Integer, HexTerrain> hexTerrainMap;
    private Map<Integer, Colony> settlementMap;
}
