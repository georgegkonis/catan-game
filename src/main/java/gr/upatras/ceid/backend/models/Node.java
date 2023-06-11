package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Port;
import gr.upatras.ceid.backend.models.colony.Colony;
import lombok.Data;

import java.util.List;

@Data
public class Node {
    private String id;
    private Colony colony;
    private Port port;
    private List<String> edgeIds;
    private List<String> tileIds;
    private Integer row;
    private Integer col;

    public Node(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    public boolean hasEdge(String edgeId) {
        return edgeIds.contains(edgeId);
    }

    public boolean hasTile(String tileId) {
        return tileIds.contains(tileId);
    }

    public boolean hasColony() {
        return colony != null;
    }


    public boolean hasPort() {
        return port != null;
    }

    public boolean isAdjacentTo(Node node) {
        return edgeIds.stream().anyMatch(node::hasEdge);
    }
}
