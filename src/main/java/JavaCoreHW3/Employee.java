package JavaCoreHW3;

import java.util.Date;
import java.util.Objects;

public abstract class Employee implements Comparable<Employee>{
    protected String name;
    protected String position;
    protected final Date birthdate;

    protected Employee(String name, String position, Date birthdate) {
        this.name = name;
        this.position = position;
        this.birthdate = birthdate;
    }

    public abstract double getAverageMonthlyWages();

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setPosition(String position) {
        if (position == null){
            throw new RuntimeException("Должность не может быть пустой");
        }
        this.position = position;
    }

    public void setName(String name) {
        if (name == null){
            throw new RuntimeException("Имя не может быть пустым");
        }
        this.name = name;
    }
    @Override
    public int compareTo(Employee o) {
        if (this.getAverageMonthlyWages() > o.getAverageMonthlyWages()) {
            return 1;
        }
        if (this.getAverageMonthlyWages() < o.getAverageMonthlyWages()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && position.equals(employee.position) && birthdate.equals(employee.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, birthdate);
    }

    @Override
    public String toString() {
        return name;
    }
}
