package gr.upatras.ceid.backend.utility;

import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Terrain;
import gr.upatras.ceid.backend.model.Board;
import gr.upatras.ceid.backend.model.Edge;
import gr.upatras.ceid.backend.model.Node;
import gr.upatras.ceid.backend.model.Tile;
import gr.upatras.ceid.backend.provider.IdProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@AllArgsConstructor
@Component
public class BoardGenerator {

    private IdProvider<String> idProvider;

    public Board generateBoard() {
        List<Tile> tiles = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        int[] rows = {3, 4, 5, 4, 3};
        int rowOffset = 2; // Offset for the rows to create the hexagonal shape
        int id = 1; // Starting ID for the tiles

        // Create the tiles and nodes
        for (int row = 0; row < rows.length; row++) {
            for (int col = 0; col < rows[row]; col++) {
                Tile tile = new Tile();

                tile.setId(String.valueOf(id++));
                tile.setRow(row);
                tile.setCol(col + rowOffset * row);

                // Create nodes for the corners
                Map<String, Node> cornerNodes = new HashMap<>();

                cornerNodes.put("topLeft", new Node(row, col));
                cornerNodes.put("topRight", new Node(row, col + 1));
                cornerNodes.put("right", new Node(row + 1, col + 1));
                cornerNodes.put("bottomRight", new Node(row + 1, col));
                cornerNodes.put("bottomLeft", new Node(row, col - 1));
                cornerNodes.put("left", new Node(row - 1, col - 1));

                // Add nodes to the list
                nodes.addAll(cornerNodes.values());

                // Set the corner nodes in the tile
                tile.setCornerNodes(cornerNodes);

                tiles.add(tile);
            }
        }

        // Create edges based on the shared sides
        for (Tile tile : tiles) {
            int row = tile.getRow();
            int col = tile.getCol();

            // Create edges for the sides
            Map<String, Edge> sideEdges = new HashMap<>();
            sideEdges.put("topLeft", new Edge(tile.getCornerNodes().get("topLeft"), tile.getCornerNodes().get("topRight")));
            sideEdges.put("topRight", new Edge(tile.getCornerNodes().get("topRight"), tile.getCornerNodes().get("right")));
            sideEdges.put("right", new Edge(tile.getCornerNodes().get("right"), tile.getCornerNodes().get("bottomRight")));
            sideEdges.put("bottomRight", new Edge(tile.getCornerNodes().get("bottomRight"), tile.getCornerNodes().get("bottomLeft")));
            sideEdges.put("bottomLeft", new Edge(tile.getCornerNodes().get("bottomLeft"), tile.getCornerNodes().get("left")));
            sideEdges.put("left", new Edge(tile.getCornerNodes().get("left"), tile.getCornerNodes().get("topLeft")));

            // Add edges to the list
            edges.addAll(sideEdges.values());

            // Set the side edges in the tile
            tile.setSideEdges(sideEdges);
        }

        // Create the board object and set the tiles, nodes, and edges
        Board board = new Board();
        board.setTiles(tiles);
        board.setNodes(nodes);
        board.setEdges(edges);

        return board;
    }

    // Helper method to retrieve a node based on row and column
    private Node getNode(List<Node> nodes, int row, int col) {
        return nodes.stream()
                .filter(node -> node.getRow() == row && node.getCol() == col)
                .findFirst()
                .orElse(null);
    }

    private ArrayList<Tile> createTiles(Boolean centeredDessert) {
        var tiles = new ArrayList<Tile>();

        for (var terrain : Terrain.values()) {
            for (int i = 0; i < terrain.getQuantity(); i++) {
                var tile = new Tile();
                var id = idProvider.generateId();

                tile.setId(id);
                tile.setTerrain(terrain);

                tiles.add(tile);
            }
        }

        Collections.shuffle(tiles);

        if (centeredDessert) {
            // put the dessert in the middle
            var dessertTile = tiles.stream()
                    .filter(tile -> tile.getTerrain() == Terrain.DESSERT)
                    .findFirst()
                    .orElseThrow();

            int midIndex = tiles.size() / 2;

            tiles.remove(dessertTile);
            tiles.add(midIndex, dessertTile);
        }

        // Assign a number token to each tile
        var numberTokens = NumberToken.values();

        for (int i = 0; i < tiles.size(); i++) {
            var tile = tiles.get(i);
            var numberToken = numberTokens[i];

            tile.setValue(numberToken);
        }
        return tiles;
    }

    private static ArrayList<Node> createNodes() {
        return new ArrayList<Node>();
    }

    private static ArrayList<Edge> createEdges() {
        return new ArrayList<Edge>();
    }
}
