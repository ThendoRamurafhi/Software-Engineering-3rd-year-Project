import java.util.ArrayList;
import java.util.List;

public class BiofilmSimulation {
    private List<Bacteria> bacteriaList;
    private EPS epsMatrix;
    private Psl pslTrail;
    private int simulationTime;
    private int bacteriaCount;

    public BiofilmSimulation(int bacteriaCount, Distribution distribution) {
        this.bacteriaList = new ArrayList<>();
        this.epsMatrix = new EPS(distribution);
        this.pslTrail = new Psl();
        this.bacteriaCount = bacteriaCount;

        for (int i = 0; i < bacteriaCount; i++) {
            Position position = new Position((float) Math.random() * 400, (float) Math.random() * 400);
            Direction direction = new Direction((float) Math.random() * 360);
            Bacteria bacteria = new Bacteria(position, direction, 0.01f, 5.0f);
            bacteriaList.add(bacteria);
        }
    }

    public void runAndTumble() {
        for (Bacteria bacteria : bacteriaList) {
            bacteria.runAndTumble();
        }
    }

    public void reproduce() {
        List<Bacteria> newBacteria = new ArrayList<>();
        for (Bacteria bacteria : bacteriaList) {
            newBacteria.add(bacteria.reproduce());
        }
        bacteriaList.addAll(newBacteria);
    }

    public void leavePslTrail() {
        for (Bacteria bacteria : bacteriaList) {
            bacteria.leavePslTrail(pslTrail);
        }
    }

    public void secreteEPS() {
        for (Bacteria bacteria : bacteriaList) {
            bacteria.secreteEPS(epsMatrix);
        }
    }

    public List<Bacteria> getBacteriaList() {
        return bacteriaList;
    }

    public EPS getEpsMatrix() {
        return epsMatrix;
    }

    public Psl getPslTrail() {
        return pslTrail;
    }

    public void updateSimulation() {
        for (Bacteria bacteria : bacteriaList) {
            bacteria.update();
        }
    }
}
