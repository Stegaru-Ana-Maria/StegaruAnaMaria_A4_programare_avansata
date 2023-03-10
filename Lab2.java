public class Airport extends Location{
    private int nr_terminals;

    public int getNr_terminals() {
        return nr_terminals;
    }

    public void setNr_terminals(int nr_terminals) {
        this.nr_terminals = nr_terminals;
    }
}

public class City extends Location{
    private int population;

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

public class Gas_station extends Location{
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        lab2.compulsory();
        lab2.homework(args);


    }
    void compulsory() {
        Location c1 = new Location();
        c1.setName("Iași");
        c1.setX(20.0);
        c1.setY(30.5);
        System.out.println(c1);

        Location c2 = new Location();
        c2.setName("Vaslui");
        c2.setX(50.0);
        c2.setY(80.5);
        System.out.println(c2);

        Road c3 = new Road("Drum", Road.RoadType.HIGHWAY,c1,c2,90, 80);
        System.out.println(c3);
    }

    void homework(String args[]){

        Location s1 = new Location();
        s1.setName("Iași");
        s1.setX(20.0);
        s1.setY(30.5);
        System.out.println(s1);

        Location s2 = new Location();
        s2.setName("Vaslui");
        s2.setX(50.0);
        s2.setY(80.5);
        System.out.println(s2);

        Road d1 = new Road("Drum", Road.RoadType.HIGHWAY,s1,s2,90, 80);
        System.out.println(d1);

        Road d2 = new Road("Drum", Road.RoadType.HIGHWAY,s1,s2,90, 80);
        System.out.println(d2);

        boolean bool = d1.equals(d2);
        System.out.println(bool);




        Location[] sites = new Location[2];
        sites[0]= new City();
        sites[1]= new Airport();




    }


}

import java.util.Objects;

public class Location {
    protected String name;

    private double x;
    private double y;
    public Location() { }
    public Location(String name) {
        this.name = name;
    }

    public String getName(){
        return name;

    }
    public void setName(String a) {
        this.name = a;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && Objects.equals(name, location.name);
    }


    }


public class Main {



}




public class Problem {
    private Location[] locations;
    private Road[] roads;

    
}

import java.util.Objects;

public class Road {

    public enum RoadType {
        HIGHWAY,
        EXPRESS;
    }


    protected String name;
    private RoadType type;

    private int lenght;
    private int speed_limit;
    public Road(String name, RoadType type, Location a, Location b, int speed_limit, int lenght) {
        this.name = name;
        this.type = type;
        this.lenght = lenght;
        this.speed_limit = speed_limit;

    }

    public String getName() {
        return name;
    }

    public RoadType getType() {
        return type;
    }

    public int getLenght() {
        return lenght;
    }

    public int getSpeed_limit() {
        return speed_limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setSpeed_limit(int speed_limit) {
        this.speed_limit = speed_limit;
    }


    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", lenght=" + lenght +
                ", speed_limit=" + speed_limit +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return lenght == road.lenght && speed_limit == road.speed_limit && Objects.equals(name, road.name) && type == road.type;
    }


}

