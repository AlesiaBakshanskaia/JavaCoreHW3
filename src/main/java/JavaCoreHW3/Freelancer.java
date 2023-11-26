package JavaCoreHW3;

import java.util.Date;
import java.util.Iterator;

public class Freelancer extends Employee implements Iterable<String> {
    private double hourlyPayment;
    private final int numberOfFields;
    private int index;

    public Freelancer(String name, String position, Date birthdate, double hourlyPayment) {
        super(name, position, birthdate);
        this.hourlyPayment = hourlyPayment;
        this.numberOfFields = 4;
        this.index = 0;
    }

    @Override
    public double getAverageMonthlyWages() {
        return 20.8 * 8 * hourlyPayment;
    }

    public double getHourlyPayment() {
        return hourlyPayment;
    }

    public void setHourlyPayment(double hourlyPayment) {
        if (hourlyPayment < 3.0) {
            throw new RuntimeException("Почасовая оплата не может быть меньше 3");
        }
        this.hourlyPayment = hourlyPayment;
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
