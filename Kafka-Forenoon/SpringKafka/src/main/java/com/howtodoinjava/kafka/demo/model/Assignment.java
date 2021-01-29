package com.howtodoinjava.kafka.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    private int StudentId;
    private String StudentName;
    private Date SubmissionTime;

    @Override
    public String toString() {
        return "Assignment{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", SubmissionTime=" + SubmissionTime +
                '}';
    }
}
