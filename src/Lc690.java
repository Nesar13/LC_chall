import java.util.*;
import java.util.List;

public class Lc690 {

   /* static Map<Integer, Employee> emap;
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
    }*/

    static int getImportanceBFS(List<Employee> employees, int queryid) {
        int sum = 0;
        Map<Integer, Employee> emap = new HashMap<>();
        Queue<Employee> queue = new LinkedList<>();
        ArrayList<Integer> visitedEmployee = new ArrayList<>();

        //------------Mapping the Employees information to their ID----------------------
        for (Employee e : employees) {
            emap.put(e.id, e);
        }

        //--------------------------------Pushing the employee with the given id---------------------

        queue.offer(emap.get(queryid));

        visitedEmployee.add(queryid);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //------------------------------------For Every level----------------------------------

            while (size-- > 0) {
                Employee e = queue.poll();
                //---------------Summing up the importance for the employees--------------------

                sum += e.importance;
                for (Integer subid : e.subordinates) {
                    Employee esub = emap.get(subid);
                    //--------Add subordiates only ifthey are not already visited-------------------

                    if (!visitedEmployee.contains(esub)) {
                        queue.offer(esub);
                        visitedEmployee.add(esub.id);
                    }
                }



            }
        } return sum;
    }



    /*public static void main(String[] args) {

        Employee employee1= new Employee();
        employee1.id=1;
        employee1.importance=5;
        List<Integer> list1= new ArrayList<>();
        list1.add(2);
        list1.add(3);
        employee1.subordinates=list1;

        Employee employee2= new Employee();
        employee2.id=2;
        employee2.importance=4;
        employee2.subordinates= new ArrayList<>();

        Employee employee3= new Employee();
        employee3.id=3;
        employee3.importance=3;
        employee3.subordinates= new ArrayList<>();
        List<Employee> employees= new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println(getImportanceBFS(employees,1));



    }*/

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
    public int getImportance3(List<Employee> employees, int id) {

        int sum=0;
        LinkedList<Employee> queue=new LinkedList<>();
        ArrayList<Integer> employeeVisited=new ArrayList<>();


        //------------Mapping the Employees information to their ID----------------------
        HashMap<Integer,Employee> EmpMap=new HashMap<>();
        for(Employee e: employees){
            EmpMap.put(e.id,e);
        }

        //-------------------------------Pushing the employee with the given id to end of queue-----
        queue.addLast(EmpMap.get(id));
        //-------------------------------Marking the employee Visited--------------------------------
        employeeVisited.add(id);



        while(queue.size()!=0){
            int size=queue.size();
            //------------------------------------For Every level----------------------------------
            while(size-->0){
                //Removing the first item in queue
                Employee e=queue.removeFirst();

                //---------------Summing up the importance for the the employees--------------------
                sum+=e.importance;
                for(Integer i:e.subordinates){
                    Employee subid=EmpMap.get(i);

                    //--------Add subordiates only if they are not already visited-------------------
                    if(employeeVisited.contains(i)==false){
                        queue.addLast(subid);
                        employeeVisited.add(i);
                    }
                }

            }
        }
        return sum;
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