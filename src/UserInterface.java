import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    private BiofilmSimulation simulation;
    private DrawingPanel drawingPanel;
    private JTextField bacteriaCountField;
    private JTextField simulationTimeField;
    private Distribution distribution;
    private int simTime;

    public UserInterface() {
        distribution = new Distribution(400, 400); // Initialize distribution map
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("Bacteria Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2));

        bacteriaCountField = new JTextField("10");
        simulationTimeField = new JTextField("100");

        controlPanel.add(new JLabel("Bacteria Count:"));
        controlPanel.add(bacteriaCountField);
        controlPanel.add(new JLabel("Simulation Time:"));
        controlPanel.add(simulationTimeField);

        JButton runTumbleButton = new JButton("Run & Tumble");
        JButton reproduceButton = new JButton("Reproduce");
        JButton pslTrailButton = new JButton("Leave Psl Trail");
        JButton secreteEPSButton = new JButton("Secrete EPS");

        runTumbleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simTime=0;
                new Thread(() -> {
                    while (simTime< Integer.parseInt(simulationTimeField.getText())) {
                        simulation.runAndTumble();
                        drawingPanel.repaint();
                        try {
                            Thread.sleep(250);  // Adjust the sleep time for smoother or faster movement
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        simTime++;
                    }
                }).start();
            }
        });

        reproduceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.reproduce();
                drawingPanel.repaint();
            }
        });

        pslTrailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.leavePslTrail();
                drawingPanel.repaint();
            }
        });

        secreteEPSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.secreteEPS();
                drawingPanel.repaint();
            }
        });

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simTime= Integer.parseInt(simulationTimeField.getText());
            }
        });

        controlPanel.add(runTumbleButton);
        controlPanel.add(reproduceButton);
        controlPanel.add(pslTrailButton);
        controlPanel.add(secreteEPSButton);
        controlPanel.add(stopButton);

        JButton startSimulationButton = new JButton("Start Simulation");
        startSimulationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bacteriaCount = Integer.parseInt(bacteriaCountField.getText());
                int simulationTime = Integer.parseInt(simulationTimeField.getText());
                simulation = new BiofilmSimulation(bacteriaCount, distribution);
                drawingPanel.setSimulation(simulation);
                drawingPanel.repaint();
            }
        });

        controlPanel.add(startSimulationButton);
        frame.add(controlPanel, BorderLayout.NORTH);

        drawingPanel = new DrawingPanel(simulation);
        frame.add(drawingPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInterface());
    }
}