public class Designer extends Person{
    int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Designer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Designer{" +
                "salary=" + salary +
                '}';
    }
}
