import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    private Settings settings;
    private BiofilmSimulation simulation;
    private JButton startButton, pauseButton, resetButton;

    public UserInterface(BiofilmSimulation simulation) {
        this.settings = new Settings();
        this.simulation = simulation;
        initUI();
    }

    private void initUI() {
        setTitle("Biofilm Simulation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        resetButton = new JButton("Reset");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.startSimulation();
                repaint();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.pauseSimulation();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.resetSimulation();
                repaint();
            }
        });

        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(pauseButton);
        panel.add(resetButton);

        add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);
        for (Bacteria bacteria : simulation.getBacteriaList()) {
            Position pos = bacteria.getPosition();
            g.fillOval((int) pos.getX(), (int) pos.getY(), 5, 5);
        }

        g.setColor(Color.BLUE);
        for (Position pos : simulation.getPslTrail().getTrail()) {
            g.fillOval((int) pos.getX(), (int) pos.getY(), 2, 2);
        }
    }

    public static void main(String[] args) {
        Position initialPosition = new Position(400, 300);
        Direction initialDirection = new Direction(0);
        EPS epsMatrix = new EPS(initialPosition, new Distribution());
        Psl pslTrail = new Psl(initialPosition);
        BiofilmSimulation simulation = new BiofilmSimulation(1000, 10, epsMatrix, pslTrail);

        for (int i = 0; i < 10; i++) {
            Bacteria bacteria = new Bacteria(initialPosition, initialDirection, 0.2f, 1.0f);
            simulation.addBacteria(bacteria);
        }

        UserInterface ui = new UserInterface(simulation);
        ui.setVisible(true);
    }
}
