package com.accolite.restapi_au.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer msgId;

    @Column
    private String message;

    @Column
    private Timestamp createdTime;

    @ManyToOne
    @JsonIgnore
    private UserData user;

}
