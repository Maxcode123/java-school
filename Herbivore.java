public class Herbivore extends Animal implements Feedable{

    public Herbivore(String code, String name, Classis classis, double avg_weight, int avg_max_age) {
        super(code, name, classis, avg_weight, avg_max_age);
    }

    @Override
    public void feed() {
        feedWithVegetables();
    };

    private void feedWithVegetables() {
        this.status = "fed";
    };
}