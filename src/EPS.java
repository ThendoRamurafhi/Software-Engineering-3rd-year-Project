public class EPS extends BiofilmComponent {
    private Distribution distribution;

    public EPS(Distribution distribution) {
        super(0.0f, null);  // EPS has no specific position
        this.distribution = distribution;
    }

    public void addEPS(Position position, float quantity) {
        distribution.updateDistribution(position, quantity);
    }

    public void spread() {
        // Logic to spread EPS across the distribution map
    }

    @Override
    public void update() {
        spread();
    }

    public Distribution getDistribution() {
        return distribution;
    }
}
