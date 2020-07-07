import java.util.*;

public class Lc690 {

    static Map<Integer, Employee> emap;
    public static int getImportance2(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public static int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

    public static void main(String[] args) {

        Employee employee1= new Employee();
        employee1.id=1;
        employee1.importance=5;
        List<Integer> list1= new ArrayList<>();
        list1.add(2);
        list1.add(3);
        employee1.subordinates=list1;

        Employee employee2= new Employee();
        employee2.id=2;
        employee2.importance=3;
        employee2.subordinates= new ArrayList<>();

        Employee employee3= new Employee();
        employee3.id=3;
        employee3.importance=3;
        employee3.subordinates= new ArrayList<>();
        List<Employee> employees= new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println(getImportance(employees,1));
    }

    static Map<Integer, Employee>employeeMap;
    public static int getImportance(List<Employee> employees, int queryid){
        employeeMap=new HashMap<>();
        for(Employee e: employees) {
            employeeMap.put(e.id, e);
        }

        return dfs1(queryid);

    }
    static int dfs1(int queryid) {
        Employee employee=employeeMap.get(queryid);
        int ans=employeeMap.get(queryid).importance;
        for (Integer e : employee.subordinates) {
    ans+= dfs1(e);
        }
    return ans;
    }
    }

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    /*public Employee (int id, int importance ){
        this.id=id;
        this.importance= importance;

    }*/
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}