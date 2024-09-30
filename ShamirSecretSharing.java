import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ShamirSecretSharing {

    // Function to read the JSON input
    public static JSONObject readTestCase(String filename) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {
            return (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Function to decode the Y value based on its base
    public static BigInteger decodeYValue(int base, String value) {
        return new BigInteger(value, base);
    }

    // Function to process points from JSON
    public static List<int[]> processPoints(JSONObject data) {
        List<int[]> points = new ArrayList<>();
        JSONObject keys = (JSONObject) data.get("keys");
        int n = Integer.parseInt(keys.get("n").toString());
        int k = Integer.parseInt(keys.get("k").toString());

        for (Object key : data.keySet()) {
            if (!key.equals("keys")) {
                int x = Integer.parseInt(key.toString());
                JSONObject root = (JSONObject) data.get(key);
                int base = Integer.parseInt(root.get("base").toString());
                String yEncoded = root.get("value").toString();
                BigInteger y = decodeYValue(base, yEncoded);
                points.add(new int[]{x, y.intValue()});
            }
        }
        return points;
    }

    public static void main(String[] args) {
        String filename = "testcase1.json";  // Replace with actual filename
        JSONObject data = readTestCase(filename);
        List<int[]> points = processPoints(data);
        System.out.println("Points: " + points);
    }
}
