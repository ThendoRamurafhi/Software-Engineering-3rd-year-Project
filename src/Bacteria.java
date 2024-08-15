public class Bacteria extends BiofilmComponent {
    private Direction direction;
    private float reproductionRate;
    private float motility;

    public Bacteria(Position position, Direction direction, float reproductionRate, float motility) {
        super(1.0f, position);  // Default quantity is 1 for bacteria
        this.direction = direction;
        this.reproductionRate = reproductionRate;
        this.motility = motility;
    }

    public void runAndTumble() {
        position.setX((float)(position.getX() + motility * Math.cos(Math.toRadians(direction.getAngle()))));
        position.setY((float)(position.getY() + motility * Math.sin(Math.toRadians(direction.getAngle()))));
        direction.setAngle((float) (Math.random() * 360));  // Random tumble
    }

    public Bacteria reproduce() {
        return new Bacteria(new Position(position.getX(), position.getY()), new Direction(direction.getAngle()), reproductionRate, motility);
    }

    public void secreteEPS(EPS eps) {
        eps.addEPS(position, 0.1f);  // Example of secretion
    }

    public void leavePslTrail(Psl psl) {
        psl.addTrail(position);
    }

    @Override
    public void update() {
        runAndTumble();
    }

    public Direction getDirection() {
        return direction;
    }
}
