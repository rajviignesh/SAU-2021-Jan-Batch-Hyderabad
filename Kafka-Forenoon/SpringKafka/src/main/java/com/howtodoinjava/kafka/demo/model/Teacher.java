package com.howtodoinjava.kafka.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int TeacherId;
    private String TeacherName;
    private String TeacherDesg;

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherId=" + TeacherId +
                ", TeacherName='" + TeacherName + '\'' +
                ", TeacherDesg='" + TeacherDesg + '\'' +
                '}';
    }
}
