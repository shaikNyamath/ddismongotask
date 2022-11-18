package com.ddis.mongotask.entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;

@Slf4j
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String state;
    private String city;
}
