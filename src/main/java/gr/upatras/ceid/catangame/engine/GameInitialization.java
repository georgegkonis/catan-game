package gr.upatras.ceid.catangame.engine;

import gr.upatras.ceid.catangame.model.Game;
import gr.upatras.ceid.catangame.model.board.Board;
import gr.upatras.ceid.catangame.model.card.development.DevelopmentCard;
import gr.upatras.ceid.catangame.model.card.resource.ResourceCard;
import gr.upatras.ceid.catangame.model.player.Player;

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
