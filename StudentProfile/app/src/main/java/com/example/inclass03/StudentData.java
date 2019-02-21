package com.example.inclass03;

import java.io.Serializable;

public class StudentData implements Serializable {

    String firstName;
    String lastName;
    String studentId;
    String department;

    public StudentData(String firstName, String lastName, String studentId, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
