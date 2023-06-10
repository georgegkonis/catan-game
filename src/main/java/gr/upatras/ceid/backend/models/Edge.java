package gr.upatras.ceid.backend.models;

import lombok.Data;

@Data
public class Edge {
    private String id;
    private Long node1Id;
    private Long node2Id;
    private Road road;
    private Double x;
    private Double y;

    public Edge(Node node1, Node node2) {
        this.node1Id = node1.getId();
        this.node2Id = node2.getId();
    }

    public boolean hasRoad() {
        return road != null;
    }
}
