package models;

public class Ability {

    private int id;
    private String type;
    private String Name;
    private String effect;

    //No-Arg Constructor
    public Ability() {
    }

    //Full-Arg Constructor
    public Ability (int id, String type, String name, String effect) {
        this.id = id;
        this.type = type;
        this.Name = name;
        this.effect = effect;

    }

    //ID-less Constructor
    public Ability ( String name, String type, String effect) {

        this.Name = name;
        this.type = type;
        this.effect = effect;

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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
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
