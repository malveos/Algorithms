/***

@Author Omkar Malve

690. Employee Importance

You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.


***/
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> mp = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        prepareMap(employees);
        return getImportance(mp.get(id));
    }

    private void prepareMap(List<Employee> employees) {
        for (Employee e : employees)
            mp.put(e.id, e);
    }

    private int getImportance(Employee e) {
        if (e == null) return 0;
        if (e.subordinates == null || e.subordinates.size() == 0)
            return e.importance;
        int a = e.importance;
        for( int i : e.subordinates) {
            a += getImportance(mp.get(i));
        }
        return a;
    }
}