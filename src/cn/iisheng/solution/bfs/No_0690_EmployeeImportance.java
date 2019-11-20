package cn.iisheng.solution.bfs;

import cn.iisheng.solution.common.Employee;

import java.util.*;

/**
 * @author iisheng
 * @date 2019/11/19 10:16:43
 */
public class No_0690_EmployeeImportance {

    public static int getImportance(List<Employee> employees, int id) {
        // 存储 员工id 和 对应的Employee 实体
        HashMap<Integer, Employee> map = new HashMap();
        // 定义一个队列
        Queue<Employee> queue = new LinkedList();
        // 记录结果的变量
        int res = 0;

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee temp = queue.poll();
            res += temp.importance;
            for (int e : temp.subordinates) {
                queue.offer(map.get(e));
            }
        }
        return res;
    }

    public static int getImportanceDFS(List<Employee> employees, int id) {
        int res = 0;
        HashMap<Integer, Employee> map = new HashMap();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        res = dfs(map, id, res);
        return res;
    }

    public static int dfs(HashMap<Integer, Employee> map, int id, int res) {
        Employee employee = map.get(id);
        int result = res;
        if (employee != null) {
            result += employee.importance;
            for (Integer i : employee.subordinates) {
                result += dfs(map, i, res);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee employee2 = new Employee(2, 3, new ArrayList<>());
        Employee employee3 = new Employee(3, 3, new ArrayList<>());
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        System.out.println(getImportance(list, 1));
        System.out.println(getImportanceDFS(list, 1));
    }
}
