public class Person {
  public String name;
  public String email;
  public String dateOfBirth;

  public Person(String name, String email, String dateOfBirth) {
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String toString() {
    return "Name: " + name + "\nEmail: " + email + "\nDate of birth: " + dateOfBirth;
  }
}
