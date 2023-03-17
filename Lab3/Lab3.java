import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab2 = new Lab3();
        lab2.compulsory();
        lab2.homework(args);

    }
    void compulsory() {

        List<Node> nodeList = new ArrayList<Node>();
        Person p1 = new Person("Popescu");
        Person p2 = new Person("Olteanu");
        Person p3 = new Person ("Paduraru");
        Company c1 = new Company("Microsoft");
        Company c2 = new Company ("Amazon");

        if(p1.compareTo(p2) < 0 && p1.compareTo(p3) < 0){
            nodeList.add(p1);
            if(p2.compareTo(p3) < 0){
                nodeList.add(p2);
                nodeList.add(p3);
            }
            else {
                nodeList.add(p3);
                nodeList.add(p2);
            }
        }


    }

    void homework(String args[]) {
        Network network = new Network();
        Company s1 = new Company("Amazon");
        Company s2 = new Company ("Microsoft");
        Programmer c1 = new Programmer("Alex");
        Programmer c2 = new Programmer("Sorin");
        Designer c3 = new Designer ("Adriana");
        nodeComparatorImportance nodeComp = new nodeComparatorImportance();

        c1.setBirth_date("12.04.1998");
        c1.setNumberOfActiveProjects(5);
        c2.setBirth_date("22.07.1995");
        c2.setNumberOfActiveProjects(2);
        c3.setBirth_date("01.04.1988");
        c3.setSalary(900);
        s1.setNumberofEmployees(10000);
        s2.setNumberofEmployees(50000);


        network.addNode(c1);
        network.addNode(c2);
        network.addNode(c3);
        network.addNode(s1);
        network.addNode(s2);


        c1.addRelationship(s2, "Front-end dev");
        s2.addRelationship(c1, "Front-end dev");
        c1.addRelationship(c3, "Relative");
        c2.addRelationship(c3, "Friend");
        c2.addRelationship(s1, "Back-end dev");
        s1.addRelationship(c2,"Back-end dev");
        c3.addRelationship(s1, "Designer");
        s1.addRelationship(c3,"Designer");
        c3.addRelationship(c2, "Best Friend");
        c3.addRelationship(c1, "Siblings");


        Collections.sort(network.nodes,nodeComp);


        System.out.println(network);

    }

}
