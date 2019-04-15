package rocks.pizzaandcoffee.yotsuba.channel4;

import org.junit.jupiter.api.Test;
import rocks.pizzaandcoffee.yotsuba.channel4.service.Channel4Service;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LastModifiedPageTest {

    Channel4Service service = new MockChannel4Service();

    @Test
    void getPagesString() {
        ArrayList<LastModifiedPage> pages = LastModifiedPage.getPages("qa", service);
        int pageNum = pages.get(0).getPage();
        assertEquals(pageNum, 1);
    }

    @Test
    void getPagesBoard() {
        Board slashQA = Board.getBoards(service).get(44);
        ArrayList<LastModifiedPage> pages = LastModifiedPage.getPages(slashQA, service);
        int pageNum = pages.get(0).getPage();
        assertEquals(pageNum, 1);
    }
}