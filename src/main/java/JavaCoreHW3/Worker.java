package JavaCoreHW3;

import java.util.Date;
import java.util.Iterator;

public class Worker extends Employee implements Iterable<String>{
    private double salary;
    private final int numberOfFields;
    private  int index;

    public Worker(String name, String position, Date birthdate, double salary) {
        super(name, position, birthdate);
        this.salary = salary;
        this.numberOfFields = 4;
        this.index = 0;
    }

    @Override
    public double getAverageMonthlyWages() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 100.0){
            throw new RuntimeException("Заработная плата не может быть меньше минимальной, установленной государством");
        }
        this.salary = salary;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index++ < numberOfFields;
            }

            @Override
            public String next() {
                switch (index) {
                    case 1:
                        return String.format("Name: %s", name);
                    case 2:
                        return String.format("Position: %s", position);
                    case 3:
                        return String.format("Date of birth: %s", birthdate);
                    default:
                        return String.format("Salary per month: %s", getAverageMonthlyWages());
                }
            }
        };
    }
}
