package org.example;

public class Project {
    private String name;
    public Project(String name){
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
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    public int compareTo(Project other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Project)) {
            return false;
        }
        Project other = (Project) obj;
        return name.equals(other.name);
    }

}