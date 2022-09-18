public class Carnivore extends Animal implements Feedable {

    public Carnivore(String code, String name, Classis classis, double avg_weight, int avg_max_age) {
        super(code, name, classis, avg_weight, avg_max_age);
    }

    @Override
    public void feed() {
        feedWithMeat();
    };

    private void feedWithMeat()
    {
        this.status = "fed";
    };

}