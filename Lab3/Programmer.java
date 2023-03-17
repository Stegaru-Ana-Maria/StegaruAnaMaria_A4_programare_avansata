public class Programmer extends Person{
    int numberOfProjects;

    public int getNumberOfActiveProjects() {
        return numberOfProjects;
    }

    public void setNumberOfActiveProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public Programmer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "numberOfProjects=" + numberOfProjects +
                '}';
    }
}
