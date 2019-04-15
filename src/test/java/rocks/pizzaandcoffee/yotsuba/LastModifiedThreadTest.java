package rocks.pizzaandcoffee.yotsuba;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LastModifiedThreadTest {

    @Test
    void getThread() {
        ArrayList<LastModifiedPage> pages = LastModifiedPage.getPages("a");
        ArrayList<LastModifiedThread> threads = pages.get(0).getThreads();
        Thread thread = threads.get(0).getThread();
        assert thread.getOp() != null;
    }
}