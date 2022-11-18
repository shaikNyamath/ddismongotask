package com.ddis.mongotask.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class UserDTO {
        private String firstName;
        private String lastName;
        private Date dob;
        private String state;
        private String city;
    }