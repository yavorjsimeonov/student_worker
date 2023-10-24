package org.tues.oop.project.studentworker.model;

public class Worker {
  private String name;
  private String surname;
  private double weeklySalary;
  private int workingHours;

  public Worker(String name, String surname, double weeklySalary, int workingHours) {
    this.name = name;
    this.surname = surname;
    this.weeklySalary = weeklySalary;
    this.workingHours = workingHours;
  }

  public double hourlyPay(){
    return (this.weeklySalary / 5) / this.workingHours;
  }


  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public double getWeeklySalary() {
    return weeklySalary;
  }

  public int getWorkingHours() {
    return workingHours;
  }
}
