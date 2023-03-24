package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.TreeSet;
import java.util.List;
import java.util.Collections;


public class Lab4 {

    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();
        lab4.compulsory();
         lab4.homework(args);

    }
    void compulsory() {
        List<Student> listOfStudents = new LinkedList<>();
        TreeSet<Project> treeOfProjects = new TreeSet<>();
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        for(Student s : students) {
            listOfStudents.add(s);
        }

        Collections.sort(listOfStudents);

        for(int i=0; i<4; i++){
            System.out.println(students[i].toString());
        }

        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("S" + i))
                .toArray(Project[]::new);

        for(Project p : projects){
            treeOfProjects.add(p);
        }

        for(int i=0; i<4; i++){
            System.out.println(projects[i].toString());
        }
    }
    void homework(String args[]) {
        Problem problem = new Problem();
        Project[] projects = new Project[3];

        Student s0 = new Student("S1");
        Student s1 = new Student("S2");
        Student s2 = new Student("S3");
        projects[0] = new Project("P1");
        projects[1] = new Project("P2");
        projects[2] = new Project("P3");

        problem.studentList.add(s0);
        problem.studentList.add(s1);
        problem.studentList.add(s2);
        problem.projectList.add(projects[0]);
        problem.projectList.add(projects[1]);
        problem.projectList.add(projects[2]);


        System.out.println(problem);





    }




}
