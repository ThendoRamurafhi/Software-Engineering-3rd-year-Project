import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawingPanel extends JPanel {
    private BiofilmSimulation simulation;

    public DrawingPanel(BiofilmSimulation simulation) {
        this.simulation = simulation;
    }

    public void setSimulation(BiofilmSimulation simulation) {
        this.simulation = simulation;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (simulation != null) {
            List<Bacteria> bacteriaList = simulation.getBacteriaList();
            for (Bacteria bacteria : bacteriaList) {
                Position pos = bacteria.getPosition();
                g.fillOval((int) pos.getX(), (int) pos.getY(), 10, 10);
            }

            // Drawing Psl trail
            g.setColor(Color.BLUE);
            for (Position pos : simulation.getPslTrail().getTrail()) {
                g.fillOval((int) pos.getX(), (int) pos.getY(), 5, 5);
            }

            // Drawing EPS distribution (as a simple color gradient)
            g.setColor(new Color(0, 255, 0, 50));
            Distribution dist = simulation.getEpsMatrix().getDistribution();
            for (int x = 0; x < dist.getWidth(); x++) {
                for (int y = 0; y < dist.getHeight(); y++) {
                    float concentration = dist.getValue(x, y);
                    if (concentration > 0) {
                        g.fillRect(x, y, 1, 1);
                    }
                }
            }
        }
    }
}
