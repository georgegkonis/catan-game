package gr.upatras.ceid.backend.enums;

import gr.upatras.ceid.backend.constants.GameConstants;
import gr.upatras.ceid.backend.exceptions.operation.DessertDoesNotProduceResourcesException;

/**
 * Enumerates the terrains of the game. Each terrain produces a specific resource, except for the dessert which produces
 * no resources.
 */
public enum Terrain {
    DESSERT, FOREST, HILL, MOUNTAIN, PASTURE, FIELD;


    /**
     * Returns the resource that the terrain produces. If the terrain is dessert, an exception is thrown.
     *
     * @return the resource that the terrain produces.
     * @throws DessertDoesNotProduceResourcesException if the terrain is dessert.
     */
    public Resource getResource() throws DessertDoesNotProduceResourcesException {
        return switch (this) {
            case FOREST -> Resource.LUMBER;
            case HILL -> Resource.BRICK;
            case MOUNTAIN -> Resource.ORE;
            case PASTURE -> Resource.WOOL;
            case FIELD -> Resource.GRAIN;
            case DESSERT -> throw new DessertDoesNotProduceResourcesException();
        };
    }

    public int getQuantity() {
        return switch (this) {
            case FOREST -> GameConstants.FOREST_TILES;
            case HILL -> GameConstants.HILL_TILES;
            case MOUNTAIN -> GameConstants.MOUNTAIN_TILES;
            case PASTURE -> GameConstants.PASTURE_TILES;
            case FIELD -> GameConstants.FIELD_TILES;
            case DESSERT -> GameConstants.DESSERT_TILES;
        };
    }
}
