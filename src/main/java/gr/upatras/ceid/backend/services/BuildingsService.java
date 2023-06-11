package gr.upatras.ceid.backend.services;

import gr.upatras.ceid.backend.enums.Color;
import gr.upatras.ceid.backend.models.*;
import gr.upatras.ceid.backend.models.colony.City;
import gr.upatras.ceid.backend.models.colony.Settlement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingsService {

    private final SessionService sessionService;

    public List<String> getRoadConstructionSlots(String sessionId, String playerId) {
        Session session = sessionService.getSession(sessionId);

        Board board = session.getBoard();
        Color playerColor = session.getPlayer(playerId).getColor();

        // Get the empty edges.
        List<Edge> edges = board.getEdges().stream()
                .filter(edge -> !edge.hasRoad())
                .toList();

        // Get the nodes with a colony of the player's color.
        List<Node> nodes = board.getNodes().stream()
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
        Session session = sessionService.getSession(sessionId);

        Board board = session.getBoard();
        Color playerColor = session.getPlayer(playerId).getColor();

        // Get the empty nodes.
        List<Node> nodes = board.getNodes().stream()
                .filter(node -> !node.hasColony())
                .toList();

        // Get the edges with a road of the player's color.
        List<Edge> edges = board.getEdges().stream()
                .filter(edge -> edge.hasRoad() &&
                                edge.getRoad().getColor() == playerColor)
                .toList();

        // Get nodes with colonies.
        List<Node> nodesWithColonies = board.getNodes().stream()
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
        Session session = sessionService.getSession(sessionId);

        Board board = session.getBoard();
        Color playerColor = session.getPlayer(playerId).getColor();

        // Get the nodes with a settlement of the player's color.

        List<Node> nodes = board.getNodes().stream()
                .filter(node -> node.hasColony() &&
                                node.getColony().getColor() == playerColor &&
                                node.getColony() instanceof Settlement)
                .toList();

        return nodes.stream()
                .map(Node::getId)
                .toList();
    }

    public void constructRoad(String sessionId, String playerId, String edgeId) {
        Session session = sessionService.getSession(sessionId);

        Color playerColor = session.getPlayer(playerId).getColor();
        Edge edge = session.getBoard().getEdge(edgeId);
        Road road = session.getBank().removeRoad(playerColor);

        edge.setRoad(road);

        sessionService.updateSession(session);
    }

    public void constructSettlement(String sessionId, String playerId, String nodeId) {
        Session session = sessionService.getSession(sessionId);

        Color playerColor = session.getPlayer(playerId).getColor();
        Node node = session.getBoard().getNode(nodeId);
        Settlement settlement = session.getBank().removeSettlement(playerColor);

        node.setColony(settlement);

        sessionService.updateSession(session);
    }

    public void constructCity(String sessionId, String playerId, String nodeId) {
        Session session = sessionService.getSession(sessionId);

        Color playerColor = session.getPlayer(playerId).getColor();
        Node node = session.getBoard().getNode(nodeId);
        City city = session.getBank().removeCity(playerColor);
        Settlement settlement = (Settlement) node.getColony();

        session.getBank().getSettlements().add(settlement);
        node.setColony(city);

        sessionService.updateSession(session);
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
