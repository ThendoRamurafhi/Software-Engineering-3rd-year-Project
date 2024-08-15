import java.util.List;

public class DataPoint {
    private int time;
    private List<Position> bacteriaPositions;
    private List<Float> EPSData;
    private List<Float> PslData;

    public void setData(int time, List<Position> bacteriaPositions, List<Float> EPSData, List<Float> PslData) {
        this.time = time;
        this.bacteriaPositions = bacteriaPositions;
        this.EPSData = EPSData;
        this.PslData = PslData;
    }
}
