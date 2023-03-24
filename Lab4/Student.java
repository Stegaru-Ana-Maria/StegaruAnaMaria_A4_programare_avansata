package org.example;

public class Student implements Comparable<Student> {
    public String name;
    public Student(String name){

        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public int compareTo(Project other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        return name.equals(other.name);
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
