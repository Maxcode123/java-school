public class Carnivore extends Animal implements Feedable {
    @Override
    public void feed() {
        feedWithMeat();
    };

    private void feedWithMeat()
    {};

}