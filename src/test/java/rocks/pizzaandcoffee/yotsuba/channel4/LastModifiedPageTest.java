package rocks.pizzaandcoffee.yotsuba.channel4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LastModifiedPageTest {
    @Test
    void getPagesString() {
        ArrayList<LastModifiedPage> pages = LastModifiedPage.getPages("a");
        int pageNum = pages.get(0).getPage();
        assertEquals(pageNum, 1);
    }

    @Test
    void getPagesBoard() {
        Board slashA = Board.getBoards().get(1);
        ArrayList<LastModifiedPage> pages = LastModifiedPage.getPages(slashA);
        int pageNum = pages.get(0).getPage();
        assertEquals(pageNum, 1);
    }
}