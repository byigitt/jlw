public class Employee extends Person {
  public float salary;

  public Employee(String name, String email, String dateOfBirth, float salary) {
    super(name, email, dateOfBirth);
    this.salary = salary;
  }
}