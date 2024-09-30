import org.json.simple.JSONObject;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Process first test case
        String filename1 = "testcase1.json";
        JSONObject data1 = ShamirSecretSharing.readTestCase(filename1);
        List<int[]> points1 = ShamirSecretSharing.processPoints(data1);
        int k1 = 3;
        double secret1 = LagrangeInterpolation.lagrangeInterpolation(points1, k1);
        System.out.println("Test Case 1 - Secret constant (C): " + secret1);

        // Process second test case
        String filename2 = "testcase2.json";
        JSONObject data2 = ShamirSecretSharing.readTestCase(filename2);
        List<int[]> points2 = ShamirSecretSharing.processPoints(data2);
        int k2 = 6;
        double secret2 = LagrangeInterpolation.lagrangeInterpolation(points2, k2);
        System.out.println("Test Case 2 - Secret constant (C): " + secret2);

        // Find wrong points for second test case
        List<int[]> wrongPoints = WrongPointsFinder.findWrongPoints(points2, k2);
        if (!wrongPoints.isEmpty()) {
            System.out.println("Test Case 2 - Wrong points: " + wrongPoints);
        } else {
            System.out.println("Test Case 2 - No wrong points found.");
        }
    }
}
