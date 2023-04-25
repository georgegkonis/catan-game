package gr.upatras.ceid.catangame.model;

import gr.upatras.ceid.catangame.model.board.Board;
import gr.upatras.ceid.catangame.model.card.development.DevelopmentCard;
import gr.upatras.ceid.catangame.model.card.resource.ResourceCard;
import gr.upatras.ceid.catangame.model.player.Player;

import java.util.List;

public class Game {
    
    private final List<Player> players;
    private final List<ResourceCard> resourceCards;
    private final List<DevelopmentCard> developmentCards;
    private final Board board;

    public Game(List<Player> players, List<ResourceCard> resourceCards, List<DevelopmentCard> developmentCards, Board board) {
        this.players = players;
        this.resourceCards = resourceCards;
        this.developmentCards = developmentCards;
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<ResourceCard> getResourceCards() {
        return resourceCards;
    }

    public List<DevelopmentCard> getDevelopmentCards() {
        return developmentCards;
    }

    public Board getBoard() {
        return board;
    }
}
