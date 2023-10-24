package org.tues.oop.project.studentworker.model;

public class Student {
  private String name;
  private String surname;
  private String facultyNumber;

  public Student(String name, String surname, String facultyNumber) {
    this.name = name;
    this.surname = surname;
    this.facultyNumber = facultyNumber;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getFacultyNumber() {
    return facultyNumber;
  }
}
