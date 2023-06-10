package gr.upatras.ceid.backend.enums;

import gr.upatras.ceid.backend.constants.GameConstants;

/**
 * Enumerates the resources of the game.
 */
public enum Resource {
    ORE, LUMBER, BRICK, GRAIN, WOOL;

    public int getQuantity() {
        return switch (this) {
            case ORE -> GameConstants.ORE_RESOURCE_CARDS;
            case LUMBER -> GameConstants.LUMBER_RESOURCE_CARDS;
            case BRICK -> GameConstants.BRICK_RESOURCE_CARDS;
            case GRAIN -> GameConstants.GRAIN_RESOURCE_CARDS;
            case WOOL -> GameConstants.WOOL_RESOURCE_CARDS;
        };
    }
}
