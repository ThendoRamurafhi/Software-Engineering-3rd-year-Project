import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BiofilmSimulation {
    private int simulationTime;
    private int bacteriaCount;
    private static List<Bacteria> bacteriaList;
    public static EPS epsMatrix;
    public static Psl pslTrail;

    private ExecutorService executor;

    public BiofilmSimulation(int simulationTime, int bacteriaCount, EPS epsMatrix, Psl pslTrail) {
        this.simulationTime = simulationTime;
        this.bacteriaCount = bacteriaCount;
        this.epsMatrix = epsMatrix;
        this.pslTrail = pslTrail;
        this.bacteriaList = new ArrayList<>();
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void startSimulation() {
        for (int i = 0; i < simulationTime; i++) {
            for (Bacteria bacteria : bacteriaList) {
                executor.execute(bacteria);
            }
        }
    }

    public void pauseSimulation() {
        executor.shutdownNow();
    }

    public void resetSimulation() {
        executor.shutdownNow();
        bacteriaList.clear();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void updateParameters(SimulationParameters params) {
        // Update simulation parameters
    }

    public void recordData(DataRecorder recorder) {
        // Record simulation data
    }

    public List<Bacteria> getBacteriaList() {
        return bacteriaList;
    }

    public Psl getPslTrail() {
        return pslTrail;
    }

    public static void addBacteria(Bacteria bacteria) {
        bacteriaList.add(bacteria);
    }
}
