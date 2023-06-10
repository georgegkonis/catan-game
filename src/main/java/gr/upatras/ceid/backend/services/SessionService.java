package gr.upatras.ceid.backend.services;

import gr.upatras.ceid.backend.domain.requests.CreatePlayerRequest;
import gr.upatras.ceid.backend.domain.requests.CreateSessionRequest;
import gr.upatras.ceid.backend.enums.Effect;
import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Resource;
import gr.upatras.ceid.backend.enums.Terrain;
import gr.upatras.ceid.backend.exceptions.SessionNotFoundException;
import gr.upatras.ceid.backend.models.*;
import gr.upatras.ceid.backend.providers.IdProvider;
import gr.upatras.ceid.backend.repositories.SessionRepository;
import gr.upatras.ceid.backend.util.BoardGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class SessionService {
    private final SessionRepository repository;
    private final IdProvider<String> idProvider;
    private final BoardGenerator boardGenerator;

    public Session getSession(String id) throws SessionNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new SessionNotFoundException(id));
    }

    public List<Session> getSessions() {
        return repository.findAll();
    }

    public Session createSession(CreateSessionRequest request) {
        Session session = new Session();

        session.setId(idProvider.generateId());
        session.setBank(createBank());
        session.setBoard(createBoard(request.dessertCentered()));
        session.setPlayers(new ArrayList<>(request.numberOfPlayers()));

        return repository.save(session);
    }

    private Board createBoard(Boolean centeredDessert) {
        return boardGenerator.generateBoard();
    }

    private Bank createBank() {
        var bank = new Bank();

        bank.setId(idProvider.generateId());
        bank.setResourceCards(createResourceCards());
        bank.setDevelopmentCards(createDevelopmentCards());

        return bank;
    }

    private List<ResourceCard> createResourceCards() {
        var resourceCards = new ArrayList<ResourceCard>();

        for (Resource resource : Resource.values()) {
            for (int i = 0; i < resource.getQuantity(); i++) {
                var id = idProvider.generateId();
                var resourceCard = new ResourceCard(id, resource);
                resourceCards.add(resourceCard);
            }
        }
        return resourceCards;
    }

    private List<DevelopmentCard> createDevelopmentCards() {
        var developmentCards = new ArrayList<DevelopmentCard>();

        for (Effect effect : Effect.values()) {
            for (int i = 0; i < effect.getQuantity(); i++) {
                var id = idProvider.generateId();
                var developmentCard = new DevelopmentCard(id, effect);
                developmentCards.add(developmentCard);
            }
        }
        return developmentCards;
    }

    public Player createPlayer(String id, CreatePlayerRequest request) {
        var player = new Player();

        player.setId(idProvider.generateId());
        player.setUserId(request.userId());
        player.setName(request.playerName());
        player.setColor(request.playerColor());

        var session = repository.findById(id).orElseThrow();
        session.getPlayers().add(player);
        repository.save(session);

        return player;
    }

    public void deleteSession(String id) {
        repository.deleteById(id);
    }
}