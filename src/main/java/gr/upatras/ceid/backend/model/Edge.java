package gr.upatras.ceid.backend.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Edge {

    private String id;
    private String node1Id;
    private String node2Id;
    private Road road;

    public Edge(Node node1, Node node2) {
        this.node1Id = node1.getId();
        this.node2Id = node2.getId();
    }

    public boolean hasRoad() {
        return road != null;
    }

    public boolean hasNode(String nodeId) {
        return Objects.equals(nodeId, node1Id) ||
               Objects.equals(nodeId, node2Id);
    }

    public String getOtherNodeId(String nodeId) {
        if (!hasNode(nodeId)) return null;
        return Objects.equals(node1Id, nodeId) ? node2Id : node1Id;
    }
}
