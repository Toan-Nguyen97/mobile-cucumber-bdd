package common;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReader {
    private JSONObject jsonObject;

    public JSONReader(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            jsonObject = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getXPath(String key) {
        return jsonObject.getString(key);
    }

    public String getXPathWithText(String key, String text) {
        String xpath = jsonObject.getString(key);
        return xpath.replace("{text}", text);
    }
}
