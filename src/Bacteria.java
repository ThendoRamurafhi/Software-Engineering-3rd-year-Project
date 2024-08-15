import java.util.concurrent.ThreadLocalRandom;

public class Bacteria extends BiofilmComponent implements Runnable {
    private Direction direction;
    private float reproductionRate;
    private float motility;

    public Bacteria(Position position, Direction direction, float reproductionRate, float motility) {
        super(1.0f, position);
        this.direction = direction;
        this.reproductionRate = reproductionRate;
        this.motility = motility;
    }

    public void move() {
        double angleChange = ThreadLocalRandom.current().nextGaussian() * 30;
        direction.setAngle((float) (direction.getAngle() + angleChange));

        position.setX((float)(position.getX() + motility * Math.cos(Math.toRadians(direction.getAngle()))));
        position.setY((float)(position.getY() + motility * Math.sin(Math.toRadians(direction.getAngle()))));
    }

    public Bacteria reproduce() {
        if (ThreadLocalRandom.current().nextFloat() < reproductionRate) {
            return new Bacteria(new Position(position.getX(), position.getY()), direction, reproductionRate, motility);
        }
        return null;
    }

    public void secreteEPS(EPS epsMatrix) {
        epsMatrix.addEPS(position, 1.0f);
    }

    public void leavePslTrail(Psl pslTrail) {
        pslTrail.addTrail(position);
    }

    @Override
    public void run() {
        move();
        //secreteEPS(BiofilmSimulation.epsMatrix);
        //leavePslTrail(BiofilmSimulation.pslTrail);
       // Bacteria offspring = reproduce();
        //if (offspring != null) {
         //   BiofilmSimulation.addBacteria(offspring);
       // }
    }

    @Override
    public void update() {
        run();
    }
}
