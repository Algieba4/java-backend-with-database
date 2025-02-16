package com.example.javabackendwithdatabase.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    public Integer id;
    public String firstName;
    public String lastName;
}