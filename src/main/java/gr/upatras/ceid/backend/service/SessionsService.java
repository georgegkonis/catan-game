package gr.upatras.ceid.backend.service;

import gr.upatras.ceid.backend.domain.request.sessions.CreatePlayerRequest;
import gr.upatras.ceid.backend.domain.request.sessions.CreateSessionRequest;
import gr.upatras.ceid.backend.enums.SessionStatus;
import gr.upatras.ceid.backend.exception.notfound.SessionNotFoundException;
import gr.upatras.ceid.backend.model.*;
import gr.upatras.ceid.backend.provider.IdProvider;
import gr.upatras.ceid.backend.repository.SessionRepository;
import gr.upatras.ceid.backend.util.BankInitializer;
import gr.upatras.ceid.backend.util.BoardInitializer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SessionsService {

    private final SessionRepository repository;
    private final IdProvider<String> idProvider;
    private final BoardInitializer boardInitializer;
    private final BankInitializer bankInitializer;

    public Session getSession(String id) throws SessionNotFoundException {
        return repository.findById(id)
                .orElseThrow(SessionNotFoundException::new);
    }

    public List<Session> getSessions() {
        return repository.findAll();
    }

    public Session createSession(CreateSessionRequest request) {
        Session session = new Session(idProvider.generateId(), request.sessionSlots());

        session.setBoard(boardInitializer.initBoard(request.dessertCentered()));
        session.setBank(bankInitializer.initBank());
        session.setPlayers(new ArrayList<>(request.sessionSlots()));
        session.setStatus(SessionStatus.WAITING);

        return repository.save(session);
    }

    public void updateSession(Session session) {
        repository.save(session);
    }

    public void updateSession(String id, SessionStatus status) {
        var session = getSession(id);
        session.setStatus(status);
        repository.save(session);
    }

    public void deleteSession(String id) {
        repository.deleteById(id);
    }

    public Player createPlayer(String id, CreatePlayerRequest request) {
        var player = new Player(idProvider.generateId());

        player.setUserId(request.userId());
        player.setName(request.playerName());
        player.setColor(request.playerColor());

        var session = repository.findById(id).orElseThrow();
        session.getPlayers().add(player);
        repository.save(session);

        return player;
    }
}