package com.example.javabackendwithdatabase.mappers;

import com.example.javabackendwithdatabase.models.dto.UserDTO;
import com.example.javabackendwithdatabase.models.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserDTOMapper {
    UserDTO userToDTO(User user);
    User dtoToUser(UserDTO userDTO);
}
