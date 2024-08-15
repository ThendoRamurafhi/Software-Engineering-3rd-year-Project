import java.util.ArrayList;
import java.util.List;

public class Psl extends BiofilmComponent {
    private List<Position> trail;

    public Psl(Position position) {
        super(0, position);
        this.trail = new ArrayList<>();
    }

    public void disperse() {
        // Logic to disperse Psl
    }

    public void addTrail(Position position) {
        trail.add(position);
    }

    public List<Position> getTrail() {
        return trail;
    }

    @Override
    public void update() {
        disperse();
    }
}
