import java.io.Serializable;

public class Animal implements Serializable {
    
    public String code;
    public String name;
    public Classis classis;
    public double avg_weight;
    public int avg_max_age;
    public String status;

    public Animal() {
        // Default constructor.
        this.code = "undefined";
        this.name = "undefined";
        this.classis = Classis.Mammal;
        this.avg_weight = 0;
        this.avg_max_age = 0;
        this.status = "unfed";
    }

    public Animal(String code, String name, Classis classis, double avg_weight, int avg_max_age) {
        // Constructor.
        this.code = code;
        this.name = name;
        this.classis = classis;
        this.avg_weight = avg_weight;
        this.avg_max_age = avg_max_age;
        this.status = "unfed";
    }

    @Override
    public String toString() {
        // Custom toString method to print animal.
        return "code: " + code + ", name: " + name + ", classis: " + classis + ", avg_weight: " + avg_weight + 
        ", avg_max_age: " + avg_max_age + ", status: " + status; 
    }

    public String getAttr(String attr) {
        // Returns the value of the given attribute (code or name).
        if (attr.equals("code")) return this.code;
        if (attr.equals("name")) return this.name;
        return "undefined";
    }

    public void feed() {
        // Placeholder.
    }

}