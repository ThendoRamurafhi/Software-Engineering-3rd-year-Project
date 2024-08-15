import java.util.ArrayList;
import java.util.List;

public class Distribution {
    private List<List<Float>> map;
    public Distribution() {
        map = new ArrayList<>();
        // Initialize map with default values
    }

    public Distribution(int width, int height) {
        map = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            List<Float> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                row.add(0.0f);
            }
            map.add(row);
        }
    }

    public void updateDistribution(Position position, float quantity) {
        int x = (int) position.getX();
        int y = (int) position.getY();
        map.get(x).set(y, map.get(x).get(y) + quantity);
    }

    public List<List<Float>> getMap() {
        return map;
    }
}
