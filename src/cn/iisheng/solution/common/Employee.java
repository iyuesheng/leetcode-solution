package cn.iisheng.solution.common;

import java.util.List;

/**
 * @author iisheng
 * @date 2019/11/19 10:12:03
 */
public class Employee {
    /**
     * unique id of this employee
     */
    public int id;
    /**
     * the importance value of this employee
     */
    public int importance;
    /**
     * the id of direct subordinates
     */
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};
