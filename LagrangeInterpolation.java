import java.util.List;

public class LagrangeInterpolation {

    // Function to calculate Lagrange Interpolation
    public static double lagrangeInterpolation(List<int[]> points, int k) {
        int n = points.size();
        double result = 0;

        for (int i = 0; i < k; i++) {
            double term = points.get(i)[1];
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    term = term * (0 - points.get(j)[0]) / (points.get(i)[0] - points.get(j)[0]);
                }
            }
            result += term;
        }
        return result;
    }

    public static void main(String[] args) {
        // Example points
        List<int[]> points = List.of(
                new int[]{1, 4},
                new int[]{2, 7},
                new int[]{3, 12}
        );
        int k = 3; // Degree + 1
        double secret = lagrangeInterpolation(points, k);
        System.out.println("Secret constant (C): " + secret);
    }
}
