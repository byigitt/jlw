import java.util.Scanner;

public class EmployeeListTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeList employeeList = new EmployeeList();
        
        int choice = -1;
        
        while (choice != 0) {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            
            switch (choice) {
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                case 1:
                    addEmployeeToEnd(employeeList, input);
                    break;
                case 2:
                    searchEmployeeByName(employeeList, input);
                    break;
                case 3:
                    employeeList.print();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println();
        }
        
        input.close();
    }
    
    public static void printMenu() {
        System.out.println("Menu");
        System.out.println("====");
        System.out.println("0: Quit");
        System.out.println("1: Add an employee to the end of the list");
        System.out.println("2: Search for an employee by name in the list");
        System.out.println("3: Print the list");
    }
    
    public static void addEmployeeToEnd(EmployeeList employeeList, Scanner input) {
        System.out.print("Enter the name of the employee to add to the end: ");
        String name = input.next();
        
        Employee employee = new Employee(name);
        employeeList.addToEnd(employee);
        
        System.out.println("Employee added to the end of the list.");
    }
    
    public static void searchEmployeeByName(EmployeeList employeeList, Scanner input) {
        System.out.print("Enter the name of the employee to search: ");
        String name = input.next();
        
        boolean found = employeeList.search(name);
        
        if (found) {
            System.out.println("Yes, Employee Found!");
        } else {
            System.out.println("No, Employee Not Found!");
        }
    }
}
