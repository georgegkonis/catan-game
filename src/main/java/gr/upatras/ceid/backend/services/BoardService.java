package gr.upatras.ceid.backend.services;

import gr.upatras.ceid.backend.models.Board;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public void createBoard() {

        Board board = new Board();
    }
}
