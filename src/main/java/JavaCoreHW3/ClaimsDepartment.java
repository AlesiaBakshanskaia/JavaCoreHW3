package JavaCoreHW3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClaimsDepartment implements Iterable<Employee>{
    private List<Employee> compoundClaimsDepartment;
    private int index;

    public ClaimsDepartment() {
        this.compoundClaimsDepartment = new ArrayList<>();
        this.index = 0;
    }

    public void addPerson(Employee employee) {
        if (employee == null){
            throw new RuntimeException("Работник не может быть null");
        }
        compoundClaimsDepartment.add(employee);
    }


    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < compoundClaimsDepartment.size();
            }

            @Override
            public Employee next() {
                return compoundClaimsDepartment.get(index++);
            }
        };
    }
}
