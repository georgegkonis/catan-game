package gr.upatras.ceid.backend.enums;

import gr.upatras.ceid.backend.constants.GameConstants;

/**
 * Enumerates the development cards of the game.
 */
public enum CardType {
    ROAD_BUILDING, VICTORY_POINT, YEAR_OF_PLENTY, MONOPOLY, KNIGHT;

    public int getQuantity() {
        return switch (this) {
            case ROAD_BUILDING -> GameConstants.ROAD_BUILDING_DEVELOPMENT_CARDS;
            case VICTORY_POINT -> GameConstants.VICTORY_POINT_DEVELOPMENT_CARDS;
            case YEAR_OF_PLENTY -> GameConstants.YEAR_OF_PLENTY_DEVELOPMENT_CARDS;
            case MONOPOLY -> GameConstants.MONOPOLY_DEVELOPMENT_CARDS;
            case KNIGHT -> GameConstants.KNIGHT_DEVELOPMENT_CARDS;
        };
    }
}
