package gr.upatras.ceid.backend.enums;

import gr.upatras.ceid.backend.exceptions.DessertDoesNotProduceResourcesException;

/**
 * Enumerates the terrains of the game. Each terrain produces a specific resource, except for the dessert which produces
 * no resources.
 */
public enum Terrain {
    DESSERT, FOREST, HILLS, MOUNTAINS, PASTURE, FIELDS;


    /**
     * Returns the resource that the terrain produces. If the terrain is dessert, an exception is thrown.
     *
     * @return the resource that the terrain produces.
     * @throws DessertDoesNotProduceResourcesException if the terrain is dessert.
     */
    public Resource getResource() throws DessertDoesNotProduceResourcesException {
        return switch (this) {
            case FOREST -> Resource.LUMBER;
            case HILLS -> Resource.BRICK;
            case MOUNTAINS -> Resource.ORE;
            case PASTURE -> Resource.WOOL;
            case FIELDS -> Resource.GRAIN;
            case DESSERT -> throw new DessertDoesNotProduceResourcesException();
        };
    }
}
