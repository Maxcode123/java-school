public class Herbivore extends Animal implements Feedable{
    @Override
    public void feed() {
        feedWithVegetables();
    };

    private void feedWithVegetables() {};
}