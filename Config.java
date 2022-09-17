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
    
    public static void storeSerializedAnimals() {
        Animal[] animals = createAnimals();
        for (int i = 0; i < animals.length; i++) {
            serialize(animals[i], "animals/" + animals[i].name);
        }
    }

    public static void storeAnimal(Animal animal) {

    }

    public static void removeAnimal(Animal animal) {
        
    }

    public static List<Animal> loadAnimals() {
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
        try (Stream<Path> stream = Files.list(Paths.get("animals"))) {
            return stream
            .filter(file -> !Files.isDirectory((file)))
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toSet());
        }
    }

    private static void serialize(Animal animal, String filename) {
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
        Animal tiger = new Animal("TG", "tiger", Classis.Mammal, 200.0, 33);
        Animal lion = new Animal("LN", "lion", Classis.Mammal, 220.0, 35);
        Animal lizard = new Animal("LZ", "lizard", Classis.Reptile, 0.450, 3);
        Animal turtle = new Animal("TL", "turtle", Classis.Reptile, 5.5, 90);
        Animal eagle = new Animal("EG", "eagle", Classis.Bird, 12.5, 15);
        Animal parrot = new Animal("PR", "parrot", Classis.Bird, 2.3, 12);
        Animal frog = new Animal("FR", "frog", Classis.Amphibian, 1.1, 11);
        Animal salamander = new Animal("SL", "salamander", Classis.Amphibian, 1.2, 5);
        Animal[] animals = {tiger, lion, lizard, turtle, eagle, parrot, frog, salamander};
        return animals;
    }


}