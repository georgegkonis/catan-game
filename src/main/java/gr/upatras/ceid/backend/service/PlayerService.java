package gr.upatras.ceid.backend.service;

import gr.upatras.ceid.backend.model.DevelopmentCard;
import gr.upatras.ceid.backend.model.Player;
import gr.upatras.ceid.backend.model.ResourceCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private final SessionService sessionService;

    public Player createPlayer(String sessionId, String playerId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Player getPlayer(String sessionId, String playerId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Player> getPlayers(String sessionId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<ResourceCard> getPlayerResourceCards(String sessionId, String playerId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addResourceCard(String sessionId, String playerId, String cardId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<DevelopmentCard> getPlayerDevelopmentCards(String sessionId, String playerId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addDevelopmentCard(String sessionId, String playerId, String cardId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Integer countVictoryPoints(String sessionId, String playerId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void playDevelopmentCard(String sessionId, String playerId, String cardId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
