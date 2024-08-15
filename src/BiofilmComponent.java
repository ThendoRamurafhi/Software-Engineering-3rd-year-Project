public abstract class BiofilmComponent {
    protected float quantity;
    protected Position position;

    public BiofilmComponent(float quantity, Position position) {
        this.quantity = quantity;
        this.position = position;
    }

    public abstract void update();

    public Position getPosition() {
        return position;
    }
}
