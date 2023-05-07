package gr.upatras.ceid.backend.engine;

import gr.upatras.ceid.backend.model.Game;
import gr.upatras.ceid.backend.model.board.Board;
import gr.upatras.ceid.backend.model.card.development.DevelopmentCard;
import gr.upatras.ceid.backend.model.card.resource.ResourceCard;
import gr.upatras.ceid.backend.model.player.Player;

import java.util.ArrayList;

public class GameInitialization {
    public GameInitialization() {
        var players = new ArrayList<Player>();
        var resourceCards = new ArrayList<ResourceCard>();
        var developmentCards = new ArrayList<DevelopmentCard>();
        var board = new Board();
        new Game(players, resourceCards, developmentCards, board);
    }
}
