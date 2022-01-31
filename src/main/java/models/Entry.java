package models;

import java.util.List;

public class Entry {

    //private

    private int id;
    private String Name;
    private int vitality;
    private String type;
    private boolean banned = false;
    private int power;
    private int endurance;
    private int speed;
    private int flight;
    private int discipline;
    private int constitution;
    private int resistance;
    private int intelligence;

    private List<Ability> abilities;
    private List<Attack> attacks;

    //No-Arg Constructor
    public Entry() {
    }

    //Full-Arg Constructor
    public Entry(int id, String name, String type,
                 int vitality, int power, int endurance, int speed, int flight,
                 int constitution, int discipline, int resistance, int intelligence)
    {

        this.id = id;
        this.Name = name;
        this.type = type;
        this.vitality = vitality;
        this.power = power;
        this.endurance = endurance;
        this.speed = speed;
        this.flight = flight;
        this.constitution = constitution;
        this.discipline = discipline;
        this.intelligence = intelligence;
        this.resistance = resistance;
    }

    //ID-less Constructor
    public Entry( String name, String type,
                 int vitality, int power, int endurance, int speed, int flight,
                 int constitution, int discipline, int resistance, int intelligence)
    {
        this.Name = name;
        this.type = type;
        this.vitality = vitality;
        this.power = power;
        this.endurance = endurance;
        this.speed = speed;
        this.flight = flight;
        this.constitution = constitution;
        this.discipline = discipline;
        this.intelligence = intelligence;
        this.resistance = resistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDiscipline() {
        return discipline;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
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
