package gr.upatras.ceid.backend.util;

import gr.upatras.ceid.backend.enums.NumberToken;
import gr.upatras.ceid.backend.enums.Terrain;
import gr.upatras.ceid.backend.model.Board;
import gr.upatras.ceid.backend.model.Edge;
import gr.upatras.ceid.backend.model.Node;
import gr.upatras.ceid.backend.model.Tile;
import gr.upatras.ceid.backend.provider.IdProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class BoardInitializer {

    private IdProvider<String> idProvider;

    // TODO: Implement
    public Board initBoard(boolean centeredDessert) {
        Board board = new Board(idProvider.generateId());

        board.setTiles(createTiles(centeredDessert));
        board.setNodes(createNodes());
        board.setEdges(createEdges());

        return board;
    }

    // TODO: Implement
    private List<Tile> createTiles(Boolean centeredDessert) {
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

    // TODO: Implement
    private List<Node> createNodes() {
        return new ArrayList<Node>();
    }

    // TODO: Implement
    private List<Edge> createEdges() {
        return new ArrayList<Edge>();
    }

    // TODO: Implement
    private static Node getNode(List<Node> nodes, int row, int col) {
        return nodes.stream()
                .filter(node -> node.getRow() == row && node.getCol() == col)
                .findFirst()
                .orElse(null);
    }
}
