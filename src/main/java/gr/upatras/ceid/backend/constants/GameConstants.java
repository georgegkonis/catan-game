package gr.upatras.ceid.backend.constants;

/**
 * Class that contains all the constants of the game.
 */
public class GameConstants {

    private GameConstants() {
        throw new IllegalStateException("Constants class");
    }

    //region Tiles

    public static final int TOTAL_TILES = 19;
    public static final int DESSERT_TILES = 1;
    public static final int HILL_TILES = 3;
    public static final int MOUNTAIN_TILES = 3;
    public static final int FOREST_TILES = 4;
    public static final int PASTURE_TILES = 4;
    public static final int FIELD_TILES = 4;

    //endregion

    //region Resource Cards

    public static final int TOTAL_RESOURCE_CARDS = 95;
    public static final int LUMBER_RESOURCE_CARDS = 19;
    public static final int BRICK_RESOURCE_CARDS = 19;
    public static final int GRAIN_RESOURCE_CARDS = 19;
    public static final int WOOL_RESOURCE_CARDS = 19;
    public static final int ORE_RESOURCE_CARDS = 19;

    //endregion

    //region Development Cards

    public static final int TOTAL_DEVELOPMENT_CARDS = 25;
    public static final int KNIGHT_DEVELOPMENT_CARDS = 14;
    public static final int VICTORY_POINT_DEVELOPMENT_CARDS = 5;
    public static final int MONOPOLY_DEVELOPMENT_CARDS = 2;
    public static final int ROAD_BUILDING_DEVELOPMENT_CARDS = 2;
    public static final int YEAR_OF_PLENTY_DEVELOPMENT_CARDS = 2;

    //endregion

    //region Ports

    public static final int TOTAL_PORTS = 9;
    public static final int GENERIC_PORTS = 4;
    public static final int WOOD_PORTS = 1;
    public static final int BRICK_PORTS = 1;
    public static final int WHEAT_PORTS = 1;
    public static final int SHEEP_PORTS = 1;
    public static final int STONE_PORTS = 1;

    //endregion

    //region Buildings

    public static final int SETTLEMENTS = 5;
    public static final int CITIES = 4;
    public static final int ROADS = 15;

    //endregion

    //region Dice

    public static final int TOTAL_DICE = 2;
    public static final int DICE_MIN = 1;
    public static final int DICE_MAX = 6;

    //endregion

    //region Players

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 4;

    //endregion

    //region Victory Points

    public static final int VICTORY_POINTS_TO_WIN = 10;
    public static final int VICTORY_POINTS_FOR_SETTLEMENT = 1;
    public static final int VICTORY_POINTS_FOR_CITY = 2;
    public static final int VICTORY_POINTS_FOR_LARGEST_ARMY = 2;
    public static final int VICTORY_POINTS_FOR_LONGEST_ROAD = 2;

    //endregion

    //region Trade

    public static final int TRADE_RATIO = 4;
    public static final int GENERIC_PORT_TRADE_RATIO = 3;
    public static final int SPECIAL_PORT_TRADE_RATIO = 2;

    //endregion

    //region Requirements

    public static final int MIN_ROADS_FOR_LONGEST_ROAD = 5;
    public static final int MIN_KNIGHTS_FOR_LARGEST_ARMY = 3;

    //endregion

    //region Robber

    public static final int ROBBER_TILE = 0;
    public static final int ROBBER_NUMBER = 7;

    //endregion
}
