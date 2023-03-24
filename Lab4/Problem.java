package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Problem {
    public Map<Student, List<Project>> prefMap = new HashMap<>();
    public List<Project> projectList = new ArrayList();
    public List<Student> studentList = new ArrayList();

    public Problem() {
    }

    public void addProject(Project project){
        projectList.add(project);
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void addPreferences(Student student, List projList){
        prefMap.put(student, projList);
    }

    public double averageNumOfPref(){
        double average = 0;
        for(Student s : prefMap.keySet())
            average += prefMap.get(s).size();
        average /= prefMap.values().size();
        return average;
    }
    public void belowaverage() {
        studentList.stream()
                .filter(s -> prefMap.size()<averageNumOfPref())
                .forEach(System.out::println);
    }


    @Override
    public String toString() {
        return "Problem{" + "studentList=" + studentList + ", projectList=" + projectList + '}';
    }
}
