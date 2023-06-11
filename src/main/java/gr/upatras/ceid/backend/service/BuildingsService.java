package gr.upatras.ceid.backend.service;

import gr.upatras.ceid.backend.model.*;
import gr.upatras.ceid.backend.model.colony.Colony;
import gr.upatras.ceid.backend.model.colony.Settlement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingsService {

    private final SessionsService sessionsService;

    public List<Colony> getColonies(String sessionId, String tileId) {
        var session = sessionsService.getSession(sessionId);
        var nodes = session.getBoard().getNodes();

        return nodes.stream()
                .filter(node -> node.hasTile(tileId))
                .filter(Node::hasColony)
                .map(Node::getColony)
                .toList();
    }

    public List<Colony> getColonies(String sessionId, String tileId, String playerId) {
        var session = sessionsService.getSession(sessionId);

        var playerColor = session.getPlayer(playerId).getColor();
        var settlements = getColonies(sessionId, tileId);

        return settlements.stream()
                .filter(settlement -> settlement.getColor() == playerColor)
                .toList();
    }

    public List<String> getRoadConstructionSlots(String sessionId, String playerId) {
        var session = sessionsService.getSession(sessionId);

        var board = session.getBoard();
        var playerColor = session.getPlayer(playerId).getColor();

        // Get the empty edges.
        var edges = board.getEdges().stream()
                .filter(edge -> !edge.hasRoad())
                .toList();

        // Get the nodes with a colony of the player's color.
        var nodes = board.getNodes().stream()
                .filter(node -> node.hasColony() &&
                                node.getColony().getColor() == playerColor)
                .toList();

        // Filter the edges that are adjacent to a node with a colony of the player's color.
        edges = filterEdgesConnectedToNodes(edges, nodes);

        return edges.stream()
                .map(Edge::getId)
                .toList();
    }

    public List<String> getSettlementConstructionSlots(String sessionId, String playerId) {
        var session = sessionsService.getSession(sessionId);

        var board = session.getBoard();
        var playerColor = session.getPlayer(playerId).getColor();

        // Get the empty nodes.
        var nodes = board.getNodes().stream()
                .filter(node -> !node.hasColony())
                .toList();

        // Get the edges with a road of the player's color.
        var edges = board.getEdges().stream()
                .filter(edge -> edge.hasRoad() &&
                                edge.getRoad().getColor() == playerColor)
                .toList();

        // Get nodes with colonies.
        var nodesWithColonies = board.getNodes().stream()
                .filter(Node::hasColony)
                .toList();

        // Filter the nodes that are adjacent to an edge with a road of the player's color.
        nodes = filterNodesConnectedToEdges(nodes, edges);

        // Filter the nodes that don't have adjacent nodes with a colony.
        nodes = filterNodesWithoutAdjacentNodes(nodes, nodesWithColonies);

        return nodes.stream()
                .map(Node::getId)
                .toList();
    }

    public List<String> getCityConstructionSlots(String sessionId, String playerId) {
        var session = sessionsService.getSession(sessionId);

        var board = session.getBoard();
        var playerColor = session.getPlayer(playerId).getColor();

        // Get the nodes with a settlement of the player's color.
        var nodes = board.getNodes().stream()
                .filter(node -> node.hasSettlement() &&
                                node.getColony().getColor() == playerColor)
                .toList();

        return nodes.stream()
                .map(Node::getId)
                .toList();
    }

    public void constructRoad(String sessionId, String playerId, String edgeId) {
        var session = sessionsService.getSession(sessionId);

        var playerColor = session.getPlayer(playerId).getColor();
        var edge = session.getBoard().getEdge(edgeId);
        var road = session.getBank().removeRoad(playerColor);

        edge.setRoad(road);

        sessionsService.updateSession(session);
    }

    public void constructSettlement(String sessionId, String playerId, String nodeId) {
        var session = sessionsService.getSession(sessionId);

        var playerColor = session.getPlayer(playerId).getColor();
        var node = session.getBoard().getNode(nodeId);
        var settlement = session.getBank().removeSettlement(playerColor);

        node.setColony(settlement);

        sessionsService.updateSession(session);
    }

    public void constructCity(String sessionId, String playerId, String nodeId) {
        var session = sessionsService.getSession(sessionId);

        var playerColor = session.getPlayer(playerId).getColor();
        var node = session.getBoard().getNode(nodeId);
        var city = session.getBank().removeCity(playerColor);
        var settlement = (Settlement) node.getColony();

        session.getBank().getSettlements().add(settlement);
        node.setColony(city);

        sessionsService.updateSession(session);
    }

    private static List<Edge> filterEdgesConnectedToNodes(List<Edge> edges, List<Node> nodes) {
        return edges.stream()
                .filter(edge -> nodes.stream().anyMatch(node -> node.hasEdge(edge.getId())))
                .toList();
    }

    private static List<Node> filterNodesConnectedToEdges(List<Node> nodes, List<Edge> edges) {
        return nodes.stream()
                .filter(node -> edges.stream().anyMatch(edge -> edge.hasNode(node.getId())))
                .toList();
    }

    private static List<Node> filterNodesWithoutAdjacentNodes(List<Node> nodes, List<Node> otherNodes) {
        return nodes.stream()
                .filter(node -> otherNodes.stream().anyMatch(node::isAdjacentTo))
                .toList();
    }
}
