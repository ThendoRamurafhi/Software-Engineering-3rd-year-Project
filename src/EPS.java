public class EPS extends BiofilmComponent {
    private Distribution distribution;

    public EPS(Position position, Distribution distribution) {
        super(0, position);
        this.distribution = distribution;
    }

    public void spread() {
        // Logic to spread EPS around the current position
    }

    public void addEPS(Position position, float quantity) {
        distribution.updateDistribution(position, quantity);
    }

    @Override
    public void update() {
        spread();
    }
}
