package rocks.pizzaandcoffee.yotsuba.channel4;

import org.json.JSONArray;
import org.json.JSONObject;
import rocks.pizzaandcoffee.yotsuba.channel4.service.Channel4Service;

import java.nio.file.Files;
import java.nio.file.Paths;

class MockChannel4Service implements Channel4Service {

    @Override
    public JSONObject getBoards() {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("src/test/resource/4chan/boards.json"));
            return new JSONObject(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONArray getPages(String board) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("src/test/resource/4chan/threads.json"));
            return new JSONArray(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject getThread(String board, int postNumber) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("src/test/resource/4chan/2697158.json"));
            return new JSONObject(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
