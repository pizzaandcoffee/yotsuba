package rocks.pizzaandcoffee.yotsuba.channel4;

import rocks.pizzaandcoffee.yotsuba.channel4.service.Channel4Service;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Channel4Service service = new MockChannel4Service();

    @org.junit.jupiter.api.Test
    void getBoards() {
        ArrayList<Board> boards = Board.getBoards(service);
        Board three = boards.get(0);
        assertEquals(three.getBoardCode(), "3");
    }

}