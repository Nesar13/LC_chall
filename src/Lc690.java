import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lc690 {

/*    Map<Integer, Employee> emap;
    public int getImportance2(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }*/

    public static void main(String[] args) {
        Employee employee=new Employee(1, 10);
        employee.subordinates.add(new Employee(2, 5));
        employee.subordinates.add(new Employee(3, 5));
        System.out.println(employee);

    }
}
class Employee {
    public int id;
    public int importance;
    public List<Employee> subordinates=new LinkedList<Employee>();
    public Employee (int id, int importance ){
        this.id=id;
        this.importance= importance;

    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}