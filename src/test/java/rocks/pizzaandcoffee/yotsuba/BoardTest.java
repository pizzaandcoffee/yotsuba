package rocks.pizzaandcoffee.yotsuba;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @org.junit.jupiter.api.Test
    void getBoards() {
        ArrayList<Board> boards = Board.getBoards();
        Board three = boards.get(0);
        assertEquals(three.getBoardCode(), "3");
    }

}