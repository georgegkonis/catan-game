package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.exceptions.notfound.EdgeNotFoundException;
import gr.upatras.ceid.backend.exceptions.notfound.NodeNotFoundException;
import gr.upatras.ceid.backend.exceptions.notfound.TileNotFoundException;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Board {
    private String id;
    private List<Tile> tiles;
    private List<Node> nodes;
    private List<Edge> edges;

    public Tile getTile(String tileId) {
        return tiles.stream()
                .filter(tile -> Objects.equals(tile.getId(), tileId))
                .findFirst()
                .orElseThrow(TileNotFoundException::new);
    }

    public Node getNode(String nodeId) {
        return nodes.stream()
                .filter(node -> Objects.equals(node.getId(), nodeId))
                .findFirst()
                .orElseThrow(NodeNotFoundException::new);
    }

    public Edge getEdge(String edgeId) {
        return edges.stream()
                .filter(edge -> Objects.equals(edge.getId(), edgeId))
                .findFirst()
                .orElseThrow(EdgeNotFoundException::new);
    }
}