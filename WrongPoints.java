import java.util.ArrayList;
import java.util.List;

public class WrongPointsFinder {

    // Function to find wrong points that don't fit the polynomial
    public static List<int[]> findWrongPoints(List<int[]> points, int k) {
        List<int[]> wrongPoints = new ArrayList<>();
        for (int[] point : points) {
            double polynomialValue = LagrangeInterpolation.lagrangeInterpolation(points, k);
            if (polynomialValue != point[1]) {
                wrongPoints.add(point);
            }
        }
        return wrongPoints;
    }

    public static void main(String[] args) {
        // Example points
        List<int[]> points = List.of(
                new int[]{1, 28735619723837L},
                new int[]{2, 28735619723850L},
                new int[]{3, 28735619723835L},
                new int[]{4, 28735619723840L},
                new int[]{5, 28735619723841L},
                new int[]{6, 28735619654702L},
                new int[]{7, 28735619723844L},
                new int[]{8, 28735619723837L},
                new int[]{9, 28735619723830L}
        );

        int k = 6; // Degree + 1
        List<int[]> wrongPoints = findWrongPoints(points, k);
        if (!wrongPoints.isEmpty()) {
            System.out.println("Wrong points: " + wrongPoints);
        } else {
            System.out.println("No wrong points found.");
        }
    }
}
