package org.tues.oop.project.studentworker;

import org.tues.oop.project.studentworker.model.Student;
import org.tues.oop.project.studentworker.model.Worker;

import java.util.Scanner;

public class StudentAndWorkerProcessor {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Student student = createStudent();
    Worker worker = createWorker();

    printStudent(student);
    printWorker(worker);
  }

  private static Student createStudent() {


    System.out.print("enter name surname and faculty number(divide by comma): ");
    String input = scanner.nextLine();

    String[] parts = input.split(", ");

    try {
      validateName(parts[0]);
      validateSurname(parts[1]);
      validateFacultyNumber(parts[2]);

      Student student = new Student(parts[0], parts[1], parts[2]);

      System.out.println("Successfully created student");

      return student;
    } catch(IllegalArgumentException exception){
      System.out.print("Failed to create student:" );
      exception.printStackTrace();
    }
    return null;
  }

  private static Worker createWorker() {

    System.out.print("enter name surname weekly salary and working hours(divide by comma): ");
    String input = scanner.nextLine();

    String[] parts = input.split(", ");

    Worker worker = null;
    try {
      validateName(parts[0].trim());
      validateSurname(parts[1].trim());
      validateWeeklySalary(Double.parseDouble(parts[2].trim()));
      validateWorkingHours(Integer.parseInt(parts[3]));

      worker = new Worker(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
      System.out.println("Successfully created student");
    } catch(IllegalArgumentException exception){
      System.out.print("Failed to create student:" );
      exception.printStackTrace();
    }
    return worker;
  }

  private static void validateName(String name) throws IllegalArgumentException {
    if (!((name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') && name.length() >= 4)) {
      throw new IllegalArgumentException("Invalid name - must start with upper case letter and must be at least 4 symbols");
    }
  }

  private static void validateSurname(String surname) throws IllegalArgumentException {
    if (!((surname.charAt(0) >= 'A' && surname.charAt(0) <= 'Z') && surname.length() >= 3)) {
      throw new IllegalArgumentException("Invalid surname - must start with upper case letter and must be at least 3 symbols");
    }
  }

  private static void validateFacultyNumber(String facultyNumber) throws IllegalArgumentException {
    if (!(facultyNumber.length() >= 5 && facultyNumber.length() <= 10)) {
      throw new IllegalArgumentException("Invalid faculty number - length must be between 5 and 10 symbols");
    }
  }

  private static void validateWeeklySalary(double weeklySalary) throws IllegalArgumentException {
    if (weeklySalary <= 0) {
      throw new IllegalArgumentException("Invalid week salary - must be a positive number bigger than 0");
    }
  }

  private static void validateWorkingHours(int workingHours) throws IllegalArgumentException {
    if (workingHours < 1 || workingHours > 12) {
      throw new IllegalArgumentException("Invalid week salary - must be a positive number bigger than 0");
    }
  }

  private static void printStudent(Student student){
    if (student == null){
      System.out.println("Student doesnt exist");
    }else{
      System.out.printf("Student name: %s\nStudent surname: %s\nFaculty number: %s",
          student.getName(), student.getSurname(), student.getFacultyNumber());
    }
  }

  private static void printWorker(Worker worker){
    if(worker == null){
      System.out.println("Worker doesnt exist");
    }else{
      System.out.printf("Worker name: %s\nWorker surname: %s\nWeek salary: %f\nHours per day: %d\nSalary per hour: %f",
          worker.getName(), worker.getSurname(), worker.getWeeklySalary(), worker.getWorkingHours(), worker.hourlyPay());
    }
  }


}