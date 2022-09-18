import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Config {
    // Config class. Responsible for storing and loading serialized objects.
    
    public static void storeSerializedAnimals() {
        // Creates and serializes animals.
        Animal[] animals = createAnimals();
        for (int i = 0; i < animals.length; i++) {
            serialize(animals[i], "animals/" + animals[i].name);
        }
    }

    public static void storeAnimal(Animal animal) {
        // Serializes given animal.
        serialize(animal, "animals/" + animal.name);
    }

    public static void removeAnimal(Animal animal) {
        // Deletes serialized animal.
        File serializedAnimal = new File("animals/" + animal.name);
        serializedAnimal.delete();
    }

    public static List<Animal> loadAnimals() {
        // Loads all serialized animals.
        List<Animal> animals = new LinkedList<Animal>();
        try{
            for (String filename : listStoredAnimalFiles()) {
                animals.add(deserialize("animals/" + filename));
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        }       
        return animals;
    }

    private static Set<String> listStoredAnimalFiles() throws IOException {
        // Returns all serialized animal filenames.
        try (Stream<Path> stream = Files.list(Paths.get("animals"))) {
            return stream
            .filter(file -> !Files.isDirectory((file)))
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toSet());
        }
    }

    private static void serialize(Animal animal, String filename) {
        // Serializes given animal to given filename.
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animal);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Animal deserialize(String filename) {
        // Deserializes given filename into an animal.
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Animal animal = (Animal) ois.readObject();
            ois.close();
            fis.close();
            return animal;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    
    private static Animal[] createAnimals() {
        // Creates and array of initial animals.
        Carnivore tiger = new Carnivore("TG", "tiger", Classis.Mammal, 200.0, 33);
        Carnivore lion = new Carnivore("LN", "lion", Classis.Mammal, 220.0, 35);
        Herbivore lizard = new Herbivore("LZ", "lizard", Classis.Reptile, 0.450, 3);
        Herbivore turtle = new Herbivore("TL", "turtle", Classis.Reptile, 5.5, 90);
        Carnivore eagle = new Carnivore("EG", "eagle", Classis.Bird, 12.5, 15);
        Herbivore parrot = new Herbivore("PR", "parrot", Classis.Bird, 2.3, 12);
        Herbivore frog = new Herbivore("FR", "frog", Classis.Amphibian, 1.1, 11);
        Herbivore salamander = new Herbivore("SL", "salamander", Classis.Amphibian, 1.2, 5);
        Animal[] animals = {tiger, lion, lizard, turtle, eagle, parrot, frog, salamander};
        return animals;
    }


}