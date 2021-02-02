package samples.problems;

// Q1: Given a list of employee ID, first names, and their manager IDs,
//
// write a function to read those inputs, calculate, and print all employees that are under a certain group manager's organization.


// Input:
// 1 Mike 4
// 2 Jordan 4
// 3 Steve 5
// 4 Jack 4
// 5 John 1
// 6 Stephen 6

// 4

// Output:
// 1, 2, 3, 4, 5

 // 4 Jack, 6 Stephen
//    |
// 1 Mike, 2 Jordan,
//    |
// 5 John
//    |
// 3 Steve

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class FindEmployees {

    // Given
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Employee {
        Integer employeeId;
        Integer managerId;
        String name;

        Set<Employee> employees;
    }

    public Set<Integer> getAllChildren(List<Employee> employeesInput, int managerIdToSearch) {
        Map<Integer, Set<Employee>> managerEmployeeMapping = new HashMap<>();

        for (Employee eachEmployee : employeesInput) {
            Set<Employee> tempEmployees;
            Integer managerId = eachEmployee.getManagerId();

            if(!managerEmployeeMapping.containsKey(managerId)) { // Does map contain manager ID?
                managerEmployeeMapping.put(managerId, Set.of(eachEmployee)); // Add to map managerId and a new set with one employee
            } else { // map does contain manager ID
                tempEmployees = managerEmployeeMapping.get(managerId); // get existing values for managerID
                tempEmployees.add(eachEmployee); // Add employee to existing group of employees
                managerEmployeeMapping.put(managerId, tempEmployees); // Add employee list to managerID mapping
            }
        }
        // [{4, {1, 2, 4}}, {5, {3}}, {1, {5}}, {6, {6}}]

        return new HashSet<>(getAllChildren(managerEmployeeMapping.get(managerIdToSearch), managerEmployeeMapping));
    }

    private Set<Integer> getAllChildren(Set<Employee> children, Map<Integer, Set<Employee>> map) { // {1,2,4}, managerEmployeeMapping
        Set<Integer> result = children.stream().map(Employee::getEmployeeId).collect(Collectors.toSet());

        for (Employee child : children) {
            result.addAll(getAllChildren(map.get(child.getManagerId()), map));
        }

        return result;
    }
}
