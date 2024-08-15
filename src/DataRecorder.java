import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataRecorder {
    private List<DataPoint> simulationData;

    public DataRecorder() {
        this.simulationData = new ArrayList<>();
    }

    public void recordData(DataPoint data) {
        simulationData.add(data);
    }

    public File exportData(String format) {
        // Logic to export data in the specified format
        return new File("simulation_data." + format);
    }
}
