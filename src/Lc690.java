import java.util.LinkedList;
import java.util.List;

public class Lc690 {

    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.subordinates.add(2);
        employee.subordinates.add(3);
        employee.importance=5;
        employee.id=1;

        Employee employee2= new Employee();





        System.out.println(employee);

    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates=new LinkedList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}