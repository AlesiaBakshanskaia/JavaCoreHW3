package JavaCoreHW3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();
        staff.add(new Worker("Ivan", "Director", new Date(1960, 10, 12), 1000.0));
        staff.add(new Worker("Fred", "Manager", new Date(1989, 12, 3), 800.0));
        staff.add(new Freelancer("Dana", "Designer", new Date(2000, 12, 3), 20.));

        Collections.sort(staff);

        for (Employee employee : staff) {
            if (employee instanceof Worker) {
                for (String i : (Worker) employee) {
                    System.out.println(i);
                }
            }
            if (employee instanceof Freelancer) {
                for (String i : (Freelancer) employee) {
                    System.out.println(i);
                }
            }
        }
        System.out.println("---------------------------");
        ClaimsDepartment cd = new ClaimsDepartment();
        cd.addPerson(new Worker("Ivan", "Director", new Date(1960, 10, 12), 1000.0));
        cd.addPerson(new Worker("Fred", "Manager", new Date(1989, 12, 3), 800.0));
        cd.addPerson(new Freelancer("Dana", "Designer", new Date(2000, 12, 3), 20.));

        for (Employee employee : cd) {
            System.out.println(employee);
        }
    }
}
