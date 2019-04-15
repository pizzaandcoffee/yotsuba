package rocks.pizzaandcoffee.yotsuba.channel4;

import org.junit.jupiter.api.Test;
import rocks.pizzaandcoffee.yotsuba.channel4.service.Channel4Service;

import java.util.ArrayList;

class LastModifiedThreadTest {

    Channel4Service service = new MockChannel4Service();

    @Test
    void getThread() {
        ArrayList<LastModifiedPage> pages = LastModifiedPage.getPages("qa", service);
        ArrayList<LastModifiedThread> threads = pages.get(0).getThreads();
        Thread thread = threads.get(0).getThread(service);
        assert thread.getOp() != null;
    }
}