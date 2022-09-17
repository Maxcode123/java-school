import java.io.Serializable;

public class Animal implements Serializable {
    
    public String code;
    public String name;
    public Classis classis;
    public double avg_weight;
    public int avg_max_age;
    public String status;

    public Animal(String code, String name, Classis classis, double avg_weight, int avg_max_age) {
        this.code = code;
        this.name = name;
        this.classis = classis;
        this.avg_weight = avg_weight;
        this.avg_max_age = avg_max_age;
        this.status = "unfed";
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", classis: " + classis + ", avg_weight: " + avg_weight + 
        ", avg_max_age: " + avg_max_age + ", status: " + status; 
    }

    public String getAttr(String attr) {
        if (attr.equals("code")) return this.code;
        if (attr.equals("name")) return this.name;
        return "undefined";
    }

}