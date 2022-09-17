import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Animal> animals;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Config.storeSerializedAnimals();
        animals = Config.loadAnimals();
        boolean exit = false;

        welcomeMessage();
        while (true) {
            System.out.print("(zoo)>>");
            int t = scanner.nextInt();
            switch (t) {
                case 0:
                welcomeMessage();
                break;

                case 1:
                printAnimals();
                break;

                case 2:
                addAnimal();
                break;

                case 3:
                searchAnimal(false);
                break;

                case 4:
                searchAnimal(true);
                break;

                case 5:
                deleteAnimal();
                break;

                case 6:
                feedAnimal();                
                break;

                case 7:
                exit = true;
                break;
            }
            if (exit) break;
        }
        scanner.close();
    }

    private static void welcomeMessage() {
        System.out.print("""
            Welcome to the Zoo!
            0. Print this message
            1. List all animals
            2. Add animal
            3. Search animal by name
            4. Search animal by code
            5. Delete animal by code
            6. Feed animal
            7. Exit
            """);
    }

    private static void printAnimals() {
        for (Animal a : animals) {
            System.out.println(a);
        }        
    }

    private static void addAnimal() {
        System.out.print("code: ");
        String code = scanner.next();
        
        System.out.print("name: ");
        String name = scanner.next();
        
        System.out.print("classis (Mammal: 1, Reptile: 2, Bird: 3, Amphibian: 4): ");
        Classis classis = toEnum(scanner.nextInt());
        
        System.out.print("average weight: ");
        double avg_weight = scanner.nextDouble();

        System.out.print("average max age: ");
        int avg_max_age = scanner.nextInt();

        Animal animal = new Animal(code, name, classis, avg_weight, avg_max_age);
        animals.add(animal);
        Config.storeAnimal(animal);
    }

    private static Classis toEnum(int classis) {
        switch (classis) {
            case 1:
            return Classis.Mammal;
            case 2:
            return Classis.Reptile;
            case 3:
            return Classis.Bird;
            case 4:
            return Classis.Amphibian;
            default:
            return Classis.Mammal;
        }
    }

    private static void searchAnimal(boolean byCode) {
        String field;
        if (byCode) field = "code";
        else field = "name";
        System.out.print(field + ": ");
        String fieldValue = scanner.next();
        
        for (Animal a : animals) {
            if (a.getAttr(field).equals(fieldValue)) {
                System.out.println(a);
                return;
            }
        }
    }

    private static void deleteAnimal() {
        System.out.print("code: ");
        String code = scanner.next();

        for (Animal a: animals) {
            if (a.code.equals(code)) {
                animals.remove(a);
                Config.removeAnimal(a);
                return;
            }
        }
    }

    private static void feedAnimal() {
        System.out.print("code: ");
        String code = scanner.next();

        for (Animal a: animals) {
            if (a.code.equals(code)) {
                a.status = "fed";
                System.out.println(a.name + " fed.");
                return;
            }
        }
    }

}