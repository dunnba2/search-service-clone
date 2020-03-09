package com.revature.rms.search.entites.employee;

import com.revature.rms.search.dtos.EmployeeDto;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

  private int id;

  private String firstName;

  private String lastName;

  private String email;

  private String title;

  private Department department;

  private ResourceMetadata resourceMetadata;

  public Employee() {
    super();
  }

  public Employee(
      int id,
      String firstName,
      String lastName,
      String email,
      String title,
      Department department,
      ResourceMetadata resourceMetadata) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.title = title;
    this.department = department;
    this.resourceMetadata = resourceMetadata;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public ResourceMetadata getResourceMetadata() {
    return resourceMetadata;
  }

  public void setResourceMetadata(ResourceMetadata resourceMetadata) {
    this.resourceMetadata = resourceMetadata;
  }

  public EmployeeDto extractEmployee() {
    return new EmployeeDto(this.id, this.firstName, this.lastName, this.email, this.title, this.department);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return id == employee.id
        && Objects.equals(firstName, employee.firstName)
        && Objects.equals(lastName, employee.lastName)
        && Objects.equals(email, employee.email)
        && Objects.equals(title, employee.title)
        && department == employee.department
        && Objects.equals(resourceMetadata, employee.resourceMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, title, department, resourceMetadata);
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", email='"
        + email
        + '\''
        + ", title='"
        + title
        + '\''
        + ", department="
        + department
        + ", resourceMetadata="
        + resourceMetadata
        + '}';
  }
}
