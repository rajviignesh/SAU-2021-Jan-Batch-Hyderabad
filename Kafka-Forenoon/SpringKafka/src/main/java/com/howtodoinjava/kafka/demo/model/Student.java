package com.howtodoinjava.kafka.demo.model;

public class Student {

    private long StudentId;
    private String StudentName;
    private String StudentStd;

    public Student(){ }

    public Student(long studentId, String studentName, String studentStd){
        this.StudentId = studentId;
        this.StudentName = studentName;
        this.StudentStd = studentStd;
    }

    public long getStudentId() {
        return StudentId;
    }

    public void setStudentId(long studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentStd() {
        return StudentStd;
    }

    public void setStudentStd(String studentStd) {
        StudentStd = studentStd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", StudentStd='" + StudentStd + '\'' +
                '}';
    }


}
