public class Distribution {
    private float[][] grid;

    public Distribution(int width, int height) {
        grid = new float[width][height];
    }

    public void updateDistribution(Position position, float quantity) {
        int x = (int) position.getX();
        int y = (int) position.getY();
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            grid[x][y] += quantity;
        }
    }

    public float getValue(int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return grid[x][y];
        }
        return 0;
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }
}
