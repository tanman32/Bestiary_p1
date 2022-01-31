package models;

public class Attack {

    private int id;
    private String Name;
    private String type;
    private int base;
    private int positive_scaling;
    private int negative_scaling;
    private int accuracy;

    //No-Arg Constructor
    public Attack() {
    }

    //Full-Arg Constructor
    public Attack (int id, String type, String name, int base, int ps, int ns, int accuracy) {
        this.id = id;
        this.type = type;
        this.Name = name;
        this.base = base;
        this.positive_scaling = ps;
        this.negative_scaling = ns;
        this.accuracy = accuracy;

    }

    //ID-less Constructor
    public Attack ( String name, String type, int base, int ps, int ns, int accuracy) {

        this.Name = name;
        this.base = base;
        this.type = type;
        this.positive_scaling = ps;
        this.negative_scaling = ns;
        this.accuracy = accuracy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getPositive_scaling() {
        return positive_scaling;
    }

    public void setPositive_scaling(int positive_scaling) {
        this.positive_scaling = positive_scaling;
    }

    public int getNegative_scaling() {
        return negative_scaling;
    }

    public void setNegative_scaling(int negative_scaling) {
        this.negative_scaling = negative_scaling;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //    @Override
//    public String toString() {
//        return "Movie{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", price=" + price +
//                ", available=" + available +
//                ", returnDate=" + returnDate +
//                '}';
//    }

}
